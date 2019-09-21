package jp.cordea.eyes

import kotlinx.coroutines.*
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MainPresenter @Inject constructor(
    private val view: MainContract.View,
    private val repository: LatLngRepository
) : MainContract.Presenter, CoroutineScope {
    override val coroutineContext: CoroutineContext get() = Dispatchers.Main + SupervisorJob()

    override fun postLatLng(latitude: String, longitude: String) {
        launch(CoroutineExceptionHandler { _, throwable -> Timber.e(throwable) }) {
            val response = repository.postLatLng(latitude, longitude)
            view.updateText(response)
        }
    }

    override fun destroy() {
        coroutineContext.cancel()
    }
}
