package cms.utils;

import javax.servlet.http.HttpServletRequest;

import cms.model.PageModel;

public class SystemContext {
	private static ThreadLocal threadLocal = new ThreadLocal();
	public static void setLocal(HttpServletRequest request){
		PageModel pm = new PageModel();
		if(request.getParameter("pageNo")!=null){
			pm.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
		}else{
			pm.setPageNo(1);
		}
		if(request.getParameter("pageSize")!=null){
			pm.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
		}else{
			pm.setPageSize(10);
		}
		threadLocal.set(pm);
	}
	public static PageModel getPM(){
		return (PageModel)threadLocal.get();
	}
	public static void removePM(){
		threadLocal.remove();
	}
}
