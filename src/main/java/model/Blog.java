package model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Blog {
    @Id
    private ObjectId id;
    private String title;
    private String description;
    private String oth;

    public Blog(ObjectId id) {
        this.id = id;
    }

    public Blog(String title, String description, String oth) {
        this.title = title;
        this.description = description;
        this.oth = oth;
    }

    public Blog(ObjectId id, String title, String description, String oth) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.oth = oth;
    }

    public Blog() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
