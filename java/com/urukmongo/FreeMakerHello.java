package com.urukmongo;


import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 02.04.2017.
 */
public class FreeMakerHello {
    public static void main(String[] args){
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(FreeMakerHello.class,"/");

        try {
            Template helloTemplate = configuration.getTemplate("hello.html");
            StringWriter writer = new StringWriter();
            Map<String, Object> helloMap = new HashMap<String, Object>();
            helloMap.put("name","Freemaker");

            helloTemplate.process(helloMap,writer);

            System.out.println(writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
