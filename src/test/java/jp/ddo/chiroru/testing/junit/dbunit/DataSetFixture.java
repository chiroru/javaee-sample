package jp.ddo.chiroru.testing.junit.dbunit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.METHOD})
public @interface DataSetFixture {

    DataSetType type() default DataSetType.FlatXml;
    String[] value();
}
