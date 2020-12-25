package day22;

import java.util.*;

class CrabCombat {
    private final Player player1;
    private final Player player2;

    private CrabCombat(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    static CrabCombat from(String input) {
        String[] split = input.split("\n\n");

        Player player1 = Player.from(split[0]);
        Player player2 = Player.from(split[1]);

        return new CrabCombat(player1, player2);
    }

    long partOne() {
        while (bothPlayersHaveCardsRemaining()) {
            playRound();
        }

        Player winner = player1.hasCardsRemaining() ? player1 : player2;

        return winner.calculateScore();
    }

    boolean bothPlayersHaveCardsRemaining() {
        return player1.hasCardsRemaining() && player2.hasCardsRemaining();
    }

    void playRound() {
        int card1 = player1.drawCard();
        int card2 = player2.drawCard();

        boolean playerOneWins = card1 > card2;

        if (playerOneWins) {
            player1.takeCard(card1);
            player1.takeCard(card2);
        } else {
            player2.takeCard(card2);
            player2.takeCard(card1);
        }
    }

    long partTwo() {
        Deque<Integer> deck1 = player1.getDeck();
        Deque<Integer> deck2 = player2.getDeck();

        final Deque<Integer> winner = new ArrayDeque<>();

        calculateWinner(deck1, deck2, winner, deck1.size(), deck2.size());

        return calculateScore(winner);
    }

    private Deque<Integer> calculateWinner(Deque<Integer> d1, Deque<Integer> d2, Deque<Integer> winner, int size1,
                                           int size2) {
        final Deque<Integer> deck1 = new ArrayDeque<>(d1);
        final Deque<Integer> deck2 = new ArrayDeque<>(d2);

        while (deck1.size() > size1) {
            deck1.removeLast();
        }

        while (deck2.size() > size2) {
            deck2.removeLast();
        }

        final Set<String> previousStates = new HashSet<>();
        while (!deck1.isEmpty() && !deck2.isEmpty()) {
            String currentState = "%s|%s".formatted(deck1, deck2);
            if (previousStates.contains(currentState)) {
                return d1;
            }
            previousStates.add(currentState);

            int card1 = deck1.removeFirst();
            int card2 = deck2.removeFirst();

            if (deck1.size() >= card1 && deck2.size() >= card2) {
                Deque<Integer> recursivelyWinningDeck = calculateWinner(deck1, deck2, null, card1, card2);
                if (recursivelyWinningDeck.equals(deck1)) {
                    deck1.addLast(card1);
                    deck1.addLast(card2);
                } else {
                    deck2.addLast(card2);
                    deck2.addLast(card1);
                }
            } else {
                if (card1 > card2) {
                    deck1.addLast(card1);
                    deck1.addLast(card2);
                } else {
                    deck2.addLast(card2);
                    deck2.addLast(card1);
                }
            }
        }

        if (winner != null) {
            winner.addAll(deck2.isEmpty() ? deck1 : deck2);
        }

        return deck2.isEmpty() ? d1 : d2;
    }

    long calculateScore(Deque<Integer> cards) {
        long score = 0;

        for (long multiplier = cards.size(); multiplier >= 1; multiplier--) {
            score += cards.removeFirst() * multiplier;
        }

        return score;
    }
}
