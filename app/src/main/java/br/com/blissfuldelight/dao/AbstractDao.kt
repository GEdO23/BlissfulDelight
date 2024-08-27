package br.com.blissfuldelight.dao

interface AbstractDao<T> {
    fun getAll(): MutableList<T>

    fun getById(id: Long): T? = null
    fun getById(id: String): T? = null

    fun getPosition(id: Long): Int? = null
    fun getPosition(id: String): Int? = null
    fun getPosition(item: T): Int? = null

    fun add(item: T): T? = null
    fun add(listOfItems: MutableList<T>): MutableList<T>? = null

    fun update(id: Long, updatedItem: T): T? = null
    fun update(id: String, updatedItem: T): T? = null
    fun updateElement(oldItem: T, updatedItem: T): T? = null

    fun remove(id: Long): T? = null
    fun remove(id: String): T? = null
    fun removeElement(item: T): T? = null
}