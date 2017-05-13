package com.devil.htmlimage

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import com.nostra13.universalimageloader.core.DisplayImageOptions
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 作者: feng on 2017/5/11.
 * 网址:http://www.cnblogs.com/simadi/  https://github.com/simadi
 */

class MainActivity : AppCompatActivity() {

    val sText = "<h1>标题1</h1><font color='#0000FF'>彩色文字</font>"+
    "<img src=\"http://b.hiphotos.baidu.com/image/pic/item/d788d43f8794a4c274c8110d0bf41bd5ad6e3928.jpg\" />"+
            "<b>粗体</b><p>欢迎访问我的<a href=\"http://www.cnblogs.com/simadi/\">cnblog博客http://www.cnblogs.com/simadi/</a>" +
            " 以及<a href=\"https://github.com/simadi\">我的github https://github.com/simadi</a></p>"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val options = DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .displayer(FadeInBitmapDisplayer(300))
                .build()
        text1!!.text = Html.fromHtml(sText, URLImageGetter(sText, this@MainActivity, text1, options), null)
    }
}
