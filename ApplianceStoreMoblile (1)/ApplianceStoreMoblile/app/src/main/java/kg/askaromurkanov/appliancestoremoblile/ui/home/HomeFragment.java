package kg.askaromurkanov.appliancestoremoblile.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

import kg.askaromurkanov.appliancestoremoblile.R;
import kg.askaromurkanov.appliancestoremoblile.dao.ProductDao;
import kg.askaromurkanov.appliancestoremoblile.databinding.FragmentHomeBinding;
import kg.askaromurkanov.appliancestoremoblile.models.Product;
import kg.askaromurkanov.appliancestoremoblile.room.AppDatabase;

public class HomeFragment extends Fragment {

    private List<Product> products;

    private AppDatabase appDatabase;
    private ProductDao productDao;

    private FragmentHomeBinding binding;

    private HomeAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        init();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    void init(){
        RecyclerView recyclerView = binding.recyclerProducts;
        adapter = new HomeAdapter();
        recyclerView.setAdapter(adapter);

//        recyclerView.setLayoutManager(new (binding.getRoot().getContext()));

//        Product product1 = new Product("Чайник", "ARG", "Кухонная техника", 8000, R.drawable.tefal);
        Product product2 = new Product("свч-печь", "ARG", "Кухонная техника", 8000, R.drawable.microwave);

        AppDatabase db =  Room.databaseBuilder(binding.getRoot().getContext(),
                AppDatabase.class, "database").allowMainThreadQueries().build();

        productDao = db.productDao();
//
//        Product p = productDao.getById(4);
//        productDao.delete(p);

//        productDao.insert(product2);


        adapter.setList(productDao.getAll());


    }
}