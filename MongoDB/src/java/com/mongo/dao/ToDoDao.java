/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongo.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;
import org.bson.BSON;
import org.bson.types.ObjectId;
import static com.mongodb.client.model.Filters.*;

/**
 *
 * @author Pritam
 */
public class ToDoDao {
    private static MongoClient client;

    public static List<BasicDBObject> getToDoList(String id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(client==null){
            client = DaoConnection.getMongoClient();
        }
        MongoCollection<BasicDBObject> collection;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        collection = client.getDatabase("myFirstDB").getCollection("todo",BasicDBObject.class);
        BasicDBObject query = new BasicDBObject();
        query.put("user_id", id);
        //query.put("password",password);
        List<BasicDBObject> dbresult = collection.find(query).into(new ArrayList<BasicDBObject>());
        System.out.println("com.mongo.dao.LoginDao.validateLogin()"+dbresult.size());
        //String id = ""
        if(dbresult.size()>0)
        {    System.out.println("com.mongo.dao.LoginDao.validateLogin()"+dbresult.get(0).get("_id"));
            return dbresult;
        }
        return null;
    }

    public static void saveTask(String user_id,String task, String priority, String desc) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(client==null){
            client = DaoConnection.getMongoClient();
        }
        MongoCollection<BasicDBObject> collection;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        collection = client.getDatabase("myFirstDB").getCollection("todo",BasicDBObject.class);
        BasicDBObject query = new BasicDBObject();
        query.put("user_id", user_id);
        query.put("task", task);
        query.put("priority", priority);
        query.put("description", desc);
        //query.put("password",password);
        //List<BasicDBObject> dbresult = collection.find(query).into(new ArrayList<BasicDBObject>());
        collection.insertOne(query);
        //System.out.println("com.mongo.dao.LoginDao.validateLogin()"+dbresult.size());
        //String id = ""
        
        
    }

    public static void removeTask(String _id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if(client==null){
            client = DaoConnection.getMongoClient();
        }
        MongoCollection<BasicDBObject> collection;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        collection = client.getDatabase("myFirstDB").getCollection("todo",BasicDBObject.class);
        System.out.println("com.mongo.dao.ToDoDao.removeTask()"+ " String is "+ _id);
        //query.put("password",password);
        //List<BasicDBObject> dbresult = collection.find(query).into(new ArrayList<BasicDBObject>());
        collection.deleteOne(eq("_id", new ObjectId(_id)));
    }
    
}
