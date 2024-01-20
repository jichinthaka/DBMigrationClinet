package com.wso2.support.db.migration.h2_to_mssql;

import com.wso2.support.db.migration.ConnectionBuilder;
import com.wso2.support.db.migration.util.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBuilderH2ToMssql extends ConnectionBuilder {
    @Override
    public Connection getSourceConnection(String url, String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");

        Logger.info("Connecting to source H2 DB : " + url);
        Connection connection = DriverManager.getConnection(url, user, password);
        if (isConnectionValid(connection)) {
            Logger.info("H2 connection is valid.");
        } else {
            Logger.error("H2 connection is not valid.");
        }

        return connection;
    }

    @Override
    public Connection getTargetConnection(String url, String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        Logger.info("Connecting to target MS-SQL DB : " + url);
        Connection connection = DriverManager.getConnection(url, user, password);
        if (isConnectionValid(connection)) {
            Logger.info("MS-SQL connection is valid.");
        } else {
            Logger.error("MS-SQL connection is not valid.");
        }

        return connection;

    }
}
