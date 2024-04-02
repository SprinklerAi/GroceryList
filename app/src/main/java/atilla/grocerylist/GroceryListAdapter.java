package atilla.grocerylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GroceryListAdapter extends RecyclerView.Adapter<GroceryViewHolder> {
    private ArrayList<Grocery> groceries;
    private Context context;

    public  GroceryListAdapter(Context context, ArrayList<Grocery> groceries) {
        this.groceries = groceries;
        this.context = context;
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GroceryViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_user, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder holder, int position) {
        holder.textGroceryName.setText(groceries.get(position).getGroceryName());
        holder.textGroceryNote.setText(groceries.get(position).getGroceryNote());
        holder.editTextGroceryNote.setText(groceries.get(position).getId());
        holder.imageDelete.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            ListGrocery.getInstance().removeGrocery(groceries.get(pos).getId());
            notifyItemRemoved(pos);
        });

        holder.imageEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();

                if(holder.editTextGroceryNote.getVisibility() == View.VISIBLE) {
                    Grocery rocket = ListGrocery.getInstance().getGroceryByIdWithoutRemove(pos);
                    rocket.setId(holder.editTextGroceryNote.getText().toString());
                    holder.editTextGroceryNote.setVisibility(View.GONE);
                    notifyDataSetChanged();
                }
                else {
                    holder.editTextGroceryNote.setVisibility(View.VISIBLE);
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return groceries.size();
    }
}

