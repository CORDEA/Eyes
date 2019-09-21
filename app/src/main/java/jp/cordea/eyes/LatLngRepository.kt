package jp.cordea.eyes

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LatLngRepository @Inject constructor(
    private val apiClient: EyesApiClient
) {
    suspend fun postLatLng(latitude: Double, longitude: Double): String =
        apiClient.postLatLng(LatLngRequest(latitude.toString(), longitude.toString())).name
}
