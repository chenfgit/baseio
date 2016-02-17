package com.gifisan.mtp.server;

import com.gifisan.mtp.component.Configuration;
import com.gifisan.mtp.servlet.GenericServlet;

public abstract class MTPServlet extends GenericServlet {

	public void initialize(ServerContext context, Configuration config) throws Exception {

	}

	public void destroy(ServerContext context, Configuration config) throws Exception {

	}

	public void onPreDeploy(ServerContext context, Configuration config) throws Exception {
		this.initialize(context, config);
	}

	public void onSubDeploy(ServerContext context, Configuration config) throws Exception {
		this.destroy(context, config);
	}

}