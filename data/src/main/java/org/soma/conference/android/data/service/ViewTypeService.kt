package org.soma.conference.android.data.service

import org.soma.conference.android.data.dto.BaseResponseDTO
import retrofit2.http.GET

interface ViewTypeService {
    @GET("api.swm-mobile.org/home.json")
    suspend fun getViewTypeExample(): BaseResponseDTO
}