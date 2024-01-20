package com.wso2.support.db.migration;

import com.wso2.support.db.migration.util.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class DataParser {
    public abstract void insertData(Connection sourceDBConnection, Connection targetDBConnection, String tableName, ResultSet sourceTableResult, List<ColumnInfo> tableColumns) throws SQLException;
    protected String buildInsertQuery(String tableName, List<ColumnInfo> tableColumns){
        String insertQuery = "INSERT INTO ";
        insertQuery = insertQuery + tableName + " ";

        String columnNames = "(";
        String valueLocations = "(";

        for (int i = 0; i < tableColumns.size(); i++) {
            ColumnInfo columnInfo = tableColumns.get(i);

            if (i > 0) {
                columnNames = columnNames + ", ";
                valueLocations = valueLocations + ", ";
            }
            columnNames = columnNames + columnInfo.getColumnName();
            valueLocations = valueLocations + "?";
        }

        columnNames = columnNames + ")";
        valueLocations = valueLocations + ")";
        insertQuery = insertQuery + columnNames + " values" + valueLocations + ";";

        Logger.info("Insert Query : " + insertQuery);
        return insertQuery;
    }

    protected abstract void convertData(PreparedStatement sourcePreparedStatement, ResultSet sourceTableResult, int valueID, int SourceDataType, String columnName) throws SQLException;
}