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
package com.generallycloud.baseio.container;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author wangkai
 *
 */
public interface DynamicClassLoader {

	public abstract URL getResource(String name);

	public abstract Enumeration<URL> getResources(String name) throws IOException;

	public abstract InputStream getResourceAsStream(String name);

	public abstract ClassLoader getParent();

	public abstract void setDefaultAssertionStatus(boolean enabled);

	public abstract void setPackageAssertionStatus(String packageName, boolean enabled);

	public abstract void setClassAssertionStatus(String className, boolean enabled);

	public abstract void clearAssertionStatus();

	public abstract void scan(String file) throws IOException;

	public abstract void scan(File file) throws IOException;

	public abstract Class<?> forName(String name) throws ClassNotFoundException;

	public abstract void unloadClassLoader();

}