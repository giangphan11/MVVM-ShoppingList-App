package vn.com.giangdev.shoppinglist

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import vn.com.giangdev.shoppinglist.data.db.ShoppingDatabase
import vn.com.giangdev.shoppinglist.data.repo.ShoppingRepository
import vn.com.giangdev.shoppinglist.ui.shoppinglist.ShoppingViewModelFactory

/**
 * Created by giangphanba on 20/05/2023.
 */
class MyApplication : Application(), KodeinAware{
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@MyApplication))

        bind() from singleton { ShoppingDatabase(instance()) }
        bind() from singleton { ShoppingRepository(instance()) }
        bind() from provider { ShoppingViewModelFactory(instance()) }
    }

}