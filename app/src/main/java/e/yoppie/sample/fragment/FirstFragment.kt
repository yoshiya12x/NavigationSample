package e.yoppie.sample.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.jakewharton.rxbinding3.view.clicks
import e.yoppie.sample.R
import e.yoppie.sample.databinding.FragmentFirstBinding
import e.yoppie.sample.define.FragmentType
import e.yoppie.sample.viewmodel.SharedViewModel

class FirstFragment : Fragment() {

    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedViewModel::class.java)
    }

    @SuppressLint("CheckResult")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val binding = DataBindingUtil.inflate<FragmentFirstBinding>(
            inflater,
            R.layout.fragment_first,
            container,
            false
        )
        binding.apply {
            lifecycleOwner = this@FirstFragment
            destinationButton.clicks().subscribe {
                Navigation.findNavController(binding.root).navigate(R.id.action_first_to_second)
            }
            snackbarButton.clicks().subscribe {
                sharedViewModel.isSelected.postValue(FragmentType.FIRST)
            }
        }

        return binding.root
    }
}
