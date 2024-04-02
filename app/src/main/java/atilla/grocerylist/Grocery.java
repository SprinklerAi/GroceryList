package atilla.grocerylist;
import java.io.Serializable;

public class Grocery implements Serializable {
    private String groceryName;
    private String groceryNote;
    private String id;

    public Grocery(String groceryName, String groceryNote) {
        this.groceryName = groceryName;
        this.groceryNote = groceryNote;
        id = "Item" + (int)(Math.random() * 200 + 50);
    }

    public String getId() {
        return id;
    }
    public void setGroceryName(String groceryName) {
        this.groceryName = groceryName;
    }
    public String getName() {
        return groceryName;
    }

    public void setNote(String groceryNote) {
        this.groceryNote = groceryNote;
    }

    public String getNote() {
        return groceryNote;
    }
}