import main.java.com.recipeapp.datahandler.CSVDataHandler;
import main.java.com.recipeapp.datahandler.DataHandler;
import main.java.com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;
import java.io.*;

public class App {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();
            // ユーザーの選択に応じて、インスタンスを生成する
            if("2".equals(choice)) {
                DataHandler json = new JSONDataHandler();
                RecipeUI ui = new RecipeUI(json);
                ui.displayMenu();
            } else {
                DataHandler csv = new CSVDataHandler();
                RecipeUI ui = new RecipeUI(csv);
                ui.displayMenu();
            }
            

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}