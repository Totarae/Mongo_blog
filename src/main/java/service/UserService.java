package service;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import model.Blog;
import org.eclipse.jetty.util.security.Credential;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class UserService {

        MongoCredential credential = null;

        MongoClient client = null;


        Datastore datastore = null;

    public UserService(Preferences prefs) {

        credential = MongoCredential.createCredential(
                prefs.get("user", null),
                prefs.get("source", null),
                prefs.get("password", null).toCharArray());

        client = new MongoClient(new ServerAddress(prefs.get("hostname", null), prefs.getInt("port", 27017)),
                Collections.singletonList(credential));

        datastore = new Morphia().createDatastore(client, prefs.get("target_database", null));

        String[] keys = new String[0];
        try {
            keys = prefs.keys();
            for (String key : keys) {
                System.out.println(key + " = " + prefs.get(key, null));
            }
        } catch (BackingStoreException e) {
            System.err.println(e);
        }
    }

    public String addpost(Blog blog){
            datastore.save(blog);
            return "add post";
    }

    public List<Blog> getAllPosts(){
        try{
                List<Blog> list = datastore.find(Blog.class).asList();

                if (list != null){
                    return list;
                }
                else{
                    return null;
                }

        } catch (Exception e) {
                e.printStackTrace();
                return null;
        }

    }

    public Blog getPostByOtherName(String username){
            Blog blog = datastore.find(Blog.class, "oth", username).get();

            if (blog != null) {
                return  blog;
            }
            else{
                return null;
            }


        }
}
