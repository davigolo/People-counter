package com.example.peoplecounter.data.source.remote

import com.example.peoplecounter.AsyncResult
import com.example.peoplecounter.domain.model.bo.BusinessBO
import com.example.peoplecounter.domain.model.bo.EmployerBO
import com.example.peoplecounter.data.datasource.mapper.toBO
import com.example.peoplecounter.data.datasource.webservice.FirebaseWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FirebaseDataSourceImpl : FirebaseDataSource {


    /**Retrofit builder*/
    companion object {
        private val httpLoggingInterceptor: HttpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        private val okHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()

        private val retrofit = Retrofit.Builder()
            .baseUrl("https://firestore.googleapis.com/v1/projects/people-counter-97622/databases/(default)/documents/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    private val remoteFirebase = retrofit.create(FirebaseWebService::class.java)

    override suspend fun getEmployers(
        bossId: String,
        businessId: String
    ): Flow<AsyncResult<List<EmployerBO>>> {
        val response = remoteFirebase.getEmployers(bossId, businessId).execute()

        val userList: Flow<AsyncResult<List<EmployerBO>>> = flow {
            val user = response.body()
            try {
                if (response.isSuccessful) {
                    emit(AsyncResult.succes(user.toBO()))
                } else {
                    emit(AsyncResult.error(user.toBO(), response.message()))
                }
            } catch (ex: Exception) {
                emit(AsyncResult.exception(ex))
            }
        }
        return userList
    }

    override suspend fun createBusiness(
        bossId: String,
        newBusiness: BusinessBO
    ): Flow<AsyncResult<Boolean>> {
        val response = remoteFirebase.addBusiness(bossId, newBusiness).execute()
        val isBusinessCreatedFlow: Flow<AsyncResult<Boolean>> = flow {
            try {
                if (response.isSuccessful) {
                    emit(AsyncResult.succes(true))
                } else {
                    emit(AsyncResult.error(false, response.message()))
                }
            } catch (ex: Exception) {
                emit(AsyncResult.exception(ex))
            }
        }
        return isBusinessCreatedFlow
    }

    override suspend fun createEmployer(
        bossId: String,
        businessId: String,
        employerBO: EmployerBO
    ): Flow<AsyncResult<Boolean>> {
        val response = remoteFirebase.addEmployer(bossId, businessId, employerBO).execute()
        val isEmployeeCreatedFlow: Flow<AsyncResult<Boolean>> = flow {
            try {
                if (response.isSuccessful) {
                    emit(AsyncResult.succes(true))
                } else {
                    emit(AsyncResult.error(false, response.message()))
                }
            } catch (ex: Exception) {
                emit(AsyncResult.exception(ex))
            }
        }
        return isEmployeeCreatedFlow
    }

    override suspend fun getBusiness(bossId: String): Flow<AsyncResult<List<BusinessBO>>> {
        val response = remoteFirebase.getBusiness(bossId).execute()

        val businessList: Flow<AsyncResult<List<BusinessBO>>> = flow {
            val data = response.body()
            try {
                if (response.isSuccessful) {
                    emit(AsyncResult.succes(data.toBO()))
                } else {
                    emit(AsyncResult.error(data.toBO(), response.message()))
                }
            } catch (ex: Exception) {
                emit(AsyncResult.exception(ex))
            }
        }
        return businessList
    }

}