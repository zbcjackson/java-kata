import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RangeTest {

    public static final boolean CLOSE = true;
    public static final boolean OPEN = false;

    @Test
    public void left_closed_contains_min(){
        Range range = new Range(3, CLOSE,5, OPEN);
        assertTrue(range.contains(3));
    }

    @Test
    public void left_open_not_contains_min() throws Exception {
        Range range = new Range(3, OPEN,5, OPEN);
        assertFalse(range.contains(3));
    }

    @Test
    public void smaller_than_min_is_not_contained() throws Exception {
        Range range = new Range(3, CLOSE,5, OPEN);
        assertFalse(range.contains(2));
    }

    @Test
    public void bigger_than_min_smaller_than_max_is_contained() throws Exception {
        Range range = new Range(3, OPEN,5, OPEN);
        assertTrue(range.contains(4));
    }

    @Test
    public void bigger_than_max_is_not_contained() throws Exception {
        Range range = new Range(3, CLOSE,5, OPEN);
        assertFalse(range.contains(6));
    }

    @Test
    public void right_closed_contains_max() throws Exception {
        Range range = new Range(3, CLOSE,5, CLOSE);
        assertTrue(range.contains(5));
    }

    @Test
    public void right_open_not_contains_max() throws Exception {
        Range range = new Range(3, CLOSE,5, OPEN);
        assertFalse(range.contains(5));
    }
}
