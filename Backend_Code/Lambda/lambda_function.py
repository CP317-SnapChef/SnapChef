
'''
Created on Dec. 11, 2018

@author: Brandon Benoit, Gong-Fan Bao
@version: 2018-12-12
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
    

    operation = event["operation"];
    
    if (operation == "getRecipes"):
        print ("hi")
    elif (operation == "getIngredients"):
        print("dab")

        
    try:

        with con.cursor() as cursor:
        
            #SQL
            sql = "SELECT recipeName, Rating, instructions FROM SnapChef.TEST WHERE ingredientName IN ('garlic', 'salt')  GROUP BY recipeName HAVING COUNT(*) = 2"
            #ingredientName IN ('milk',  'butter'), change milk and butter to whichever ingredients the user enters
            #change COUNT to number of ingredients entered
            
            #Initialize Return Object
            recipes = {}; #Empty Dictionary
                
            #Execute Query
            cursor.execute(sql)
            
            print("cursor.description: ", cursor.description)
            print()
            
            #translating rows to dictionary
            counter = 1
            for row in cursor:
                print(row)
                
                recipes.update({"recipe" + str(counter) : row[0]});
                recipes.update({"rating" + str(counter) : row[1]});
                recipes.update({"instructions" + str(counter) : row[2]});
                counter += 1;
                
            recipes_json = {"recipes": recipes};
            response = json.dumps(recipes_json);

    finally:
        #close connection
        con.close();
        
    return response;
        
