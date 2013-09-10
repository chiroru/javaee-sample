package jp.ddo.chiroru.testing.junit.dbunit;

import org.dbunit.dataset.IDataSet;

public interface DataSetGenerator {
    IDataSet generate(String path);
}
