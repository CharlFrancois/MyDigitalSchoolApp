package com.example.nerxavtv.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

    @Dao
    interface TrainingDao {
        // Récupére l'ensemble de la collection "training"
        @Query("SELECT * FROM training")
        fun getAll(): List<Training>

        // Récupére un élement de la collection "training" par rapport à l'id qu'on lui passe en paramètre
        @Query("SELECT * FROM training WHERE id = :id")
        fun getOneById(id: Int): Training

        // Ajoute un élément à la collection "training'
        @Insert
        fun insert(vararg training: Training)
    }
