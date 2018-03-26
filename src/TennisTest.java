import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TennisTest {
    Tennis game = new Tennis("Jackson", "Joseph");

    private void player1Scores(int times) {
        for(int i = 0; i < times; i++)
            game.player1Scores();
    }

    private void player2Scores(int times) {
        for(int i = 0; i < times; i++)
            game.player2Scores();
    }

    @Test
    public void love_all(){
        assertEquals("Love All", game.getScore());
    }

    @Test
    public void fifteen_love() throws Exception {
        player1Scores(1);
        assertEquals("Fifteen Love", game.getScore());
    }

    @Test
    public void thirty_love() throws Exception {
        player1Scores(2);
        assertEquals("Thirty Love", game.getScore());
    }

    @Test
    public void forty_love() throws Exception {
        player1Scores(3);
        assertEquals("Forty Love", game.getScore());
    }

    @Test
    public void love_fifteen() throws Exception {
        game.player2Scores();
        assertEquals("Love Fifteen", game.getScore());
    }

    @Test
    public void fifteen_all() throws Exception {
        player1Scores(1);
        player2Scores(1);
        assertEquals("Fifteen All", game.getScore());
    }

    @Test
    public void deuce() throws Exception {
        player1Scores(3);
        player2Scores(3);
        assertEquals("Deuce", game.getScore());
    }

    @Test
    public void deuce_again() throws Exception {
        player1Scores(3);
        player2Scores(3);
        player1Scores(1);
        player2Scores(1);
        assertEquals("Deuce", game.getScore());
    }

    @Test
    public void player1_adv() throws Exception {
        player1Scores(3);
        player2Scores(3);
        player1Scores(1);
        assertEquals("Jackson Adv", game.getScore());
    }

    @Test
    public void player2_adv() throws Exception {
        player1Scores(3);
        player2Scores(3);
        player2Scores(1);
        assertEquals("Joseph Adv", game.getScore());
    }

    @Test
    public void player1_win() throws Exception {
        player1Scores(4);
        assertEquals("Jackson Win", game.getScore());
    }

    @Test
    public void player2_win() throws Exception {
        player2Scores(4);
        assertEquals("Joseph Win", game.getScore());
    }

    @Test
    public void player1_win_after_adv() throws Exception {
        player1Scores(3);
        player2Scores(3);
        player1Scores(1);
        player1Scores(1);
        assertEquals("Jackson Win", game.getScore());
    }

    @Test
    public void player2_win_after_adv() throws Exception {
        player1Scores(3);
        player2Scores(3);
        player2Scores(1);
        player2Scores(1);
        assertEquals("Joseph Win", game.getScore());
    }
}
