package com.lhx.base;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.lhx.common.mybatis.dao.TabColDao;
import com.lhx.file.copy.CopyFileUtil;
import com.lhx.file.factory.ContextModelFactory;
import com.lhx.file.model.ContextModel;
import com.lhx.file.model.TabColModel;
import com.lhx.utils.SpringConfigTool;

public class BuildModuleTest extends BaseTest {
	
	TabColDao tabColDao;

/*	@Test
	public void buildUser() throws IOException {
		tabColDao = (TabColDao)SpringConfigTool.getBean("tabColDao");
		TabColModel queryCondition = new TabColModel("LHX_T_SYS_USER");
		List<TabColModel> tabColList = tabColDao.queryList(queryCondition);
		ContextModel contextModel = ContextModelFactory.create(tabColList, "LHX_T_SYS_USER", "system.user", "User","用户");
		CopyFileUtil.copy(contextModel);
	}
	
	@Test
	public void buildOrg() throws IOException {
		tabColDao = (TabColDao)SpringConfigTool.getBean("tabColDao");
		TabColModel queryCondition = new TabColModel("LHX_T_SYS_ORG");
		List<TabColModel> tabColList = tabColDao.queryList(queryCondition);
		ContextModel contextModel = ContextModelFactory.create(tabColList, "LHX_T_SYS_ORG", "system.org", "Org","组织机构");
		CopyFileUtil.copy(contextModel);
	}
	
	
	@Test
	public void buildUserOrg() throws IOException {
		tabColDao = (TabColDao)SpringConfigTool.getBean("tabColDao");
		TabColModel queryCondition = new TabColModel("LHX_T_SYS_USER_ORG");
		List<TabColModel> tabColList = tabColDao.queryList(queryCondition);
		ContextModel contextModel = ContextModelFactory.create(tabColList, "LHX_T_SYS_USER_ORG", "system.userOrg", "UserOrg","用户组织机构");
		CopyFileUtil.copy(contextModel);
	}
	

	
	@Test
	public void buildUserRole() throws IOException {
		tabColDao = (TabColDao)SpringConfigTool.getBean("tabColDao");
		TabColModel queryCondition = new TabColModel("LHX_T_SYS_USER_ROLE");
		List<TabColModel> tabColList = tabColDao.queryList(queryCondition);
		ContextModel contextModel = ContextModelFactory.create(tabColList, "LHX_T_SYS_USER_ROLE", "system.userRole", "UserRole","用户角色");
		CopyFileUtil.copy(contextModel);
	}
	
	@Test
	public void buildRoleMenu() throws IOException {
		tabColDao = (TabColDao)SpringConfigTool.getBean("tabColDao");
		TabColModel queryCondition = new TabColModel("LHX_T_SYS_ROLE_MENU");
		List<TabColModel> tabColList = tabColDao.queryList(queryCondition);
		ContextModel contextModel = ContextModelFactory.create(tabColList, "LHX_T_SYS_ROLE_MENU", "system.roleMenu", "RoleMenu","角色菜单");
		CopyFileUtil.copy(contextModel);
	}
	


	
	
/*	@Test
	public void buildForm() throws IOException{
		tabColDao = (TabColDao)SpringConfigTool.getBean("tabColDao");
		TabColModel queryCondition = new TabColModel("LHX_T_SYS_FORM_FILED_DEF");
		List<TabColModel> tabColList = tabColDao.queryList(queryCondition);
		ContextModel contextModel = ContextModelFactory.create(tabColList, "LHX_T_SYS_FORM_FILED_DEF", "system.form", "Form","表单管理");
		CopyFileUtil.copy(contextModel,true,true,true);
	}*/
	
/*	@Test
	public void buildFormType() throws IOException{
		tabColDao = (TabColDao)SpringConfigTool.getBean("tabColDao");
		TabColModel queryCondition = new TabColModel("LHX_T_FORM_TYPE");
		List<TabColModel> tabColList = tabColDao.queryList(queryCondition);
		ContextModel contextModel = ContextModelFactory.create(tabColList, "LHX_T_FORM_TYPE", "system.formType", "FormType","表单分类");
		CopyFileUtil.copy(contextModel,true,false,false);
	}
	
	@Test
	public void buildFormDef() throws IOException{
		tabColDao = (TabColDao)SpringConfigTool.getBean("tabColDao");
		TabColModel queryCondition = new TabColModel("LHX_T_FORM_DEF");
		List<TabColModel> tabColList = tabColDao.queryList(queryCondition);
		ContextModel contextModel = ContextModelFactory.create(tabColList, "LHX_T_FORM_DEF", "system.formDef", "FormDef","表单定义");
		CopyFileUtil.copy(contextModel,true,false,false);
	}*/
	
