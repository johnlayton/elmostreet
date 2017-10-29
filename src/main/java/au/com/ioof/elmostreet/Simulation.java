package au.com.ioof.elmostreet;

import java.util.Arrays;

public final class Simulation {

    private static final int X_SIZE = 5;
    private static final int Y_SIZE = 5;

    private Simulation() {
    }

    public static void main(final String[] args) {

        if (args.length < 1) {
            throw new RuntimeException("Invalid scenario");
        }

        Arrays.stream(args).forEach(scenario -> new Robot(new Table(X_SIZE, Y_SIZE), System.out::println).accept(scenario));
    }

}
