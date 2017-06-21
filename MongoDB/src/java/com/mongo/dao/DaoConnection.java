/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongo.dao;

import com.mongodb.MongoClient;

public class DaoConnection {
    private static final String host = "localhost";
    private static final int port = 27017;
    
    public static MongoClient getMongoClient() {
        MongoClient client=null;
        try{
            client = new MongoClient();
        }catch(Exception e){
            e.printStackTrace();
        }
        return client;
    }
    
}
