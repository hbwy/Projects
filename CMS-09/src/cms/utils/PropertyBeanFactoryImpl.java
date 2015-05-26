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
	//重载的构造方法，为用户提供两种产生PropertyBeanFactoryImpl实例的方式
	public PropertyBeanFactoryImpl(){
		this("beans.properties");
	}
	public PropertyBeanFactoryImpl(String ConfigurationFile) {
		try {
			// 读取配置文件，配置文件应放在Src根目录
			Properties props = new Properties();
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(ConfigurationFile));
			Set set = props.entrySet();
			for (Iterator iterator = set.iterator(); iterator.hasNext();) {
				Map.Entry entry = (Map.Entry) iterator.next();
				String key = (String)entry.getKey();	//取得每个entry的键值对
				String classname = (String)entry.getValue();
				Class clz = Class.forName(classname);	//取得类类型
				Object bean = clz.newInstance();
				beans.put(key, bean);		//产生实例，并放到Map中
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object getBean(String name) {
		return beans.get(name);
	}
}
