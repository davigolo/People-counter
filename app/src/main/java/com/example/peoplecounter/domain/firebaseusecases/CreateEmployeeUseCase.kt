package com.example.peoplecounter.domain.firebaseusecases

import com.example.peoplecounter.AsyncResult
import com.example.peoplecounter.domain.model.bo.EmployerBO
import kotlinx.coroutines.flow.Flow

interface CreateEmployeeUseCase {
    suspend fun createEmployer(bossId: String, businessId: String, employerBO: EmployerBO): Flow<AsyncResult<Boolean>>
}