package com.example.skeleton.common;

/**
 * @author yebing
 */
public enum Role {
    ADMIN(1,"admin"),
    USER(2,"user"),
    WE_CHAT(3,"weChat");

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Role(int id,String name){
        this.id = id;
        this.name = name;

    }
}
