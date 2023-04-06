package com.learning.assignment.interactor

import com.google.common.truth.Truth.assertThat
import com.learning.domain.interactor.GetAllUserUseCase
import com.learning.domain.model.Users
import com.learning.domain.model.Result
import com.learning.domain.model.OrderType
import com.learning.assignment.core.di.FakeClassifiedListingRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetAllUserUseCaseTest {

    private lateinit var getAllUserUseCase: GetAllUserUseCase
    private lateinit var fakeRepository: FakeClassifiedListingRepository

    @Before
    fun setUp() {
        fakeRepository = FakeClassifiedListingRepository()
        getAllUserUseCase = GetAllUserUseCase(fakeRepository)
    }

    @Test
    fun `Get_Users_Count`() = runBlocking {

        val result = getAllUserUseCase.execute(GetAllUserUseCase.Params(OrderType.Ascending))

        assertThat(result).isInstanceOf(Result.Success::class.java)

        val usersResult = result as Result.Success<Users>

        assertThat(usersResult.data).isNotNull()

        val users = usersResult.data.users

        assertThat(users).isNotNull()

        assertThat(users).hasSize(5)
    }

    @Test
    fun `Get_Users_Title`() = runBlocking {

        val result = getAllUserUseCase.execute(GetAllUserUseCase.Params(OrderType.Ascending))

        assertThat(result).isInstanceOf(Result.Success::class.java)

        val usersResult = result as Result.Success<Users>

        assertThat(usersResult.data).isNotNull()

        val users = usersResult.data.users

        assertThat(users).isNotNull()

        for (i in users.indices) {
            assertThat(users[i].login).isEqualTo("Fake ${i + 1}")
        }
    }

    @Test
    fun `Get_Users_Sort_By_Name_Ascending`() = runBlocking {

        val result = getAllUserUseCase.execute(GetAllUserUseCase.Params(OrderType.Ascending))

        assertThat(result).isInstanceOf(Result.Success::class.java)

        val usersResult = result as Result.Success<Users>

        assertThat(usersResult.data).isNotNull()

        val users = usersResult.data.users

        assertThat(users).isNotNull()

        for(i in 0..users.size - 2) {
            assertThat(users[i].login).isLessThan(users[i+1].login)
        }
    }

    @Test
    fun `Get_Users_Sort_By_Name_Descending`() = runBlocking {

        val result = getAllUserUseCase.execute(GetAllUserUseCase.Params(OrderType.Descending))

        assertThat(result).isInstanceOf(Result.Success::class.java)

        val usersResult = result as Result.Success<Users>

        assertThat(usersResult.data).isNotNull()

        val users = usersResult.data.users

        assertThat(users).isNotNull()

        for(i in 0..users.size - 2) {
            assertThat(users[i].login).isGreaterThan(users[i+1].login)
        }
    }
}