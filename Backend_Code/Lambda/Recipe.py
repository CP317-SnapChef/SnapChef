'''
Created on Dec. 11, 2018

@author: Brandon Benoit
@version: 2018-12-11
'''

class Recipe(object):
    recipeName = ""
    rating = 0
    prepTime = 0
    cookTime = 0
    servings = 0
    ingredients = []
    instructions = []
    description = ""
    peanutFree = False
    vegatarian = False
    vegan = False
    

    def __init__(self, recipeName,rating,prepTime,cookTime,servings,ingredients,instructions,description,peanutFree,vegatarian,vegan):
        '''
        Constructor
        '''
        Recipe.recipeName = recipeName
        Recipe.rating = rating
        Recipe.prepTime = prepTime
        Recipe.cookTime = cookTime
        Recipe.servings = servings
        Recipe.ingredients = ingredients
        Recipe.instructions = instructions
        Recipe.description = description
        Recipe.peanutFree = peanutFree
        Recipe.vegatarian = vegatarian
        Recipe.vegan = vegan
        
    '''
    Setters
    '''
    def setRecipeName(self, recipeName):
        Recipe.recipeName = recipeName
    

    def setRating(self, rating):
        Recipe.rating = rating
    

    def setPrepTime(self, prepTime):
        Recipe.prepTime = prepTime
    

    def setCookTime(self, cookTime):
        Recipe.cookTime = cookTime
    

    def setServings(self, servings):
        Recipe.servings = servings
    

    def setIngredients(self, ingredients):
        Recipe.ingredients = ingredients
    

    def setInstructions(self, instructions):
        Recipe.instructions = instructions
    

    def setDescription(self, description):
        Recipe.description = description
    

    def setPeanutFree(self, peanutFree):
        Recipe.peanutFree = peanutFree
    

    def setVegetarian(self, vegetarian):
        Recipe.isVegetarian = vegetarian
    

    def setVegan(self, vegan):
        Recipe.vegan = vegan
    
    
    '''
    Getters
    '''
    def getRecipeName(self,):
        return Recipe.recipeName
    

    def getRating(self):
        return Recipe.rating

    def getPrepTime(self):
        return Recipe.prepTime
    

    def getCookTime(self):
        return Recipe.cookTime
    

    def getServings(self):
        return Recipe.servings
    

    def getIngredients(self):
        return Recipe.ingredients
    

    def getInstructions(self):
        return Recipe.instructions
    

    def getDescription(self):
        return Recipe.description
    

    def getPeanutFree(self):
        return Recipe.isPeanutFree
    

    def getVegetarian(self):
        return Recipe.vegetarian
    

    def getVegan(self):
        return Recipe.isVegan
    