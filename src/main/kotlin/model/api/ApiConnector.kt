package model.api

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import model.classes.CategoryClass
import model.classes.ProductClass
import model.classes.apiResponseClasses.*

//http://localhost:3000/card?useruid=1
//http://localhost:3000/card?useruid=1&productuid=1&count=1
class ApiConnector {
    private val connection = "http://localhost:3000"
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true }) // позволяет игнорировать лишние поля
        }
    }

    suspend fun fetchCategories(): List<CategoryClass> {
        val response: List<CategoryResponse> = client.get("$connection/category").body()
        return response.map { it.toCategory() }
    }

    suspend fun fetchProducts(categoryUid: Int): List<ProductClass> {
        val response: List<ProductsResponse> = client.get("$connection/products?categoryuid=$categoryUid").body()
        println(response)
        return response.map { it.toProductClass() }
    }

    suspend fun addToCart(useruid: Int = 1, productuid: Int, count: Int) {
        val client = HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }

        val response: HttpResponse = client.post("http://localhost:3000/card") {
            contentType(ContentType.Application.Json)
            setBody(CartRequest(useruid, productuid, count))
        }

        val responseText = response.bodyAsText()
        println("Ответ сервера: $responseText")

        client.close()
    }
    suspend fun fetchCartItems(): List<ProductClass> {
        val client = HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                })
            }
        }

        val res: List<CartItemResponse> = client.get("http://localhost:3000/card?useruid=1").body()
        val items = res.map {it.toProduct()}
        client.close()
        return items
    }

    suspend fun addToFavs(useruid: Int = 1, productuid: Int) {
        val client = HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }

        val response: HttpResponse = client.post("http://localhost:3000/favorite") {
            contentType(ContentType.Application.Json)
            setBody(FavRequest(useruid, productuid))
        }

        val responseText = response.bodyAsText()
        println("Ответ сервера: $responseText")

        client.close()
    }
    suspend fun getFavs(useruid: Int = 1): List<ProductClass> {
        val response: List<ProductsResponse> = client.get("$connection/favorite?useruid=$useruid").body()
        println(response)
        return response.map { it.toProductClass() }
    }
}