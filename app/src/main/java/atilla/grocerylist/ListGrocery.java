package atilla.grocerylist;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ListGrocery {
    private ArrayList<Grocery> groceries = new ArrayList<>();

    private static ListGrocery listGrocery = null;


    private ListGrocery() {
    }
    public static ListGrocery getInstance() {
        if (listGrocery == null) {
            listGrocery = new ListGrocery();
        }
        return listGrocery;
    }

    public void addGrocery(Grocery grocery) {
        groceries.add(grocery);
    }

    public void getGroceryByName(String name) {

    }

    public void removeGrocery(String id) {
        int i = 0;
        for (Grocery g : groceries) {
            if (g.getId().equals(id)) {
                break;
            }
            i++;
        }
        groceries.remove(i);
    }

    public ArrayList<Grocery> getGroceries() {
        return groceries;
    }

    public void saveGroceries(Context context) {
        try {
            ObjectOutputStream groceryWriter = new ObjectOutputStream(context.openFileOutput("groceries.data", Context.MODE_PRIVATE));
            groceryWriter.writeObject(groceries);
            groceryWriter.close();
        } catch (IOException e) {
            System.out.println("Couldn't save items to a file");
        }
    }

    public void loadGroceries(Context context) {
        try {
            ObjectInputStream groceryReader = new ObjectInputStream(context.openFileInput("groceries.data"));
            groceries = (ArrayList<Grocery>) groceryReader.readObject();
            groceryReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Failed to load items");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Failed to load items");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load items");
            e.printStackTrace();
        }
    }

    public Grocery getGroceryByIdWithoutRemove(int id) {
        return groceries.get(id);
    }

}