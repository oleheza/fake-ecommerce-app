package ua.oldev.fakeecommerceapp.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import ua.oldev.fakeecommerceapp.BuildConfig
import ua.oldev.fakeecommerceapp.core.data.network.service.CategoriesService
import ua.oldev.fakeecommerceapp.core.data.network.service.ProductsService
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Named("base_url")
    fun provideBaseUrl(): String = "https://fakestoreapi.com/"

    @Provides
    fun provideRetrofit(@Named("base_url") baseUrl: String): Retrofit {
        val okhttp = OkHttpClient.Builder()
            .apply {
                if (BuildConfig.DEBUG) {
                    addInterceptor(HttpLoggingInterceptor())
                }
            }.build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .client(okhttp)
            .baseUrl(baseUrl)
            .build()
    }

    @Provides
    fun provideCategoriesService(retrofit: Retrofit): CategoriesService {
        return retrofit.create(CategoriesService::class.java)
    }

    @Provides
    fun provideProductsService(retrofit: Retrofit): ProductsService {
        return retrofit.create(ProductsService::class.java)
    }
}