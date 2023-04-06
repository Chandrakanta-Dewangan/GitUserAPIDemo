package com.learning.domain.interactor

import com.learning.domain.interactor.base.UseCase
import com.learning.domain.model.Users
import com.learning.domain.model.OrderType
import com.learning.domain.model.Result
import com.learning.domain.repository.ClassifiedListingRepository
import javax.inject.Inject

class GetAllUserUseCase @Inject constructor(
    private val repo: ClassifiedListingRepository
) : UseCase<Result<Users>, GetAllUserUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<Users> {
        params!!
        return when (val result = repo.getAllUsers()) {
            is Result.Error -> {
                result
            }
            is Result.Success<Users> -> {
                val sortedList = when (params.orderType) {
                    OrderType.Ascending -> result.data.users.sortedBy { it.login }
                    OrderType.Descending -> result.data.users.sortedByDescending { it.login }
                }
                Result.Success(Users(sortedList))
            }
        }
    }

    data class Params(val orderType: OrderType)
}