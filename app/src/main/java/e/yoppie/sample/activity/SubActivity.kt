package e.yoppie.sample.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import e.yoppie.sample.R
import e.yoppie.sample.databinding.ActivitySubBinding
import e.yoppie.sample.define.FragmentType
import e.yoppie.sample.viewmodel.SharedViewModel

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivitySubBinding>(this, R.layout.activity_sub)

        val sharedViewModel = ViewModelProviders.of(this).get(SharedViewModel::class.java)
        sharedViewModel.isSelected.observe(this, Observer { value ->
            value?.let {
                if (it != FragmentType.NOTHING) {
                    Snackbar.make(
                        findViewById(android.R.id.content), it.type, Snackbar.LENGTH_SHORT
                    ).show()
                    sharedViewModel.isSelected.postValue(FragmentType.NOTHING)
                }
            }
        })
    }
}
