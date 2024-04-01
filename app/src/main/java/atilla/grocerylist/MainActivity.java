package atilla.grocerylist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ListGrocery listGrocery;
    private RecyclerView rvGroceries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListGrocery.getInstance().loadGroceries(getApplicationContext());
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        listGrocery = ListGrocery.getInstance();
        rvGroceries = findViewById(R.id.rvGroceries);
        rvGroceries.setLayoutManager(new LinearLayoutManager(this));
        rvGroceries.setAdapter(new GroceryListAdapter(getApplicationContext(), listGrocery.getGroceries()));
    }

    public void openAddGroceryActivity(View view) {
        Intent intent = new Intent(this, AddGroceryActivity.class);
        startActivity(intent);
    }
}