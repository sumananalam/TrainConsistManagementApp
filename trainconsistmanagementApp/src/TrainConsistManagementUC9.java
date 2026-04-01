import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

public class TrainConsistManagementUC9 {
    public static void main(String[] args) {
        // Create a list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Sleeper", 72)); // Adding another Sleeper for grouping
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 20));

        // Group bogies by type using Collectors.groupingBy
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
            .collect(Collectors.groupingBy(Bogie::getName));

        // Display the grouped result
        System.out.println("Grouped Bogies by Type:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}