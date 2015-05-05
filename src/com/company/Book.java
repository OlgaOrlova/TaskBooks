package com.company;

public class Book {
    private String title;
    private String author;
    private int year;

    public Book() {

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book(int year, String author, String title) {
        this.year = year;
        this.author = author;
        this.title = title;
    }

    @Override
    public String toString() {
        return author+";"+title+";"+year;
    }
}
