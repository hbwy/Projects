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
	
	//����������ʱ�ͳ�ʼ��BeanFactory
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		BeanFactory beanFactory = null;
		String ConfigurationFile = config.getInitParameter("configureLocation");
		if (ConfigurationFile == null) { // �����ȡ�����ļ�λ��Ϊ�գ������޲ι��췽��
			beanFactory = new PropertyBeanFactoryImpl();
		} else { // �����вι��췽��
			beanFactory = new PropertyBeanFactoryImpl(ConfigurationFile);
		}
		// ��beanFactory�ŵ�ServletContext��
		// �����дinit(ServletConfig)����������ͨ��config.getServletContext()�����ServletContext����
		config.getServletContext().setAttribute(INIT_FACTORY_NAME, beanFactory);
		
		//��ʼ������ת����
		ConvertUtils.register(new ChannelsSetConverter(), Channel.class);
	}

}