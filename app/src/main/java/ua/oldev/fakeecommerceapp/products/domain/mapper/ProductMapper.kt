package ua.oldev.fakeecommerceapp.products.domain.mapper

import ua.oldev.fakeecommerceapp.core.data.network.dto.ProductDTO
import ua.oldev.fakeecommerceapp.products.domain.model.ProductModel

fun ProductDTO.toModel(): ProductModel {
    return ProductModel(
        id = this.id,
        title = this.title,
        image = this.image,
        description = this.description,
        rate = this.rating.rate,
        ratingCount = this.rating.count,
        price = this.price
    )
}