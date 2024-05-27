
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Omer
 */
public class Carton {
    private int cartonHight;
    private int usedCartonHight = 0;
    private ArrayList<Book> booksList;
    
    public Carton(int cartonHight) {
        this.cartonHight = cartonHight;
        this.booksList = new ArrayList<>();
    }
    
    public void addBook(Book bookToAdd) {
        if (cartonHight - bookToAdd.getBookWidth() >= 0) {
        booksList.add(bookToAdd);
        cartonHight -= bookToAdd.getBookWidth();
        usedCartonHight += bookToAdd.getBookWidth();
        } else {
            System.out.println("Can't add the book, not enought space");
        }
    }
    
    public void removeBook (Book bookToRemove) {
        booksList.remove(bookToRemove);
        cartonHight += bookToRemove.getBookWidth();
        usedCartonHight -= bookToRemove.getBookWidth();
    }
    
    public int getNombreOfBooksInList() {
        return booksList.size();
    }
    
    public int getCartonHight() {
        return this.cartonHight;
    }
    
    public void printAllBooks() {
        booksList.forEach(book -> {
            System.out.println(book.getBookTitle());
        });
    }
    
    
    @Override
    public String toString() {
        return String.format("The Carton has %d books and the hight used is %d", getNombreOfBooksInList(), usedCartonHight);
    }
}
