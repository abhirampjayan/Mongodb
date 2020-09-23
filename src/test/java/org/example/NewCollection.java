package org.example;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

public class NewCollection {
    public static void main(String[] args) {
        MongoClient client=new MongoClient("localhost",27017);
        MongoIterable<String> iterable=client.listDatabaseNames();
        System.out.println("\n\n");
        iterable.forEach(new Block<String>() {
            @Override
            public void apply(String s) {
                System.out.println(s);
            }
        });
        final MongoDatabase database=client.getDatabase("test");
        MongoIterable<String> iterable1=database.listCollectionNames();
        iterable1.forEach(new Block<String>() {
            @Override
            public void apply(String s) {
                System.out.println(s);
            }
        });
        MongoCollection collection=database.getCollection("car");
        MongoIterable<Document> iterable2=collection.find();
        iterable2.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                System.out.println(document);
            }
        });

    }
}
