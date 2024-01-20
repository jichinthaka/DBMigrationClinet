package com.wso2.support.db.migration;

import com.wso2.support.db.migration.util.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class ConnectionBuilder {

    public abstract Connection getSourceConnection(String url, String user, String password) throws ClassNotFoundException, SQLException;
    public abstract Connection getTargetConnection(String url, String user, String password) throws ClassNotFoundException, SQLException;


    protected boolean isConnectionValid(Connection connection) {
        try {
            return connection != null && !connection.isClosed() && connection.isValid(5); // 5 seconds timeout
        } catch (SQLException e) {
            Logger.error(e.toString());
            return false;
        }
    }
}
