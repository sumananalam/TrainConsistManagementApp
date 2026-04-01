import java.util.ArrayList;
import java.util.Comparator;
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

public class TrainConsistManagementUC7 {
    public static void main(String[] args) {
        // Create a List to store passenger bogies
        List<Bogie> bogies = new ArrayList<>();

        // Add bogies
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 20));

        // Sort the list using Comparator based on capacity
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        // Display the sorted bogies
        System.out.println("Sorted Bogies by Capacity:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }
    }
}