package org.soma.conference.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import org.soma.conference.domain.viewtype.SceneVO
import javax.inject.Inject

class ExampleViewTypeUseCase @Inject constructor(
    private val repository: ExampleViewTypeRepository
) {
    suspend fun getExampleViewType(): Flow<SceneVO> =
        withContext(Dispatchers.IO) {
            // IO 스레드에서 비동기 작업 수행
            // 예시: 데이터베이스 쿼리, 네트워크 요청 등
            // 비동기 작업이 완료되면 SceneVO 객체를 방출 (emit)
            repository.getViewType()
        }
}