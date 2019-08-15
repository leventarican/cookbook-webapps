package com.github.leventarican;

import java.util.Properties;

public class JNDIProperties {
	public static Properties getInitProperties() {
		Properties result = new Properties();
		result.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		result.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
		result.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
		result.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
		result.setProperty("org.omg.CORBA.ORBInitialPort", "3700");	// ORB Listener Port (ORB IIOP Listener)
		return result;
	}
}
