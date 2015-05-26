package cms.backend.servlet;

import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.beanutils.ConvertUtils;

import cms.model.Channel;
import cms.utils.BeanFactory;
import cms.utils.ChannelsSetConverter;
import cms.utils.PropertyBeanFactoryImpl;

public class InitBeanFactoryServlet extends HttpServlet {

	public static final String INIT_FACTORY_NAME = "_my_bean_factory";
	
	//服务器启动时就初始化BeanFactory
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		BeanFactory beanFactory = null;
		String ConfigurationFile = config.getInitParameter("configureLocation");
		if (ConfigurationFile == null) { // 如果读取配置文件位置为空，调用无参构造方法
			beanFactory = new PropertyBeanFactoryImpl();
		} else { // 调用有参构造方法
			beanFactory = new PropertyBeanFactoryImpl(ConfigurationFile);
		}
		// 把beanFactory放到ServletContext中
		// 如果重写init(ServletConfig)方法，必须通过config.getServletContext()来获得ServletContext对象
		config.getServletContext().setAttribute(INIT_FACTORY_NAME, beanFactory);
		
		//初始化类型转换器
		ConvertUtils.register(new ChannelsSetConverter(), Channel.class);
	}

}