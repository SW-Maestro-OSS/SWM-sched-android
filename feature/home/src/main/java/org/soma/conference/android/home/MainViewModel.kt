package org.soma.conference.android.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.soma.conference.domain.ExampleViewTypeUseCase
import org.soma.conference.domain.viewtype.AViewVO
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: ExampleViewTypeUseCase
) : ViewModel() {
    init {

    }

    fun initView() {
        viewModelScope.launch {
            val vo = useCase.getExampleViewType().first()
            Log.d("MainViewModel1", vo.sceneName)
            Log.d("MainViewModel2", "${vo.contents[0]}")
        }
    }
}