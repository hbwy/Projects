package cms.utils;

import cms.backend.dao.ArticleDao;

public interface BeanFactory {
	//隐藏了Dao的类型，通过name取得Dao对应的Dao对象
	Object getBean(String name);
}
