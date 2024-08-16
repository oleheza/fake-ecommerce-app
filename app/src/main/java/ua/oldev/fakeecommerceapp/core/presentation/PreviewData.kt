package ua.oldev.fakeecommerceapp.core.presentation

import ua.oldev.fakeecommerceapp.products.domain.model.ProductModel

val fakeCategories = listOf("Category 1", "Category 2", "Category 3")

val fakeProduct1 = ProductModel(
    id = 0,
    title = "Product 1",
    description = "I'm just a fake",
    image = "",
    ratingCount = 10,
    rate = 4.5f,
    price = 10f
)


val fakeProduct2 = ProductModel(
    id = 1,
    title = "Product 2",
    description = "I'm just another fake",
    image = "",
    ratingCount = 15,
    rate = 4f,
    price = 100f
)


val fakeProduct3 = ProductModel(
    id = 2,
    title = "Product 3",
    description = "I'm just third fake",
    image = "",
    ratingCount = 5,
    rate = 5f,
    price = 9f
)

val fakeProducts = listOf(fakeProduct1, fakeProduct2, fakeProduct3)