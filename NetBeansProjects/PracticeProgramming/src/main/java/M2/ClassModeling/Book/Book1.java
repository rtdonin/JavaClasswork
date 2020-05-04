/*
Created by: Margaret Donin
Date created: 04/27/20
Date revised:
Model a book as if the class were to be part of a library cataloging system.
*/

package M2.ClassModeling.Book;

public class Book1{
    private String title;
    private String author;
    private int dewyDecimal;
    private String genre;
    private String synopsis;

    public Book1(String title, String author, int dewyDecimal, String genre, String synopsis) {
        this.title = title;
        this.author = author;
        this.dewyDecimal = dewyDecimal;
        this.genre = genre;
        this.synopsis = synopsis;
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

    public int getDewyDecimal() {
        return dewyDecimal;
    }

    public void setDewyDecimal(int dewyDecimal) {
        this.dewyDecimal = dewyDecimal;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return title + " by " + author + " in the " + genre + " genre.";
    }
    
    
    
    
}