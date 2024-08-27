package br.com.blissfuldelight.utils

class RatingsUtil {
    fun getAverage(ratingList: List<Double>): String {
        return ratingList.average().toString()
    }
}