package org.example;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

public class NewCollection {
    public static void main(String[] args) {
        //Connection part
        MongoClient client=new MongoClient("localhost",27017);
        //Print databases
        MongoIterable<String> iterable=client.listDatabaseNames();
        System.out.println("\n\n");
        iterable.forEach(new Block<String>() {
            @Override
            public void apply(String s) {
                System.out.println(s);
            }
        });
        System.out.println("////////////////////////////////////////////");

        // Select databases
        MongoDatabase database=client.getDatabase("test");
        //List collections
        MongoIterable<String> iterable1=database.listCollectionNames();
        iterable1.forEach(new Block<String>() {
            @Override
            public void apply(String s) {
                System.out.println(s);
            }
        });
        System.out.println("////////////////////////////////////////////");
        //Createa a new Collection
        database.createCollection("newBox");
        //List collections
        MongoIterable<String> iterable3=database.listCollectionNames();
        iterable3.forEach(new Block<String>() {
            @Override
            public void apply(String s) {
                System.out.println(s);
            }
        });
        System.out.println("////////////////////////////////////////////");
        //Select collections
        MongoCollection collection=database.getCollection("car");
        MongoIterable<Document> iterable2=collection.find();
        iterable2.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                System.out.println(document);
            }
        });
        System.out.println("////////////////////////////////////////////");
    }
}
