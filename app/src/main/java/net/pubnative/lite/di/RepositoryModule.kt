package net.pubnative.lite.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.pubnative.lite.domain.Repository
import net.pubnative.lite.repository.RepositoryImp
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
    ): Repository = RepositoryImp()
}