package org.soma.conference.android

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.soma.conference.domain.ExampleViewTypeRepository
import org.soma.conference.domain.ExampleViewTypeUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DomainModule {
    @Singleton
    @Provides
    fun provideExampleViewTypeUseCase(
        repository: ExampleViewTypeRepository
    ): ExampleViewTypeUseCase {
        return ExampleViewTypeUseCase(repository)
    }
}