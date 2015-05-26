package cms.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class RequestUtil {
	public static Object copyParam(Class entityClass, HttpServletRequest request) {
		try {
			// ����ʵ�����ʵ��
			Object entity = entityClass.newInstance();
			// ȡ���������
			Map allParams = request.getParameterMap();
			Set entries = allParams.entrySet();
			for (Iterator iterator = entries.iterator(); iterator.hasNext();) {
				Map.Entry entry = (Map.Entry) iterator.next();
				String name = (String) entry.getKey();
				Object[] value = (Object[]) entry.getValue();
				if (value != null) {
					if (value.length == 1) {
						// entity�����Է��뵽�ĸ�ʵ�����У�name����������value������ֵ
						//BeanUtils.copyProperty�ǰ����ԷŽ�ʵ��ķ���
						BeanUtils.copyProperty(entity, name, value[0]);
					} else {
						BeanUtils.copyProperty(entity, name, value);
					}
				}
			}
			return entity;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

}
