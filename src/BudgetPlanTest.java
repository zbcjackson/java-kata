import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BudgetPlanTest {
    BudgetRepoStub budgetRepo = new BudgetRepoStub();
    BudgetPlan budgetPlan = new BudgetPlan(budgetRepo);

    private void givenBudgetPeriods(Budget... budgets) {
        budgetRepo.setBudgets(Arrays.asList(budgets));
    }

    private void assertQuery(LocalDate startDate, LocalDate endDate, int expectedAmount) {
        assertEquals(expectedAmount, budgetPlan.query(new Period(startDate, endDate)), 0.01);
    }

    @Test
    public void query_out_of_budget_periods(){
        givenBudgetPeriods();
        assertQuery(LocalDate.of(2018, 1, 1), LocalDate.of(2018, 1, 10), 0);
    }

    @Test
    public void query_one_budget_period() throws Exception {
        givenBudgetPeriods(new Budget("2018-03", 1000));
        assertQuery(LocalDate.of(2018, 3, 1), LocalDate.of(2018, 3, 31), 1000);
    }

    @Test
    public void query_one_day_in_march() throws Exception {
        givenBudgetPeriods(new Budget("2018-03", 3100));
        assertQuery(LocalDate.of(2018, 3, 1), LocalDate.of(2018, 3, 1), 100);
    }

    @Test
    public void query_one_day_in_feb() throws Exception {
        givenBudgetPeriods(new Budget("2018-02", 2800));
        assertQuery(LocalDate.of(2018, 2, 1), LocalDate.of(2018, 2, 1), 100);
    }

    @Test
    public void query_two_days() throws Exception {
        givenBudgetPeriods(new Budget("2018-02", 2800));
        assertQuery(LocalDate.of(2018, 2, 5), LocalDate.of(2018, 2, 6), 200);
    }

    @Test
    public void query_start_date_out_of_budget() throws Exception {
        givenBudgetPeriods(new Budget("2018-02", 2800));
        assertQuery(LocalDate.of(2018, 1, 31), LocalDate.of(2018, 2, 3), 300);
    }

    @Test
    public void query_end_date_out_of_budget() throws Exception {
        givenBudgetPeriods(new Budget("2018-02", 2800));
        assertQuery(LocalDate.of(2018, 2, 25), LocalDate.of(2018, 3, 3), 400);
    }

    @Test
    public void query_across_two_budgets() throws Exception {
        givenBudgetPeriods(new Budget("2018-02", 2800), new Budget("2018-03", 31000));
        assertQuery(LocalDate.of(2018, 2, 25), LocalDate.of(2018, 3, 3), 3400);
    }

    @Test
    public void query_across_multiple_budgets() throws Exception {
        givenBudgetPeriods(new Budget("2018-02", 2800), new Budget("2018-03", 31000), new Budget("2018-04", 30));
        assertQuery(LocalDate.of(2018, 2, 25), LocalDate.of(2018, 4, 5), 31405);
    }
}
