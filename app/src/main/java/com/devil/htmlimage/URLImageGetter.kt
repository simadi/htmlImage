package com.devil.htmlimage

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.text.Html
import android.view.View
import android.widget.TextView

import com.nostra13.universalimageloader.core.DisplayImageOptions
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.assist.ImageSize
import com.nostra13.universalimageloader.core.assist.ViewScaleType
import com.nostra13.universalimageloader.core.imageaware.NonViewAware
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener

/**
 * 作者: feng on 2017/5/11.
 * 网址:http://www.cnblogs.com/simadi/  https://github.com/simadi
 */

class URLImageGetter(val shopDeString: String, var context: Context, val textView: TextView, val options: DisplayImageOptions) : Html.ImageGetter {

    override fun getDrawable(source: String): Drawable {
        val urlDrawable = URLDrawable()
        val imageSize = ImageSize(480, 320)
        val nonViewAware = NonViewAware(imageSize, ViewScaleType.CROP)
        ImageLoader.getInstance().displayImage(source, nonViewAware, options, object : SimpleImageLoadingListener() {
            override fun onLoadingComplete(imageUri: String?, view: View?, loadedImage: Bitmap?) {
                super.onLoadingComplete(imageUri, view, loadedImage)
                urlDrawable.bitmap1 = loadedImage
                urlDrawable.setBounds(0, 0, loadedImage!!.width, loadedImage.height)
                textView.invalidate()
                textView.text = textView.text // 解决图文重叠
            }
        })
        return urlDrawable
    }
}
