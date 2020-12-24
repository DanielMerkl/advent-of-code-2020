package day22;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

class Player {
    private final Queue<Integer> cards;

    private Player(Queue<Integer> cards) {
        this.cards = cards;
    }

    static Player from(String input) {
        Queue<Integer> cards = new LinkedBlockingQueue<>();
        input.lines()
                .filter(line -> !line.startsWith("Player"))
                .map(Integer::parseInt)
                .forEach(cards::add);

        return new Player(cards);
    }

    int drawCard() {
        if (cards.isEmpty()) {
            throw new RuntimeException("Can't draw any more cards!");
        }

        return cards.poll();
    }

    void takeCard(int card) {
        cards.add(card);
    }

    boolean hasCardsRemaining() {
        return !cards.isEmpty();
    }

    long calculateScore() {
        long score = 0;

        for (int multiplier = cards.size(); multiplier >= 1; multiplier--) {
            score += (long) drawCard() * multiplier;
        }

        return score;
    }
}
