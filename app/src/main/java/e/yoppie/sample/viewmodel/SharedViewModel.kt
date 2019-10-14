package e.yoppie.sample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import e.yoppie.sample.define.FragmentType

class SharedViewModel : ViewModel(){
    val isSelected = MutableLiveData<FragmentType>().apply {
        this.value = FragmentType.NOTHING
    }
}
