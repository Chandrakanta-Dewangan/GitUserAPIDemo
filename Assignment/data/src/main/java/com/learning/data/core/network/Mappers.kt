package com.learning.data.core.network
import com.learning.data.core.network.api.GetAllUserResponse
import com.learning.data.core.network.api.Result
import com.learning.domain.model.User
import com.learning.domain.model.Users
import kotlin.math.log

fun GetAllUserResponse.toDomain(): Users = Users(
    users = results.toDomain()
)

fun List<Result>.toDomain(): List<User> {
    val result = mutableListOf<User>()
    this.forEach {
        result.add(it.toDomain())
    }
    return result
}

fun Result.toDomain(): User = User(
    login = login,
    id = id,
    node_id = node_id,
    avatar_url = avatar_url,
    gravatar_id = gravatar_id,
    url = url,
    html_url = html_url,
    followers_url = followers_url,
    following_url = following_url,
    gists_url = gists_url,
    starred_url = starred_url,
    subscriptions_url = subscriptions_url,
    organizations_url = organizations_url,
    repos_url = repos_url,
    events_url = events_url,
    received_events_url = received_events_url,
    type = type,
    site_admin = site_admin,
    score = score
)