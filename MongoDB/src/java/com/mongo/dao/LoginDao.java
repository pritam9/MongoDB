/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongo.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Pritam
 */
public class LoginDao {

    private static MongoClient client;
    
    
    public static String validateLogin(String username, String password) {
        if(client==null){
            client = DaoConnection.getMongoClient();
        }
        MongoCollection<BasicDBObject> collection;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        collection = client.getDatabase("myFirstDB").getCollection("users",BasicDBObject.class);
        BasicDBObject query = new BasicDBObject();
        query.put("username", username);
        query.put("password",password);
        List<BasicDBObject> dbresult = collection.find(query).into(new ArrayList<BasicDBObject>());
        System.out.println("com.mongo.dao.LoginDao.validateLogin()"+dbresult.size());
        //String id = ""
        if(dbresult.size()>0)
        {    System.out.println("com.mongo.dao.LoginDao.validateLogin()"+dbresult.get(0).get("_id"));
            return dbresult.get(0).get("_id").toString();
        }
        return null;
    }
    
}
