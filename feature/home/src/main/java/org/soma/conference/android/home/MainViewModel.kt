package org.soma.conference.android.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.soma.conference.domain.ExampleViewTypeUseCase
import org.soma.conference.domain.viewtype.SceneVO
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: ExampleViewTypeUseCase
) : ViewModel(), OnClickListItemListener {

    private val _sceneVO = MutableStateFlow(SceneVO.empty())
    val sceneVO = _sceneVO.asStateFlow()

    fun initView() {
        viewModelScope.launch {
            useCase.getExampleViewType().collect {
                _sceneVO.emit(it)
            }
        }
    }

    override fun onClickListItem() {

    }
}

interface OnClickListItemListener {
    fun onClickListItem()
}