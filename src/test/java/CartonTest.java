import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartonTest {

    @Test
    public void testCartonConstructorAndGetters() {
        Carton carton = new Carton(100);
        assertEquals(100, carton.getCartonHight());
        assertEquals(0, carton.getNombreOfBooksInList());
    }

    @Test
    public void testAddBook() {
        Carton carton = new Carton(100);
        Book book1 = new Book(20, "Book1");
        Book book2 = new Book(30, "Book2");
        carton.addBook(book1);
        assertEquals(80, carton.getCartonHight());
        assertEquals(1, carton.getNombreOfBooksInList());
        carton.addBook(book2);
        assertEquals(50, carton.getCartonHight());
        assertEquals(2, carton.getNombreOfBooksInList());
    }

    @Test
    public void testAddBookWhenNoSpace() {
        Carton carton = new Carton(50);
        Book book1 = new Book(20, "Book1");
        Book book2 = new Book(30, "Book2");
        carton.addBook(book1);
        assertEquals(30, carton.getCartonHight());
        assertEquals(1, carton.getNombreOfBooksInList());
        carton.addBook(book2);
        assertEquals(0, carton.getCartonHight());
        assertEquals(2, carton.getNombreOfBooksInList());
    }

    @Test
    public void testRemoveBook() {
        Carton carton = new Carton(100);
        Book book1 = new Book(20, "Book1");
        Book book2 = new Book(30, "Book2");
        carton.addBook(book1);
        carton.addBook(book2);
        assertEquals(50, carton.getCartonHight());
        assertEquals(2, carton.getNombreOfBooksInList());
        carton.removeBook(book1);
        assertEquals(70, carton.getCartonHight());
        assertEquals(1, carton.getNombreOfBooksInList());
    }

    @Test
    public void testToString() {
        Carton carton = new Carton(100);
        Book book1 = new Book(20, "Book1");
        Book book2 = new Book(30, "Book2");
        carton.addBook(book1);
        carton.addBook(book2);
        assertEquals("The Carton has 2 books and the hight used is 50", carton.toString());
    }
}