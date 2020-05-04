/*
Created by: Margaret Donin
Date created: 04/27/20
Date revised:
Model a book as if the class were to be part of a publishing system that the author uses to write the book.
*/

package ClassModeling.Book;

public class Chapters{
    private String title;
    private String text;

    public Chapters(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
}