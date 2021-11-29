package com.example.library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {
    private RecyclerView booksRecyclerView;
    private BookRecyclerViewAdapter booksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        booksAdapter = new BookRecyclerViewAdapter(this, "allBooks");
        booksRecyclerView = findViewById(R.id.booksRecyclerView);

        // overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        booksRecyclerView.setAdapter(booksAdapter);
        // booksRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        booksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        booksAdapter.setBooks(Utils.getInstance().getAllBooks());
    }

    /*
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_out, R.anim.slide_in);
    }
     */

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}