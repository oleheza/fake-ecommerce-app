package ua.oldev.fakeecommerceapp.core.presentation.navigation

data object Categories : Destination.NoArgumentDestination("categories")

data object Products : Destination("products", "category_id") {
    const val CATEGORY_ID_KEY = "category_id"

    operator fun invoke(categoryId: String): String =
        route.appendParams(CATEGORY_ID_KEY to categoryId)
}

data object ProductDetails : Destination("product_details", "product_id") {
    const val PRODUCT_ID_KEY = "product_id"

    operator fun invoke(productId: Int): String = route.appendParams(PRODUCT_ID_KEY to productId)
}

internal fun String.appendParams(vararg params: Pair<String, Any?>): String {
    val builder = StringBuilder(this)
    params.forEach { param ->
        param.second?.toString()?.let { argument ->
            builder.append("/${argument}")
        }
    }
    return builder.toString()
}