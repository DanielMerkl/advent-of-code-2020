package day22;

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
        while (!gameFinished()) {
            playRound();
        }

        Player winner = player1.hasCardsRemaining() ? player1 : player2;

        return winner.calculateScore();
    }

    boolean gameFinished() {
        return !player1.hasCardsRemaining() || !player2.hasCardsRemaining();
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

    public long partTwo() {
        return 0;
    }
}
