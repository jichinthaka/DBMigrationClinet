# **DBMigrationClinet**

>We assume below points in this program:
>
>>Both source and target DBs are having tables with same names
> 
>>Each same table in source and target BS are having same column names

### How build the Source?
> 1. Download the Source
> 2. run `mvn clean install`

### How to run the Program?
 1. Configure the `configuration.toml`

Sample `configuration.toml` : 

```
[[databases]]
wso2_db = "AM_DB"    # possible values: "AM_DB", "REG_DB"
[databases.source]
type = "h2"     # possible types: "h2", "mssql"
url = "jdbc:h2:file:/Users/myuser/Documents/Backups/database/WSO2AM_DB"
username = "wso2carbon"
password = "wso2carbon"

[databases.target]
type = "mssql"     # possible types: "h2", "mssql"
url = "jdbc:sqlserver://192.102.222.196:1433;databaseName=AM_DB_TEST"
username = "root"
password = "root"

[[databases]]
wso2_db = "REG_DB"    # possible values: "AM_DB", "REG_DB"
[databases.source]
type = "h2"     # possible types: "h2", "mssql"
url = "jdbc:h2:file:/Users/myuser/Documents/Backups/database/WSO2CARBON_DB"
username = "wso2carbon"
password = "wso2carbon"

[databases.target]
type = "mssql"     # possible types: "h2", "mssql"
url = "jdbc:sqlserver://192.102.222.196:1433;databaseName=REG_DB_TEST"
username = "root"
password = "root"
```
Here, there are two database migration.

 2. Keep the `configuration.toml` in the same directory of the above built jar file. 


 3. Execute the jar file. 
 
 `java -jar DBMigrationClinet-1.0-SNAPSHOT-jar-with-dependencies.jar 2>&1 | tee migrationlogs.log`

This command will save the output logs of the program to the file  `migrationlogs.log` in the same directory. 


## Extendability
For now, this application is written for the Database migration from H2 to MSSQL. But this is extendable for other DB types. 
Refer this blog [1] for more details. 

[1] - https://medium.com/@jayaweerage.imesh/how-to-migrate-wso2-apim-default-h2-database-data-eebd0d9f5eb7