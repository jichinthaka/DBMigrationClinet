package com.wso2.support.db.migration;

import com.wso2.support.db.migration.util.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataExporter {

    public ResultSet exportFromTable(Connection dbConnection, String tableName) throws SQLException {
        Statement sqlStmt = dbConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        Logger.info("Reading data from source table..");
        ResultSet results = sqlStmt.executeQuery("SELECT * FROM " + tableName);

//        String query = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'PUBLIC'";
//        String query = "show tables;";
//        ResultSet results = sqlStmt.executeQuery(query);
//        System.out.println(results);
//        {
//
//            System.out.println("Tables in the database:");
//
//            while (results.next()) {
//                String tableName_temp = results.getString(1);
//                System.out.println(tableName_temp);
//            }
//        }


        return results;
    }
}
