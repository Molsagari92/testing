import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class URLPartsTest {

    private static Calculator calculator;

    @BeforeAll
    public static void init(){
        calculator=new Calculator();
    }

    @Test
    void addPositiveNumbers(){ //nem kell a public,mert ezeket nem hívjuk meg máshol
        Assertions.assertEquals(3,calculator.add(1, 2)); //egyenlő
        Assertions.assertNotEquals(2,calculator.add(1, 2)); //nem egyenlő
    }

    @Test
    void addNegativeNumbers(){
        Assertions.assertEquals(-1, calculator.add(0,-1));
    }

    @Test
    void addStrings(){
        Assertions.assertEquals("ab", calculator.addString("a", "b"));
        Assertions.assertEquals("áé", calculator.addString("á", "é"));
        Assertions.assertEquals("&@", calculator.addString("&", "@"));
        Assertions.assertEquals("", calculator.addString("", ""));
        Assertions.assertEquals("\n\n", calculator.addString("\n", "\n"));
        Assertions.assertNotEquals("12", calculator.addString("1", "2"), "Failed to add numbers.");
    }

}
