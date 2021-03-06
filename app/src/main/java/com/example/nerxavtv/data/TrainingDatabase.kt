package com.example.nerxavtv.data
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nerxavtv.TrainingFragment

@Database(entities = [Training::class], version = 1)
abstract class TrainingDatabase : RoomDatabase() {
    abstract fun trainingDao(): TrainingDao
    companion object{
        @Volatile
        var INSTANCE: TrainingDatabase? = null

    fun getInstance(context: Context): TrainingDatabase {
        return INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                TrainingDatabase::class.java,
                "training_database")
                .fallbackToDestructiveMigration()
                .build()
                .also { INSTANCE = it }}}
    }
}