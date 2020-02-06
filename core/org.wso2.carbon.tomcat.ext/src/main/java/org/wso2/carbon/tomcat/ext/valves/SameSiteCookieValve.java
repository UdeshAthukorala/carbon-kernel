/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.carbon.tomcat.ext.valves;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;
import org.wso2.carbon.tomcat.ext.transport.CarbonResponseWrapper;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * SameSiteValve can be used to add sameSite attribute for the response cookies.
 */
public class SameSiteCookieValve extends ValveBase {

    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {

        if (getNext() != null) {
            getNext().invoke(request, new CarbonResponseWrapper(response));
        }
    }
}
