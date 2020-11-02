package com.example.book_list;

public class Book {
    String title, author, genre;
    int year;

    public Book(String title, String author, String genre, int year) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    public  String toString() {
        return "Author: " + author + "\nTitle:" + title;
    }
}
