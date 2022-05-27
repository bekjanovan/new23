package kg.askaromurkanov.appliancestoremoblile.ui.home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;


import java.util.ArrayList;
import java.util.List;


import kg.askaromurkanov.appliancestoremoblile.dao.ProductDao;
import kg.askaromurkanov.appliancestoremoblile.databinding.ItemProductBinding;
import kg.askaromurkanov.appliancestoremoblile.models.Product;
import kg.askaromurkanov.appliancestoremoblile.room.AppDatabase;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private List<Product> products = new ArrayList<>();
    private ProductDao productDao;

    public void setList(List<Product> products){
        this.products = products;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductBinding itemProductBinding = ItemProductBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);

        ViewHolder viewHolder = new ViewHolder(itemProductBinding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        productDao = Room.databaseBuilder(holder.binding.getRoot().getContext(), AppDatabase.class, "database").allowMainThreadQueries().build().productDao();
        Product product = products.get(position);
        holder.binding.applianceName.setText(product.getName());
        holder.binding.applianceImage.setImageResource(product.getImage());
        holder.binding.applianceFactory.setText(product.getFactory());
        holder.binding.applianceFactory.setText(product.getFactory());
        holder.binding.cardView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(holder.binding.getRoot().getContext()).create();
                alertDialog.setTitle("Вы хотите добавить "+product.getName() + " " + product.getFactory()+" в корзину");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "принять",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "отклонить",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemProductBinding binding;

        public ViewHolder(@NonNull ItemProductBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

    }
}
