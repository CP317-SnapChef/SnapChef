import boto3, os, db

fileName='dog.jpg'
bucket='snapchef-deployments-mobilehub-1070441847'

client=boto3.client('rekognition')
s3 = boto3.client('s3')

def scanFile(key):
	response = client.detect_labels(Image={'S3Object':{'Bucket':bucket,'Name':key}})
	
	result = []
	for label in response['Labels']:
		result.append(label['Name'])
		
	return result
		

def uploadFile(path,key):
	data = open(path, 'rb')
	s3.put_object(Body=data, Bucket=bucket, Key=key)
	data.close()
		
def getKeys():
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
		
def deleteByKey(key):
	
	s3.delete_object(
		Bucket=bucket,
		Key=key
	)
	
def deleteByKeys(keys):

	delete = {'Objects':[]}
	
	for key in keys:
		delete['Objects'].append({'Key':key})
		
	s3.delete_objects(
		Bucket=bucket,
		Delete=delete
	)
	

def writeToCSV(file, key, results):
	
	file.write(key + ',')
	for result in results:
		file.write(result + ',')
		
	file.write('\n')
	
def writeMatrixToCSV(file, matrix, matrixCount):
		
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

def testDirectory(path):
	
	dir = os.listdir(path)
	
	output = open('results.csv','w')
	matrix = []
	matrixCount = 0
		
	for key in dir:
		uploadFile(path + '/' + key, key)
		results = scanFile(key)
		
		deleteByKey(key)
		
		#writeToCSV(output, key, results)
		matrixCount = addToMatrix(matrix, key,results,matrixCount)
		
	
	writeMatrixToCSV(output,matrix , matrixCount)
	output.close()
	
def return_result(results, discard_list):
	
		
	for result in results:
		if result not in discard_list:
			return result
			
	
	return '*Not Recognized*'
	

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
		
	
driver(['bread.jpg', 'egg.jpg'], 'DiscardPile.csv', 'condiments and extras.csv')
