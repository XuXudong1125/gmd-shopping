package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TYPE_ONE表对应的实体类，用于保存表中一行一级类别信息
 * 
 * @author 徐旭东
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeOne implements java.io.Serializable {
	
	private static final long serialVersionUID = 3224375634526784004L;

	/**
	 * 一级类别编号
	 */
    private Integer typeOneId;

    /**
	 * 一级类别名称
	 */
    private String typeOneName;

    /**
	 * 一级类别数量
	 */
    private Integer typeOneNum;

    /**
	 * 一级类别备注
	 */
    private String typeOneRemark;
}