package jp.ddo.chiroru.testing.junit.logging;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingTestWatcher
        extends TestWatcher {

    private final static Logger L = LoggerFactory.getLogger(LoggingTestWatcher.class);

    @Override
    protected void starting(Description description) {
        L.info("[starting] ================================================================================");
        L.info("");
        L.info(" [ " + description.getClassName() + "]");
        L.info("  " + description.getMethodName());
    }

    @Override
    protected void finished(Description description) {
        L.info("=================================================================================[finished]");
    }

}
