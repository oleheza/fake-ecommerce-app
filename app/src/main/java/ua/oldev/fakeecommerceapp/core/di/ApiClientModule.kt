package ua.oldev.fakeecommerceapp.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ua.oldev.fakeecommerceapp.core.data.network.client.ApiClient
import ua.oldev.fakeecommerceapp.core.data.network.client.RetrofitApiClient

@Module
@InstallIn(SingletonComponent::class)
abstract class ApiClientModule {
    @Binds
    abstract fun bindApiClient(apiClient: RetrofitApiClient): ApiClient
}