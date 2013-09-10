package jp.ddo.chiroru.testing.resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public abstract class CachingPropertyLoader
        implements PropertyLoader {

    private final Map<String, Properties> cache;

    public CachingPropertyLoader() {
        cache = Collections.synchronizedMap(new HashMap<String, Properties>());
    }

    @Override
    public Properties load(String path) throws IOException {
        if (!isCached(path)) {
            InputStream in = getResourceAsStream(path);

            if (in == null)
                throw new FileNotFoundException(path);

            try {
                cache(path, load(in, path.toLowerCase().endsWith(".xml")));
            }
            finally {
                in.close();
            }
        }

        return getCachedProperties(path);
    }

    private Properties load(InputStream in, boolean isXml) throws IOException {
        Properties props = new Properties();

        if (isXml)
            props.loadFromXML(in);
        else
            props.load(in);

        return props;
    }

    private Properties getCachedProperties(String path) {
        return Properties.class.cast(cache.get(path).clone());
    }

    private void cache(String path, Properties props) {
        cache.put(path, props);
    }

    private boolean isCached(String path) {
        return cache.containsKey(path);
    }


    protected void clearCache() {
        cache.clear();
    }

    protected abstract InputStream getResourceAsStream(String path);
}
