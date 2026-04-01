class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class PassengerBogie {
    private String name;
    private int capacity;

    public PassengerBogie(String name, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
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

public class TrainConsistManagementUC14 {
    public static void main(String[] args) {
        try {
            // Valid bogie
            PassengerBogie sleeper = new PassengerBogie("Sleeper", 72);
            System.out.println("Created: " + sleeper);

            // Invalid bogie - zero capacity
            PassengerBogie invalid = new PassengerBogie("Invalid", 0);
        } catch (InvalidCapacityException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        try {
            // Invalid bogie - negative capacity
            PassengerBogie negative = new PassengerBogie("Negative", -10);
        } catch (InvalidCapacityException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}