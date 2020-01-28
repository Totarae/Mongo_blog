package model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;

@Entity
public class Blog {
    @Id
    private ObjectId id;
    private String title;
    private String description;
    private Date publish_date;
    private String oth;

    public Blog(ObjectId id) {
        this.id = id;
    }

    public Blog(String title, String description, String oth, Date dt) {
        this.title = title;
        this.description = description;
        this.oth = oth;
        this.publish_date = dt;
    }

    public Blog(ObjectId id, String title, String description, String oth, Date dt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.oth = oth;
        this.publish_date = dt;
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

    public String getOth() {
        return oth;
    }

    public void setOth(String oth) {
        this.oth = oth;
    }

    public Date getPublish_date() { return publish_date; }

    public void setPublish_date(Date publish_date) { this.publish_date = publish_date; }
}
