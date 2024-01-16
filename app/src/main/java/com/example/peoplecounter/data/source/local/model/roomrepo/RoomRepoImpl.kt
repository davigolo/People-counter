package com.example.peoplecounter.data.source.local.model.roomrepo

import androidx.room.Room
import com.example.peoplecounter.AsyncResult
import com.example.peoplecounter.data.source.local.model.PeopleCounter
import com.example.peoplecounter.data.source.local.model.PeopleCounterDb
import com.example.peoplecounter.presentation.MainActivity.Companion.context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RoomRepoImpl : RoomRepo {

    private val room: PeopleCounterDb = Room
        //inject context using dagger
        .databaseBuilder(context, PeopleCounterDb::class.java, "users")
        .build()

    override suspend fun addOrTakeUsers(user: Int): Flow<AsyncResult<PeopleCounter>> {
        val response = room.userDao().addOrTakeUsers(user)
        val users: Flow<AsyncResult<PeopleCounter>> = flow {
            val users: Flow<AsyncResult<PeopleCounter>> = flow {
                try {
                    //emit(AsyncResult.succes(response))
                } catch (ex: Exception) {
                    emit(AsyncResult.exception(ex))
                }
            }
        }
        return users
    }
}