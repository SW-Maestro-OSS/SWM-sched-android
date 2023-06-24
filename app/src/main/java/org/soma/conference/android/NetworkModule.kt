package org.soma.conference.android

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.soma.conference.android.data.CommonViewTypeDeserializer
import org.soma.conference.android.data.dto.BaseResponseDTO
import org.soma.conference.android.data.service.ViewTypeService
import org.soma.conference.domain.viewtype.CommonViewVO
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {
    companion object {
        private const val BASE_URL = "https://s3.ap-northeast-2.amazonaws.com/"

        @Qualifier
        @Retention(AnnotationRetention.BINARY)
        annotation class ApiRetrofitProvider

        @Provides
        @Singleton
        fun provideHttpClient(): OkHttpClient {
            val httpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            httpClientBuilder.addInterceptor(loggingInterceptor)

            return httpClientBuilder
                .retryOnConnectionFailure(true)
                .connectionPool(ConnectionPool(5, 10, TimeUnit.SECONDS)).build()
        }

        @Provides
        @Singleton
        fun provideRetrofit(
            client: OkHttpClient
        ): Retrofit {
            val gson = GsonBuilder()
                .registerTypeAdapter(CommonViewVO::class.java, CommonViewTypeDeserializer())
                .create()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()
        }

        @Provides
        @Singleton
        fun provideViewTypeService(
            retrofit: Retrofit
        ): ViewTypeService {
            return retrofit.create(ViewTypeService::class.java)
        }
    }
}