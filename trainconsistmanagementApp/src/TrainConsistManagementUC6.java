import java.util.HashMap;
import java.util.Map;

public class TrainConsistManagementUC6 {
    public static void main(String[] args) {
        // Create a HashMap to store bogie-capacity information
        HashMap<String, Integer> bogieCapacity = new HashMap<>();

        // Insert capacity values for bogies
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 60);
        bogieCapacity.put("First Class", 20);

        // Iterate over the map using entrySet() and display each bogie along with its capacity
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}