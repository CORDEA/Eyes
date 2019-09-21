package jp.cordea.eyes

interface MainContract {
    interface View {
        fun updateText(text: String)
    }

    interface Presenter {
        fun postLatLng(latitude: String, longitude: String)
        fun destroy()
    }
}
