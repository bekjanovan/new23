package kg.askaromurkanov.appliancestoremoblile.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import kg.askaromurkanov.appliancestoremoblile.dao.ProductDao;
import kg.askaromurkanov.appliancestoremoblile.models.Product;

@Database(entities = {Product.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProductDao productDao();
}