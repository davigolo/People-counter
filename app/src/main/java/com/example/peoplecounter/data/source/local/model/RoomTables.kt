package com.example.peoplecounter.data.source.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class PeopleCounter(
    @PrimaryKey
    val totalPeople: Int? = null
)