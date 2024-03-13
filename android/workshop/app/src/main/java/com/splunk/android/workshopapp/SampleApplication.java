/*
 * Copyright Splunk Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.splunk.android.workshopapp;

import android.app.Application;

import com.splunk.rum.Config;
import com.splunk.rum.SplunkRum;
import com.splunk.rum.StandardAttributes;
import io.opentelemetry.api.common.Attributes;


public class SampleApplication extends Application {
    private final String realm = "us0";
    private final String rumAccessToken = "a5OVE71NXiRkCYxH34_Fbw";

    @Override
    public void onCreate() {
        super.onCreate();
        Config config = Config.builder()
                .applicationName("srauhala_rum_android")
                .rumAccessToken("a5OVE71NXiRkCYxH34_Fbw")
                .realm("us0")
                .deploymentEnvironment("srauhala_rum_android")
                .debugEnabled(true)
                .globalAttributes(Attributes.builder()
                        .put("MY_APP_KEY", "MY_APP_VALUE")
                        .put(StandardAttributes.APP_VERSION, BuildConfig.VERSION_NAME)
                        .build())
                .build();
        SplunkRum.initialize(config, this);


/*        SplunkRum.builder()
                .setApplicationName("srauhala_rum_android")
                .setDeploymentEnvironment("srauhala_rum_android") // Environment
                .setRealm(realm)
                .setRumAccessToken(rumAccessToken)
                .setGlobalAttributes(
                        Attributes.builder() // Add the application version. Alternatively, you
                                // can pass BuildConfig.VERSION_NAME as the value.
                                .put(StandardAttributes.APP_VERSION, "1.0")
                                .build()
                )
                // Activates debug logging if needed
                //.enableDebug()
                .build(this);*/

    }
}
