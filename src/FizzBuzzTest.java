import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    @Test
    public void normal_number_outputs_itself(){
        FizzBuzz game = new FizzBuzz();
        assertEquals("1", game.say(1));
        assertEquals("2", game.say(2));
    }

    @Test
    public void multiples_of_3_outputs_fizz() throws Exception {
        FizzBuzz game = new FizzBuzz();
        assertEquals("Fizz", game.say(3));
        assertEquals("Fizz", game.say(6));
    }

    @Test
    public void multiples_of_5_outputs_buzz() throws Exception {
        FizzBuzz game = new FizzBuzz();
        assertEquals("Buzz", game.say(5));
        assertEquals("Buzz", game.say(10));
    }

    @Test
    public void multiples_of_15_outputs_fizzbuzz() throws Exception {
        FizzBuzz game = new FizzBuzz();
        assertEquals("FizzBuzz", game.say(15));
        assertEquals("FizzBuzz", game.say(30));
    }
}
