import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartonTest {

    @Test
    public void testCartonConstructorAndGetters() {
        Carton carton = new Carton(100, TypeOfCarton.Book);
        assertEquals(0, carton.getUsedCartonHeight());
        assertEquals(0, carton.getNumberOfObjectsInList());
    }
    
    @Test
    public void testCreateCartonsWithDiffrentTypes() {
        Carton bookCarton = new Carton(100, TypeOfCarton.Book);
        Carton clothCarton = new Carton(100, TypeOfCarton.Cloth);
        
        assertEquals("The Carton has 0 objects and the height used is 0", bookCarton.toString());
        assertEquals("The Carton has 0 objects and the height used is 0", bookCarton.toString());
        
        bookCarton.addObject(new Book("The 3 body problem", 30));
        clothCarton.addObject(new Cloth("T shirt", 20));
        assertEquals("The Carton has 1 objects and the height used is 30", bookCarton.toString());
        assertEquals("The Carton has 1 objects and the height used is 20", clothCarton.toString());
    }

    @Test
    public void testAddBallToBookCarton() {
        Carton carton = new Carton(100, TypeOfCarton.Book);
        Book book1 = new Book("Book1", 20);
        Ball ball = new Ball("Basketball", 30);
        carton.addObject(book1);
        assertEquals(20, carton.getUsedCartonHeight());
        assertEquals(1, carton.getNumberOfObjectsInList());
        assertEquals("Can't add the class Ball to a carton of type Book", carton.addObject(ball));
    }
    
}