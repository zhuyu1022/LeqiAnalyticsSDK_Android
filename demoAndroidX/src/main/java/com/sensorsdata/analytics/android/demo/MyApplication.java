/*
 * Created by wangzhuozhou on 2016/11/12.
 * Copyright 2015－2020 Sensors Data Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sensorsdata.analytics.android.demo;

import android.app.Application;

import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SensorsAnalyticsAutoTrackEventType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;

public class MyApplication extends Application {
    /**
     * Sensors Analytics 采集数据的地址
     */
    // private final static String SA_SERVER_URL = "https://sdkdebugtest.datasink.sensorsdata.cn/sa?project=default&token=cfb8b60e42e0ae9b";
    private final static String SA_SERVER_URL = "https://big-data.leqi.us/api/test/event/android";
   // private final static String SA_SERVER_URL = "https://big-data.leqi.us/api/changkuan_app/event/android/debug";

    //    https://big-data.leqi.us/api/<app_key>/event/<sdk_type>
//    app_key为该应用的标识
//            sdk_typeSDK类型,详情见sdk_type说明
    @Override
    public void onCreate() {
        super.onCreate();
        initSensorsDataAPI();
    }

    /**
     * 初始化 Sensors Analytics SDK
     */
    private void initSensorsDataAPI() {
        SAConfigOptions configOptions = new SAConfigOptions(SA_SERVER_URL);
        //传入渠道名称
        configOptions.setChannel(BuildConfig.FLAVOR_market);
        // 打开自动采集, 并指定追踪哪些 AutoTrack 事件
        configOptions.setAutoTrackEventType(SensorsAnalyticsAutoTrackEventType.APP_START |
                SensorsAnalyticsAutoTrackEventType.APP_END |
                SensorsAnalyticsAutoTrackEventType.APP_VIEW_SCREEN |
                SensorsAnalyticsAutoTrackEventType.APP_CLICK);
        SensorsDataAPI.startWithConfigOptions(this, configOptions);
        SensorsDataAPI.sharedInstance(this).trackFragmentAppViewScreen();
        SensorsDataAPI.sharedInstance().setFlushInterval(20000);
    }
}
