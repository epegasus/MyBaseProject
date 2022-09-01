package dev.epegasus.baseproject.helper.adapters.binding

import android.net.Uri
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.imageview.ShapeableImageView
import dev.epegasus.baseproject.R
import java.io.File

/*@BindingAdapter(value = ["imageId", "isBackground"], requireAll = false)
fun ShapeableImageView.setImageFromDrawable(imageId: Int, isBackground: Boolean) {
    var bgGlide = 0
    if (isBackground) {
        bgGlide = R.drawable.bg_glide
    }
    Glide
        .with(this)
        .load(imageId)
        .placeholder(bgGlide)
        .transition(DrawableTransitionOptions.withCrossFade(100))
        .into(this)
}*/

@BindingAdapter("imageUri")
fun ShapeableImageView.setImageFromDrawable(imageUri: Uri?) {
    Glide
        .with(this)
        .load(imageUri)
        .placeholder(R.drawable.bg_glide)
        .transition(DrawableTransitionOptions.withCrossFade(100))
        .into(this)
}

@BindingAdapter("imagePath")
fun ShapeableImageView.setImageFromPath(imagePath: File) {
    Glide
        .with(this)
        .load(imagePath.toString())
        .placeholder(R.drawable.bg_glide)
        .transition(DrawableTransitionOptions.withCrossFade(100))
        .into(this)
}

@BindingAdapter("imagePath")
fun ImageFilterView.setImageFromPath(imagePath: File) {
    Glide
        .with(this)
        .load(imagePath.toString())
        .placeholder(R.drawable.bg_glide)
        .transition(DrawableTransitionOptions.withCrossFade(100))
        .into(this)
}

@BindingAdapter("imageId")
fun ImageFilterView.setImageFromDrawable(imageId: Int) {
    Glide
        .with(this)
        .load(imageId)
        .into(this)
}

@BindingAdapter("imageId")
fun ShapeableImageView.setImageFromDrawable(imageId: Int) {
    Glide
        .with(this)
        .load(imageId)
        .into(this)
}

@BindingAdapter("customColor")
fun ShapeableImageView.setColor(customColor: Int) {
    setBackgroundColor(ContextCompat.getColor(this.context, customColor))
}
