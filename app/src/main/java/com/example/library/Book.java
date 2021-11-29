package com.example.library;

public class Book {
    private int id;
    private String title;
    private String author;
    private int pages;
    private String imageUrl;
    private String shortDescription;
    private String longDescription;
    private boolean isExpanded;

    public Book(int id, String title, String author, int pages, String imageUrl, String shortDescription, String longDescription) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.imageUrl = imageUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.isExpanded = false;
    }

    public boolean isExpanded() { return isExpanded; }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) { this.longDescription = longDescription; }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", imageUrl='" + imageUrl + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                '}';
    }
}
