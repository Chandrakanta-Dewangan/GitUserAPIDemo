package com.learning.data.core.network.api

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
//https://api.github.com/search/users?q=Q&page=1&per_page=100
interface ClassifiedListingApi {
    @GET("users?")
    @Headers("Content-type: application/json")
    suspend fun getAllUsers(@Query("q") q: String, @Query("page") page: String,
                          @Query("per_page") per_page: String): GetAllUserResponse
}

/*{
  "total_count": 8415,
  "incomplete_results": false,
  "items": [
    {
      "login": "q",
      "id": 65956,
      "node_id": "MDQ6VXNlcjY1OTU2",
      "avatar_url": "https://avatars.githubusercontent.com/u/65956?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/q",
      "html_url": "https://github.com/q",
      "followers_url": "https://api.github.com/users/q/followers",
      "following_url": "https://api.github.com/users/q/following{/other_user}",
      "gists_url": "https://api.github.com/users/q/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/q/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/q/subscriptions",
      "organizations_url": "https://api.github.com/users/q/orgs",
      "repos_url": "https://api.github.com/users/q/repos",
      "events_url": "https://api.github.com/users/q/events{/privacy}",
      "received_events_url": "https://api.github.com/users/q/received_events",
      "type": "User",
      "site_admin": false,
      "score": 1.0
    },
 */
data class GetAllUserResponse(
    @SerializedName("total_count") val pagination: Any,
    @SerializedName("incomplete_results") val incomplete_result: Any,
    @SerializedName("items") val results: List<Result>
)


data class Result(
    @SerializedName("login") val login: String,
    @SerializedName("id") val id: Int,
    @SerializedName("node_id") val node_id: String,
    @SerializedName("avatar_url") val avatar_url: String,
    @SerializedName("gravatar_id") val gravatar_id: String,
    @SerializedName("url") val url: String,
    @SerializedName("html_url") val html_url: String,
    @SerializedName("followers_url") val followers_url: String,
    @SerializedName("following_url") val following_url: String,
    @SerializedName("gists_url") val gists_url: String,
    @SerializedName("starred_url") val starred_url: String,
    @SerializedName("subscriptions_url") val subscriptions_url: String,
    @SerializedName("organizations_url") val organizations_url: String,
    @SerializedName("repos_url") val repos_url: String,
    @SerializedName("events_url") val events_url: String,
    @SerializedName("received_events_url") val received_events_url: String,
    @SerializedName("type") val type: String,
    @SerializedName("site_admin") val site_admin: Boolean,
    @SerializedName("score") val score: Double
)