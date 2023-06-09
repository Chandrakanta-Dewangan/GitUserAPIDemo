package com.learning.data.core.impl

import com.learning.data.core.dao.ClassifiedListingDao
import com.learning.domain.model.Users
import com.learning.domain.model.Result
import com.learning.domain.repository.ClassifiedListingRepository
import javax.inject.Inject

class ClassifiedListingRepositoryImpl @Inject constructor(
    private val classifiedListingDao: ClassifiedListingDao
) : ClassifiedListingRepository {

    override suspend fun getAllUsers(): Result<Users> {
        return classifiedListingDao.getAllUsers()
    }
}