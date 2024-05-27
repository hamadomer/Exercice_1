/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class Main {

    public static void main(String[] args) {
        Carton testCarton = new Carton(10);

        Book book1 = new Book(2, "Bilbo le hobbit");
        testCarton.addBook(book1);
        System.out.println(testCarton.toString());

        Book book2 = new Book(3, "Germinal");
        testCarton.addBook(book2);
        Book book3 = new Book(2, "Dune I");
        testCarton.addBook(book3);
        Book book4 = new Book(2, "Dune II");
        testCarton.addBook(book4);

        System.out.println(testCarton.toString());
        
        testCarton.addBook(new Book(5, "Encyclopédie Universalis 2014"));
        testCarton.removeBook(book3);
        testCarton.removeBook(book4);
        testCarton.addBook(new Book(5, "Encyclopédie Universalis 2014"));

        System.out.println(testCarton.toString());

        testCarton.printAllBooks();
    }
}
