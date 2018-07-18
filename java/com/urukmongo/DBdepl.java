package com.urukmongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

;

/**
 * Created by Admin on 10.04.2017.
 */
public class DBdepl {
    public static void main(String[] args){
        MongoClient client = new MongoClient();
        MongoDatabase db = client.getDatabase("course");
        MongoCollection<Document> coll = db.getCollection("DBdepl");

        coll.drop();

        Document smith = new Document("name","Smith")
                    .append("age",30)
                    .append("profession","programmer");

        coll.insertOne(smith);
    }
}
