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
        assertEquals("The Carton has 0 objects and the height used is 0", clothCarton.toString());
        
        bookCarton.addObject(new Book("The 3 body problem", 30));
        clothCarton.addObject(new Cloth("T shirt", 20));
        assertEquals("The Carton has 1 objects and the height used is 30", bookCarton.toString());
        assertEquals("The Carton has 1 objects and the height used is 20", clothCarton.toString());
    }

    @Test
    public void testAddBallToBookCartons() {
        // Given: en sachant que tel chose existe
        // When : Si je fait telle action
        // Then: alors il se passe ça (assert)
        
        
        Carton carton = new Carton(100, TypeOfCarton.Book);
        Book book1 = new Book("Book1", 20);
        Ball ball = new Ball("Basketball", 30);
        carton.addObject(book1);
        assertEquals(20, carton.getUsedCartonHeight());
        assertEquals(1, carton.getNumberOfObjectsInList());
        assertEquals("Can't add the class Ball to a carton of type Book", carton.addObject(ball));
    }
    
    @Test
    public void testAddCartonToBallCarton() {
        // Given
        Carton ballCarton = new Carton(100, TypeOfCarton.Ball);
        assertEquals(0, ballCarton.getNumberOfObjectsInList());
        // when
        ballCarton.addObject(new Carton(20, TypeOfCarton.Carton));
        // Then
        assertEquals(1, ballCarton.getNumberOfObjectsInList());
    }
    
    @Test
    public void testCanNotAddBallAfterAddingCarton() {
        Carton ballCarton = new Carton(100, TypeOfCarton.Ball);
        assertEquals(0, ballCarton.getNumberOfObjectsInList());
        ballCarton.addObject(new Carton(20, TypeOfCarton.Carton));
        assertEquals(1, ballCarton.getNumberOfObjectsInList());
        // adding this shouldn't work thus the object has been refused and the list should stay the same size
        ballCarton.addObject(new Ball("BasketBall", 5));
        assertEquals(1, ballCarton.getNumberOfObjectsInList());
    }
    
    @Test
    public void testTheTotalNumberOfItemsInCartonAndifFoundSubCarton () {
        Carton ballCarton = new Carton(100, TypeOfCarton.Ball);
        ballCarton.addObject(new Ball("FootBall", 5));
        ballCarton.addObject(new Ball("HandBall", 10));
        Carton bookCarton = new Carton(200, TypeOfCarton.Book);
        bookCarton.addObject(new Book("Song of ice and Fire", 20));
        assertEquals(2, ballCarton.getNumberOfObjectsInList());
        assertEquals(1, bookCarton.getNumberOfObjectsInList());
        //check if the type of book carton still the same
        assertEquals(TypeOfCarton.Book, bookCarton.getCartonType());
        bookCarton.addObject(ballCarton);
        assertEquals(TypeOfCarton.Carton, bookCarton.getCartonType());
        assertEquals(4, bookCarton.getNumberOfObjectsInList());
    }
   
}