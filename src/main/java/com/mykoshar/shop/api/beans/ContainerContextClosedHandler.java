package com.mykoshar.shop.api.beans;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener // register it as you wish 
public class ContainerContextClosedHandler implements ServletContextListener { 
    private static final Logger logger = LoggerFactory.getLogger(ContainerContextClosedHandler.class); 
 
    @Override 
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // nothing to do 
    } 
 
    @Override 
    public void contextDestroyed(ServletContextEvent sce) {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        Driver d = null;
        while (drivers.hasMoreElements()) {
            try {
                d = drivers.nextElement();
                DriverManager.deregisterDriver(d);
                logger.warn(String.format("Driver %s deregistered", d));
            }
            catch (SQLException ex) {
            	logger.warn(String.format("Error deregistering driver %s", d), ex);
            }
        }
        try {
            AbandonedConnectionCleanupThread.checkedShutdown();
        } catch (Exception e) {
            logger.warn("SEVERE problem cleaning up: " + e.getMessage());
            e.printStackTrace();
        }
      }
 
} 
