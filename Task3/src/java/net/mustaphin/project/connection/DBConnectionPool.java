/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mustaphin.project.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author me
 */
public class DBConnectionPool {

    private static DBConnectionPool instance;
    private static AtomicBoolean instanceCreated = new AtomicBoolean();
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private final Queue<Connection> availableConnections = new ArrayDeque<>();
    private final String url;
    private String user;
    private String password;
    private int maxConn;

    public static DBConnectionPool getInstance(String url, String user, String password, int maxConn) {
	if (!instanceCreated.get()) {
	    lock.lock();
	    if (!instanceCreated.get()) {
		instance = new DBConnectionPool(url, user, password, maxConn);
		instanceCreated.set(true);
	    }
	    condition.signalAll();
	    lock.unlock();
	}
	return instance;
    }

    private DBConnectionPool(String url, String user, String password, int maxConn) {
	this.url = url;
	this.user = user;
	this.password = password;
	this.maxConn = maxConn;
	loadDrivers();
    }

    private void loadDrivers() {
	try {
	    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	} catch (SQLException ex) {
	    //TODO log4j
	}
    }

    public Connection getConnection() {
	Connection connection = null;
	if (availableConnections.isEmpty()) {
	    try {
		condition.await();
	    } catch (InterruptedException ex) {
		//TODO log4j
	    }
	} else {
	    connection = availableConnections.poll();
	    try {
		if (connection.isClosed()) {
		    condition.await();
		}
	    } catch (InterruptedException | SQLException ex) {
		//TODO log4j
	    }
	}
	return connection;
    }

    private Connection newConnection() {
	Connection connection = null;
	try {
	    connection = DriverManager.getConnection(url, user, password);
	} catch (SQLException ex) {
	    //TODO log4j
	}
	return connection;
    }

    public void freeConnection(Connection connection) {
	lock.lock();
	if ((connection != null) && (availableConnections.size()) <= maxConn) {
	    availableConnections.add(connection);
	    condition.signal();
	}
	lock.unlock();
    }

    public void release() throws SQLException {
	lock.lock();
	Iterator allConnections = availableConnections.iterator();
	while (allConnections.hasNext()) {
	    Connection con = (Connection) allConnections.next();
	    con.close();
	}
	availableConnections.clear();
	lock.unlock();
    }
}
