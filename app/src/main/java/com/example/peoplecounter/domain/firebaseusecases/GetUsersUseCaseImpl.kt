package com.example.peoplecounter.domain.firebaseusecases

import com.example.peoplecounter.AsyncResult
import com.example.peoplecounter.domain.model.bo.EmployerBO
import kotlinx.coroutines.flow.Flow

class GetUsersUseCaseImpl: GetUsersUseCase {
    override suspend fun getEmployers(bossId: String, businessId: String): Flow<AsyncResult<List<EmployerBO>>> {
        return FirebaseRepoInstance.firebaseRepo.getEmployers(bossId, businessId)
    }
}