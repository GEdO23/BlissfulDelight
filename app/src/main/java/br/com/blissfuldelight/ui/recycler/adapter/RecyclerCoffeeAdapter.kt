package br.com.blissfuldelight.ui.recycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.blissfuldelight.R
import br.com.blissfuldelight.dao.CoffeeDao
import br.com.blissfuldelight.model.Coffee
import br.com.blissfuldelight.utils.PriceUtil
import br.com.blissfuldelight.utils.RatingsUtil
import br.com.blissfuldelight.utils.ResourcesUtil

class RecyclerCoffeeAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dao = CoffeeDao()
    private val coffeeList: List<Coffee> = dao.getAll()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewCriada: View = LayoutInflater.from(context)
            .inflate(R.layout.product_item, parent, false)
        return NotaViewHolder(viewCriada)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val coffee: Coffee = coffeeList[position]

        bindName(holder, coffee)
        bindImage(holder, coffee)
        bindPrice(holder, coffee)
        bindRating(holder, coffee)
        bindCategory(holder, coffee)
    }

    override fun getItemCount() = coffeeList.size

    class NotaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private fun bindName(
        holder: RecyclerView.ViewHolder,
        coffee: Coffee
    ) {
        val name = holder.itemView.findViewById<TextView>(R.id.product_item_name)
        name.text = coffee.name
    }

    private fun bindCategory(
        holder: RecyclerView.ViewHolder,
        coffee: Coffee
    ) {
        val category = holder.itemView.findViewById<TextView>(R.id.product_item_category)
        category.text = coffee.category?.categoryName
    }

    private fun bindRating(
        holder: RecyclerView.ViewHolder,
        coffee: Coffee
    ) {
        val rating = holder.itemView.findViewById<TextView>(R.id.product_item_rating)
        val averageRating = RatingsUtil().getAverage(coffee.ratings)
        rating.text = averageRating
    }

    private fun bindPrice(
        holder: RecyclerView.ViewHolder,
        coffee: Coffee
    ) {
        val price = holder.itemView.findViewById<TextView>(R.id.product_item_price)
        val formattedPrice = PriceUtil().format(coffee.price)
        price.text = formattedPrice
    }

    private fun bindImage(
        holder: RecyclerView.ViewHolder,
        coffee: Coffee
    ) {
        val img = holder.itemView.findViewById<ImageView>(R.id.product_item_photo_img)
        val imgDrawable = ResourcesUtil().getDrawable(context, coffee.image)
        img.setImageDrawable(imgDrawable)
    }
}