package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import main.java.com.recipeapp.model.Ingredient;
import main.java.com.recipeapp.model.Recipe;
import main.java.com.recipeapp.datahandler.DataHandler;

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }
    
    public void displayMenu() {

        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        displayRecipes();
                        break;
                    case "2":
                        addNewRecipe();
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    private void displayRecipes() {
        try {
            ArrayList<Recipe> recipes = dataHandler.readData();
            if (recipes.isEmpty()) {
                System.out.println("No recipes available.");
                return;
            }
            System.out.println("Recipes:");
            for (Recipe recipe : recipes) {
                System.out.println("-----------------------------------");
                System.out.println("Recipe Name: " + recipe.getName());
                System.out.print("Main Ingredients: ");
                // 最後のカンマを出したくない
                List<Ingredient> ingredients = recipe.getIngredients();
                for (int i = 0; i < ingredients.size(); i++) {
                    System.out.print(ingredients.get(i).getName());
                    if (i < ingredients.size() - 1) {
                        System.out.print(",");
                    }
                }
                System.out.println();
            }
        } catch (Exception ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
    }

    private void addNewRecipe() {
        try{
            // インプットを受け取る
            System.out.println();
            System.out.print("Enter recipe name: ");
            String recipeName = reader.readLine(); // レシピ名

            ArrayList<Ingredient> ingredients =new ArrayList<>(); // 材料リストのオブジェクト生成
            System.out.println("Enter ingredients (type 'done' when finished): ");
            while (true) {
                System.out.print("Ingredient: ");
                String inputItem = reader.readLine(); // 材料のインプット
                if (inputItem.equals("done")) {
                    break;
                }
                Ingredient ingredient = new Ingredient(inputItem); // 材料オブジェクトの生成
                ingredients.add(ingredient);// 材料リストに追加
            }
            Recipe recipe = new Recipe(recipeName, ingredients);// レシピのオブジェクト生成
            dataHandler.writeData(recipe);
            System.out.println("Recipe added successfully.");
        } catch (IOException ex) {
            System.out.println("Failed to add new recipe: " + ex.getMessage());
        }
    }
    // インプットを受け取る
    // レシピ名を生成する
    // 材料を生成する
    // 材料のリストを生成する
    // レシピオブジェクトを作る
    // writeData()の引数に渡す
}
