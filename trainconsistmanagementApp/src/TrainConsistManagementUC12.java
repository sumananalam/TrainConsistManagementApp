import java.util.ArrayList;
import java.util.List;

class GoodsBogie {
    private String type;
    private String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return type + " bogie carrying " + cargo;
    }
}

public class TrainConsistManagementUC12 {
    public static void main(String[] args) {
        // Create a list of goods bogies
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Cylindrical", "Coal"));
        bogies.add(new GoodsBogie("Open", "Coal"));

        // Check safety compliance using streams
        boolean isSafe = bogies.stream()
            .allMatch(b -> {
                if ("Cylindrical".equals(b.getType())) {
                    return "Petroleum".equals(b.getCargo());
                }
                return true; // Other types are allowed any cargo
            });

        // Display the result
        System.out.println("Train Safety Compliance: " + (isSafe ? "Safe" : "Unsafe"));
    }
}