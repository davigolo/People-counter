package com.example.peoplecounter.domain.firebaseusecases

import com.example.peoplecounter.AsyncResult
import com.example.peoplecounter.domain.model.bo.EmployerBO
import kotlinx.coroutines.flow.Flow

interface GetUsersUseCase {
    suspend fun getEmployers(bossId: String, businessId: String): Flow<AsyncResult<List<EmployerBO>>>
}