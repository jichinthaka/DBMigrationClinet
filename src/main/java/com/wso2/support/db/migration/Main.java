package com.wso2.support.db.migration;

import com.moandjiezana.toml.Toml;
import com.wso2.support.db.migration.h2_to_mssql.MigratorH2ToMSsql;
import com.wso2.support.db.migration.util.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;


public class Main {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Logger.info("***** Start the programme *****");
        Logger.info("Reading configurations from configuration.toml file...");

        Toml toml;

        // Use the class loader to get the resource stream
//        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("configuration.toml")) {
            try (InputStream inputStream = new FileInputStream(new File("./configuration.toml"))) {
            if (inputStream != null) {
                // Read and parse the TOML file
                toml = new Toml().read(inputStream);
            } else {
                Logger.error("Could not find the configuration.toml file.");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        List<Toml> databasesList = toml.getTables("databases");

        if (databasesList.isEmpty()){
            Logger.error("There is no configured databases in configuration.toml file.");
            return;
        }

        for (Toml databaseToml : databasesList) {
            Migrator migrator = null;

            String sourceType = databaseToml.getString("source.type");
            String targetType = databaseToml.getString("target.type");

            Logger.info("**************************************");
            Logger.info("**************************************");

            if (sourceType.equalsIgnoreCase("h2") & targetType.equalsIgnoreCase("mssql")) {
                Logger.info("Started DB migration from H2 to MSSQL.");
                migrator = new MigratorH2ToMSsql();
            } else {
                Logger.error("Only H2 to MSSQL migration is implemented.");
            }

            if(!migrator.run(databaseToml)) {
                Logger.error("Finished DB migration with Errors.");
                Logger.info("**************************************");
                Logger.info("**************************************");
            }
            else {
                Logger.info("Finished DB migration.");
                Logger.info("**************************************");
                Logger.info("**************************************");
            }
        }

    }

}
