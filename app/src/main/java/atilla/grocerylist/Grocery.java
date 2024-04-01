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
    public void setId(String id) {
        this.id = id;
    }
    public String getGroceryName() {
        return groceryName;
    }

    public String getGroceryNote() {
        return groceryNote;
    }
}