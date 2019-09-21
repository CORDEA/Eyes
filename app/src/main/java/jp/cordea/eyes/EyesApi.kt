package jp.cordea.eyes

import retrofit2.http.Body
import retrofit2.http.POST

interface EyesApi {
    @POST("/latlng")
    suspend fun postLatLng(@Body request: LatLngRequest): LatLngResponse
}
