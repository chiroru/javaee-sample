package jp.ddo.chiroru.javaee.sample.presentation.format;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TimestampAdapter
        extends XmlAdapter<String, Timestamp> {

    private final static DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Timestamp unmarshal(String v) throws Exception {
        return Timestamp.valueOf(v);
    }

    @Override
    public String marshal(Timestamp v) throws Exception {
        return f.format(v);
    }
}
