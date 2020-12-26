package day25;

class ComboBreaker {
    public static final int HANDSHAKE_SUBJECT_NUMBER = 7;
    public static final int TRANSFORMATION_DIVIDER = 20201227;
    private final long doorPublicKey;
    private final long cardPublicKey;

    private ComboBreaker(long doorPublicKey, long cardPublicKey) {
        this.doorPublicKey = doorPublicKey;
        this.cardPublicKey = cardPublicKey;
    }

    static ComboBreaker from(String input) {
        String[] lines = input.split("\n");
        long doorPublicKey = Long.parseLong(lines[0]);
        long cardPublicKey = Long.parseLong(lines[1]);

        return new ComboBreaker(doorPublicKey, cardPublicKey);
    }

    long partOne() {
        long cardLoopSize = calculateLoopSize(cardPublicKey);

        return transform(doorPublicKey, cardLoopSize);
    }

    long calculateLoopSize(long publicKey) {
        long loopSize = 0;
        long currentValue = 1;

        while (currentValue != publicKey) {
            currentValue *= HANDSHAKE_SUBJECT_NUMBER;
            currentValue %= TRANSFORMATION_DIVIDER;
            loopSize++;
        }

        return loopSize;
    }

    private long transform(long subjectNumber, long loopSize) {
        long result = 1;

        for (long loop = 0; loop < loopSize; loop++) {
            result *= subjectNumber;
            result %= TRANSFORMATION_DIVIDER;
        }

        return result;
    }
}
