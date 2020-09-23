package org.example;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import static com.mongodb.client.model.Filters.*;

public class Filter {
    public static void main(String[] args) {
        MongoClient client=new MongoClient();
        MongoDatabase database= client.getDatabase("test");
        MongoCollection collection=database.getCollection("pop");
        //FindIterable<Document> iterable=collection.find().filter(Filters.eq("username","Jinn")).sort(Sorts.descending("username"));
        FindIterable<Document> iterable=collection.find(and(ne("username","Jinn"),ne("username","Abhi")));
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                System.out.println(document.toJson());
            }
        });
    }
}
