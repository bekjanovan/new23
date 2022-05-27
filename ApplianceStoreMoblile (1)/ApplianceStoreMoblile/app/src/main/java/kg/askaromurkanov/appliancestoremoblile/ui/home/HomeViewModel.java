package kg.askaromurkanov.appliancestoremoblile.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import kg.askaromurkanov.appliancestoremoblile.models.Product;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<List<Product>> product;
    private List<Product> products;

    public HomeViewModel() {
        this.product = new MutableLiveData<>();

    }


    void init(){
        products = new ArrayList<>();

    }

    private void fillList(){
        products = new ArrayList<Product>();
    }
}