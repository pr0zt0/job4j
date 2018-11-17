package ru.job4j.tracker;

public class Item {
    private String name;
    private String description;
    private long created;
    private String[] comment;
    private String id;

    public Item(String name, String description, long created) {
        this.name = name;
        this.description = description;
        this.created = created;
       // this.comment = comment;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public long getCreated() {
        return this.created;
    }

    public String[] getComment() {
        return this.comment;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
