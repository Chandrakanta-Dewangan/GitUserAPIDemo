package com.learning.domain.repository

import com.learning.domain.model.Users
import com.learning.domain.model.Result

interface ClassifiedListingRepository {
    suspend fun getAllUsers(): Result<Users>
}