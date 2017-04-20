package com.dspsemi.declare.core.util.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import com.dspsemi.common.enums.DetailEnum;
import com.dspsemi.common.enums.Enums;
import com.dspsemi.common.enums.entity.*;
import com.dspsemi.common.enums.entity.status.*;
import com.dspsemi.declare.core.enums.*;

/**
 * @author XiaoJin Wang
 *
 */
@MappedTypes({
	/***** CORE包   *****/
	LogLevel.class,
	MsgType.class,
	NoticeType.class,
	ObjType.class,
	TopicStatus.class,
	DevBoardApplyStatus.class,
	JobType.class,
	JobFieldType.class,
	DevBoardProType.class,
	
	/***** COMMON包   *****/
	Gender.class,
	OpenClose.class,
	PhoneType.class,
	YesNo.class,
	DataType.class,
	RequestMethod.class,
	/***** 状态  分割线 *****/
	CloseDelStatus.class,
	CloseStatus.class,
	DeleteStatus.class,
	OnShelfStatus.class,
	Status.class,
	UserStatus.class,
	VerifyStatus.class,
	/***** utils *****/
	GeneratorEnum.class
})
public class EnumTypeHandler<T extends Enum<T> & DetailEnum<V>, V> extends BaseTypeHandler<T>{
	
	private Class<T> classType;
	
	public EnumTypeHandler(Class<T> clazz) {
		this.classType = clazz;
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			T parameter, JdbcType jdbcType) throws SQLException {
		ps.setObject(i, parameter.getValue());
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		return Enums.parse(classType, (V)rs.getObject(columnName));
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		return (T)rs.getObject(columnIndex);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getNullableResult(CallableStatement cs,
			int columnIndex) throws SQLException {
		return (T)cs.getObject(columnIndex);
	}

}
