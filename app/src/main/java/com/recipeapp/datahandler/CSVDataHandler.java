package main.java.com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import main.java.com.recipeapp.model.Ingredient;
import main.java.com.recipeapp.model.Recipe;

public class CSVDataHandler implements DataHandler {
    private String filePath;

    // コンストラクタ
    public CSVDataHandler() {
        filePath = "app/src/main/resources/recipes.csv";
    }

    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    // メソッド

    @Override
    public String getMode() {
        return "CSV"; //文字列CSVを返してください。
    }

    @Override
    public ArrayList<Recipe> readData() throws IOException{
        ArrayList<Recipe> recipes = new ArrayList<>(); // レシピリスト
        // レシピデータの読み込み
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            ArrayList<String> lists = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                lists.add(line); // リストに追加
            }
            for (String list : lists) {
                // 一行分を二分割
                String[] parts = list.split(",", 2);
                String recipeName = parts[0]; // レシピ名
                String[] items = parts[1].split(","); // 材料リスト
    
                ArrayList<Ingredient> ingredients =new ArrayList<>(); // 材料リストのインスタンス生成
                for (String item : items) {
                    Ingredient ingredient = new Ingredient(item); // 材料の生成
                    ingredients.add(ingredient); // 材料のリストに材料を追加する
                }
    
                Recipe recipe = new Recipe(recipeName, ingredients); // レシピの生成
                recipes.add(recipe); // レシピのリストにレシピを追加する
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return recipes; // データをリスト形式で返します

        /*
         * ラインごとのデータをレシピ名と材料のリストに分ける
         * レシピをインスタンス化する
         * レシピのオブジェクトをリストに追加する
         */
    }

    @Override
    public void writeData(Recipe recipe) throws IOException {
        // ファイルの書き込み
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            ArrayList<Ingredient> ingredients = recipe.getIngredients();
            ArrayList<String> items = new ArrayList<>();
            // 材料リスト
            for (Ingredient ingredient : ingredients) {
                items.add(ingredient.getName());
            }
            writer.newLine();  // 改行
            writer.write(recipe.getName() + "," + items); // ユーザーのインプット
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null;
    }

}
