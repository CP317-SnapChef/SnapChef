"""  
-------------------------------------------------------  
aws.py
-------------------------------------------------------  
Author:  Arjun Ananth, Adam Gumieniak, Brian Hane, Zhengern Yuan
Version: _updated_="2017-12-07"
-------------------------------------------------------  
"""
import boto3, os, db

fileName='dog.jpg'
bucket='snapchef-deployments-mobilehub-1070441847'

client=boto3.client('rekognition')
s3 = boto3.client('s3')
"""
-------------------------------------------------------
The function calls on Image Rekognition to the contents of the image (is it a carrot? etc)

Parameters:
	key - string name of the s3 file to scan using Rekognition

-------------------------------------------------------
"""
def scanFile(key):
	response = client.detect_labels(Image={'S3Object':{'Bucket':bucket,'Name':key}})
	
	result = []
	for label in response['Labels']:
		result.append(label['Name'])
		
	return result
		
"""
-------------------------------------------------------
The function uploads an image file into S3 Cloud Storage

Parameters
	path - string path & filename of the file to uplaod to S3
	key - string key that will be used to name the file when uploaded
-------------------------------------------------------
"""
def uploadFile(path,key):
	data = open(path, 'rb')
	s3.put_object(Body=data, Bucket=bucket, Key=key)
	data.close()
"""
-------------------------------------------------------
The function scans the specified S3 bucket and returns all the keys

Parameters

	bucket - string name of the bucket within S3 to scan
-------------------------------------------------------
"""		
def getKeys(bucket):
	response = s3.list_objects(
		Bucket=bucket,
		#Delimiter='string', #character to group keys
		#Marker='string', # key to start with when listing objects
		#MaxKeys=123, 
		#Prefix='string', #Limits the response to keys that begin with the specified prefix.
	)
	
	keys = []
	
	for obj in response['Contents']:
		keys.append(obj['Key'])
		
	return keys
"""
-------------------------------------------------------
The function removes images off S3 by specific key

Parameters
	bucket - string name of the bucket to remove from
	key - string key name of the file to remove
-------------------------------------------------------
"""
def deleteByKey(bucket, key):
	
	s3.delete_object(
		Bucket=bucket,
		Key=key
	)
"""
-------------------------------------------------------
The function deletes multiple images off S3 by specific list of keys

Parameters
	bucket - string name of the bucket to remove from
	keys - list of string key names of files to delete off the S3
-------------------------------------------------------
"""	
def deleteByKeys(bucket, keys):

	delete = {'Objects':[]}
	
	for key in keys:
		delete['Objects'].append({'Key':key})
		
	s3.delete_objects(
		Bucket=bucket,
		Delete=delete
	)
	
"""
-------------------------------------------------------
The function outputs results into a csv file

Parameters
	file - open csv file to write to
	key - string key name of S3 file that was scanned 
	results - list of strings of results from the scan
-------------------------------------------------------
"""	
def writeToCSV(file, key, results):
	
	file.write(key + ',')
	for result in results:
		file.write(result + ',')
		
	file.write('\n')
"""
-------------------------------------------------------
The function outputs matrix results into a csv file

Parameters
	file - open csv file to write to
	matrix - matrix of results of all the objects scanned in the S3
-------------------------------------------------------
"""	
def writeMatrixToCSV(file, matrix):
		
	max = 0
	
	for result in matrix:
		if len(result) > max:
			max = len(result)
	
	for i in range(max):
		for result in matrix:
			if i < len(result):
				file.write(result[i] + ',')
			else:
				file.write(',')
		file.write('\n')
"""	
-------------------------------------------------------
The function takes the results output by Rekognition of a scanned file from S3 and places them into a matrix 
The results must be placed into the same row of the matrix if the filen is the same type of object as was previously scanned
This relies on naming convention of the scanned files - each type of object (ex. all images of beef) would have the same prefix (the type 
of object it is i.e. beef), followed by a digit from 0-9 to avoid file naming errors. 

Parameters
	file - open csv file to write to
	key - string key name of the object whose results are being added to the matrix
	matrix - matrix of results of all the objects scanned in the S3
	matrixCount - length of the outer list
-------------------------------------------------------
"""		
def addToMatrix(matrix, key, results,matrixCount):
	
	if matrixCount == 0:
		matrix.append([key] + results)
		matrixCount+=1
	else:
		if matrix[matrixCount-1][0][0:len( matrix[matrixCount-1][0])-5] == key[0:len(key)-5]:
			matrix[matrixCount-1] += results
		else:
			matrix.append([key] + results)
			matrixCount+=1
	return matrixCount


"""	
-------------------------------------------------------
This function scans an entire local directory of images and tests each one using Rekognition and outputs the result to a file

Parameters
	path - string path to the directory containing all the images
-------------------------------------------------------
"""	
def testDirectory(path):
	
	dir = os.listdir(path)
	
	output = open('results.csv','w')
	matrix = []
	matrixCount = 0
		
	for key in dir:
		uploadFile(path + '/' + key, key)
		results = scanFile(key)
		
		deleteByKey(key)
		
		matrixCount = addToMatrix(matrix, key,results,matrixCount)
		
	
	writeMatrixToCSV(output,matrix , matrixCount)
	output.close()

"""	
-------------------------------------------------------
This function tests the result of a Rekognition scan against a list of discarded results (ex. images of steak will return food and meat,
however these resutls are to be discarded.

Parameters
	path - string path to the directory containing all the images
-------------------------------------------------------
"""	
def return_result(results, discard_list):
	
		
	for result in results:
		if result not in discard_list:
			return result
			
	
	return '*Not Recognized*'
	
"""
-------------------------------------------------------
The function is the main test driver of the program to ensure all the functions are working 

Parameters
	pics - list of picture names to be tested with the image recognition
		if the directory conatining the pictures is not the working directory then the names must include the path as well
	discard_file_path - string path and file name of the csv containing all the discarded results
	extras_file_path - string path and file name of the csv containing the extras and condiments not to be recognized by image
			    and queried from the database
-------------------------------------------------------
"""
def driver(pics, discard_file_path, extras_file_path):

	ingredients = []
	discards = []
	
	discard_file = open(discard_file_path, 'r')
	
	line = discard_file.readline()
	
	while line:
		discards.append(line.strip())
		line = discard_file.readline()
		
	
	discard_file.close()
	
	for pic in pics:

		key = pic
		
		uploadFile(pic, key)
		
		results = scanFile(key)
		
		result = return_result(results, discards)
		
		deleteByKey(key)
		
		ingredients.append(result)
		
	for ingredient in ingredients:
		print(ingredient)
		
	correct = input('Are these the correct ingredients?')
	
	if not (correct == 'yes' or correct == 'Yes' or correct == 'YES' or correct == 'y' or correct == 'Y'):
		print('If ingredient is correct, press {enter}, else enter the correct ingredient')
		for i in range(len(ingredients)):
			inp = input(ingredients[i] + ': ')
			if inp != '':
				ingredients[i] = inp
				
				
	extras_file = open(extras_file_path, 'r')
	
	recipes = db.get_recipes(ingredients, extras_file)
	
	extras_file.close()
	
	for x in recipes:
		print(x)
		
