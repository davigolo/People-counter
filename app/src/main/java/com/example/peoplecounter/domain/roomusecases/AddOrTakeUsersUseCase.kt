package com.example.peoplecounter.domain.roomusecases

import com.example.peoplecounter.AsyncResult
import com.example.peoplecounter.data.source.local.model.PeopleCounter
import kotlinx.coroutines.flow.Flow

interface AddOrTakeUsersUseCase {
    suspend fun addOrTakeUsers(user: Int): Flow<AsyncResult<PeopleCounter>>
}