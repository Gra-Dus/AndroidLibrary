package com.example.library.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.library.db
import com.example.library.db.models.CountReaders
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {
    var number: MutableLiveData<Int> = MutableLiveData()
    var savedNumber: MutableLiveData<List<CountReaders>> = MutableLiveData()
    fun plus() {
        if (number.value != null) {
            number.postValue(number.value!! + 1)
        } else {
            number.postValue(1)
        }

    }

    fun minus() {
        if (number.value != null && number.value!! > 0) {
            number.postValue(number.value!! - 1)
        }
    }

    fun set(id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO) {
                val model = db?.dao()?.getCounterByDate(id)?.count?.toInt()
                number.postValue(model?:0)
            }
        }
    }

    fun saveData(data: Int, number: String) {
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO) {
                db?.dao()?.insertCounter(
                    CountReaders(
                        date = data,
                        count = number
                    )
                )
                savedNumber.postValue(db?.dao()?.getCounters())
            }
        }
    }

    fun getData() {
        savedNumber.postValue(db?.dao()?.getCounters())
    }

    fun isExist(i: Int): Boolean {
        val bool: Boolean? = null
        return bool != null && bool == true
    }

    fun clear() {
        number.postValue(0)
    }
}