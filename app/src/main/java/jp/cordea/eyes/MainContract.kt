package jp.cordea.eyes

import android.location.Location
import kotlinx.coroutines.channels.Channel

interface MainContract {
    interface View {
        fun updateText(text: String)
    }

    interface Presenter {
        fun observeLocation(channel: Channel<Location>)
        fun destroy()
    }
}
