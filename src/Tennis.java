public class Tennis {
    public static final String SPACE = " ";
    private static final String[] SCORE_WORDS = {"Love", "Fifteen", "Thirty", "Forty"};
    public static final String DRAW = "All";
    public static final String DEUCE = "Deuce";
    public static final String ADVANTAGE = "Adv";
    public static final String WIN = "Win";
    private final String nameOfPlayer1;
    private final String nameOfPlayer2;
    private int scoreOfPlayer1 = 0;
    private int scoreOfPlayer2 = 0;

    public Tennis(String nameOfPlayer1, String nameOfPlayer2) {
        this.nameOfPlayer1 = nameOfPlayer1;
        this.nameOfPlayer2 = nameOfPlayer2;
    }

    public String getScore() {
        if (scoreOfPlayer1 > 3 && scoreOfPlayer1 > scoreOfPlayer2 + 1){
            return playerWin(nameOfPlayer1);
        }
        if (scoreOfPlayer2 > 3 && scoreOfPlayer2 > scoreOfPlayer1 + 1){
            return playerWin(nameOfPlayer2);
        }

        if (inDeuce()){
            if (scoreOfPlayer1 > scoreOfPlayer2) {
                return advantageScore(nameOfPlayer1);
            }
            if (scoreOfPlayer2 > scoreOfPlayer1) {
                return advantageScore(nameOfPlayer2);
            }
        }

        if (isDraw()) {
            return drawScore();
        }

        return normalScore();
    }

    private boolean inDeuce() {
        return scoreOfPlayer1 >= 3 && scoreOfPlayer2 >= 3;
    }

    private String playerWin(String player) {
        return player + SPACE + WIN;
    }

    private String normalScore() {
        return SCORE_WORDS[scoreOfPlayer1] + SPACE + SCORE_WORDS[scoreOfPlayer2];
    }

    private String advantageScore(String player) {
        return player + SPACE + ADVANTAGE;
    }

    private String drawScore() {
        if (inDeuce()){
            return DEUCE;
        }
        return SCORE_WORDS[scoreOfPlayer1] + SPACE + DRAW;
    }

    private boolean isDraw() {
        return scoreOfPlayer1 == scoreOfPlayer2;
    }

    public void player1Scores() {
        scoreOfPlayer1++;
    }

    public void player2Scores() {
        scoreOfPlayer2++;
    }
}
