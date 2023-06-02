package vn.com.giangdev.shoppinglist.data.repo

import androidx.lifecycle.LiveData
import vn.com.giangdev.shoppinglist.data.db.ShoppingDatabase
import vn.com.giangdev.shoppinglist.data.db.entities.ShoppingItem

/**
 * Created by giangphanba on 20/05/2023.
 */
class ShoppingRepository(private val db: ShoppingDatabase) {

    suspend fun insert(item: ShoppingItem) = db.getShoppingDao().insert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}