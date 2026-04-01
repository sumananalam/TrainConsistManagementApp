import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;

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

public class TrainConsistManagementUC12Test {

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));

        boolean isSafe = bogies.stream()
            .allMatch(b -> {
                if ("Cylindrical".equals(b.getType())) {
                    return "Petroleum".equals(b.getCargo());
                }
                return true;
            });

        assertTrue(isSafe);
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Coal"));

        boolean isSafe = bogies.stream()
            .allMatch(b -> {
                if ("Cylindrical".equals(b.getType())) {
                    return "Petroleum".equals(b.getCargo());
                }
                return true;
            });

        assertFalse(isSafe);
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));

        boolean isSafe = bogies.stream()
            .allMatch(b -> {
                if ("Cylindrical".equals(b.getType())) {
                    return "Petroleum".equals(b.getCargo());
                }
                return true;
            });

        assertTrue(isSafe);
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Cylindrical", "Coal"));

        boolean isSafe = bogies.stream()
            .allMatch(b -> {
                if ("Cylindrical".equals(b.getType())) {
                    return "Petroleum".equals(b.getCargo());
                }
                return true;
            });

        assertFalse(isSafe);
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<GoodsBogie> bogies = new ArrayList<>();

        boolean isSafe = bogies.stream()
            .allMatch(b -> {
                if ("Cylindrical".equals(b.getType())) {
                    return "Petroleum".equals(b.getCargo());
                }
                return true;
            });

        assertTrue(isSafe);
    }
}