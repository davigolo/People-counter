package com.example.peoplecounter.data.source.local.model.roomrepo

import com.example.peoplecounter.AsyncResult
import com.example.peoplecounter.data.source.local.model.PeopleCounter
import kotlinx.coroutines.flow.Flow

interface RoomRepo {
    suspend fun addOrTakeUsers(user: Int): Flow<AsyncResult<PeopleCounter>>
}
