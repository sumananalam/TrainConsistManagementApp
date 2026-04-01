import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

public class TrainConsistManagementUC13 {
    public static void main(String[] args) {
        // Create a large list of bogies for testing
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 60));
            bogies.add(new Bogie("First Class", 20));
        }

        // Loop-based filtering
        long startTime = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie.getCapacity() > 60) {
                loopFiltered.add(bogie);
            }
        }
        long endTime = System.nanoTime();
        long loopTime = endTime - startTime;

        // Stream-based filtering
        startTime = System.nanoTime();
        List<Bogie> streamFiltered = bogies.stream()
            .filter(b -> b.getCapacity() > 60)
            .collect(Collectors.toList());
        endTime = System.nanoTime();
        long streamTime = endTime - startTime;

        // Display results
        System.out.println("Loop-based filtering time: " + loopTime + " ns");
        System.out.println("Stream-based filtering time: " + streamTime + " ns");
        System.out.println("Results match: " + loopFiltered.size() + " == " + streamFiltered.size());
    }
}