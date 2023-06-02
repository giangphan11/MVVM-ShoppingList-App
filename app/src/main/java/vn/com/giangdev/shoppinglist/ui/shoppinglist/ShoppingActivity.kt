package vn.com.giangdev.shoppinglist.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import vn.com.giangdev.shoppinglist.R
import vn.com.giangdev.shoppinglist.adapter.ShoppingItemAdapter
import vn.com.giangdev.shoppinglist.data.db.ShoppingDatabase
import vn.com.giangdev.shoppinglist.data.repo.ShoppingRepository
import vn.com.giangdev.shoppinglist.databinding.ActivityMainBinding
import vn.com.giangdev.shoppinglist.ui.dialog.AddShoppingItemDialog

class ShoppingActivity : AppCompatActivity(),  KodeinAware{

    lateinit var viewBinding: ActivityMainBinding

    lateinit var viewModel: ShoppingViewModel

    lateinit var adapter: ShoppingItemAdapter

    override val kodein by kodein()

    private val factory: ShoppingViewModelFactory by instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setSupportActionBar(viewBinding.toolbar)

        viewModel = ViewModelProvider(this, factory = factory).get(ShoppingViewModel::class.java)
        this.initAdapter()

        viewBinding.fabAddShoppingItem.setOnClickListener {
            val addShoppingDialog = AddShoppingItemDialog(context = this, viewModel = viewModel)
            addShoppingDialog.show()
        }

        viewModel.getListShoppingItems().observe(this){items ->
            this.adapter.items = items
            adapter.notifyDataSetChanged()
        }

    }

    private fun initAdapter(){
        adapter = ShoppingItemAdapter(listOf(), viewModel)
        with(viewBinding){
            rcvShoppingList.layoutManager = LinearLayoutManager(this@ShoppingActivity)
            rcvShoppingList.adapter = this@ShoppingActivity.adapter
        }
    }
}