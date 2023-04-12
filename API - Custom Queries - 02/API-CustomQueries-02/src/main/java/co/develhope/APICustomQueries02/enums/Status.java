package co.develhope.APICustomQueries02.enums;

import java.util.Random;

/**
 * Enum uguale all'esercizio precedente
 */
public enum Status {

    ONTIME,
    DELAYED,
    CANCELLED;

    private static final Random PRNG = new Random();

    public static Status randomStatus() {
        Status[] status = values();
        return status[PRNG.nextInt(status.length)];
    }
}
