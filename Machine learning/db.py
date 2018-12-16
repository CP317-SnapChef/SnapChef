
import pymysql

def get_recipes(ingredientsList, extrasFile):

	extras = []
	
	for line in extrasFile:
		extras.append(line.strip())

	host="snapchefdbinstance.chvgyyoopqkx.us-east-2.rds.amazonaws.com"
	port=3306
	dbname="SnapChef"
	user="Kriesh"
	password="Snapchef2018"

	conn = pymysql.connect(host, user=user,port=port, passwd=password, db=dbname)

	tup = ()
	
	i = 0
	
	while i <len(ingredientsList):
		if ingredientsList[i] in extras:
			ingredientsList.remove(ingredientsList[i])
		else:
			i += 1
		
	
	for ingredient in ingredientsList:
		tup = tup + (ingredient,)	
			
	cursor = conn.cursor()

	sql = '''SELECT recipeName, Rating, instructions, ingredientName 
					FROM SnapChef.TEST 
					WHERE ingredientName 
					IN %s
					GROUP BY recipeName HAVING COUNT(*) = ''' + str(len(tup))

	cursor.execute(sql, (tup,))
	
	
	result = []
	
	for row in cursor:
		result.append(row)

	return result

