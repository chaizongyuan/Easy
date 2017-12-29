package cn.et.food.service;

import java.util.List;

import cn.et.food.entity.Emp;

public interface EmpService {

	/* (non-Javadoc)
	 * @see cn.et.food.service.impl.DeptService#queryTreeNode(java.lang.Integer)
	 */
	public abstract List<Emp> queryEmp(Integer id);

}