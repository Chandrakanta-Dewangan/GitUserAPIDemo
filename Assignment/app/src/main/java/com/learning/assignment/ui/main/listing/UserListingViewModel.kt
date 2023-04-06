package com.learning.assignment.ui.main.listing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.learning.domain.interactor.GetAllUserUseCase
import com.learning.domain.model.User
import com.learning.domain.model.Users
import com.learning.domain.model.OrderType
import com.learning.domain.model.Result
import com.learning.assignment.ui.main.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListingViewModel @Inject constructor(
    private val getAllUserUseCase: GetAllUserUseCase
) : BaseViewModel() {

    private var sort: OrderType = OrderType.Ascending

    private val _users: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>()
    }

    val users: LiveData<List<User>> get() = _users

    fun loadData() {
        viewModelScope.launch {
            showLoader()
            val result = getAllUserUseCase.execute(GetAllUserUseCase.Params(sort))
            hideLoader()
            when (result) {
                is Result.Success<Users> -> {
                    val allAds = result.data.users
                    if (allAds.isNotEmpty()) {
                        _users.postValue(allAds)
                    }
                }
                is Result.Error -> {
                    result.exception.message?.let { showToast(it) }
                }
            }
        }
    }

    fun sort() {
        sort = when(sort) {
            OrderType.Ascending -> {
                OrderType.Descending
            }
            OrderType.Descending -> {
                OrderType.Ascending
            }
        }
        val currentList = _users.value!!
        val sortedList = when (sort) {
            OrderType.Ascending -> currentList.sortedBy { it.login }
            OrderType.Descending -> currentList.sortedByDescending { it.login }
        }
        _users.postValue(sortedList)
    }

}