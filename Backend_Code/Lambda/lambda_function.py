
'''
Created on Dec. 11, 2018

@author: Brandon Benoit, Gong-Fan Bao, Sriram Vasuthevan
@version: 2018-12-15
'''

import json
import pymysql
import pymysql.cursors
from Database_Credential import Database_Credential 
 
host_address = 'snapchefdbinstance.chvgyyoopqkx.us-east-2.rds.amazonaws.com' #endpoint
DB_name = "snapchefdbinstance" #the db name
name = Database_Credential.username #host username
passwrd = Database_Credential.password #get pass
  
def lambda_handler(event, context):
    response = None;
    reponseCode = 200;
    
    #simple connection
    con = pymysql.connect(host = host_address,
                      port = 3306,
                      user = name,
                      password = passwrd);
    
    
    #Gets the operation and the ingredients from the API Parameters
    operation = event["queryStringParameters"]["operation"]
    ingredients = event["multiValueQueryStringParameters"]["ingredient"]
    
    #Gets information for one recipe
    if (operation == "getRecipes"):
        
        try:
    
            with con.cursor() as cursor:
            
                #SQL statement
                sql = genIngredientsQuery(ingredients)
                print(sql)
                #Initialize Return Object
                recipes = []; 
                #Execute Query
                cursor.execute(sql)
                
                keys=["recipe","rating","instructions"]
                
                #translating rows to dictionary
                for row in cursor:
                    newRecipes=dict(zip(keys,row))
                    
                    with con.cursor() as temp_cursor:
                        
                        sql_getIngredients = "SELECT ingredientName FROM SnapChef.TEST WHERE recipeName = " + "\'"+newRecipes["recipe"]+"\'"
                        temp_cursor.execute(sql_getIngredients)
                            
                        recipeIngredients=""
                        for row in temp_cursor: 
                            recipeIngredients += row[0]+"\n " #there is only one column
                            
                    newRecipes["ingredients"]=recipeIngredients
                    
                    recipes.append(newRecipes)
                    
                recipes_json = {"recipes": recipes};
                response = {
                    "statusCode": 200,
                    "headers": {
                        "my_header": "my_value"
                    },
                    "body": json.dumps(recipes_json),
                    "isBase64Encoded": False
                };
    
        finally:
            #close connection
            con.close();
        
    #Gets information for one recipe
    elif (operation == "getRecipeInfo"): 
        
        try:
    
            with con.cursor() as cursor:
            
                #SQL statement
                sql = "SELECT DISTINCT recipeName, Rating, instructions FROM SnapChef.TEST WHERE recipeName = " + "'" + "".join(event["multiValueQueryStringParameters"]["ingredient"]) + "'"
                print(sql)
                #Initialize Return Object
                recipes = []; 
                #Execute Query
                cursor.execute(sql)
                
                keys=["recipe","rating","instructions"]
                
                #translating rows to dictionary
                for row in cursor:
                    newRecipes=dict(zip(keys,row))
                    
                    with con.cursor() as temp_cursor:
                        
                        sql_getIngredients = "SELECT ingredientName FROM SnapChef.TEST WHERE recipeName = " + "\'"+newRecipes["recipe"]+"\'"
                        temp_cursor.execute(sql_getIngredients)
                            
                        recipeIngredients=""
                        for row in temp_cursor: 
                            recipeIngredients += row[0]+"\n " #there is only one column
                            
                    newRecipes["ingredients"]=recipeIngredients
                    
                    recipes.append(newRecipes)
                    
                recipes_json = {"recipes": recipes};
                response = {
                    "statusCode": 200,
                    "headers": {
                        "my_header": "my_value"
                    },
                    "body": json.dumps(recipes_json),
                    "isBase64Encoded": False
                };
                
        finally:
            #close connection
            con.close();
        
    return response;
    
def genIngredientsQuery(ingredients):
    #Converts a list of Ingredients in an SQL query
    Query="SELECT recipeName, Rating, instructions FROM SnapChef.TEST WHERE ingredientName IN ("
    for i in ingredients:
        Query+="\'"+i+"\',"
    Query=Query[:-1]
    Query+=") GROUP BY recipeName HAVING COUNT(*) = "+str(len(ingredients))
    return Query
        
