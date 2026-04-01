import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class PassengerBogie {
    private String name;
    private int capacity;

    public PassengerBogie(String name, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class TrainConsistManagementUC14Test {

    @Test
    void testException_ValidCapacityCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("Sleeper", 72);
        assertEquals("Sleeper", bogie.getName());
        assertEquals(72, bogie.getCapacity());
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        InvalidCapacityException exception = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("Negative", -10);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        InvalidCapacityException exception = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("Zero", 0);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ExceptionMessageValidation() {
        InvalidCapacityException exception = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("Invalid", -1);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("AC Chair", 60);
        assertEquals("AC Chair", bogie.getName());
        assertEquals(60, bogie.getCapacity());
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws InvalidCapacityException {
        PassengerBogie bogie1 = new PassengerBogie("Sleeper", 72);
        PassengerBogie bogie2 = new PassengerBogie("First Class", 20);
        assertEquals("Sleeper", bogie1.getName());
        assertEquals(20, bogie2.getCapacity());
    }
}