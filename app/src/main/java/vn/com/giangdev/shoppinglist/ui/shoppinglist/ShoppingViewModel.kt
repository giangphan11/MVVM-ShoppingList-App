package vn.com.giangdev.shoppinglist.ui.shoppinglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import vn.com.giangdev.shoppinglist.data.db.entities.ShoppingItem
import vn.com.giangdev.shoppinglist.data.repo.ShoppingRepository

/**
 * Created by giangphanba on 20/05/2023.
 */
class ShoppingViewModel(private val repo: ShoppingRepository) : ViewModel() {

    fun addItem(item: ShoppingItem) = viewModelScope.launch {
        repo.insert(item)
    }

    fun delete(item: ShoppingItem) = viewModelScope.launch {
        repo.delete(item)
    }

    fun getListShoppingItems()  = repo.getAllShoppingItems()

}