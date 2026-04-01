import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.stream.Collectors;
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

public class TrainConsistManagementUC13Test {

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 20));

        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie.getCapacity() > 60) {
                loopFiltered.add(bogie);
            }
        }

        assertEquals(1, loopFiltered.size());
        assertEquals("Sleeper", loopFiltered.get(0).getName());
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 20));

        List<Bogie> streamFiltered = bogies.stream()
            .filter(b -> b.getCapacity() > 60)
            .collect(Collectors.toList());

        assertEquals(1, streamFiltered.size());
        assertEquals("Sleeper", streamFiltered.get(0).getName());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 20));

        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie.getCapacity() > 60) {
                loopFiltered.add(bogie);
            }
        }

        List<Bogie> streamFiltered = bogies.stream()
            .filter(b -> b.getCapacity() > 60)
            .collect(Collectors.toList());

        assertEquals(loopFiltered.size(), streamFiltered.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));

        long startTime = System.nanoTime();
        List<Bogie> filtered = bogies.stream()
            .filter(b -> b.getCapacity() > 60)
            .collect(Collectors.toList());
        long endTime = System.nanoTime();

        long elapsed = endTime - startTime;
        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 60));
        }

        List<Bogie> streamFiltered = bogies.stream()
            .filter(b -> b.getCapacity() > 60)
            .collect(Collectors.toList());

        assertEquals(1000, streamFiltered.size());
    }
}