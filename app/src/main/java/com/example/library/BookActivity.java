package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    public static final String BOOK_ID_KEY = "bookId";

    private TextView bookTitle, bookAuthor, bookPages, bookLongDescription;
    private Button addToCurrentlyReadingButton, addToWantToReadButton, addToAlreadyReadButton, addToFavoritesButton;
    private ImageView currentBookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initializeViews();

        // String longDescription = "The book opens with a woman named Aomame (青豆) as she rides a taxi to a work assignment. She hears the Sinfonietta by Leoš Janáček playing on the radio and immediately recognizes it, somehow having detailed knowledge of its history and context.";
        // TODO: Get the data from recycler view in here
        // Book book = new Book(1, "1Q84", "Haruki Murakami", 1350, "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1483103331l/10357575.jpg", "A work of maddening brilliance", longDescription);

        Intent intent = getIntent();
        if(intent != null) {
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);
            if(bookId != -1) {
                Book incomingBook = Utils.getInstance().getBookById(bookId);
                if(incomingBook != null) {
                    setData(incomingBook);
                    handleAlreadyRead(incomingBook);
                    handleWantToReadBook(incomingBook);
                    handleCurrentlyReadingBook(incomingBook);
                    handleFavoriteBooks(incomingBook);
                }
            }
        }
    }

    private void handleFavoriteBooks(Book incomingBook) {
        ArrayList<Book> favoriteBooks = Utils.getInstance().getFavoriteBooks();

        boolean existInFavoriteBooks = false;

        for(Book book : favoriteBooks) {
            if(book.getId() == incomingBook.getId()) {
                existInFavoriteBooks = true;
            }
        }

        if(existInFavoriteBooks) {
            addToFavoritesButton.setEnabled(false);
        } else {
            addToFavoritesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().addedToFavorite(incomingBook)) {
                        Toast.makeText(BookActivity.this, "Book Added Successfully", Toast.LENGTH_SHORT).show();
                        //TODO: navigate the user to new activity
                        Intent intent = new Intent(BookActivity.this, FavoriteActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something went wrong! Try again!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleCurrentlyReadingBook(Book incomingBook) {
        ArrayList<Book> currentlyReadingBooks = Utils.getInstance().getCurrentlyReadingBooks();

        boolean existInCurrentlyReadingBooks = false;

        for(Book book : currentlyReadingBooks) {
            if(book.getId() == incomingBook.getId()) {
                existInCurrentlyReadingBooks = true;
            }
        }

        if(existInCurrentlyReadingBooks) {
            addToCurrentlyReadingButton.setEnabled(false);
        } else {
            addToCurrentlyReadingButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().addedToCurrentlyReading(incomingBook)) {
                        Toast.makeText(BookActivity.this, "Book Added Successfully", Toast.LENGTH_SHORT).show();
                        //TODO: navigate the user to new activity
                        Intent intent = new Intent(BookActivity.this, CurrentlyReadingActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something went wrong! Try again!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleWantToReadBook(Book incomingBook) {
        ArrayList<Book> wantToReadBooks = Utils.getInstance().getWantToReadBooks();

        boolean existsInWantToReadBooks = false;

        for(Book book : wantToReadBooks) {
            if(book.getId() == incomingBook.getId()) {
                existsInWantToReadBooks = true;
            }
        }

        if(existsInWantToReadBooks) {
            addToWantToReadButton.setEnabled(false);
        } else {
            addToWantToReadButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().addedToWantToRead(incomingBook)) {
                        Toast.makeText(BookActivity.this, "Book Added Successfully", Toast.LENGTH_SHORT).show();
                        //TODO: navigate the user to new activity
                        Intent intent = new Intent(BookActivity.this, WantToReadActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something went wrong! Try again!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    /**
     * Enable and Disable button
     * Add the book to Already Read Book ArrayList
     * @param incomingBook
     */
    private void handleAlreadyRead(Book incomingBook) {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance().getAlreadyReadBooks();

        boolean existsInAlreadyReadBooks = false;

        for(Book book : alreadyReadBooks) {
            if(book.getId() == incomingBook.getId()) {
                existsInAlreadyReadBooks = true;
            }
        }

        if(existsInAlreadyReadBooks) {
            addToAlreadyReadButton.setEnabled(false);
        } else {
            addToAlreadyReadButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().addedToAlreadyRead(incomingBook)) {
                        Toast.makeText(BookActivity.this, "Book Added Successfully", Toast.LENGTH_SHORT).show();
                        //TODO: navigate the user to new activity
                        Intent intent = new Intent(BookActivity.this, AlreadyReadBookActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something went wrong! Try again!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setData(Book book) {
        bookTitle.setText(book.getTitle());
        bookAuthor.setText(book.getAuthor());
        bookPages.setText(String.valueOf(book.getPages()));
        bookLongDescription.setText(book.getLongDescription());
        Glide.with(this).asBitmap().load(book.getImageUrl()).into(currentBookImage);
    }

    private void initializeViews() {
        bookTitle = findViewById(R.id.bookTitle);
        bookAuthor = findViewById(R.id.bookAuthor);
        bookPages = findViewById(R.id.bookPages);
        bookLongDescription = findViewById(R.id.bookLongDescription);

        addToCurrentlyReadingButton = findViewById(R.id.addToCurrentlyReadingButton);
        addToWantToReadButton = findViewById(R.id.addToWantToReadButton);
        addToAlreadyReadButton = findViewById(R.id.addToAlreadyReadButton);
        addToFavoritesButton = findViewById(R.id.addToFavoritesButton);

        currentBookImage = findViewById(R.id.currentBookImage);
    }
}