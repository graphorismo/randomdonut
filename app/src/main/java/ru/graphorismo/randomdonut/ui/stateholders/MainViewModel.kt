package ru.graphorismo.randomdonut.ui.stateholders

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import ru.graphorismo.randomdonut.data.model.DonutData
import ru.graphorismo.randomdonut.data.repository.DonutRepository

class MainViewModel : ViewModel() {

    var repo : DonutRepository = DonutRepository.getInstance()

    private var _donutData = MutableLiveData<DonutData>(null)
    val donutData: LiveData<DonutData> = _donutData

    init{
        updateDonutData()
    }

    fun updateDonutData(){
        viewModelScope.launch {
            try {
                _donutData.value = repo.getRandomDonut()
            } catch (ex: Exception) {
                Log.e("DONUT", "Cant finish the network respond: ${ex.message}")
            }
        }
    }
}