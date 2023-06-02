package vn.com.giangdev.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import vn.com.giangdev.shoppinglist.data.db.entities.ShoppingItem

/**
 * Created by giangphanba on 20/05/2023.
 */
@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase : RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao

    companion object{
        @Volatile
        private var instance: ShoppingDatabase ?= null

        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: crateDatabase(context)
        }

        private fun crateDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            ShoppingDatabase::class.java, name = "ShoppingDB.dp"
        ).build()
    }
}