/*
 * Copyright 2015-2017 GenerallyCloud.com
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
package com.generallycloud.baseio.common;

import java.util.Properties;

public class LoggerFactory {

	private static boolean enableSLF4JLogger = false;
	
	static{
		try {
			Class.forName("org.slf4j.LoggerFactory");
			configure();
		} catch (Exception e) {
		}
		
	}

	public static void enableSLF4JLogger(boolean enable) {
		enableSLF4JLogger = enable;
	}

	public static Logger getLogger(Class<?> clazz) {
		if (!enableSLF4JLogger) {
			return new ConsoleLogger(clazz);
		}
		return new SLF4JLogger(clazz);
	}

	public static void configure() {
		try {
			configure(FileUtil.readPropertiesByCls("log4j.properties", Encoding.UTF8));
		} catch (Exception e) {
		}
	}

	public static void configure(Properties properties) {
		if (properties == null) {
			return;
		}
		enableSLF4JLogger = true;
		configure0(properties);
	}

	private static void configure0(Properties properties) {
		org.apache.log4j.PropertyConfigurator.configure(properties);
	}

}
