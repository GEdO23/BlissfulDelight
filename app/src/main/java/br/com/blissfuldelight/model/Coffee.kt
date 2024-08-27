package br.com.blissfuldelight.model

import java.math.BigDecimal

data class Coffee(
    var id: String,
    var name: String,
    var description: String,
    var ratings: List<Double>,
    var price: BigDecimal,
    var category: Category?,
    var image: String,
    var size: Size?
) {
    constructor() : this(
        "", "", "",
        emptyList(), BigDecimal("0"), null, "", null
    )

    constructor(
        id: String,
        name: String,
        description: String,
        ratings: List<Double>,
        price: BigDecimal,
        category: Category,
        image: String
    ) : this() {
        this.id = id
        this.name = name
        this.description = description
        this.ratings = ratings
        this.price = price
        this.category = category
        this.image = image
    }
}
