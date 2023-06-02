package vn.com.giangdev.shoppinglist.ui.dialog

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import vn.com.giangdev.shoppinglist.data.db.entities.ShoppingItem
import vn.com.giangdev.shoppinglist.databinding.DialogAddShoppingItemBinding
import vn.com.giangdev.shoppinglist.ui.shoppinglist.ShoppingViewModel

/**
 * Created by giangphanba on 20/05/2023.
 */
class AddShoppingItemDialog( context: Context, val viewModel: ShoppingViewModel): AppCompatDialog(context) {

    lateinit var viewBinding: DialogAddShoppingItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        viewBinding = DialogAddShoppingItemBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        with(viewBinding){
            btnCancel.setOnClickListener {
                this@AddShoppingItemDialog.dismiss()
            }

            btnAdd.setOnClickListener {
                val name = etName.text.toString()
                val amount = etAmount.text.toString().toInt()
                if (name.isEmpty()){
                    Toast.makeText(context, "Pls, enter a name", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
                val shoppingItem = ShoppingItem(name = name, amount = amount)
                viewModel.addItem(shoppingItem)
                dismiss()
            }
        }
    }
}