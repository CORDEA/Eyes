package jp.cordea.eyes

import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EyesApiClient @Inject constructor(
    retrofit: Retrofit
) : EyesApi {
    private val apiClient: EyesApi = retrofit.create()

    override suspend fun postLatLng(request: LatLngRequest): LatLngResponse =
        apiClient.postLatLng(request)
}
