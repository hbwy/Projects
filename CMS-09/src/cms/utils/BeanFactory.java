package cms.utils;

import cms.backend.dao.ArticleDao;

public interface BeanFactory {
	//������Dao�����ͣ�ͨ��nameȡ��Dao��Ӧ��Dao����
	Object getBean(String name);
}
