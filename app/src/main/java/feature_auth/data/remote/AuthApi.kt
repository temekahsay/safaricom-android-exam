package temesgen.girmay.safaricom.feature_auth.data.remote


import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class LoginRequest(
    val pin: String
)

@Serializable
data class UserDto(
    val id: String,
    val name: String,
    val phoneNumber: String,
    val email: String,
    val balance: Double,
    val currency: String
)

@Serializable
data class LoginDataDto(
    val user: UserDto,
    val token: String,
    val expiresIn: Long
)

@Serializable
data class ErrorDetailDto(
    val code: String,
    val details: String
)

@Serializable
data class LoginResponse(
    val success: Boolean,
    val message: String,
    val data: LoginDataDto? = null,
    val error: ErrorDetailDto? = null
)

class AuthApiService {

    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                coerceInputValues = true
            })
        }
    }

    suspend fun login(pin: String): Result<LoginResponse> = withContext(Dispatchers.IO) {
        try {
            val response: LoginResponse = client.post("https://api.mockfly.dev/mocks/5064738f-5131-4b0a-8909-ca1634e26c27/login") {
                contentType(ContentType.Application.Json)
                setBody(LoginRequest(pin = pin))
            }.body()

            if (response.success) {
                Result.success(response)
            } else {
                Result.failure(Exception(response.message))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}