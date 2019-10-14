package e.yoppie.sample.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.jakewharton.rxbinding3.view.clicks
import e.yoppie.sample.R
import e.yoppie.sample.databinding.ActivityMainBinding
import e.yoppie.sample.fragment.FirstFragment

class MainActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.button.clicks().subscribe {
            supportFragmentManager.beginTransaction().add(R.id.fragment_container_view, FirstFragment()).commit()
        }
    }
}
