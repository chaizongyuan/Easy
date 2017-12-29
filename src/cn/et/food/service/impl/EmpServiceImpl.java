package cn.et.food.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.food.dao.EmpMapper;
import cn.et.food.entity.Emp;
import cn.et.food.entity.EmpExample;
import cn.et.food.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {
	
	
	@Autowired
	EmpMapper em;
	/* (non-Javadoc)
	 * @see cn.et.food.service.impl.DeptService#queryTreeNode(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see cn.et.food.service.impl.EmpService#queryEmp(java.lang.Integer)
	 */
	public List<Emp> queryEmp(Integer id){
		EmpExample ee = new EmpExample();
		if(id!=null){
			ee.createCriteria().andDeptidEqualTo(id);
		}			
		return em.selectByExample(ee);		
	}
	 
	
}
