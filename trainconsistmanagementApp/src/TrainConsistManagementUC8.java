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

public class TrainConsistManagementUC8 {
    public static void main(String[] args) {
        // Create a list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 20));

        // Filter bogies with capacity > 60 using streams
        List<Bogie> filteredBogies = bogies.stream()
            .filter(b -> b.getCapacity() > 60)
            .collect(Collectors.toList());

        // Display the filtered bogies
        System.out.println("Filtered Bogies (Capacity > 60):");
        for (Bogie bogie : filteredBogies) {
            System.out.println(bogie);
        }
    }
}