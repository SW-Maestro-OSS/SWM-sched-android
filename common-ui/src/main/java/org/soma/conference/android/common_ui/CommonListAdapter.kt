package org.soma.conference.android.common_ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.soma.conference.android.common_ui.commonViewType.AViewHolder
import org.soma.conference.android.common_ui.commonViewType.BViewHolder
import org.soma.conference.android.common_ui.commonViewType.base.BaseCommonHolder
import org.soma.conference.android.common_ui.databinding.ItemABinding
import org.soma.conference.android.common_ui.databinding.ItemBBinding
import org.soma.conference.domain.viewtype.CommonListItemVO
import org.soma.conference.domain.viewtype.CommonViewTypes


class CommonListAdapter : RecyclerView.Adapter<BaseCommonHolder>() {
    private lateinit var items: List<CommonListItemVO>

    override fun onCreateViewHolder(parent: ViewGroup, viewTypeOrdinal: Int): BaseCommonHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (CommonViewTypes.values()[viewTypeOrdinal]) {
            CommonViewTypes.TITLE_IMAGE -> {
                AViewHolder(ItemABinding.inflate(inflater, parent, false))
            }

            CommonViewTypes.TITLE -> {
                BViewHolder(ItemBBinding.inflate(inflater, parent, false))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return CommonViewTypes.findOrdinalFromViewType(items[position].viewType)
    }

    override fun onBindViewHolder(holder: BaseCommonHolder, position: Int) {
        holder.bind(items[position].content)
    }

    fun setItems(items: List<CommonListItemVO>) {
        this.items = items
    }
}