	/*@Test
	public void buildRole() throws IOException {
		tabColDao = (TabColDao)SpringConfigTool.getBean("tabColDao");
		TabColModel queryCondition = new TabColModel("LHX_T_SYS_ROLE");
		List<TabColModel> tabColList = tabColDao.queryList(queryCondition);
		ContextModel contextModel = ContextModelFactory.create(tabColList, "LHX_T_SYS_ROLE", "system.role", "Role","角色管理");
		CopyFileUtil.copy(contextModel,false,false,true);
	}
	

	
	
/*	@Test
	public void buildMenu() throws IOException {
		tabColDao = (TabColDao)SpringConfigTool.getBean("tabColDao");
		TabColModel queryCondition = new TabColModel("LHX_T_SYS_MENU");
		List<TabColModel> tabColList = tabColDao.queryList(queryCondition);
		ContextModel contextModel = ContextModelFactory.create(tabColList, "LHX_T_SYS_MENU", "system.menu", "Menu","菜单");
		CopyFileUtil.copy(contextModel,true,true,true);
	}
*/
	
/*	@Test
	public void buildMenuUrl() throws IOException {
		tabColDao = (TabColDao)SpringConfigTool.getBean("tabColDao");
		TabColModel queryCondition = new TabColModel("LHX_T_SYS_RESOURCE");
		List<TabColModel> tabColList = tabColDao.queryList(queryCondition);
		ContextModel contextModel = ContextModelFactory.create(tabColList, "LHX_T_SYS_RESOURCE", "system.resource", "Resource","系统资源访问表");
		CopyFileUtil.copy(contextModel,true,false,false);
	}*/
	
	
/*	@Test
	public void buildRole() throws IOException {
		tabColDao = (TabColDao)SpringConfigTool.getBean("tabColDao");
		TabColModel queryCondition = new TabColModel("LHX_T_SYS_ROLE");
		List<TabColModel> tabColList = tabColDao.queryList(queryCondition);
		ContextModel contextModel = ContextModelFactory.create(tabColList, "LHX_T_SYS_ROLE", "system.role", "Role","角色管理");
		CopyFileUtil.copy(contextModel,true,false,false);
	}*/
	
/*	@Test
	public void buildMenu() throws IOException {
		tabColDao = (TabColDao)SpringConfigTool.getBean("tabColDao");
		TabColModel queryCondition = new TabColModel("LHX_T_SYS_MENU");
		List<TabColModel> tabColList = tabColDao.queryList(queryCondition);
		ContextModel contextModel = ContextModelFactory.create(tabColList, "LHX_T_SYS_MENU", "system.menu", "Menu","菜单");
		CopyFileUtil.copy(contextModel,false,false,true);
	}*/
	
/*	@Test
	public void buildDict() throws IOException {
		tabColDao = (TabColDao)SpringConfigTool.getBean("tabColDao");
		TabColModel queryCondition = new TabColModel("LHX_T_SYS_DICT");
		List<TabColModel> tabColList = tabColDao.queryList(queryCondition);
		ContextModel contextModel = ContextModelFactory.create(tabColList, "LHX_T_SYS_DICT", "system.dict", "Dict","数据字典");
		CopyFileUtil.copy(contextModel,true,true,true);
	}*/
	
/*	@Test
	public void buildMarket() throws IOException {
		tabColDao = (TabColDao)SpringConfigTool.getBean("tabColDao");
		TabColModel queryCondition = new TabColModel("LHX_T_STOCK_MARKET_INFO");
		List<TabColModel> tabColList = tabColDao.queryList(queryCondition);
		ContextModel contextModel = ContextModelFactory.create(tabColList, "LHX_T_STOCK_MARKET_INFO", "stock.market", "Market","股票行情");
		CopyFileUtil.copy(contextModel,true,true,false);
	}*/
	
	@Test
	public void buildTDIndex() throws IOException {
		tabColDao = (TabColDao)SpringConfigTool.getBean("tabColDao");
		TabColModel queryCondition = new TabColModel("LHX_T_STOCK_MARKET_TDINDEX");
		List<TabColModel> tabColList = tabColDao.queryList(queryCondition);
		ContextModel contextModel = ContextModelFactory.create(tabColList, "LHX_T_STOCK_MARKET_TDINDEX", "stock.tdIndex", "TDIndex","TD指标");
		CopyFileUtil.copy(contextModel,true,true,false);
	}

}
