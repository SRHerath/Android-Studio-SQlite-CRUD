package com.example.testing.Sql;

import java.io.Serializable;

public class ItemModel implements Serializable {


        private int id;
        private String code;
        private String des;
        private String quan;



    // creating getter and setter methods
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }


    public String getItemCode() { return code; }

    public void setItemCode(String code)
    {
        this.code = code;
    }

    public String getItemDes()
    {
        return des;
    }

    public void setItemDes(String des)
    {
        this.des = des;
    }

    public String getItemQuan() { return quan; }

    public void setItemQuan(String quan)
    {
        this.quan = quan;
    }

}
