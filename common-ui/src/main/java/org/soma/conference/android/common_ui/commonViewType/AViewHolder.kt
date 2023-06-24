package org.soma.conference.android.common_ui.commonViewType

import com.bumptech.glide.Glide
import org.soma.conference.android.common_ui.commonViewType.base.BaseCommonHolder
import org.soma.conference.android.common_ui.databinding.ItemABinding
import org.soma.conference.domain.viewtype.AViewVO
import org.soma.conference.domain.viewtype.ViewContent

class AViewHolder(private val binding: ItemABinding) : BaseCommonHolder(binding.root) {
    override fun bind(viewContent: ViewContent) {
        viewContent as AViewVO
        Glide.with(binding.root.context)
            .load(viewContent.iconUrl)
            .into(binding.aImage)
        binding.aText.text = viewContent.title
    }
}