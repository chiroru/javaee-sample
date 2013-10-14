package jp.ddo.chiroru.testing.database;

public @interface TestDataFixture {

    TestDataFileFormat testDataFileFormat() default TestDataFileFormat.Yaml;

    String[] value() default {};
}
