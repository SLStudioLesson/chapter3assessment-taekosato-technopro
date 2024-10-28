package main.java.com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
    public ArrayList<Recipe> readData() throws IOException {
        // レシピデータの読み込み
        ArrayList<Recipe> recipes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2);
                recipes.getName().add(parts[0]);
                if (parts.length > 1) {
                    recipes.getIngredients().add(parts[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return recipes;
    }

    @Override
    public void writeData(Recipe recipe) throws IOException {
    }

    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null;
    }

}
