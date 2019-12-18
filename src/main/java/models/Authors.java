package models;

import java.util.ArrayList;
import java.util.List;

public class Authors {
    private String authorName;
    private static ArrayList<Authors> allAuthors = new ArrayList<>();
    private int id;
    private List<Books> authorBooks;

    public Authors(String authorName){
        this.authorName = authorName;
        allAuthors.add(this);
        this.id = allAuthors.size();
        this.authorBooks = new ArrayList<Books>();
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getId() {
        return id;
    }

    public static Authors findAuthor(int id){
        return allAuthors.get(id-1);
    }

    public void addBookToAuthor(Books newBook){
        authorBooks.add(newBook);
    }

    public List<Books> getAllThisAuthorBooks(){
        return authorBooks;
    }

    public static ArrayList<Authors> getAllAuthors() {
        return allAuthors;
    }
}
