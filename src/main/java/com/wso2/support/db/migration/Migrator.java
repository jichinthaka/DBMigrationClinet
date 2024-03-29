package com.wso2.support.db.migration;

import com.moandjiezana.toml.Toml;
import com.wso2.support.db.migration.util.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public abstract class Migrator {

    public abstract boolean run(Toml toml) throws ClassNotFoundException, SQLException;

    protected boolean migrate(TableInfo tableInfo, DataExporter DataExporter, DataParser dataParser, ConnectionBuilder connectionBuilder, Toml toml) throws ClassNotFoundException, SQLException {
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
            // hard coded
            if (wso2_db.equalsIgnoreCase("REG_DB")) {
                String disableConstraintSql = "ALTER TABLE REG_RESOURCE_TAG NOCHECK CONSTRAINT REG_RESOURCE_TAG_FK_BY_PATH_ID;"
                        + "ALTER TABLE REG_RESOURCE_PROPERTY NOCHECK CONSTRAINT REG_RESOURCE_PROPERTY_FK_BY_PATH_ID;";
                PreparedStatement disableConstraintStatement = targetConnection.prepareStatement(disableConstraintSql);
                disableConstraintStatement.executeUpdate();
            }

            // Iterate over the tableInfo map
            for (Map.Entry<String, List<ColumnInfo>> entry : tableInfo.getTableInfo(wso2_db).entrySet()) {
                String tableName = entry.getKey();
                List<ColumnInfo> tableColumns = entry.getValue();

                Logger.info("Migrating table : " + tableName);

                ResultSet table_data = DataExporter.exportFromTable(sourceConnection, tableName);

                if (table_data == null) {
                    Logger.info("Continue to next table...");
                    continue;
                }

                table_data.last();
                int rowCount = table_data.getRow();

                if (rowCount == 0) {
                    Logger.info("Table is Empty.");
                } else {
                    table_data.beforeFirst();
                    Logger.info("Inserting " + rowCount + " rows...");
                    boolean isInserted = dataParser.insertData(sourceConnection, targetConnection, tableName, table_data, tableColumns);
                    if (!isInserted) {
                        Logger.info("Continue to next table...");
                        continue;
                    }
                }

                table_data.close();
            }


            //hard coded
            if(wso2_db.equalsIgnoreCase("REG_DB"))
            {
                // Re-enable the foreign key constraint
                String enableConstraintSql = "ALTER TABLE REG_RESOURCE_TAG CHECK CONSTRAINT REG_RESOURCE_TAG_FK_BY_PATH_ID;"
                        + "ALTER TABLE REG_RESOURCE_PROPERTY CHECK CONSTRAINT REG_RESOURCE_PROPERTY_FK_BY_PATH_ID;";
                PreparedStatement enableConstraintStatement = targetConnection.prepareStatement(enableConstraintSql);
                enableConstraintStatement.executeUpdate();
            }
        } catch (SQLException e) {
            sourceConnection.close();
            targetConnection.close();
            Logger.error(e.toString());
            return false;
        }



        sourceConnection.close();
        targetConnection.close();

        return true;
    }
}
