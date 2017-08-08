package com.lhx.common.service.tree.impl;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lhx.common.service.tree.TreeService;
import com.lhx.common.tree.DictTreeModel;
import com.lhx.system.dict.dao.DictDao;

@Service("dictTreeServiceImpl")
public class DictTreeServiceImpl implements TreeService<DictTreeModel> {
	
	@Autowired
	private DictDao dictDao;

	@Override
	public List<DictTreeModel> createTree(Map<String, String> param) {
		param.put("i18n",Locale.getDefault().toString());
		return dictDao.queryDictAllTree(param);
	}

}
