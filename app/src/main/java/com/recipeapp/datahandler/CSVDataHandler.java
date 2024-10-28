package main.java.com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.model.Recipe;

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
    public ArrayList<Recipe> readData() throws IOExceprion {
        // レシピデータの読み込み
        ArrayList<String> recipes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                recipes.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return recipes;
    }

    // @Override
    // public void writeData(Recipe recipe) throws IOExceprion {
    // }

    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOExceprion {
        return null;
    }

}
