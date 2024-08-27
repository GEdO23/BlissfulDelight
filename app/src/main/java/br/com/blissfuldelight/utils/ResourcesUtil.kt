package br.com.blissfuldelight.utils

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable

class ResourcesUtil {
    fun getDrawable(context: Context, image: String): Drawable {
        val resources: Resources = context.resources
        val drawableId: Int = resources.getIdentifier(image,
            "drawable", context.packageName)
        return resources.getDrawable(drawableId)
    }
}