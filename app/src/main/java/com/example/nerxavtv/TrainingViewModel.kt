package com.example.nerxavtv

import android.app.Application
import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nerxavtv.data.Training
import com.example.nerxavtv.data.TrainingDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class TrainingViewModel : ViewModel() {
    val training: MutableLiveData<Training?> = MutableLiveData<Training?>(null)
    fun findTrainingById(i: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val t = trainingDao?.getOneById(i)
            withContext(Dispatchers.Main) {
                training.value = t
            }
        }
    }

    private val trainingDao = TrainingDatabase.INSTANCE?.trainingDao()

    private val training1 = com.example.nerxavtv.data.Training(
        id = 1,
        title = "Bachelor E-Business",
        description = "certification professionnelle reconnue par l'État de niveau 6 : \"Concepteur Réalisateur Web et Digital\". Arrêté du 11 juillet 2018 publié au JO du 21 juillet 2018. Efficom.",
        code = "RNCP29826"
    )

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                trainingDao?.insert(training1)
            }
            catch (e: Exception) {}
        }
    }

    var title : String? = null
    var description : String? = null
    var code : String? = null
}
