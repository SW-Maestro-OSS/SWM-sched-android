package org.soma.conference.android.common_ui.commonViewType

import org.soma.conference.android.common_ui.commonViewType.base.BaseCommonHolder
import org.soma.conference.android.common_ui.databinding.ItemBBinding
import org.soma.conference.domain.viewtype.BViewVO
import org.soma.conference.domain.viewtype.ViewContent

class BViewHolder(private val binding: ItemBBinding) : BaseCommonHolder(binding.root) {
    override fun bind(viewContent: ViewContent) {
        viewContent as BViewVO
        binding.bText.text = viewContent.title
    }
}