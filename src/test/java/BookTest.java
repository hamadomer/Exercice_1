import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testBookConstructorAndGetters() {
        Book book = new Book(200, "Test Book");
        assertEquals("Test Book", book.getBookTitle());
        assertEquals(200, book.getBookWidth());
    }

    @Test
    public void testSetBookTitle() {
        Book book = new Book(200, "Test Book");
        book.setBookTitle("New Test Book");
        assertEquals("New Test Book", book.getBookTitle());
    }

    @Test
    public void testSetBookWidth() {
        Book book = new Book(200, "Test Book");
        book.setBookWidth(300);
        assertEquals(300, book.getBookWidth());
    }
}