package yrostami.service;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Yousef.
 */
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();

//        String serverName = ctx.getInitParameter("serverName");
//        String databaseName = ctx.getInitParameter("databaseName");
//        int portNumber = Integer.valueOf(ctx.getInitParameter("portNumber"));
//        String user = ctx.getInitParameter("user");
//        String password = ctx.getInitParameter("password");
//
//        DataBase.initializeDatabase(serverName, databaseName, portNumber, user, password);

        DataBase.initializeDatabase();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DataBase.destroyDatabase();
    }
}
