import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TrainConsistManagementUC11 {
    public static void main(String[] args) {
        // Define regex patterns
        String trainIdPattern = "TRN-\\d{4}";
        String cargoCodePattern = "PET-[A-Z]{2}";

        // Compile patterns
        Pattern trainIdCompiled = Pattern.compile(trainIdPattern);
        Pattern cargoCodeCompiled = Pattern.compile(cargoCodePattern);

        // Example inputs
        String[] trainIds = {"TRN-1234", "TRAIN12", "TRN12A", "1234-TRN"};
        String[] cargoCodes = {"PET-AB", "PET-ab", "PET123", "AB-PET"};

        // Validate Train IDs
        System.out.println("Train ID Validation:");
        for (String id : trainIds) {
            Matcher matcher = trainIdCompiled.matcher(id);
            System.out.println(id + ": " + (matcher.matches() ? "Valid" : "Invalid"));
        }

        // Validate Cargo Codes
        System.out.println("\nCargo Code Validation:");
        for (String code : cargoCodes) {
            Matcher matcher = cargoCodeCompiled.matcher(code);
            System.out.println(code + ": " + (matcher.matches() ? "Valid" : "Invalid"));
        }
    }
}