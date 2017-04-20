package com.dspsemi.declare.core.pojo.sys;

import com.dspsemi.common.enums.entity.YesNo;
import com.dspsemi.common.jpa.Add2Resource;
import com.dspsemi.common.jpa.Entity;
import com.dspsemi.common.jpa.Id;
import com.dspsemi.common.jpa.Table;
import com.dspsemi.common.lang.dto.AbstractOperateEntity;
import com.dspsemi.declare.core.util.mybatis.GeneratorEnum;

/**
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="sys_generator")
public class Generator extends AbstractOperateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	@Id
	private GeneratorEnum generatorType;
	
	private String initialVal;
	
	private String currentVal;
	
	private String maxVal;
	
	private Integer fetchSize;
	
	private Integer increment;
	
	private YesNo isCycle;
	

	public Generator(){
	
	}

	public Generator(GeneratorEnum generatorType){
		this.generatorType = generatorType;
	}

	public GeneratorEnum getGeneratorType() {
		return generatorType;
	}

	public void setGeneratorType(GeneratorEnum generatorType) {
		this.generatorType = generatorType;
	}

	public String getInitialVal() {
		return initialVal;
	}
	
	public void setInitialVal(String initialVal) {
		this.initialVal = initialVal;
	}
	
	public String getCurrentVal() {
		return currentVal;
	}
	
	public void setCurrentVal(String currentVal) {
		this.currentVal = currentVal;
	}
	
	public String getMaxVal() {
		return maxVal;
	}
	
	public void setMaxVal(String maxVal) {
		this.maxVal = maxVal;
	}
	
	public Integer getFetchSize() {
		return fetchSize;
	}
	
	public void setFetchSize(Integer fetchSize) {
		this.fetchSize = fetchSize;
	}
	
	public Integer getIncrement() {
		return increment;
	}

	public void setIncrement(Integer increment) {
		this.increment = increment;
	}

	public YesNo getIsCycle() {
		return isCycle;
	}

	public void setIsCycle(YesNo isCycle) {
		this.isCycle = isCycle;
	}
	
}

