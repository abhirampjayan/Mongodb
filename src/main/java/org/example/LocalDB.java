package org.example;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoIterable;

public class LocalDB {
    public static void main(String[] args) {
        MongoClient client=new MongoClient("127.0.0.1",27017);
        MongoIterable<String> mitems= client.listDatabaseNames();
        mitems.forEach(new Block<String>() {
            @Override
            public void apply(String dbname) {
                System.out.println(" "+dbname);
            }
        });
    }
}
