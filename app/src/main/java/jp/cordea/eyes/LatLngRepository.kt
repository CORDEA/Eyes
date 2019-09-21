package jp.cordea.eyes

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LatLngRepository @Inject constructor(
    private val apiClient: EyesApiClient
) {
    suspend fun postLatLng(latitude: String, longitude: String): String =
        apiClient.postLatLng(LatLngRequest(latitude, longitude)).name
}
