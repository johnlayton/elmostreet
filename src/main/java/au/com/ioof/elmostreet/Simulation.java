package au.com.ioof.elmostreet;

import java.util.Arrays;

public final class Simulation {

    private Simulation() {
    }

    public static void main(final String[] args) {

        if (args.length < 1) {
            throw new RuntimeException("Invalid scenario");
        }

        Arrays.stream(args).forEach(scenario -> new Robot(new Table(5, 5), System.out::println).accept(scenario));
    }

}
