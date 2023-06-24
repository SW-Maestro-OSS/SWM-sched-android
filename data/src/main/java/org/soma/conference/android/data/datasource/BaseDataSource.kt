package org.soma.conference.android.data.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.soma.conference.android.data.dto.BaseResponseDTO
import org.soma.conference.android.data.dto.SceneDTO

open class BaseDataSource {
    suspend fun extractResponseData(rawResponse: BaseResponseDTO): Flow<SceneDTO> = flow {
        emit(rawResponse.responseData)
    }
}
