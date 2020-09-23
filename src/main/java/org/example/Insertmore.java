package org.example;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Insertmore {
    public static void main(String[] args) {
        MongoClient client=new MongoClient();
        MongoDatabase database= client.getDatabase("test");
        MongoCollection collection=database.getCollection("pop");
        List<Document> list=new ArrayList<Document>();
        Document document1=new Document().append("username","Jinn1").append("name","Jinn1");
        Document document2=new Document().append("username","Jinn2").append("name","Jinn2");
        Document document3=new Document().append("username","Jinn3").append("name","Jinn3");
        list.add(document1);
        list.add(document2);
        list.add(document3);
        collection.insertMany(list);
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
