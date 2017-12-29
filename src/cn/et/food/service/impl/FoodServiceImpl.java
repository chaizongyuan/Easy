package cn.et.food.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.food.dao.FoodMapper;
import cn.et.food.entity.Food;
import cn.et.food.entity.FoodExample;
import cn.et.food.entity.FoodExample.Criteria;
import cn.et.food.service.FoodService;
import cn.et.food.utils.PageTools;

@Service
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	FoodMapper fm;
	/* (non-Javadoc)
	 * @see cn.et.food.service.impl.FoodService#queryStudent(java.lang.String)
	 */
	public PageTools queryFood(String foodname,Integer page,Integer rows){
		if(foodname==null){
			foodname="";
		}
		
		FoodExample example = new FoodExample();
		//构造一个条件
		Criteria c = example.createCriteria();
		//如果有多个条件可以后面跟and...
		c.andFoodnameLike("%"+foodname+"%");
		
		//查询总记录数
		int total=(int)fm.countByExample(example);
		
		PageTools ps=new PageTools(page, total, rows);
		//通过RowBounds自动生成每页的数据
		RowBounds rb = new RowBounds(ps.getStartIndex()-1,rows);
		List<Food> foodList = fm.selectByExampleWithRowbounds(example, rb);
		ps.setRows(foodList);
		return ps;
	}
	
	public int queryFoodCount(FoodExample example){
		
		int total=(int)fm.countByExample(example);
		return total;
	}
	
	
	/**
	 * 添加菜品
	 */
	public void saveFood(Food food){	
		fm.insert(food);
	}
	
	

	/**
	 * 删除菜品
	 */
	public void deleteFood(Integer foodid){
		fm.deleteByPrimaryKey(foodid);	
	}
	
	/**
	 * 修改菜品
	 */
	public void updateFood(Food food){
		fm.updateByPrimaryKey(food);
	}
	
}
