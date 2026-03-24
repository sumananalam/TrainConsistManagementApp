import java.util.LinkedList;

/**
 * MAIN CLASS - UseCase4TrainConsistOrdered
 *
 * Use Case 4: Maintain Ordered Bogie IDs (LinkedList)
 *
 * Description:
 * This class demonstrates how train bogies are maintained in a specific
 * physical sequence using LinkedList.
 *
 * At this stage, the application:
 * - Maintains insertion order of bogies
 * - Supports adding bogies at specific positions
 * - Removes bogies from the head or tail
 * - Displays the final ordered train consist
 *
 * This maps ordered train formation using LinkedList.
 *
 * @author Developer
 * @version 4.0
 */
public class UseCase4TrainConsistOrdered {

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC4 - Maintain Ordered Bogie IDs ");
        System.out.println("==========================================\n");

        // Create a LinkedList to store train consist in order
        LinkedList<String> trainConsist = new LinkedList<>();

        // --- Add bogies in sequence (Locomotive → Passenger → Cargo → Guard) ---
        System.out.println("Step 1: Adding bogies in sequence...");
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist);
        System.out.println();

        // --- Insert a bogie at a specific position (Pantry Car at position 2) ---
        System.out.println("Step 2: Inserting 'Pantry Car' at position 2...");
        trainConsist.add(2, "Pantry Car");

        System.out.println("After Inserting Pantry Car:");
        System.out.println(trainConsist);
        System.out.println();

        // --- Remove the first and last bogie ---
        System.out.println("Step 3: Removing first and last bogie...");
        String removedFirst = trainConsist.removeFirst();
        String removedLast = trainConsist.removeLast();

        System.out.println("Removed First Bogie: " + removedFirst);
        System.out.println("Removed Last Bogie: " + removedLast);
        System.out.println();

        // --- Display final ordered train consist ---
        System.out.println("Final Ordered Train Consist:");
        System.out.println(trainConsist);
        System.out.println();

        System.out.println("UC4 ordered train consist operations completed successfully...");
    }
}