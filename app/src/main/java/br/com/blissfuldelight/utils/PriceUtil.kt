package br.com.blissfuldelight.utils

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.NumberFormat

class PriceUtil {
    fun format(price: BigDecimal): String {
        val localFormat: NumberFormat = DecimalFormat.getCurrencyInstance()
        return localFormat.format(price)
    }
}