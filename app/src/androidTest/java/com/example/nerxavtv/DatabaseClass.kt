package com.example.nerxavtv

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.nerxavtv.data.Training
import com.example.nerxavtv.data.TrainingDao
import com.example.nerxavtv.data.TrainingDatabase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class DatabaseClass {
    private lateinit var trainingDao: TrainingDao
    private lateinit var db: TrainingDatabase

    private val training1 = Training(id = 1,
        title = "Bachelor E-Business",
        description = "certification professionnelle reconnue par l'État de niveau 6 : \"Concepteur Réalisateur Web et Digital\". Arrêté du 11 juillet 2018 publié au JO du 21 juillet 2018. Efficom.",
        code = "RNCP29826")

    private val training2 = Training(id = 2,
        title = "Bachelor Webmarketing & Social media",
        description = "certification professionnelle reconnue par l'État de niveau 6 : \"Concepteur Réalisateur Web et Digital\". Arrêté du 11 juillet 2018 publié au JO du 21 juillet 2018. Efficom.",
        code = "RNCP29826")

    private val training3 = Training(id = 3,
        title = "Bachelor Webdesign",
        description = "certification professionnelle reconnue par l'État de niveau 6 : \"Concepteur Réalisateur Web et Digital\". Arrêté du 11 juillet 2018 publié au JO du 21 juillet 2018. Efficom.",
        code = "RNCP29826")


    @Before
    fun createDb() {
        val context: Context = ApplicationProvider.getApplicationContext()
        db = Room.inMemoryDatabaseBuilder(context, TrainingDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        trainingDao = db.trainingDao()}

    @After
    @Throws(IOException::class)
    fun closeDb() = db.close()

    @Test
    @Throws(Exception::class)
    fun insertAndRetrieve() {
        trainingDao.insert(training1, training2, training3)
        val training = trainingDao.getAll()
        assert(training.size == 3)
    }
}
