package com.example.library;

import java.util.ArrayList;

public class Utils {
    private static Utils instance;

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favoriteBooks;

    private Utils() {
        if(allBooks == null) {
            allBooks = new ArrayList<>();
            initData();
        }
        if(alreadyReadBooks == null) {
            alreadyReadBooks = new ArrayList<>();
        }
        if(wantToReadBooks == null) {
            wantToReadBooks = new ArrayList<>();
        }
        if(currentlyReadingBooks == null) {
            currentlyReadingBooks = new ArrayList<>();
        }
        if(favoriteBooks == null) {
            favoriteBooks = new ArrayList<>();
        }
    }

    private void initData() {
        //TODO: add initial data
        allBooks.add(new Book(1, "1Q84", "Haruki Murakami", 1350, "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1483103331l/10357575.jpg", "A work of maddening brilliance", "Long Description"));
        allBooks.add(new Book(2, "The Myth of Sisyphus", "Albert Camus", 250, "https://miro.medium.com/max/500/1*DDsOx6D3oe8ZxcA-OTfIDA.jpeg", "One of the most influential works of this century, this is a crucial exposition of existentialist", "Long Description"));
    }

    public static Utils getInstance() {
        if(instance == null) {
            instance = new Utils();
            return instance;
        } else {
            return instance;
        }
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public Book getBookById(int id) {
        for(Book book : allBooks) {
            if(book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public boolean addedToAlreadyRead(Book book) {
        return alreadyReadBooks.add(book);
    }

    public boolean addedToWantToRead(Book book) {
        return wantToReadBooks.add(book);
    }

    public boolean addedToCurrentlyReading(Book book) {
        return currentlyReadingBooks.add(book);
    }

    public boolean addedToFavorite(Book book) {
        return favoriteBooks.add(book);
    }

    public boolean removeFromAlreadyRead(Book book) { return alreadyReadBooks.remove(book); }

    public boolean removeFromWantToRead(Book book) { return wantToReadBooks.remove(book); }

    public boolean removeFromCurrentlyReading(Book book) { return currentlyReadingBooks.remove(book); }

    public boolean removeFromFavorites(Book book) {
        return favoriteBooks.remove(book);
    }
}
