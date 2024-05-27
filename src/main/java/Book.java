/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Omer
 */
public class Book {
    private String bookTitle;
    private int bookWidth;
    
    public Book(int bookWidth, String bookTitle) {
        this.bookTitle = bookTitle; 
        this.bookWidth = bookWidth;
    }
    
    public String getBookTitle() {
        return this.bookTitle;
    }
    
    public void setBookTitle(String inputTitle) {
        this.bookTitle = inputTitle;
    }
    
    public int getBookWidth() {
        return this.bookWidth;
    }
    
    public void setBookWidth(int inputWidth) {
        this.bookWidth = inputWidth;
    }
}
