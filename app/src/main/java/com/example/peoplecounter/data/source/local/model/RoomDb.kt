package com.example.peoplecounter.data.source.local.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.peoplecounter.data.source.local.model.DAO.PeopleDao

@Database(
    entities = [PeopleCounter::class],
    version = 1
)
abstract class PeopleCounterDb: RoomDatabase() {
    abstract fun userDao(): PeopleDao
}