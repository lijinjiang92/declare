package com.dspsemi.declare.core.service.sys;

import org.junit.Test;

import com.dspsemi.declare.core.service.sys.GeneratorService;
import com.dspsemi.declare.core.util.test.BaseTest;

public class GeneratorServiceTest extends BaseTest<GeneratorService> {
	
	@Test
    public void testGenerator() {
    	try {
    		LOG.info(bean.batchAdd());
		} catch (Exception e) {
			LOG.error("run error!!!", e);
		}
    }
    
}
