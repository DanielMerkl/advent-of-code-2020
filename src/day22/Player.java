package day22;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

class Player {
    private final Deque<Integer> deck;

    private Player(Deque<Integer> deck) {
        this.deck = deck;
    }

    static Player from(String input) {
        Deque<Integer> cards = new ArrayDeque<>();
        input.lines()
                .filter(line -> !line.startsWith("Player"))
                .map(Integer::parseInt)
                .forEach(cards::add);

        return new Player(cards);
    }

    int drawCard() {
        if (deck.isEmpty()) {
            throw new RuntimeException("Can't draw any more cards!");
        }

        return deck.poll();
    }

    void takeCard(int card) {
        deck.add(card);
    }

    boolean hasCardsRemaining() {
        return !deck.isEmpty();
    }

    long calculateScore() {
        long score = 0;

        for (int multiplier = deck.size(); multiplier >= 1; multiplier--) {
            score += (long) drawCard() * multiplier;
        }

        return score;
    }

    public Deque<Integer> getDeck() {
        return deck;
    }
}
