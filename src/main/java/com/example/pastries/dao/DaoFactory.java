package com.example.pastries.dao;

public class DaoFactory {

    public static final PastryDao createPastryDao(){
        return new PastryDao();
    }


}
