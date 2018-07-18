package com.urukmongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.bson.Document;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Admin on 02.04.2017.
 */
public class BlogEngine {
    private static Configuration configuration;

    private static Configuration createConfig() {
        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(BlogEngine.class, "/");
        //Всё хранится в jar.
        //TODO: Заменить setServletContextForTemplateLoading

        cfg.setDefaultEncoding("UTF-8");
        return cfg;
    }
    /*Конфиг для Freemarker*/

    public static void main(String[] args){

        configuration = createConfig();

        MongoClient client = new MongoClient();
        MongoDatabase database = client.getDatabase("course");
        final MongoCollection<Document> coll = database.getCollection("hello");

        coll.drop();

        coll.insertOne(new Document("name", "MongoDB"));

        Spark.get(new Route("/") {
            public Object handle(Request request, Response response) {
                StringWriter writer = new StringWriter();
                try {
                    Template helloTemplate = configuration.getTemplate("hello.html");

                    Document document = coll.find().first();

                    helloTemplate.process(document,writer);

                    System.out.println(writer);
                } catch (Exception e) {
                    halt(500);
                    e.printStackTrace();
                }
                return writer;
            }
        });

        Spark.get(new Route("/login") {
            @Override
            public Object handle(Request request, Response response) {
                Map<String, Object> model = new HashMap<>();
                model.put("loggedOut", removeSess)
                return null;
            }
        });
    }
}
