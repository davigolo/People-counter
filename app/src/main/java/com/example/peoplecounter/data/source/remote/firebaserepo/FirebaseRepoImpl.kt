package com.example.peoplecounter.data.datasource.firebaserepo

import com.example.peoplecounter.AsyncResult
import com.example.peoplecounter.domain.model.bo.BusinessBO
import com.example.peoplecounter.domain.model.bo.EmployerBO
import com.example.peoplecounter.data.source.remote.FirebaseDataSource
import com.example.peoplecounter.data.source.remote.FirebaseDataSourceImpl
import kotlinx.coroutines.flow.Flow

class FirebaseRepoImpl: FirebaseRepo {
    private val firebaseDataSource: FirebaseDataSource by lazy { FirebaseDataSourceImpl() }

    override suspend fun getEmployers(bossId: String, businessId: String): Flow<AsyncResult<List<EmployerBO>>> {
        return firebaseDataSource.getEmployers(bossId, businessId)
    }

    override suspend fun createBusiness(bossId: String, newBusiness: BusinessBO): Flow<AsyncResult<Boolean>> {
        return firebaseDataSource.createBusiness(bossId, newBusiness)
    }

    override suspend fun createEmployer(
        bossId: String,
        businessId: String,
        employerBO: EmployerBO
    ): Flow<AsyncResult<Boolean>> {
        return firebaseDataSource.createEmployer(bossId, businessId, employerBO)
    }

    override suspend fun getBusiness(bossId: String): Flow<AsyncResult<List<BusinessBO>>> {
        return firebaseDataSource.getBusiness(bossId)
    }
}