package org.soma.conference.domain.viewtype

data class SceneVO(
    val sceneName: String, val contents: List<CommonListItemVO>
) {
    companion object {
        fun empty(): SceneVO {
            return SceneVO(
                sceneName = "", contents = emptyList()
            )
        }
    }
}
