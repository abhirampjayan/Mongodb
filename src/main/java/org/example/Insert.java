package org.example;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

public class Insert {
    public static void main(String[] args) {
        MongoClient client=new MongoClient("localhost",27017);
        MongoDatabase database=client.getDatabase("test");
        MongoCollection collection=database.getCollection("pop");
        Document document=new Document().append("username","Jinn").append("name","Jinn");
        collection.insertOne(document);
        MongoIterable<Document> iterable=collection.find();
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                System.out.println(document);
            }
        });
        client.close();
    }
}
