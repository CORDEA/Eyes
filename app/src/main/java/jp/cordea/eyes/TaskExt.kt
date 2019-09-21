package jp.cordea.eyes

import com.google.android.gms.tasks.Task
import kotlinx.coroutines.channels.Channel

fun <T> Task<T>.asChannel(): Channel<T> {
    val channel = Channel<T>()
    addOnSuccessListener {
        if (it == null) {
            channel.close(IllegalArgumentException())
        } else {
            channel.offer(it)
        }
    }
    addOnFailureListener {
        channel.close(it)
    }
    return channel
}
