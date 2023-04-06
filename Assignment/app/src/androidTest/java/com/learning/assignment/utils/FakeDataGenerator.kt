package com.learning.assignment.utils

import com.learning.domain.model.User

object FakeDataGenerator {
    fun getFakeUsers(): List<User> {
        val users = mutableListOf<User>()
        for (i in 1 until 6) {
            users.add(
                User(
                    login = "Fake $i",
                    id = 20704777,
                    node_id = "MDQ6VXNlcjIwNzA0Nzc3",
                    avatar_url = "https://avatars.githubusercontent.com/u/20704777?v=4",
                    gravatar_id = "",
                    url = "https://api.github.com/users/499453466",
                    html_url = "https://github.com/499453466",
                    followers_url = "https://api.github.com/users/499453466/followers",
                    following_url = "https://api.github.com/users/499453466/following{/other_user}",
                    gists_url = "https://api.github.com/users/499453466/gists{/gist_id}",
                    starred_url = "https://api.github.com/users/499453466/starred{/owner}{/repo}",
                    subscriptions_url = "https://api.github.com/users/499453466/subscriptions",
                    organizations_url = "https://api.github.com/users/499453466/orgs",
                    repos_url = "https://api.github.com/users/499453466/repos",
                    events_url = "https://api.github.com/users/499453466/events{/privacy}",
                    received_events_url = "https://api.github.com/users/499453466/received_events",
                    type = "User",
                    site_admin = false,
                    score = 1.0
                )
            )
        }
        return users
    }


}