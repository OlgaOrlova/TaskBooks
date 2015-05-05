package com.company;


import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Library {
    static ArrayList<Book> books = new ArrayList<>();
    static File file = new File("Books.txt");


    private static final Logger logger = Logger.getLogger("Logger name");


    public static void writeFile() throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        try {
            logger.log(Level.INFO, "try write to file - " + file.getAbsolutePath());


            for (Book book : books) {
                fileWriter.write(book.getAuthor() + ";");
                fileWriter.write(book.getTitle() + ";");
                fileWriter.write(book.getYear() + "\n");
                fileWriter.flush();
            }

        } catch (IOException e) {
            logger.log(Level.SEVERE, "error while writing to file " + file, e);
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    logger.log(Level.SEVERE, "error while closing file " + file, e);
                }

            }
        }
    }

    public static ArrayList<Book> readFile() throws IOException {

        FileReader fileReader = new FileReader(file);

        ArrayList<Book> books = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String line = null;
            try {
                while ((line = bufferedReader.readLine()) != null) {

                    String[] arr = line.split(";");
                    Book tmpBook = new Book();
                    tmpBook.setAuthor(arr[0]);
                    tmpBook.setTitle(arr[1]);
                    tmpBook.setYear(Integer.parseInt(arr[2]));
                    books.add(tmpBook);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return books;
    }

}

