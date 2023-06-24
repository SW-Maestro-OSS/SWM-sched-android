package org.soma.conference.android.data.dto

import org.soma.conference.domain.viewtype.CommonListItemVO
import org.soma.conference.domain.viewtype.SceneVO

data class SceneDTO(
    val screenName: String?, val contents: List<CommonListItemVO>?
)

fun SceneDTO.toVO(): SceneVO {
    return SceneVO(
        sceneName = this.screenName ?: "Unknown",
        contents = if (!this.contents.isNullOrEmpty()) this.contents else emptyList()
    )
}