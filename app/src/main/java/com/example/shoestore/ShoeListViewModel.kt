package com.example.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.modeks.Shoe

class ShoeListViewModel : ViewModel() {
    private var _shoeList = MutableLiveData<ArrayList<Shoe>>()
    val shoeList: LiveData<ArrayList<Shoe>> get() = _shoeList
    var shoeName = MutableLiveData<String>()
    var sizeName = MutableLiveData<String>()
    var company = MutableLiveData<String>()
    var description = MutableLiveData<String>()
    var state = false

    init {
        _shoeList.value = ArrayList<Shoe>()
    }

    fun addNewShoe(shoe: Shoe) {
        _shoeList.value?.add(shoe)
        clear()
        Log.i("ShoeListViewModel", "DONE ${_shoeList.value?.size}")
    }

    fun clear(){
        shoeName.value = ""
        sizeName.value = ""
        company.value = ""
        description.value = ""
    }
}