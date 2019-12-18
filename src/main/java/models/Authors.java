package models;

import java.util.ArrayList;

public class Authors {
    private String authorName;
    private static ArrayList<Authors> allAuthors = new ArrayList<>();
    private int mId;

    public Authors(String authorName){
        this.authorName = authorName;
        this.mId = allAuthors.size();
        allAuthors.add(this);
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getmId() {
        return mId;
    }

    public static ArrayList<Authors> getAllAuthors() {
        return allAuthors;
    }
}
