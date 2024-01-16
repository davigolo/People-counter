package com.example.peoplecounter.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.peoplecounter.AsyncResult
import com.example.peoplecounter.domain.model.bo.EmployerBO
import com.example.peoplecounter.domain.firebaseusecases.GetUsersUseCase
import com.example.peoplecounter.domain.firebaseusecases.GetUsersUseCaseImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private val getUsersUseCase: GetUsersUseCase = GetUsersUseCaseImpl()
    private var employeeList: AsyncResult<List<EmployerBO>>? = null

    //Call requestEmployeeList before getEmployeeList
    fun getEmployeeList() = employeeList

    fun requestEmployeeList(bossId: String, businessId: String) {
        viewModelScope.launch (Dispatchers.IO) {
            val users = getUsersUseCase.getEmployers(bossId, businessId)
            users.collect {
                employeeList = it
            }
        }
    }
}