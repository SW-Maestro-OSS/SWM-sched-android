package org.soma.conference.domain

import kotlinx.coroutines.flow.Flow
import org.soma.conference.domain.viewtype.SceneVO

interface ExampleViewTypeRepository {
    suspend fun getViewType(): Flow<SceneVO>
}