package com.shilm.utils;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;

import org.apache.log4j.Logger;

/**
 * 具体实现类
 * <p>Description: </p>
 *	
 * @author shilm
 * @date 2016年4月27日
 * 联系方式：shilm@carnation.com.cn
 */
public class MysqlUtils implements DBPools {

	
	private static Logger log = Logger.getLogger(MysqlUtils.class);
	
	private final static int POOLINITSIZE = Integer.parseInt(ApplicationContext.getProperty("initialsize"));
	
	private static String username = ApplicationContext.getProperty("username");
	
	private static String password = ApplicationContext.getProperty("password");
	
	private static String url = ApplicationContext.getProperty("url");
	
	private static LinkedList<Connection> list = new LinkedList<Connection>();
	
	static {
		try {
			Class.forName(ApplicationContext.getProperty("driverClassName"));
			for(int i=0;i<POOLINITSIZE;i++) {
				Connection con = DriverManager.getConnection(url, username, password);
				list.add(con);
			}
		} catch (ClassNotFoundException e) {
			log.error(" DriverClass Error!!");
		} catch (SQLException e) {
			log.error(" create Connection Error");
		}
		log.info(" Mysql Connection pools is init finish, size = " + POOLINITSIZE);
	}
	/**
	 * 在加载该类时就创建了一个数据库连接池list,里面10个连接
	 * 当多线程请求连接时，遇到 list<=0时，等待，如果客户端返回了连接， 就唤醒等待的连接
	 * 目前遇到的问题：程序执行到   notifyAll(); 时出现 java.lang.IllegalMonitorStateException 异常
	 * 我很纳闷的是明明是同一个锁啊，为什么？    
	 * 网上查到：如果当前线程不是对象所得持有者，该方法抛出一个java.lang.IllegalMonitorStateException 异常”
	 */
	public Connection getConnection() throws SQLException {
		synchronized(MysqlUtils.class) {
			while(list.size() <= 0 ) {
				try {
					log.info(Thread.currentThread().getName() + " 开始等待。。。。。。 " );
					MysqlUtils.class.wait();
				} catch (InterruptedException e) {
					log.error(" Thread " + Thread.currentThread().getName()
							+ " has waiting error!");
				}
			}
		}
		final Connection con = list.removeFirst();
		Connection conn =  (Connection) Proxy.newProxyInstance(MysqlUtils.class.getClassLoader()
			, new Class[]{Connection.class}
			,new InvocationHandler() {
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if(!method.getName().equals("close")) {
					return method.invoke(con, args);
				} else {
					synchronized(MysqlUtils.class) {
						list.add(con);
						MysqlUtils.class.notifyAll();
						return null;
					}
				}
			}
		});
		
		return conn;
	
		
	}
	
	public synchronized void close(Connection connection) {
		
	}

	
	public Connection getConnection(String username, String password) throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	public void setLogWriter(PrintWriter out) throws SQLException {
		
	}

	public void setLoginTimeout(int seconds) throws SQLException {
		
	}

	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	public java.util.logging.Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

}
