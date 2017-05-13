package com.devil.htmlimage

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
/**
 * 作者: feng on 2017/5/11.
 * 网址:http://www.cnblogs.com/simadi/  https://github.com/simadi
 */

class URLDrawable: BitmapDrawable() {
    var bitmap1: Bitmap? = null
    override fun draw(canvas: Canvas) {
        if (bitmap1 != null) {
            canvas.drawBitmap(bitmap1!!, 0f, 0f, paint)
        }
    }
}
