# AutoFitDimen
自动生成适配dimen的库。
## 说明
本库是用于在适配的时候使用，适配的时候可以快捷的生成在不同分辨率下的dimen文件，生成文件是在编译期间，不影响apk的安装速率。
本库只是为了减少程序员的工作，作为一个工具库的使用。
如果发现任何问题，欢迎联系我：13572278564@163.com。
## 引入
**添加另一个库**

使用本库需要同时引入另外一个库：AutoFitDimenProcessor，地址为：https://github.com/ZhangMiao147/AutoFitDimenProcessor 。该库实现在编译时间生成不同分辨率下的dimens.xml文件，所以需要一起使用。

**gradle**

在工程的build.gradle中添加：
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
在项目的build.gradle中引入库：
```
    compile 'com.github.ZhangMiao147:AutoFitDimen:0.1'
    annotationProcessor 'com.github.ZhangMiao147:AutoFitDimenProcessor:0.1'
```

## 使用
在使用这个库之前，需要你前提写好一个标准的dimen.xml文件，然后库会根据你写好的标准dimen.xml去生成不同分辨率下的dimen.xml文件。
##### 举例标准文件
../res/values-1280x752/dimens
```
<resources>
    <dimen name="size_2">2px</dimen>
    <dimen name="size_3">3px</dimen>
    <dimen name="size_30">30px</dimen>
    <dimen name="size_50">50px</dimen>
    <dimen name="size_64">64px</dimen>
    <dimen name="size_66">66px</dimen>
    <dimen name="size_70">70px</dimen>
    <dimen name="size_75">75px</dimen>
    <dimen name="size_91">91px</dimen>
</resources>
```
##### 在代码中使用
```
@BindDimen(normal = "dimenfitTest/src/main/res/values-1280x752/dimens.xml",
        dimenFit = {"800x480", "1024x600", "1024x768", "1136x640", "1280x752", "1280x800", "1366x768", "1920x1080", "1920x1200", "2048x1536", "2560x1600"})
public class BaseApplication extends Application {
```
在代码中找个任意的地方使用BindDimen注解即可。
BindDimen注解中**normal**参数的值就是前面提到的标准文件。
BindDimen注解中**dimenFit**参数的值是需要适配的分辨率。

##### 运行
运行build之后就可以看到生成的不同分辨率下的dimen文件了。

**注意：不同分辨率的dimen值的计算是按照BindDimen传递的dimenFit的值与标准的分辨率的比值计算的，比如800x480分辨率的dimen值就等于标准值*（double）800/1280。**























