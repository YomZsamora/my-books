package models;

import java.util.ArrayList;

public class Books {
    private String bookName;
    private String description;
    private int noOfPages;
    private boolean availability;
    private static ArrayList<Books> allBooks = new ArrayList<>();

    public Books(String bookName, String description, int noOfPages, boolean availability){
        this.bookName = bookName;
        this.description = description;
        this.noOfPages = noOfPages;
        this.availability = availability;
        allBooks.add(this);
    }

    public String getBookName() {
        return bookName;
    }

    public String getDescription() {
        return description;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public boolean isAvailability() {
        return availability;
    }

    public static ArrayList<Books> getAllBooks() {
        return allBooks;
    }
}
