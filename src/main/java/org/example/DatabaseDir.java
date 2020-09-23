package org.example;


import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.BSONObject;
import org.bson.Document;

public class DatabaseDir {
    public static void main(String[] args) {
        MongoClient client=new MongoClient("localhost",27017);
        MongoIterable<String> iterable=client.listDatabaseNames();
        iterable.forEach(new Block<String>() {
            @Override
            public void apply(String s) {
                System.out.println(s);
            }
        });
        MongoDatabase database=client.getDatabase("test");
        MongoCollection collection=database.getCollection("car");
        MongoIterable<Document> iterable1=collection.find();
        iterable1.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                System.out.println(""+document.toJson());
            }
        });
    }
}
