package org.collectd.java;

import org.collectd.api.OConfigItem;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;

import static org.collectd.api.DataSource.TYPE_DERIVE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GenericJMXConfValueTest {

    @Test
    public void genericObjectToNumberShouldWorkWithAtomicLong() {
        final OConfigItem config = new OConfigItem("");
        final OConfigItem type = new OConfigItem("Type");
        type.addValue("DERIVE");
        config.addChild(type);
        final OConfigItem attribute = new OConfigItem("Attribute");
        attribute.addValue("test");
        config.addChild(attribute);
        final GenericJMXConfValue value = new GenericJMXConfValue(config);

        assertThat((Long) value.genericObjectToNumber(1L, TYPE_DERIVE), is(1L));
        assertThat((Long) value.genericObjectToNumber(new AtomicLong(2), TYPE_DERIVE), is(2L));
    }
}