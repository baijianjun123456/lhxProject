package com.lhx.message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lhx.Message.service.AttachManagerService;
import com.lhx.Message.service.PublicizeManagerService;
import com.lhx.Message.service.RERecordManagerService;
import com.lhx.Message.service.SERecordManagerService;
import com.lhx.Message.service.UPloadsettingManagerService;
import com.lhx.Message.service.impl.PublicizeManagerServiceImpl;
import com.lhx.common.BaseController;
import com.lhx.common.DateUtil;
import com.lhx.message.publicize.model.Publicize;
import com.lhx.message.publicize.model.PublicizeQuery;
import com.lhx.message.receiverecord.model.RERecord;
import com.lhx.message.sendrecord.model.SERecord;
import com.lhx.system.role.model.Role;
import com.lhx.system.service.RoleManagerService;
import com.lhx.utils.StringUtil;
import com.lhx.utils.UUIDUtil;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Commons;

@Controller
@RequestMapping("/message/publicize")
public class PublicizeController extends BaseController {
	@Autowired
	private PublicizeManagerService publicizeManagerService;
	@Autowired
	private PublicizeManagerServiceImpl publicizeManagerServiceImpl;
	@Autowired
	private AttachManagerService attachManagerService;
/*	@Autowired
	private ReceiverecordManagerService receiverecordManagerService;*/
	@Autowired
	private RERecordManagerService rERecordManagerService;
	@Autowired
	private SERecordManagerService sERecordManagerService;
	@Autowired
	private UPloadsettingManagerService uPloadsettingManagerService;
	@Autowired
	private RoleManagerService roleManagerService;
	@RequestMapping(value="/page/{page}.do")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,@PathVariable("page") String page,Publicize pub){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		super.setParameter(request, resultMap);
		if(StringUtil.isNotBlank(pub.getId_())){
			resultMap.put("result", publicizeManagerServiceImpl.get(pub));
			RERecord rERecord=new RERecord();	
			if(!"".equals(pub.getId_())&&null!=pub.getId_()){
				rERecord.setPubid(pub.getId_());
			}			
			resultMap.put("resultRERecord", rERecordManagerService.get(rERecord));
		}
		return new ModelAndView("/message/publicize/"+page,resultMap);
	}
	@RequestMapping(value="/ajaxlist.do")
	@ResponseBody
	public String ajaxlist(HttpServletRequest request,HttpServletResponse response,PublicizeQuery pubQuery){

		Map<String,Object>  resultMap = new HashMap<String,Object>();
		
		publicizeManagerService.getListPage(pubQuery);
		
		resultMap.put("result", pubQuery);
		Gson gson = new Gson();
		
		return gson.toJson(pubQuery);
	}
	@RequestMapping(value="/getpublicizelist.do")
	@ResponseBody
	public ModelAndView getpublicizelist(HttpServletRequest request,HttpServletResponse response,PublicizeQuery pubQuery){

		Map<String,Object>  resultMap = new HashMap<String,Object>();		
		List<Publicize> publicizeList= publicizeManagerService.getListPage(pubQuery);		
		resultMap.put("publicizeList", publicizeList);				
		return new ModelAndView("/message/publicize/publicizeListAll",resultMap);
	}
	@RequestMapping(value="/publicizeDetail.do")
	@ResponseBody
	public ModelAndView publicizeDetail(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		//01、获取单个公告内容
		String pubId=request.getParameter("pubId");
		Publicize publicize=new Publicize();
		publicize.setId_(pubId);
		if(StringUtil.isNotBlank(publicize.getId_())){
			publicize=publicizeManagerServiceImpl.get(publicize);
		}
		resultMap.put("result", publicize);//获取单个公告	
		//02、获取所有的公告内容
		PublicizeQuery pubQuery=new PublicizeQuery();
		List<Publicize> pubList=publicizeManagerService.getListPage(pubQuery);
		resultMap.put("resultList", pubList);		
		//03、获取上篇下片内容   ==============begin
		List<Publicize> pubSortList=new ArrayList<Publicize>();
		for (int i = 0; i < pubList.size(); i++) {
			Publicize pubCurrent=pubList.get(i);
			if(pubCurrent.getId_().trim().equals(pubId.trim())){
				if(i==0){					
					if(pubList.size()>1){
						pubSortList.add(pubList.get(pubList.size()-1));//前一个
						pubSortList.add(pubList.get(1));//后一个
					}					
				}else if(i>0){
					pubSortList.add(pubList.get(i-1));//前一个
					if(pubList.size()>1&&(i+1)<pubList.size()){
					  pubSortList.add(pubList.get(i+1));//后一个
					}
				}
			}
		}
		resultMap.put("pubSortList", pubSortList);//获取底部数据	
		//03、获取上篇下片内容   ==============end
		return new ModelAndView("/message/publicize/publicizeDetail",resultMap);
	}	
	@RequestMapping(value="/addPublicize.do")
	@ResponseBody
	public Map<String,Object> addUser(HttpServletRequest request,HttpServletResponse response,Publicize publicize){
		String roleIdStr=request.getParameter("roleIdStr");
		Map<String,Object>  resultMap = new HashMap<String,Object>();			
		String pubId=UUIDUtil.getUUID();
		publicize.setId_(pubId);
		publicize.setIsdel("1");
		publicize.setThcontent("XXXX");
		publicize.setAttchid("XXXX");
		publicize.setImageid("XXXX");
		publicize.setFabutime(DateUtil.getCurrentDateStr());
		publicize.setStatus("1");
		publicize.setRemark("XXXX");		
		RERecord rERecord=new RERecord();	
		if(!"".equals(roleIdStr)&&null!=roleIdStr){
			rERecord.setId_("R_"+UUIDUtil.getUUID());//此处是以角色来进行划分，故明明方式为R_Id方式
		}		
		rERecord.setDeptid("");
		rERecord.setRoleid(roleIdStr);
		rERecord.setLevel(publicize.getLevel());
		rERecord.setReceivemember("");
		rERecord.setPubid(pubId);
		rERecord.setPubtitle(publicize.getTitle());
		rERecord.setIsdel("1");
		rERecord.setIsshow("1");
		rERecord.setRemark("XXXX");		
		rERecord.setReceivetime(DateUtil.getCurrentDateStr());
		SERecord seRecord=new SERecord();	
		if(!"".equals(roleIdStr)&&null!=roleIdStr){
			seRecord.setId_("R_"+UUIDUtil.getUUID());//此处是以角色来进行划分，故明明方式为R_Id方式
		}
		seRecord.setDeptid("XXXX");
		seRecord.setSendtime(DateUtil.getCurrentDateStr());
		seRecord.setRoleid("XXXX");
		seRecord.setLevel(publicize.getLevel());
		seRecord.setSendmember("XXXX");
		seRecord.setPubid(pubId);
		seRecord.setPubtitle(publicize.getTitle());
		seRecord.setIsdel("1");
		seRecord.setIsshow("XXXX");
		seRecord.setRemark("XXXX");			
		try {
			publicizeManagerService.addPublicize(publicize);
			rERecordManagerService.addRERecord(rERecord);
			sERecordManagerService.addSERecord(seRecord);
			resultMap.put("flag", "true");
		} catch (Exception e) {
			System.out.println("===========================================天假公告失败，失败原因："+e.getMessage());
			resultMap.put("flag", "false");
		}
		return resultMap;
	}
	@RequestMapping(value="/updatPublicize.do")
	@ResponseBody
	public Map<String,Object> updatPublicize(HttpServletRequest request,HttpServletResponse response,Publicize publicize){
		String roleIdStr=request.getParameter("roleIdStr");
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		try {
			//���ռ�¼��
			RERecord rERecord=new RERecord();
			rERecord.setPubid(publicize.getId_());
			List<RERecord>	reList=	rERecordManagerService.getList(rERecord);
			for (RERecord reRecord2 : reList) {			
				reRecord2.setId_(reRecord2.getId_());
				reRecord2.setDeptid("");
				reRecord2.setRoleid(roleIdStr);
				reRecord2.setLevel(publicize.getLevel());
				reRecord2.setReceivemember("");
				reRecord2.setPubtitle(publicize.getTitle());
				reRecord2.setIsdel("1");
				reRecord2.setIsshow("");
				reRecord2.setRemark("");	
				rERecordManagerService.updateRERecord(reRecord2);
			}
			SERecord seRecord=new SERecord();
			seRecord.setPubid(publicize.getId_());
		    List<SERecord> seList=sERecordManagerService.getList(seRecord);
		    for (SERecord seRecord2 : seList) {		    	
		    	seRecord2.setId_(seRecord2.getId_());
		    	seRecord2.setDeptid("");
		    	seRecord2.setRoleid(roleIdStr);
		    	seRecord2.setLevel(publicize.getLevel());
		    	seRecord2.setSendmember("");	
		    	seRecord2.setPubtitle(publicize.getTitle());
		    	seRecord2.setIsdel("1");
		    	seRecord2.setIsshow("");
		    	seRecord2.setRemark("");		
				sERecordManagerService.updateSERecord(seRecord2);
			}				
			publicizeManagerService.updatePublicize(publicize);	
			resultMap.put("flag", "true");
		} catch (Exception e) {
			System.out.println("公告删除失败，失败原因："+e.getMessage());
			resultMap.put("flag", "false");			
		}
		
		return resultMap;
	}	
	@RequestMapping(value="/deletePublicize.do")
	@ResponseBody
	public Map<String,Object> deletePublicize(HttpServletRequest request,HttpServletResponse response,Publicize pub){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		publicizeManagerServiceImpl.removePublicize(pub, false);
		resultMap.put("flag", "true");
		return resultMap;
	}
	@RequestMapping(value = "/getComboboxData")  
    @ResponseBody  
    public String getComboboxData(HttpServletRequest request,Role role) {            
		 String data ;  	     
	       JsonArray array = new JsonArray();  	        
	       try{  
            List<Role> resultList = roleManagerService.getList(role);  
            if(!resultList.isEmpty()){              
                for(Role lb : resultList){  
                	JsonObject json = new JsonObject();  
                	json.addProperty("id__", lb.getId_());
                	json.addProperty("name_", lb.getName());
         	        array.add(json);
                }  
            }  
            data =  array.toString();  
        } catch (Exception e) {  
            data = "{}" ;  
        }          
        return data;  
    } 
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding( "utf-8" );
		response.setHeader("Content-Type" , "text/html");
		String realPath = request.getSession().getServletContext().getRealPath("/");
		String configStr = new ActionEnter(request, realPath).exec();
		System.out.println(realPath);
		response.getWriter().write(configStr);
	}
	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}*/
}
