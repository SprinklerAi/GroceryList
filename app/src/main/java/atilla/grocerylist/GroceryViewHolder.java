package atilla.grocerylist;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GroceryViewHolder extends RecyclerView.ViewHolder {
    TextView textGroceryName, textGroceryNote;
    ImageView imageEdit, imageDelete;

    public GroceryViewHolder(@NonNull View itemView) {
        super(itemView);
        textGroceryName = itemView.findViewById(R.id.textGroceryName);
        textGroceryNote = itemView.findViewById(R.id.textGroceryNote);
        imageEdit = itemView.findViewById(R.id.imageEdit);
        imageDelete = itemView.findViewById(R.id.imageDelete);
    }
}