package com.wso2.support.db.migration.h2_to_mssql;

import com.wso2.support.db.migration.ColumnInfo;
import com.wso2.support.db.migration.DataParser;
import com.wso2.support.db.migration.util.Logger;
import org.h2.jdbc.JdbcSQLException;

import java.sql.*;
import java.util.List;

public class DataParserH2ToMssql extends DataParser {
    @Override
    public boolean insertData(Connection sourceDBConnection, Connection targetDBConnection, String tableName, ResultSet sourceTableResult, List<ColumnInfo> tableColumns) {
        try {
            String insertQuery = buildInsertQuery(tableName, tableColumns);
            boolean isIdentity = isAutoIncrementColumn_h2(sourceDBConnection, tableName);

            if (isIdentity) {
//            Logger.info("This is a table with Identity column in MSSQL.");
                insertQuery = "SET IDENTITY_INSERT " + tableName + " ON; " + insertQuery + " SET IDENTITY_INSERT " + tableName + " OFF;";
            }

//        System.out.println("isIdentity : " + isIdentity);
//        System.out.println("insertQuery : " + insertQuery);

            PreparedStatement preparedStatement = targetDBConnection.prepareStatement(insertQuery);

            int rowCount = 0;
            while (sourceTableResult.next()) {
                rowCount += 1;
                boolean isConverted = false;
                for (int i = 0; i < tableColumns.size(); i++) {
                    ColumnInfo columnInfo = tableColumns.get(i);
                    String columnName = columnInfo.getColumnName();
                    int dataType = columnInfo.getDataType();

//                System.out.println("dataType : " + dataType + ", columnName : " + columnName + ", h2_table_data_result : " + sourceTableResult.getString(columnName));

                    isConverted = convertData(preparedStatement, sourceTableResult, i + 1, dataType, columnName);

                    if(!isConverted)
                    {
                        break;
                    }
                }
                if(!isConverted)
                {
                    Logger.info("Continue to insert other rows...");
                    continue;
                }
//            System.out.println(preparedStatement);
                try {
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    Logger.error(e.toString());
                    Logger.info("Continue to insert other rows...");
                }
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
//        Logger.info("Inserted " + rowCount + " rows.");
        }
        catch (SQLException e) {
            Logger.error(e.toString());
            Logger.error("Error while inserting data to target table.");
            return false;
        }
        return true;
    }

    @Override
    protected boolean convertData(PreparedStatement sourcePreparedStatement, ResultSet sourceTableResult, int valueID, int SourceDataType, String columnName) {
        try {
            switch (SourceDataType) {
                case Types.INTEGER:
                case Types.SMALLINT:
//                System.out.println("value " + valueID + " : " + sourceTableResult.getInt(columnName));
                    sourcePreparedStatement.setInt(valueID, sourceTableResult.getInt(columnName));
                    break;
                case Types.BIGINT:
//                System.out.println("value " + valueID + " : " + sourceTableResult.getInt(columnName));
                    sourcePreparedStatement.setLong(valueID, sourceTableResult.getLong(columnName));
                    break;
                case Types.VARCHAR:
                case Types.CHAR:
//                System.out.println("value " + valueID + " : " + sourceTableResult.getString(columnName));
                    sourcePreparedStatement.setString(valueID, sourceTableResult.getString(columnName));
                    break;
                case Types.TIMESTAMP:
//                System.out.println("value " + valueID + " : " + sourceTableResult.getTimestamp(columnName));
                    sourcePreparedStatement.setTimestamp(valueID, sourceTableResult.getTimestamp(columnName));
                    break;
                case Types.BOOLEAN:
                case Types.TINYINT:
//                System.out.println("value " + valueID + " : " + sourceTableResult.getBoolean(columnName));
                    sourcePreparedStatement.setBoolean(valueID, sourceTableResult.getBoolean(columnName));
                    break;
                case Types.BLOB: // Handle BLOB to VARBINARY conversion
                    Blob blob = sourceTableResult.getBlob(columnName);
                    byte[] bytes = null;
                    if (blob != null) {
                        bytes = blob.getBytes(1, (int) blob.length());
                    }
                    sourcePreparedStatement.setBytes(valueID, bytes);
                    break;
                default:
                    Logger.error("Identified unsupported datatype.");
                    throw new SQLException("ERROR: Unsupported data type: " + columnName);

            }
        }
        catch (SQLException e) {
            Logger.error(e.toString());
            Logger.error("Error while converting data to target table.");
            return false;
        }
        return true;
    }

    private boolean isAutoIncrementColumn_h2(Connection connection, String tableName) throws SQLException {
        try (ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM " + tableName + " WHERE 1 = 0")) {
            ResultSetMetaData metadata = rs.getMetaData();

            // This is the general solution, but slower
            /*
            int columnCount = metadata.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                if (metadata.isAutoIncrement(i)) {
                    return true; // Found an identity column
                }
            }
            */

            // hard coded to make speed
            if(!tableName.equalsIgnoreCase("REG_RESOURCE")) {
                if (metadata.isAutoIncrement(1)) {
                    return true; // Found an identity column
                }
            }
            else {
                for (int i = 1; i <= 4/*columnCount*/; i++) {
                    if (metadata.isAutoIncrement(i)) {
                        return true; // Found an identity column
                    }
                }
            }
        }
        return false; // No identity columns found
    }
}
