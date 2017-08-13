package com.lhx.system;

import org.junit.Test;

import com.lhx.base.BaseTest;
import com.lhx.system.org.dao.OrgDao;
import com.lhx.system.org.model.Org;
import com.lhx.utils.DateUtil;
import com.lhx.utils.SpringConfigTool;
import com.lhx.utils.UUIDUtil;

public class OrgTest extends BaseTest{
	
	private String id_ = "";

	@Test
	public void add() {
		OrgDao orgDao = (OrgDao)SpringConfigTool.getBean("orgDao");
		id_ = UUIDUtil.getUUID();
		Org org = Org.newInstance(id_, "0", "六合信", "0001", "00012003");
		org.setCreatet(DateUtil.getSysCurrentTime());
		orgDao.save(org);
	}
	
	@Test
	public void query() {
		OrgDao orgDao = (OrgDao)SpringConfigTool.getBean("orgDao");
		orgDao.query(id_);
	}

	
	@Test
	public void queryList() {
		OrgDao orgDao = (OrgDao)SpringConfigTool.getBean("orgDao");
		Org org = Org.newInstance(null, null, "六合信", null, null);
		orgDao.queryList(org);
	}

	
	@Test
	public void update() {
		OrgDao orgDao = (OrgDao)SpringConfigTool.getBean("orgDao");
		Org org = Org.newInstance(null, null, "六合信NEW", null, null);
		orgDao.update(org);

	}

	@Test
	public void delete() {
		OrgDao orgDao = (OrgDao)SpringConfigTool.getBean("orgDao");
		orgDao.delete("");
	}

}
