/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author me
 */
public class DBConnectionPool {

    private static DBConnectionPool instance = null;
    private volatile static boolean instanceCreated = false;
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static DBConnectionPool getInstance(String URL, String user, String password, int maxConn) {
	if (!instanceCreated) {
	    lock.lock();
	    if (!instanceCreated) {
		instance = new DBConnectionPool(URL, user, password, maxConn);
		instanceCreated = true;
	    }
	    condition.signalAll();
	    lock.unlock();
	}
	return instance;
    }

    private final List<Connection> CONNECTION = new ArrayList<>();
    private String URL;
    private String user;
    private String password;
    private int maxConn;

    private DBConnectionPool(String URL, String user, String password, int maxConn) {
	this.URL = URL;
	this.user = user;
	this.password = password;
	this.maxConn = maxConn;
	loadDrivers();
    }

    private void loadDrivers() {
	try {
	    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	} catch (SQLException ex) {
	    Logger.getLogger(DBConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public Connection getConnection() {
	Connection con = null;
	if (!CONNECTION.isEmpty()) {
	    con = CONNECTION.get(CONNECTION.size() - 1);
	    CONNECTION.remove(con);
	    try {
		if (con.isClosed()) {
		    con = getConnection();
		}
	    } catch (SQLException ex) {
		Logger.getLogger(DBConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
		con = getConnection();
	    }
	} else {
	    con = newConnection();
	}
	return con;
    }

    private Connection newConnection() {
	Connection con = null;
	try {
	    con = DriverManager.getConnection(URL, user, password);
	} catch (SQLException ex) {
	    Logger.getLogger(DBConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
	}
	return con;
    }

    public void freeConnection(Connection con) {
	lock.lock();
	if ((con != null) && (CONNECTION.size()) <= maxConn) {
	    CONNECTION.add(con);
	}
	lock.unlock();
    }

    public void release() throws SQLException {
	lock.lock();
	Iterator allConnections = CONNECTION.iterator();
	while (allConnections.hasNext()) {
	    Connection con = (Connection) allConnections.next();
	    con.close();
	}
	CONNECTION.clear();
	lock.unlock();
    }
}
