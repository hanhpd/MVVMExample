package com.example.mvvmexample.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

import com.example.mvvmexample.models.NicePlace

class MainViewModel: ViewModel() {
    var lst = MutableLiveData<ArrayList<NicePlace>>()
    var newlist = arrayListOf<NicePlace>()

    fun add(blog: NicePlace){
        newlist.add(blog)
        lst.value=newlist
    }

    fun remove(blog: NicePlace){
        newlist.remove(blog)
        lst.value=newlist
    }

}