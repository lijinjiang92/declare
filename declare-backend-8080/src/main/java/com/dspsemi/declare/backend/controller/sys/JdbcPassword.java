package com.dspsemi.declare.backend.controller.sys;

import com.alibaba.druid.filter.config.ConfigTools;

public class JdbcPassword {

	public static void main(String[] args) throws Exception {
			System.out.println(ConfigTools.encrypt("123"));

	}

}
