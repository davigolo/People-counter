package com.example.peoplecounter.domain.firebaseusecases

import com.example.peoplecounter.AsyncResult
import com.example.peoplecounter.domain.model.bo.BusinessBO
import kotlinx.coroutines.flow.Flow

class GetBusinessUseCaseImpl: GetBusinessUseCase {
    override suspend fun getBusiness(bossId: String): Flow<AsyncResult<List<BusinessBO>>> {
        return FirebaseRepoInstance.firebaseRepo.getBusiness(bossId)
    }
}