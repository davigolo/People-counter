package com.example.peoplecounter.domain.firebaseusecases

import com.example.peoplecounter.AsyncResult
import com.example.peoplecounter.domain.model.bo.BusinessBO
import kotlinx.coroutines.flow.Flow

interface CreateBusinessUseCase {
    suspend fun createBusiness(bossId: String, newBusiness: BusinessBO): Flow<AsyncResult<Boolean>>
}