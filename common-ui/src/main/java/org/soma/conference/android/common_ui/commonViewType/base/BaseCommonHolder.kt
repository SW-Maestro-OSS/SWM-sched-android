package org.soma.conference.android.common_ui.commonViewType.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import org.soma.conference.domain.viewtype.ViewContent

abstract class BaseCommonHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(viewContent: ViewContent)
}