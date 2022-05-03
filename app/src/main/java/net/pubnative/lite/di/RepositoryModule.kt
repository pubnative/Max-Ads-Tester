package net.pubnative.lite.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import net.pubnative.lite.domain.Repository
import net.pubnative.lite.repository.RepositoryImp

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideRepository(
    ): Repository = RepositoryImp()
}