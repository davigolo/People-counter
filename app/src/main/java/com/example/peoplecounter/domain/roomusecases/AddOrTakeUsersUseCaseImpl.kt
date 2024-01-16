package com.example.peoplecounter.domain.roomusecases

import com.example.peoplecounter.AsyncResult
import com.example.peoplecounter.data.source.local.model.PeopleCounter
import kotlinx.coroutines.flow.Flow

class AddOrTakeUsersUseCaseImpl: AddOrTakeUsersUseCase {
    override suspend fun addOrTakeUsers(user: Int): Flow<AsyncResult<PeopleCounter>> {
        return RoomRepoInstance.roomRepoInstance.addOrTakeUsers(user)
    }
}