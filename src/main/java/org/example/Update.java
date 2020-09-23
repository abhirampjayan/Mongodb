package org.example;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.exclude;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Updates.*;

public class Update {
    public static void main(String[] args) {
        MongoClient client=new MongoClient();
        MongoDatabase database= client.getDatabase("test");
        MongoCollection collection=database.getCollection("pop");
        //FindIterable<Document> iterable=collection.find().filter(Filters.eq("username","Jinn")).sort(Sorts.descending("username"));
        FindIterable<Document> iterable=collection.find(and(ne("username","Jinn"),ne("username","Abhi"))).projection(include("username")).projection(exclude("_id"));
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                System.out.println(document.toJson());
            }
        });
        collection.updateMany(ne("username","Admin"),set("name","user"));
        collection.updateOne(eq("username","Admin"),set("name","APJ"));

        //collection.deleteOne(eq("username","Admin"))
        //collection.deleteMany(ne("username","Admin"))
        //collection.drop();
        //database.drop();

    }
}
