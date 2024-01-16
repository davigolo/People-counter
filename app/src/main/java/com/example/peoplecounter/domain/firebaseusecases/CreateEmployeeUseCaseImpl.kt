package com.example.peoplecounter.domain.firebaseusecases

import com.example.peoplecounter.AsyncResult
import com.example.peoplecounter.domain.model.bo.EmployerBO
import kotlinx.coroutines.flow.Flow

class CreateEmployeeUseCaseImpl: CreateEmployeeUseCase {
    override suspend fun createEmployer(
        bossId: String,
        businessId: String,
        employerBO: EmployerBO
    ): Flow<AsyncResult<Boolean>> {
        return FirebaseRepoInstance.firebaseRepo.createEmployer(bossId, businessId, employerBO)
    }
}