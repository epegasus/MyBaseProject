package dev.epegasus.baseproject.helper.utils

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.TypedValue
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.card.MaterialCardView
import dev.epegasus.baseproject.R
import dev.epegasus.baseproject.helper.extensions.FragmentExtensions.showToast
import dev.epegasus.baseproject.helper.utils.GeneralUtils.getResString
import dev.epegasus.baseproject.helper.utils.LogUtils.showLog
import java.io.File

class ImageUtils {

    fun Fragment.sharePicture(context: Context, file: File, fileUri: Uri) {
        if (file.exists()) {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.setDataAndType(fileUri, context.contentResolver.getType(fileUri))
            shareIntent.putExtra(Intent.EXTRA_STREAM, fileUri)
            context.startActivity(Intent.createChooser(shareIntent, "Choose an app"))
        } else {
            showLog(context, "sharePicture", "else", "Path not Exist")
            showToast(getResString(context, R.string.image_does_not_exist))
        }
    }

    fun createBitmapFromView(view: View, height: Int = 0): Bitmap {
        val bitmap: Bitmap? = if (height != 0) {
            Bitmap.createBitmap(view.width, height, Bitmap.Config.ARGB_8888)
        } else {
            Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        }
        val canvas = Canvas(bitmap!!)
        view.layout(view.left, view.top, view.right, view.bottom)
        view.draw(canvas)
        return bitmap
    }

    fun createRoundedBitmapFromView(view: View, pixels: Int): Bitmap {
        val bitmap = createBitmapFromView(view)
        val output = Bitmap.createBitmap(bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)
        val color = -0xbdbdbe
        val paint = Paint()
        val rect = Rect(0, 0, bitmap.width, bitmap.height)
        val rectF = RectF(rect)
        val roundPx = pixels.toFloat()
        paint.isAntiAlias = true
        canvas.drawARGB(0, 0, 0, 0)
        paint.color = color
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(bitmap, rect, rect, paint)
        return output
    }

    fun createDrawableFromBitmap(context: Context, bitmap: Bitmap): Drawable {
        return BitmapDrawable(context.resources, bitmap)
    }

    fun createDrawableFromPath(imagePath: String): Drawable? {
        return Drawable.createFromPath(imagePath)
    }

    val Number.toPx get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), Resources.getSystem().displayMetrics)

    fun getCornerRadiusInPixel(collageBorderOutlineRadius: Float, view: MaterialCardView): Int {
        // Converting Dp to appropriate pixel for bitmap
        val temp = if (view.width > view.height) view.width else view.height
        val cornerRadiusDP = (collageBorderOutlineRadius * (temp.toFloat() / 500))
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, cornerRadiusDP, view.resources.displayMetrics).toInt()
    }

    fun convertDrawableToBitmap(drawable: Drawable, isCheck: Boolean = true): Bitmap {
        if (drawable is BitmapDrawable && isCheck) {
            return drawable.bitmap
        }
        var width = drawable.intrinsicWidth
        width = if (width > 0) width else 1
        var height = drawable.intrinsicHeight
        height = if (height > 0) height else 1

        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        return bitmap
    }

    fun deepCopyDrawable(drawable: Drawable): Drawable? {
        return drawable.constantState?.newDrawable()?.mutate()
    }
}