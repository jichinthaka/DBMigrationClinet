package com.wso2.support.db.migration;

public class ColumnInfo {

    private String column;
    private int type;

    public ColumnInfo(String column, int type){
        this.column = column;
        this.type = type;
    }

    public String getColumnName() {
        return column;
    }

    public int getDataType() {
        return type;
    }
}
