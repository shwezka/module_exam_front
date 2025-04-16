package model.api

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import model.classes.CategoryClass
import model.classes.apiResponseClasses.CategoryResponse
import model.classes.apiResponseClasses.toCategory

class ApiConnector {
    private val connection = "http://localhost:3000/"
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true }) // позволяет игнорировать лишние поля
        }
    }

    suspend fun fetchCategories(): List<CategoryClass> {
        val response: List<CategoryResponse> = client.get("http://localhost:3000/category").body()
        return response.map { it.toCategory() }
    }
}