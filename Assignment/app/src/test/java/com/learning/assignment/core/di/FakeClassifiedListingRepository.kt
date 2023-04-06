package com.learning.assignment.core.di

import com.learning.domain.model.Users
import com.learning.domain.model.Result
import com.learning.domain.repository.ClassifiedListingRepository
import com.learning.assignment.core.utils.FakeDataGenerator

class FakeClassifiedListingRepository : ClassifiedListingRepository {
    private val users = Users(FakeDataGenerator.getFakeUsers())
    override suspend fun getAllUsers(): Result<Users> {
        return Result.Success(users)
    }
}