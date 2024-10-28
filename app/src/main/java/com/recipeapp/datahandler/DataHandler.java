package main.java.com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.model.Recipe;

public interface DataHandler {
    // メソッド
    public String getMode();

    public ArrayList<Recipe> readData() throws IOExceprion;

    public void writeData(Recipe recipe) throws IOExceprion;

    public ArrayList<Recipe> searchData(String keyword) throws IOExceprion;
}
