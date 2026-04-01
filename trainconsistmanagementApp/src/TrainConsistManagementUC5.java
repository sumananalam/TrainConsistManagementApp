import java.util.LinkedHashSet;

public class TrainConsistManagementUC5 {
    public static void main(String[] args) {
        // Create a LinkedHashSet to represent the train formation
        LinkedHashSet<String> formation = new LinkedHashSet<>();

        // Attach bogies
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // Attempt to attach a duplicate bogie
        formation.add("Sleeper");

        // Display the final formation order
        System.out.println("Train Formation: " + formation);
    }
}