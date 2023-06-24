package org.soma.conference.android.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.soma.conference.android.data.datasource.ViewTypeDataSource
import org.soma.conference.android.data.dto.toVO
import org.soma.conference.domain.ExampleViewTypeRepository
import org.soma.conference.domain.viewtype.SceneVO
import javax.inject.Inject

class ExampleViewTypeRepositoryImpl @Inject constructor(private var viewTypeDatasource: ViewTypeDataSource) :
    ExampleViewTypeRepository {
    override suspend fun getViewType(): Flow<SceneVO> =
        viewTypeDatasource.getViewTypeExample().map {
            it.toVO()
        }
}