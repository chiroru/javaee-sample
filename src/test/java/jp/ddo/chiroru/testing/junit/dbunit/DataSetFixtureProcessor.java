package jp.ddo.chiroru.testing.junit.dbunit;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import org.dbunit.dataset.IDataSet;

public class DataSetFixtureProcessor {

    private Map<DataSetType, DataSetGenerator> repository;

    public DataSetFixtureProcessor() {
        repository = getGenerators();
    }

    public IDataSet doProcess(DataSetType type, String path) {
        DataSetGenerator generator = repository.get(type);
        return generator.generate(path);
    }

    private Map<DataSetType, DataSetGenerator> getGenerators() {
        ImmutableMap.Builder<DataSetType, DataSetGenerator> builder = ImmutableMap.builder();
        builder.put(DataSetType.FlatXml, new FlatXmlDataSetGenerator());
        return builder.build();
    }
}
