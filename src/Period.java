import java.time.LocalDate;

public class Period {
    private LocalDate startDate;
    private LocalDate endDate;

    public Period(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    int getOverlappingDayCount(Period another) {
        LocalDate startOfOverlapping = startDate.isAfter(another.startDate) ? startDate : another.startDate;
        LocalDate endOfOverlapping = endDate.isBefore(another.endDate) ? endDate : another.endDate;
        return startOfOverlapping.until(endOfOverlapping).getDays() + 1;
    }
}
