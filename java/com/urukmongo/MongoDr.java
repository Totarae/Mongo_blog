package com.urukmongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Created by Admin on 03.04.2017.
 */
public class MongoDr {
    public static void main(String[] args){
        MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(500).build();
        MongoClient client=new MongoClient(new ServerAddress(),options);

        MongoDatabase db = client.getDatabase("test").withReadPreference(ReadPreference.secondary());

        MongoCollection coll = db.getCollection("test");
    }
}
