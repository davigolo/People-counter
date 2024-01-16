package com.example.peoplecounter.data.datasource.firebaserepo

import com.example.peoplecounter.AsyncResult
import com.example.peoplecounter.domain.model.bo.BusinessBO
import com.example.peoplecounter.domain.model.bo.EmployerBO
import kotlinx.coroutines.flow.Flow

interface FirebaseRepo {
    suspend fun getEmployers(bossId: String, businessId: String): Flow<AsyncResult<List<EmployerBO>>>
    suspend fun createBusiness(bossId: String, newBusiness: BusinessBO): Flow<AsyncResult<Boolean>>
    suspend fun createEmployer(bossId: String, businessId: String, employerBO: EmployerBO): Flow<AsyncResult<Boolean>>
    suspend fun getBusiness(bossId: String): Flow<AsyncResult<List<BusinessBO>>>
}