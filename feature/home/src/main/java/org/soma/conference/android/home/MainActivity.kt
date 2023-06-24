package org.soma.conference.android.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.soma.conference.android.common_ui.BaseActivity
import org.soma.conference.android.common_ui.CommonListAdapter
import org.soma.conference.android.home.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: CommonListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initList()

        lifecycleScope.launch {
            viewModel.sceneVO.collect {
                adapter.setItems(it.contents)
                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun initList() {
        adapter = CommonListAdapter()
        binding.mainList.adapter = adapter
        binding.mainList.layoutManager = LinearLayoutManager(this)

        viewModel.initView()
    }
}