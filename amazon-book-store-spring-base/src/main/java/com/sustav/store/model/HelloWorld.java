package com.sustav.store.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Anton Sustavov
 * @since 2020/11/03
 */
public class HelloWorld {
    public static final Log LOG = LogFactory.getLog(HelloWorld.class);

    public void sayHello() {
        LOG.info("Hello World!");
    }

}
