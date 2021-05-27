package com.example.nerxavtv.data
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.time.chrono.HijrahChronology.INSTANCE

@Database(entities = [Training::class], version = 1)
abstract class TrainingDatabase : RoomDatabase() {
    abstract fun trainingDao(): TrainingDao
    companion object{
        @Volatile
        private var INSTANCE: TrainingDatabase? = null

    fun getInstance(context: Context): TrainingDatabase {
        return INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                TrainingDatabase::class.java,
                "color_database")
                .fallbackToDestructiveMigration()
                .build()
                .also { INSTANCE = it }}}
    }
}