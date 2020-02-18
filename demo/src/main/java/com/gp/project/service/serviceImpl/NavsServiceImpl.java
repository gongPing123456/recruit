package com.gp.project.service.serviceImpl;

import com.gp.project.common.Result;
import com.gp.project.mapper.NavsMapper;
import com.gp.project.pojo.Navs;
import com.gp.project.service.NavsService;
import org.omg.CORBA.NamedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @time 2019/11/12 16:17
 * @Author gp
 */
@Service
public class NavsServiceImpl implements NavsService {
	@Autowired
	NavsMapper navsMapper;
	@Override
	public List<Navs> getServiceList() {


		List<Navs> navs = navsMapper.selectAll();
		return getNavsJson(navs);
	}

	@Override
	public Result addNavs(Navs navs) {
		Result result=new Result();
		navsMapper.insertSelective(navs);
		return result;
	}

	@Override
	public Navs getNavs(Navs navs) {
		Navs navs1 = navsMapper.selectByPrimaryKeySelective(navs);
		return navs1;
	}


	/**
	 * 处理左导航返回的JSON 数据
	 * @param navs
	 * @return
	 */
	public  List<Navs> getNavsJson(List<Navs> navs){
		for (int i = 0; i < navs.size(); i++) {
			if (navs.get(i).getIsSubdirectory()){
				for (int j = 0; j < navs.size(); j++) {
					if (navs.get(j).getId().equals(navs.get(i).getSubdirectory()))
					{
						navs.get(j).children.add(navs.get(i));
					}
				}

			}
		}
		List<Navs> navsList =new ArrayList<>();
		for (int i = 0; i < navs.size(); i++) {
			if (!navs.get(i).getIsSubdirectory()){
				navsList.add(navs.get(i));
			}
		}
		return  navsList;
	}
}
