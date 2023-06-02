package vn.com.giangdev.shoppinglist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vn.com.giangdev.shoppinglist.R
import vn.com.giangdev.shoppinglist.data.db.entities.ShoppingItem
import vn.com.giangdev.shoppinglist.databinding.ShoppingItemBinding
import vn.com.giangdev.shoppinglist.ui.shoppinglist.ShoppingViewModel

/**
 * Created by giangphanba on 20/05/2023.
 */
class ShoppingItemAdapter(var items: List<ShoppingItem>, val viewModel: ShoppingViewModel) :
    RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(val viewBinding: ShoppingItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(ShoppingItemBinding.bind(view))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val shoppingItem = items[position]
        with(holder.viewBinding){
            tvName.text = shoppingItem.name
            tvAmount.text = shoppingItem.amount.toString()
        }

        holder.viewBinding.imgDelete.setOnClickListener {
            viewModel.delete(shoppingItem)
        }

        holder.viewBinding.imgPlus.setOnClickListener {
            shoppingItem.amount ++
            viewModel.addItem(shoppingItem)
        }

        holder.viewBinding.imgMinus.setOnClickListener {

            shoppingItem.amount --
            viewModel.addItem(shoppingItem)
            if (shoppingItem.amount == 0){
                viewModel.delete(shoppingItem)
            }
        }
    }
}