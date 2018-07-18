package com.urukmongo;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created by Admin on 27.03.2017.
 */
public class SparkHelloWorld {

    public static void main(String[] args){
        Spark.get( new Route("/") {
            public Object handle(Request request, Response response) {
                return "Hello World from Spark!";
            }
        });
    }

}
