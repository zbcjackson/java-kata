import java.time.YearMonth;

public class Budget {
    private double amount;
    private YearMonth month;

    public Budget(String month, long amount) {
        String[] yearMonth = month.split("-");
        this.month = YearMonth.of(Integer.valueOf(yearMonth[0]), Integer.valueOf(yearMonth[1]));
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public YearMonth getMonth() {
        return month;
    }

    public Period getPeriod() {
        return new Period(month.atDay(1), month.atEndOfMonth());
    }

    int getDayCount() {
        return getMonth().lengthOfMonth();
    }
}
