package service;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import model.Blog;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserService {

        String user = "oooo";     // the user name
        String source = "oooo";   // the source where the user is defined
        String realPsswd = "oooo";

        char[] password = realPsswd.toCharArray(); // the password as a character array

        MongoCredential credential = MongoCredential.createCredential(user, source, password);

        MongoClient client = new MongoClient(new ServerAddress("000.000.000.000", 27017), Collections.singletonList(credential));


        Datastore datastore = new Morphia().createDatastore(client, "blog");

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
