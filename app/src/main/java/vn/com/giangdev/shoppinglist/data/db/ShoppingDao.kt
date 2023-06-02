package vn.com.giangdev.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import vn.com.giangdev.shoppinglist.data.db.entities.ShoppingItem

/**
 * Created by giangphanba on 20/05/2023.
 */
@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}