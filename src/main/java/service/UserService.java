package service;

import com.mongodb.MongoClient;
import model.Blog;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.List;

public class UserService {
        MongoClient client = new MongoClient("185.93.109.227", 27017);

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
