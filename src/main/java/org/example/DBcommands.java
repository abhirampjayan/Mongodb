package org.example;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DBcommands {
    public static void main(String[] args) {
        MongoClient client=new MongoClient();
        MongoDatabase database= client.getDatabase("test");
        MongoCollection collection=database.getCollection("pop");
        Document res=database.runCommand(new Document("serverStatus",1));
        Document res2=database.runCommand(new Document("dbStatus",1));
        System.out.println(res.toJson());
        System.out.println(res2.toJson());
    }
}
