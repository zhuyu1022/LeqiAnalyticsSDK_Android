package com.sensorsdata.analytics.android.sdk

object Config {

    const val NONCE_STR = "nonce_str"       //随机字符串
    const val UUID = "uuid"                 //用户ID,优先获取设备ID,若获取失败,则随机生成一个32位字符串,并长期缓存下来
    const val APP_USER_ID = "app_user_id"   //该应用的用户ID,当应用获取到了用户ID后,应该通知SDK,SDK在后续的上报中需要携带此ID
    const val TIME = "time"                 //事件发生时的时间戳,单位为毫秒
    const val PATH = "path"                 //事件发生时的页面名
    const val EVENT_TYPE = "event_type"     //事件类型
    const val DEVICE = "device"
    const val SDK_VERSION = "sdk_version"
    const val OS_VERSION = "os_version"      //系统版本
    const val LIB = "lib"                     //设备类型(Android\IOS)
    const val MANUFACTURER = "manufacturer"  //设备生产商,例如HUAWEI
    const val MODEL = "model"                //设备型号
    const val SCREEN_WIDTH = "screen_width"  //屏幕宽度分辨率
    const val SCREEN_HEIGHT = "screen_height" //屏幕高度分辨率
    const val WIFI = "wifi"                  //是否使用了wifi
    const val NETWORK_TYPE = "network_type"  //网络类型
    const val DEVICE_ID = "device_id"        //设备ID
    const val PACKAGE_NAME = "package_name"  //APP包名
    const val APP_VERSION = "app_version"    //APP版本号
    const val ELEMENT = "element"            //控件信息

    object Elemet {
        const val ELEMENT_ID = "element_id"
        const val ELEMENT_POSITION = "element_position"
        const val ELEMENT_CONTENT = "element_content"
        const val ELEMENT_TYPE = "element_type"
    }

    /**
     * 定义事件类型
     */
    object EventName {
        const val START = "START"       //启动事件
        const val CLOSE = "CLOSE"       //应用关闭/切后台事件
        const val CLICK = "CLICK"        //点击事件
        const val VIEW = "VIEW"          //页面切换事件
        const val CUSTOM = "CUSTOM"     //自定义上报的事件
        const val SHARE = "SHARE"       //分享事件（小程序）
    }


    /*  {
          "nonce_str":"0fde1850-aba8-11ea-a1dc-1063c8b9fe62",
          "time":1591854914499,
          "track_id":1,
          "uuid":"630cd38a-aba8-11ea-a6e8-1063c8b9fe62",
          "app_user_id":"6c7df562-aba8-11ea-8712-1063c8b9fe62",
          "element":null,
          "event_type":"START",
          "path":"com.sensorsdata.analytics.android.demo.activity.TestMainActivity",
          "sdk_version":1,
          "sdk_type":"Android",
          "app_verison":"1.0.13",
          "event_params":null,
          "device":{
               "lib":"Android",
               "ip":"10.13.234.34",
               "os_version":"10",
               "device_id":"ccc2ed76-aba8-11ea-8fba-1063c8b9fe62",
               "model":"BLA-AL00",
               "screen_width":1080,
               "screen_height":2160,
               "manufacturer":"XIOAMI",
               "wifi":false,
               "network_type":"3G",
               "screen_name":"com.leqi.us.test"
      }
      }*/

}