package org.soma.conference.android.data.datasource

import kotlinx.coroutines.flow.Flow
import org.soma.conference.android.data.dto.SceneDTO
import org.soma.conference.android.data.service.ViewTypeService
import javax.inject.Inject

class ViewTypeDataSource @Inject constructor(private val viewTypeService: ViewTypeService) :
    BaseDataSource() {
    suspend fun getViewTypeExample(): Flow<SceneDTO> =
        extractResponseData(viewTypeService.getViewTypeExample())
}