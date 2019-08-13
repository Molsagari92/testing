import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DartsTest {

    private Darts d;

    @BeforeEach
    public void setUpGame() {
        d = new Darts();
    }

    @Test
    public void aGameshouldStartAt301() {
        Assertions.assertEquals(301, d.getScore(), "The game should start at 301 points.");
        Assertions.assertFalse(d.isFinished());
    }

    @Test
    public void shouldCorrectlyCalculateNormalThrow() {
        d.dart(20);
        Assertions.assertEquals(281, d.getScore());
    }

    @Test
    public void shouldCorrectlyCalculateDoubleThrow() {
       d.dart(20, "DOUBLE");
        Assertions.assertEquals(261, d.getScore());

    }

    @Test
    public void shouldCorrectlyCalculateTripleThrow() {
        d.dart(20, "TRIPLE");
        Assertions.assertEquals(241, d.getScore());
    }

    @Test
    public void shouldCountFirstTurns() {
        Assertions.assertEquals(3, d.getDartsLeft());
        Assertions.assertEquals(1, d.getTurn());
    }

    @Test
    public void shouldCountTheTurn() {
        Assertions.assertEquals(1, d.getTurn());
        d.getDartsLeft();
        assertEquals(1, d.getTurn());
        d.getDartsLeft();
        assertEquals(1, d.getTurn());
        d.getDartsLeft();
        Assertions.assertEquals(2, d.getTurn());
    }

    @Test
    public void shouldStartWithDouble() {

    }

    @Test
    public void shouldFinishWithDouble() {
    }

    /*
    Házi: írjatok programot ami kielégíti a teszteket, illetve fejezzétek be az utolsó 3 tesztet!
    Ne írjatok olyan programot, ami egyenlőre nem szükséges!!
     */

    /*
    - getScore()
    - dart(int score)
    - dart (int score, multiplier)
    - private calculatePoints() - ezt nem hívjuk meg a tesztek alkalmával
    - getDartsLeft() ->int
    - getTurn() ->int
    - isFinished()
     */

    /*
    - 301 ponttal indul a játék
    - 3 dobás van körönként
    - duplával kell kezdeni
    - duplával kell kiszállni
    - 0-nak kell lenni a végén
    - ha az utolsó kör eredménye 0, de nem duplázott a játékos, az előző kör eredménye érvényes
    - ha az utolsó kör eredménye 0, akkor az előző kör eredménye érvényes
    -ha az utolsó kör ereménye negatív, akkor az előző kör eredménye érvényes
    -lehet duplát dobni
    -lehet triplát dobni
     */
}
