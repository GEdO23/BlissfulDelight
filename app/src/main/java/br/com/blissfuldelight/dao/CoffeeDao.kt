package br.com.blissfuldelight.dao

import android.util.Log
import br.com.blissfuldelight.model.Category
import br.com.blissfuldelight.model.Coffee
import java.math.BigDecimal

class CoffeeDao : AbstractDao<Coffee> {
    private val coffeeList: MutableList<Coffee> = mutableListOf(
        Coffee(
            "1",
            "Caffe Mocha",
            "Like caffè latte, caffè mocha is based on espresso and hot milk but with added chocolate flavouring and sweetener, typically in the form of cocoa powder and sugar. Many varieties use chocolate syrup instead, and some may contain dark or milk chocolate.",
            mutableListOf(4.8, 4.8, 4.8, 4.8),
            BigDecimal("4.53"),
            Category.DEEP_FOAM,
            "img_coffee_2"
        ),
        Coffee(
            "2",
            "Flat White",
            "Like caffè latte, caffè mocha is based on espresso and hot milk but with added chocolate flavouring and sweetener, typically in the form of cocoa powder and sugar. Many varieties use chocolate syrup instead, and some may contain dark or milk chocolate.",
            mutableListOf(4.8, 4.8, 4.8, 4.8),
            BigDecimal("3.53"),
            Category.EXPRESSO,
            "img_coffee_3"
        ),
        Coffee(
            "3",
            "Mocha Fusi",
            "Like caffè latte, caffè mocha is based on espresso and hot milk but with added chocolate flavouring and sweetener, typically in the form of cocoa powder and sugar. Many varieties use chocolate syrup instead, and some may contain dark or milk chocolate.",
            mutableListOf(4.8, 4.8, 4.8, 4.8),
            BigDecimal("7.53"),
            Category.ICE_HOT,
            "img_coffee_5"
        ),
        Coffee(
            "4",
            "Caffe Panna",
            "Like caffè latte, caffè mocha is based on espresso and hot milk but with added chocolate flavouring and sweetener, typically in the form of cocoa powder and sugar. Many varieties use chocolate syrup instead, and some may contain dark or milk chocolate.",
            mutableListOf(4.8, 4.8, 4.8, 4.8),
            BigDecimal("5.53"),
            Category.ICE_HOT,
            "img_coffee_4"
        ),
    )

    override fun getAll() = coffeeList

    override fun getById(id: String) =
        coffeeList.find { it.id == id }

    override fun getPosition(item: Coffee) =
        coffeeList.indexOf(item)

    override fun remove(id: String): Coffee? {
        val removedItem = getById(id)
        coffeeList.minus(removedItem)
        return removedItem
    }

    override fun removeElement(item: Coffee): Coffee {
        coffeeList.minusElement(item)
        return item
    }

    override fun update(id: String, updatedItem: Coffee): Coffee? {
        val oldItem = getById(id)

        if (oldItem != null) {
            val oldItemPosition = getPosition(oldItem)
            removeElement(oldItem)
            coffeeList.add(oldItemPosition, updatedItem)
            return updatedItem
        }
        return null
    }

    override fun add(item: Coffee): Coffee {
        coffeeList.add(item)
        return item
    }

    override fun add(listOfItems: MutableList<Coffee>): MutableList<Coffee>? {
        for (coffee in listOfItems) {
            coffeeList += coffee
            Log.i("coffee add", coffee.toString())
        }
        Log.i("coffee get all", ""+coffeeList)
        return coffeeList
    }

}