package jp.cordea.eyes

import android.location.Location
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MainPresenter @Inject constructor(
    private val view: MainContract.View,
    private val repository: LatLngRepository
) : MainContract.Presenter, CoroutineScope {
    override val coroutineContext: CoroutineContext get() = Dispatchers.Main + SupervisorJob()

    override fun observeLocation(channel: Channel<Location>) {
        launch(CoroutineExceptionHandler { _, throwable -> Timber.e(throwable) }) {
            for (c in channel) {
                val response = repository.postLatLng(c.latitude, c.longitude)
                view.updateText(response)
            }
        }
    }

    override fun destroy() {
        coroutineContext.cancel()
    }
}
