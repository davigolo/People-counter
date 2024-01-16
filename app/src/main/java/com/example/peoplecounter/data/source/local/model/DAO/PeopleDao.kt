package com.example.peoplecounter.data.source.local.model.DAO

import androidx.room.Dao
import androidx.room.Query
import com.example.peoplecounter.data.source.local.model.PeopleCounter

@Dao
interface PeopleDao {
    @Query("UPDATE PeopleCounter SET totalPeople = totalPeople + :people ")
    suspend fun addOrTakeUsers(people: Int): Void
}