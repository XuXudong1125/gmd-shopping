package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TYPE_ONE���Ӧ��ʵ���࣬���ڱ������һ��һ�������Ϣ
 * 
 * @author ����
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeOne implements java.io.Serializable {
	
	private static final long serialVersionUID = 3224375634526784004L;

	/**
	 * һ�������
	 */
    private Integer typeOneId;

    /**
	 * һ���������
	 */
    private String typeOneName;

    /**
	 * һ���������
	 */
    private Integer typeOneNum;

    /**
	 * һ�����ע
	 */
    private String typeOneRemark;
}