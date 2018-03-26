public class Range {
    private final int min;
    private final boolean leftClosed;
    private final int max;
    private final boolean rightClosed;

    public Range(int min, boolean leftClosed, int max, boolean rightClosed) {
        this.min = min;
        this.leftClosed = leftClosed;
        this.max = max;
        this.rightClosed = rightClosed;
    }

    public boolean contains(int number) {
        if (leftClosed && number == min)
            return true;
        if (rightClosed && number == max)
            return true;
        return number > min && number < max;
    }
}
