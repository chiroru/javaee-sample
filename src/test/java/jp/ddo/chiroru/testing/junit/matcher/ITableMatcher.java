package jp.ddo.chiroru.testing.junit.matcher;

import org.dbunit.DatabaseUnitException;
import org.dbunit.DatabaseUnitRuntimeException;
import org.dbunit.dataset.ITable;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ITableMatcher
        extends TypeSafeMatcher<ITable> {

    public static Matcher<ITable> tableOf(ITable expected) {
        return new ITableMatcher(expected);
    }

    private final ITable expected;
    
    String assertionMsg = null;

    ITableMatcher(ITable expected) {
        this.expected = expected;
    }

    @Override
    public boolean matchesSafely(ITable actual) {
        try {
            org.dbunit.Assertion.assertEquals(expected, actual);
        } catch (DatabaseUnitException e) {
            throw new DatabaseUnitRuntimeException(e);
        } catch (AssertionError e) {
            assertionMsg = e.getMessage();
            return false;
        }
        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendValue(expected);
        if (assertionMsg == null)
            return;
        description.appendText("\n >>>").appendText(assertionMsg);
    }
}
