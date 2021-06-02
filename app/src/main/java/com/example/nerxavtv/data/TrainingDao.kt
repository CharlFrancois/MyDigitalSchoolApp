package com.example.nerxavtv.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

    @Dao
    interface TrainingDao {
        @Query("SELECT * FROM training")
        fun getAll(): List<Training>

        @Insert
        fun insert(vararg training: Training)
    }
