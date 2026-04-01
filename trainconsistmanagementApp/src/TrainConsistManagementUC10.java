import java.util.ArrayList;
import java.util.List;

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

public class TrainConsistManagementUC10 {
    public static void main(String[] args) {
        // Create a list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 20));

        // Calculate total seating capacity using stream reduce
        int totalCapacity = bogies.stream()
            .mapToInt(Bogie::getCapacity)
            .sum();

        // Display the total seating capacity
        System.out.println("Total Seating Capacity: " + totalCapacity);
    }
}