package au.com.ioof.elmostreet;

public final class Simulation {

    private Simulation() {
    }

    public static void main(final String[] args) {

        if (args.length != 1) {
            throw new RuntimeException("Invalid scenario");
        }

        System.out.println("Hello");

    }

}
