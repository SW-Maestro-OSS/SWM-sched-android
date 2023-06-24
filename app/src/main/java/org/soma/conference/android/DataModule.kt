package org.soma.conference.android

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.soma.conference.android.data.ExampleViewTypeRepositoryImpl
import org.soma.conference.android.data.datasource.ViewTypeDataSource
import org.soma.conference.domain.ExampleViewTypeRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataModule {
    @Singleton
    @Provides
    fun provideExampleViewTypeRepository(viewTypeDataSource: ViewTypeDataSource): ExampleViewTypeRepository {
        return ExampleViewTypeRepositoryImpl(viewTypeDataSource)
    }
}