package com.lhx.market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lhx.common.BaseController;
import com.lhx.common.utils.SessionUtil;
import com.lhx.stock.info.model.StockInfo;
import com.lhx.stock.model.EchartModel;
import com.lhx.stock.self.model.StockSelf;
import com.lhx.stock.service.IndexManagerService;
import com.lhx.stock.service.MarketManagerService;
import com.lhx.stock.service.StockInfoManagerService;
import com.lhx.stock.service.StockSelfManagerService;
import com.lhx.utils.SpringConfigTool;
import com.lhx.utils.UUIDUtil;

@Controller
@RequestMapping("/market/manager")
public class MarketController extends BaseController{
	
	@Autowired
	private MarketManagerService marketManagerService;
	
	@Autowired
	private StockInfoManagerService stockInfoManagerService;
	
	@Autowired
	private StockSelfManagerService stockSelfManagerService;

	@RequestMapping(value="/page/{page}.do")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,@PathVariable("page") String page,StockSelf stockSelf){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		super.setParameter(request, resultMap);
		if("mainChart".equals(page)){
			
			if(SessionUtil.getLoginUser(request) != null){
				stockSelf.setUserId(SessionUtil.getLoginUser(request).getUserId());
				resultMap.put("isSelf",stockSelfManagerService.isSelf(stockSelf));

			}

		}
		return new ModelAndView("/market/display/jsp/"+page,resultMap);
	}
	
	@RequestMapping(value="/chartData.do")
	@ResponseBody
	public EchartModel chartData(HttpServletRequest request,HttpServletResponse response,String tcode){
		return marketManagerService.createModel(tcode);
	}
	
	@RequestMapping(value="/search.do")
	@ResponseBody
	public Map<String,List<StockInfo>> search(HttpServletRequest request,HttpServletResponse response,StockInfo stockInfo){
		Map<String,List<StockInfo>>  resultMap = new HashMap<String,List<StockInfo>>();
		resultMap.put("result", stockInfoManagerService.getList(stockInfo)) ;
		return resultMap;
	}
	
	@RequestMapping(value="/tdCalculate.do")
	public void tdCalculate(HttpServletRequest request,HttpServletResponse response,String tcode){
		Map<String,String>  param = new HashMap<String,String>();
		param.put("tcode", tcode);
		IndexManagerService indexManagerService = (IndexManagerService)SpringConfigTool.getBean("stIndex");
		indexManagerService.calculate(param);;
	}
	
	@RequestMapping(value="/addSelf.do")
	public void addSelf(HttpServletRequest request,HttpServletResponse response,StockSelf stockSelf){
		stockSelf.setId_(UUIDUtil.getUUID());			
		stockSelf.setUserId(SessionUtil.getLoginUser(request).getUserId());
		stockSelfManagerService.addStockSelf(stockSelf);
	}
	
	@RequestMapping(value="/removeSelf.do")
	@ResponseBody
	public void removeSelf(HttpServletRequest request,HttpServletResponse response,StockSelf stockSelf){
		stockSelf.setUserId(SessionUtil.getLoginUser(request).getUserId());
		stockSelfManagerService.removeStockSelf(stockSelf, true);
	}
	
	@RequestMapping(value="/getAllSelf.do")
	@ResponseBody
	public  Map<String,List<StockSelf>> getAllSelf(HttpServletRequest request,HttpServletResponse response,StockSelf stockSelf){
		Map<String,List<StockSelf>>  result = new HashMap<String,List<StockSelf>>();
		stockSelf.setUserId(SessionUtil.getLoginUser(request).getUserId());
		result.put("datalist", stockSelfManagerService.getList(stockSelf));
		return result;
	}
}
