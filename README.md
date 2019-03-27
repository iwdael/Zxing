# Zxing
[![](https://img.shields.io/badge/platform-android-orange.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/language-java-yellow.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/jcenter-1.0.5-brightgreen.svg)](http://jcenter.bintray.com/com/hacknife/zxing) [![](https://img.shields.io/badge/build-passing-brightgreen.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/license-apache--2.0-green.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/api-19+-green.svg)](https://github.com/hacknife)<br/><br/>
扫描二维码、识别二维码图片、前所未有的简单。

## 特点
* 支持扫描二维码
* 支持识别图片二维码
* 支持创建二维码(附带Logo)
<br/>
<br/>
<br/>

![](https://raw.githubusercontent.com/hacknife/Zxing/master/screenshots.png)

<br/>
<br/>
## 概述

Zxing主要是由*BaseCaptureActivity*和*QRHelper*组成。

## 使用说明

### 扫描二维码

通过继承BaseCaptureActivity，并实现两个方法，即可实现扫描二维码功能。

```
public class ScanActivity extends BaseCaptureActivity {
    @Override
    public SurfaceView getSurfaceView() {
        return null;
    }

    @Override
    public void dealDecode(Result rawResult, Bitmap barcode, float scaleFactor) {

    }
}

```
### 二维码识别与创建
##### 识别二维码
```
Result QRHelper.readQrImage(Bitmap scanBitmap);
```
```
Result QRHelper.readQrImage(String picturePath);
```
##### 创建二维码
```
Bitmap createQRCodeBitmap( String content, int size, int padding);
```
```
Bitmap createQRCodeBitmap(String content, int size, int padding,  Bitmap logoBitmap, float logoPercent);
```
```
Bitmap createQRCodeBitmap(String content, int size,
                          String character_set, String error_correction, String margin,
                          @ColorInt int color_black, @ColorInt int color_white, Bitmap targetBitmap,
                          Bitmap logoBitmap, float logoPercent);
```
## 快速引入项目
合并以下代码到需要使用的Module的dependencies中。
```
	dependencies {
                ...
              implementation 'com.hacknife:zxing:1.0.5'
	}
```
<br><br><br>
## 感谢浏览
请不要吝啬你的小星星，如果你有任何疑问，请加入QQ群，我将竭诚为你解答。
<br>
![Image Text](https://github.com/hacknife/CarouselBanner/blob/master/qq_group.png)
