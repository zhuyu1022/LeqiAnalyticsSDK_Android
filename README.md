![logo](https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1371754600,2168804107&fm=15&gp=0.jpg)
<br><br>

## 乐骐简介

[**乐骐科技**](https://www.leqi.us/)
无锡乐骐科技有限公司 [1-2]  主要业务是计算机视觉领域研发工作，包括人脸识别，人脸属性分析、人体/车体检测/识别及行为分析、图像和视频检索、文字识别、运动追踪。多个成功项目经验：海量人像快速检索系统、商场客流量统计分析系统、公交客流统计分析、智能视频监控系统等。

## SDK 简介

LeqiAnalytics SDK ，目前支持代码埋点、全埋点
## 基本要求
Android 4.0 及以上。


## 1.如何集成


- **1.1 引入插件（目前用神策的插件），在 project 级别的 build.gradle 文件中添加 android-gradle-plugin2 依赖：**

```
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.5.3'
        //添加神策分析 android-gradle-plugin2 依赖
        classpath 'com.sensorsdata.analytics.android:android-gradle-plugin2:3.2.4'
    }
}
```
- **1.2 在project 级别的 build.gradle中加入Jitpack仓库**

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

- **1.3 在app's build.gradle中应用插件和添加依赖**

```
// 应用 com.sensorsdata.analytics.android 插件
apply plugin: 'com.sensorsdata.analytics.android'
dependencies {
  ...
   implementation 'com.github.zhuyu1022:LeqiAnalyticsSDK_Android:0.0.5'
}
```


## 2.使用

- **2.1 上传地址说明**

```
https://big-data.leqi.us/api/<app_key>/event/<sdk_type> 生产环境
https://big-data.leqi.us/api/<app_key>/event/<sdk_type>/debug 调试使用
app_key   为该应用的标识  
sdk_type  SDK类型 安卓集成就传入android

```

- **2.2 基本配置**

```
                //配置上传地址
                val url = "https://big-data.leqi.us/api/e09f591a/event/android/debug"
                val configOptions = SAConfigOptions(url)
                // 打开自动采集, 并指定追踪哪些Track 事件，以下为全采集
                configOptions.setAutoTrackEventType(
                    SensorsAnalyticsAutoTrackEventType.APP_START or
                            SensorsAnalyticsAutoTrackEventType.APP_END or
                            SensorsAnalyticsAutoTrackEventType.APP_VIEW_SCREEN or
                            SensorsAnalyticsAutoTrackEventType.APP_CLICK
                )
                SensorsDataAPI.startWithConfigOptions(this, configOptions)
                //自动追踪 Fragment 的 ViewScreen 事件
                SensorsDataAPI.sharedInstance(this).trackFragmentAppViewScreen()
                //配置上传间隔，默认值15秒
                SensorsDataAPI.sharedInstance().flushInterval = 20000
                //是否打印日志，默认false
                SensorsDataAPI.sharedInstance().enableLog(true)
```


- **2.3 用户登录，设置userid**

```
SensorsDataAPI.sharedInstance().login("登录 ID")

```
- **2.4 代码埋点追踪事件**

```
try {
    JSONObject properties = new JSONObject();
    properties.put("ProductID", 123456);                    // 设置商品 ID
    properties.put("ProductCatalog", "Laptop Computer");    // 设置商品类别
    SensorsDataAPI.sharedInstance().track("BuyProduct", properties);
} catch (JSONException e) {
    e.printStackTrace();
}
```

- **2.5 其他功能测试中....**


## 规划

可参考 [ROADMAP](ROADMAP.md).

