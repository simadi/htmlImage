#说明
20170213本项目是在原来的基础上进行改写的，原项目是java，我改写成了kotlin的

# htmlImage
有时候我们需要加载一段HTML文本，文本中有<img>标签图片，如商品详情。那么怎么才能更好的显示图片呢，当然是用UIL开源库了，那怎么使用呢。这就是本示例想要展示的

# 方法
textView.setText(Html.fromHtml(text,imageGetter,tagHandler);来加载html文本，
imageGetter需要返回drawable对象，那么可以重写ImageGetter,即可。

# URLImageGetter
```java  
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
```
![image](https://github.com/babylikebird/htmlImage/blob/master/Screenshot_2016-04-25-13-32-20.png)
