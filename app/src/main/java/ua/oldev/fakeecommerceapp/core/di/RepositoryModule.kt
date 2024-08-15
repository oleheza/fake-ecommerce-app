package ua.oldev.fakeecommerceapp.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ua.oldev.fakeecommerceapp.core.data.repository.CategoriesRepositoryImpl
import ua.oldev.fakeecommerceapp.core.data.repository.ProductsRepositoryImpl
import ua.oldev.fakeecommerceapp.core.domain.repository.CategoriesRepository
import ua.oldev.fakeecommerceapp.core.domain.repository.ProductsRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCategoriesRepository(categoriesRepositoryImpl: CategoriesRepositoryImpl): CategoriesRepository

    @Binds
    abstract fun bindProductsRepository(productsRepositoryImpl: ProductsRepositoryImpl): ProductsRepository
}