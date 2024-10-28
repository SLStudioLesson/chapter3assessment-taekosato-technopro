package main.java.com.recipeapp.datahandler;

import java.util.ArrayList;

import com.recipeapp.model.Recipe;

public class JSONDataHandler implements  DataHandler{
    @Override
    public String getMode() {
        return "JSON";
        // 文字列JSONを返してください。
    }

    @Override
    public ArrayList<Recipe> readData() throws IOExceprion {
        return null;
    }

    // @Override
    // public void writeData(Recipe recipe) throws IOExceprion {
    // }

    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOExceprion {
        return null;
    }
}
