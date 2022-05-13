package de.tvsmiles.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import de.tvsmiles.app.domain.Repository
import de.tvsmiles.app.repository.RepositoryImp

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideRepository(
    ): Repository = RepositoryImp()
}