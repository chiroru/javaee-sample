package jp.ddo.chiroru.testing.junit.dbunit;

import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;

public class FlatXmlDataSetGenerator
        implements DataSetGenerator {

    @Override
    public IDataSet generate(String path) {
        try {
            FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
            builder.setColumnSensing(true);
            return builder.build(getClass().getResourceAsStream(path));
        } catch (DataSetException e) {
            throw new RuntimeException("テストデータの定義ファイル[" + path + "]の読み込みに失敗しました.", e);
        }
    }
}
