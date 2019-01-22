package ru.job4j.tracker;

public class Item {
    private String name;
    private String description;
    private long created;
    private String[] comment;
    private String id;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.created = System.currentTimeMillis();
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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Заявка : ID " + this.id + " Имя " + this.name + " Описание " + this.description;
    }
}

