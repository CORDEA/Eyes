package jp.cordea.eyes

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.core.app.ActivityCompat
import dagger.android.support.DaggerAppCompatActivity
import jp.cordea.eyes.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainContract.View {
    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { }

        val granted = ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        if (!granted) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                0
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    override fun updateText(text: String) {
    }
}
