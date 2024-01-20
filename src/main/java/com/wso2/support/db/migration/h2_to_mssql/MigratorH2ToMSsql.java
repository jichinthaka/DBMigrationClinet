package com.wso2.support.db.migration.h2_to_mssql;

import com.moandjiezana.toml.Toml;
import com.wso2.support.db.migration.DataExporter;
import com.wso2.support.db.migration.DataParser;
import com.wso2.support.db.migration.Migrator;
import com.wso2.support.db.migration.TableInfo;
import com.wso2.support.db.migration.ConnectionBuilder;

import java.sql.SQLException;

public class MigratorH2ToMSsql extends Migrator {
    @Override
    public void run(Toml toml) throws SQLException, ClassNotFoundException {

        TableInfo tableInfo = new TableInfo();
        DataExporter DataExporter = new DataExporter();

        DataParser dataParser = new DataParserH2ToMssql();
        ConnectionBuilder connectionBuilder = new ConnectionBuilderH2ToMssql();

        migrate(tableInfo, DataExporter, dataParser, connectionBuilder, toml);

    }
}
