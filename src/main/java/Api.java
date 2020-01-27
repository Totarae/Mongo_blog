import com.google.gson.Gson;
import freemarker.template.Configuration;
import freemarker.template.Template;
import model.Blog;
import service.UserService;
import spark.Spark;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class Api {
    public static UserService userservice = new UserService();
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {
        final Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        staticFileLocation("/styles");
        cfg.setClassForTemplateLoading(Api.class,"/");
        cfg.setDefaultEncoding("UTF-8");

        port(getHerokuAssignedPort());

        Gson gson = new Gson();

        get("/add-post",((req,res)->{
            res.status(200);
            res.type("text/html");

            Map<String, Object> map = new HashMap<>();
            StringWriter writer = new StringWriter();

            try {
                Template template = cfg.getTemplate("add_post.ftl");
                template.process(map,writer);
            }
            catch (Exception e) {
                Spark.halt(500);
            }
            return writer;
        }));

        get("/hello", (req, res) -> "Hello World");

        get("/web", (req,res)->{
            res.type("application/json");
            return userservice.getAllPosts();
        }, gson::toJson);

        get("/", ((request, response) -> {
            response.status(200);
            response.type("text/html");

            StringWriter writer = new StringWriter();

            Map<String, Object> input = new HashMap<String, Object>();
            List<Blog> systems = userservice.getAllPosts();
            input.put("posts", systems);

            try {
                Template template = cfg.getTemplate("index.ftl");
                template.process(input,writer);
            }
            catch (Exception e) {
                Spark.halt(500);
            }

            return writer;
        }));

        get("/:username",(req,res) -> {
            res.type("application/json");
            Blog blog = userservice.getPostByOtherName(req.params("username"));
            if (blog != null) {
                return blog;
            }
            else {
                return "No post founnd";
            }
        }, gson::toJson);

        post("/new_post", (req, res) -> {
            String a, b, c;
            Blog blg1 = new Blog(req.queryParams("title"),req.queryParams("post"),req.queryParams("username"));
            userservice.addpost(blg1);
            return null;
        });
    }
}