/*
Created by: Margaret Donin
Date created: 04/27/20
Date revised:
Model a book as if the class were to be part of a publishing system that the author uses to write the book.
*/

package M2.ClassModeling.Book;

public class Book0{
    private String title;
    private String author;
    private int ISBN_10;
    private int ISBN_13;
    private Chapters[] chapter;

    public Book0(String title, String author, int ISBN_10, int ISBN_13, Chapters[] chapter) {
        this.title = title;
        this.author = author;
        this.ISBN_10 = ISBN_10;
        this.ISBN_13 = ISBN_13;
        this.chapter = chapter;
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

    public int getISBN_10() {
        return ISBN_10;
    }

    public void setISBN_10(int ISBN_10) {
        this.ISBN_10 = ISBN_10;
    }

    public int getISBN_13() {
        return ISBN_13;
    }

    public void setISBN_13(int ISBN_13) {
        this.ISBN_13 = ISBN_13;
    }

    public Chapters[] getChapter() {
        return chapter;
    }

    public void setChapter(Chapters[] chapter) {
        this.chapter = chapter;
    }
}