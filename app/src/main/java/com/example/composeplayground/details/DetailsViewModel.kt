package com.example.composeplayground.details

import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.composeplayground.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DetailsViewModelFactory(private val itemId: Int) :
    ViewModelProvider.NewInstanceFactory(){
        override fun <T : ViewModel> create(modelClass: Class<T>): T = DetailsViewModel(itemId = itemId) as T
    }

class DetailsViewModel(itemId: Int) : ViewModel() {

    //private lateinit var _item: MutableStateFlow<Item>

    private val _item = MutableStateFlow<Item>( getItemById(itemId) )

    val item: StateFlow<Item>
        get() = _item


    fun getItemById(id: Int): Item{
        val list: ArrayList<Item> = ArrayList<Item>()

        for (i in 0..20) {
            list.add(
                Item(
                    id = i,
                    imageRes = R.drawable.ic_launcher_background,
                    name = "numer " + i
                )
            )
        }
        return list.get(id)
    }
}

data class Item(
    val id: Int,
    @DrawableRes val imageRes: Int? = null,
    val price: String? = null,
    val name: String,
    val nestedItems: List<String> = emptyList(),
)