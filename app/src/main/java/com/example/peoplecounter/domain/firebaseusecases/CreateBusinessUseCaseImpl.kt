package com.example.peoplecounter.domain.firebaseusecases

import com.example.peoplecounter.AsyncResult
import com.example.peoplecounter.domain.model.bo.BusinessBO
import kotlinx.coroutines.flow.Flow

class CreateBusinessUseCaseImpl: CreateBusinessUseCase {
    override suspend fun createBusiness(bossId: String, newBusiness: BusinessBO): Flow<AsyncResult<Boolean>> {
        return FirebaseRepoInstance.firebaseRepo.createBusiness(bossId, newBusiness)
    }
}