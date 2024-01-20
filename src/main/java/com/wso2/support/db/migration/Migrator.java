package com.wso2.support.db.migration;

import com.moandjiezana.toml.Toml;
import com.wso2.support.db.migration.util.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public abstract class Migrator {

    public abstract boolean run(Toml toml) throws SQLException, ClassNotFoundException;

    protected void migrate(TableInfo tableInfo, DataExporter DataExporter, DataParser dataParser, ConnectionBuilder connectionBuilder, Toml toml) throws SQLException, ClassNotFoundException {
        // Access values from the TOML file

        String wso2_db = toml.getString("wso2_db");

        String sourceUrl = toml.getString("source.url");
        String sourceUsername = toml.getString("source.username");
        String sourcePassword = toml.getString("source.password");

        String targetUrl = toml.getString("target.url");
        String targetUsername = toml.getString("target.username");
        String targetPassword = toml.getString("target.password");

        Connection sourceConnection = connectionBuilder.getSourceConnection(sourceUrl, sourceUsername, sourcePassword );
        Connection targetConnection = connectionBuilder.getTargetConnection(targetUrl, targetUsername, targetPassword);


        try {
            // Iterate over the tableInfo map
            for (Map.Entry<String, List<ColumnInfo>> entry : tableInfo.getTableInfo(wso2_db).entrySet()) {
                String tableName = entry.getKey();
                List<ColumnInfo> tableColumns = entry.getValue();

                Logger.info("Migrating table : " + tableName);

                ResultSet table_data = DataExporter.exportFromTable(sourceConnection, tableName);
                table_data.last();
                int rowCount = table_data.getRow();

                if (rowCount == 0) {
                    Logger.info("Table is Empty.");
                } else {
                    table_data.beforeFirst();
                    Logger.info("Inserting " + rowCount + " rows...");
                    dataParser.insertData(sourceConnection, targetConnection, tableName, table_data, tableColumns);
                }

                if (table_data != null) {
                    table_data.close();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
