package org.example;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import org.bson.Document;

public class Find {
    public static void main(String[] args) {
        MongoClient client=new MongoClient();
        MongoDatabase database= client.getDatabase("test");
        MongoCollection collection=database.getCollection("pop");
        FindIterable<Document> iterable=collection.find().sort(Sorts.ascending("username"));
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                System.out.println(document.toJson());
            }
        });
    }
}
