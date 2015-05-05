package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args)  {

        Book book = new Book(1801, "K.Dojl", "Sherloc");
        Book book1 = new Book(1802, "J.London", "Columb");
        Book book2 = new Book(1803, "Dostojevski", "Idiot");
        Book book3 = new Book(1804, "Tolstoj", "Anna Karenina");
        Book book4 = new Book(1805, "Gogol", "Shinel");


        Library.books.add(book);
        Library.books.add(book1);
        Library.books.add(book2);
        Library.books.add(book3);
        Library.books.add(book4);

        try {
            Library.writeFile();


            ArrayList<Book> books = Library.readFile();

            for(Book item: books)
                System.out.println(item);

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
