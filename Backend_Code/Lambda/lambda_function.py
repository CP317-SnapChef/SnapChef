
'''
Created on Dec. 11, 2018

@author: Brandon Benoit, Gong-Fan Bao, Sriram Vasuthevan
@version: 2018-12-14
'''

import json
import pymysql
import pymysql.cursors

host_address = 'snapchefdbinstance.chvgyyoopqkx.us-east-2.rds.amazonaws.com' #endpoint
DB_name = "snapchefdbinstance" #the db name

name = "backend" #host username
passwrd = "coachrocky" #get pass
  
def lambda_handler(event, context):
    response = None;
    reponseCode = 200;
    
    #simple connection
    con = pymysql.connect(host = host_address,
                      port = 3306,
                      user = name,
                      password = passwrd);
    
    #Use Case statements to determine operation
    
    
    operation = event["queryStringParameters"]["operation"]
    ingredients = event["multiValueQueryStringParameters"]["ingredient"]
    
    if (operation == "getRecipes"):
        
        try:
    
            with con.cursor() as cursor:
            
                #SQL
                sql = "SELECT recipeName, Rating, instructions FROM SnapChef.TEST WHERE ingredientName IN "+ genIngredientsQuery(ingredients) +"  GROUP BY recipeName HAVING COUNT(*) = "+str(len(ingredients))
                #ingredientName IN , change milk and butter to whichever ingredients the user enters
                #change COUNT to number of ingredients entered
                
                #Initialize Return Object
                recipes = []; 
                    
                #Execute Query
                cursor.execute(sql)
                
                print("cursor.description: ", cursor.description)
                print()
                
                #translating rows to dictionary
                for row in cursor:
                    print(row)
                    newRecipes={}
                    newRecipes["recipe"]=row[0]
                    newRecipes["rating"]=row[1]
                    newRecipes["instructions"]=row[2]
                    
                    with con.cursor() as temp_cursor:
                        
                        sql_getIngredients = "SELECT ingredientName FROM SnapChef.TEST WHERE recipeName = " + "\'"+newRecipes["recipe"]+"\'"
                        temp_cursor.execute(sql_getIngredients)
                            
                        print("cursor.description: ", cursor.description)
                        print()
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
                    "body": json.dumps(recipes),
                    "isBase64Encoded": False
                };
    
        finally:
            #close connection
            con.close();
        
    return response;
    
def genIngredientsQuery(Ingredients):
    Query="("
    for i in Ingredients:
        Query+="\'"+i+"\',"
    Query=Query[:-1]
    Query+=")"
    return Query
        
