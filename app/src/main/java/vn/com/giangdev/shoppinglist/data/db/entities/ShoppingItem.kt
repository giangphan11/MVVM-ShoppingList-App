package vn.com.giangdev.shoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by giangphanba on 20/05/2023.
 */
@Entity(tableName = "shopping_items")
data class ShoppingItem(
    @ColumnInfo(name = "item_name")
    var name: String = "",

    @ColumnInfo(name = "item_amount")
    var amount: Int = 0
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
