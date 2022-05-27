package kg.askaromurkanov.appliancestoremoblile.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import kg.askaromurkanov.appliancestoremoblile.models.Product;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM Product")
    List<Product> getAll();

    @Query("SELECT * FROM Product WHERE id = :id")
    Product getById(long id);

    @Insert
    void insert(Product product);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);

}