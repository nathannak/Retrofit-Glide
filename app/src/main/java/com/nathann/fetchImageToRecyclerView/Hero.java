package com.nathann.fetchImageToRecyclerView;

public class Hero {

    String name;
    String realname;
    String team;

    public String getName() {
        return name;
    }

    public String getRealname() {
        return realname;
    }

    public String getTeam() {
        return team;
    }

    public String getFirstappearance() {
        return firstappearance;
    }

    public String getCreatedby() {
        return createdby;
    }

    public String getPublishers() {
        return publishers;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getBio() {
        return bio;
    }

    public Hero(String name, String realname, String team, String firstappearance, String createdby, String publishers, String imageurl, String bio) {
        this.name = name;
        this.realname = realname;
        this.team = team;
        this.firstappearance = firstappearance;
        this.createdby = createdby;
        this.publishers = publishers;
        this.imageurl = imageurl;
        this.bio = bio;
    }

    String firstappearance;
    String createdby;
    String publishers;
    String imageurl;
    String bio;

}
