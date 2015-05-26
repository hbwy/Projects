package cms.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class PropertyBeanFactoryImpl implements BeanFactory {
	
	Map<String, Object> beans = new HashMap<String,Object>();
	//���صĹ��췽����Ϊ�û��ṩ���ֲ���PropertyBeanFactoryImplʵ���ķ�ʽ
	public PropertyBeanFactoryImpl(){
		this("beans.properties");
	}
	public PropertyBeanFactoryImpl(String ConfigurationFile) {
		try {
			// ��ȡ�����ļ��������ļ�Ӧ����Src��Ŀ¼
			Properties props = new Properties();
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(ConfigurationFile));
			Set set = props.entrySet();
			for (Iterator iterator = set.iterator(); iterator.hasNext();) {
				Map.Entry entry = (Map.Entry) iterator.next();
				String key = (String)entry.getKey();	//ȡ��ÿ��entry�ļ�ֵ��
				String classname = (String)entry.getValue();
				Class clz = Class.forName(classname);	//ȡ��������
				Object bean = clz.newInstance();
				beans.put(key, bean);		//����ʵ�������ŵ�Map��
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object getBean(String name) {
		return beans.get(name);
	}
}
