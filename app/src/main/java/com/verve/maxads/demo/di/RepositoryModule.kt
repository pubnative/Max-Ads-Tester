package com.verve.maxads.demo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import com.verve.maxads.demo.domain.Repository
import com.verve.maxads.demo.repository.RepositoryImp

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideRepository(
    ): Repository = RepositoryImp()
}