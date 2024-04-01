package atilla.grocerylist;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddGroceryActivity extends AppCompatActivity {
    private EditText editGroceryName;
    private EditText editGroceryNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_grocery);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editGroceryName = findViewById(R.id.editGroceryName);
        editGroceryNote = findViewById(R.id.editGroceryNote);

    }

    public void addGrocery(View view) {
        String groceryName = editGroceryName.getText().toString();
        String groceryNote = editGroceryNote.getText().toString();

        Grocery grocery = new Grocery(groceryName, groceryNote);
        ListGrocery.getInstance().addGrocery(grocery);


        ListGrocery.getInstance().saveGroceries(this);

    }
}