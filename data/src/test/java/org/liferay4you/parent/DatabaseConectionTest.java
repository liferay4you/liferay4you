package org.liferay4you.parent;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/application-context.xml")
public abstract class DatabaseConectionTest {
	
	private static Log log = LogFactory.getLog(DatabaseConectionTest.class);
	
	@BeforeClass
	public static void setUp() {
		try {
			// Set necessary system properties
			System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
			System.setProperty(Context.URL_PKG_PREFIXES,  "org.apache.naming");
			
			// Create initial context
			InitialContext ic = new InitialContext();
			ic.createSubcontext("java:");
			ic.createSubcontext("java:/comp");
			ic.createSubcontext("java:/comp/env");
			ic.createSubcontext("java:/comp/env/jdbc");
			
			// Create data source
			MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
			dataSource.setUser("root");
			dataSource.setPassword("root");
			dataSource.setServerName("localhost");
			dataSource.setPort(3306);
			dataSource.setDatabaseName("liferay4you");
			
			// finall bind the datasoruce
			ic.bind("java:/comp/env/jdbc/l4u", dataSource);
			
		} catch (Exception e) {
			log.error("Database connection failed", e);
		}
	}
	
}
