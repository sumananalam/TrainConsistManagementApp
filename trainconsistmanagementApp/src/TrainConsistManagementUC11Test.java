import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.junit.jupiter.api.Test;

public class TrainConsistManagementUC11Test {

    private final Pattern trainIdPattern = Pattern.compile("TRN-\\d{4}");
    private final Pattern cargoCodePattern = Pattern.compile("PET-[A-Z]{2}");

    @Test
    void testRegex_ValidTrainID() {
        Matcher matcher = trainIdPattern.matcher("TRN-1234");
        assertTrue(matcher.matches());
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(trainIdPattern.matcher("TRAIN12").matches());
        assertFalse(trainIdPattern.matcher("TRN12A").matches());
        assertFalse(trainIdPattern.matcher("1234-TRN").matches());
    }

    @Test
    void testRegex_ValidCargoCode() {
        Matcher matcher = cargoCodePattern.matcher("PET-AB");
        assertTrue(matcher.matches());
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(cargoCodePattern.matcher("PET-ab").matches());
        assertFalse(cargoCodePattern.matcher("PET123").matches());
        assertFalse(cargoCodePattern.matcher("AB-PET").matches());
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(trainIdPattern.matcher("TRN-123").matches());
        assertFalse(trainIdPattern.matcher("TRN-12345").matches());
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(cargoCodePattern.matcher("PET-ab").matches());
        assertTrue(cargoCodePattern.matcher("PET-AB").matches());
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(trainIdPattern.matcher("").matches());
        assertFalse(cargoCodePattern.matcher("").matches());
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(trainIdPattern.matcher("TRN-1234extra").matches());
        assertFalse(cargoCodePattern.matcher("PET-ABextra").matches());
    }
}