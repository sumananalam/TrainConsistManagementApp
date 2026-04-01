import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
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

public class TrainConsistManagementUC10Test {

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 20));

        int total = bogies.stream()
            .mapToInt(Bogie::getCapacity)
            .sum();

        assertEquals(224, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));

        int total = bogies.stream()
            .mapToInt(Bogie::getCapacity)
            .sum();

        assertEquals(132, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));

        int total = bogies.stream()
            .mapToInt(Bogie::getCapacity)
            .sum();

        assertEquals(72, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int total = bogies.stream()
            .mapToInt(Bogie::getCapacity)
            .sum();

        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        Bogie bogie = new Bogie("Sleeper", 72);

        int capacity = bogie.getCapacity();

        assertEquals(72, capacity);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 10));
        bogies.add(new Bogie("AC Chair", 20));

        int total = bogies.stream()
            .mapToInt(Bogie::getCapacity)
            .sum();

        assertEquals(30, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));

        List<Bogie> original = new ArrayList<>(bogies);

        int total = bogies.stream()
            .mapToInt(Bogie::getCapacity)
            .sum();

        assertEquals(original, bogies);
    }
}