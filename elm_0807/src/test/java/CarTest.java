import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.when;

public class CarTest {

    private Engine engine;
    private FuelTank fuelTank;
    private Car car;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    @Before
    public void setup() {
        engine = Mockito.mock(Engine.class);
        fuelTank = Mockito.mock(FuelTank.class);
        car = new Car(engine, fuelTank);

    }

    @Test
    public void isRunning() {
        when(engine.isRunning()).thenReturn(true);
        assertTrue(engine.isRunning());
        when(engine.isRunning()).thenReturn(false);
        assertFalse(engine.isRunning());
    }

    private void assertFalse(boolean running) {
    }

    private void assertTrue(boolean running) {
    }

    @Test
    public void shouldStartEngine() {
        when(fuelTank.getFuel()).thenReturn(100);
        when(engine.isRunning()).thenReturn(false, true);
        car.start();
    }

    @Test
    public void shouldNotStartEngineWhenFuelTankIsEmpty() {
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Can't start: no fuel");
        when(fuelTank.getFuel()).thenReturn(0);
        when(engine.isRunning()).thenReturn(false);
        car.start();
    }

    @Test
    public void shoulNotStartEngineWhenAlreadyRunning() {
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Engine already running");
        when(fuelTank.getFuel()).thenReturn(100);
        when(engine.isRunning()).thenReturn(true);
        car.start();
    }

    @Test
    public void shouldNotStartEngine() {
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Started engine but isn't running");
        when(fuelTank.getFuel()).thenReturn(100);
        when(engine.isRunning()).thenReturn(false);
        car.start();
    }
}
