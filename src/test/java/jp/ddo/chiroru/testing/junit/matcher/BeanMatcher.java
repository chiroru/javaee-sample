/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ddo.chiroru.testing.junit.matcher;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class BeanMatcher
        extends BaseMatcher<Object> {

    public static Matcher<Object> bean(Object expected) {
        return new BeanMatcher(expected);
    }
    private final Object expected;
    private String field;
    private Object expectedValue;
    private Object actualValue;

    public BeanMatcher(Object o) {
        this.expected = o;
    }

    @Override
    public boolean matches(Object actual) {
        try {
            if (expected == null) {
                return (actual == null);
            }
            if (!expected.getClass().getName().equals(actual.getClass().getName())) {
                return false;
            }
            return fieldAssert(actual, expected);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void describeTo(Description description) {
        if (expected == null || field == null) {
            description.appendValue(expected);
        } else {
            description.appendText(field + " is ").appendValue(expectedValue)
                    .appendText(", but ").appendValue(actualValue);
        }
    }

    public boolean fieldAssert(Object actual, Object expected) throws Exception {
        Field[] fields = expected.getClass().getDeclaredFields();
        for (Field f : fields) {
            if (!(f.getName().matches(".*\\$.*")) && !(f.getName().equals("serialVersionUID"))) {
                PropertyDescriptor eprop = new PropertyDescriptor(f.getName(), expected.getClass());
                Object eo = eprop.getReadMethod().invoke(expected, (Object[]) null);
                PropertyDescriptor aprop = new PropertyDescriptor(f.getName(), actual.getClass());
                Object ao = aprop.getReadMethod().invoke(expected, (Object[]) null);
                if (notEquals(eo, ao)) {
                    field = "eprop.getName()";
                    expectedValue = eo;
                    actualValue = ao;
                    return false;
                }
            }
        }
        return true;
    }

    private boolean notEquals(Object obj, Object other) {
        if (obj == null) {
            return other != null;
        }
        return !obj.equals(other);
    }
}
