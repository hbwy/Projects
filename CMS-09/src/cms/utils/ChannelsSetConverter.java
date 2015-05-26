package cms.utils;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.beanutils.Converter;

import cms.model.Channel;

public class ChannelsSetConverter implements Converter {
	//��������ת���������ַ�������װ����channel.id�����ŵ�Channel������
	//����Channel����ļ���
	//targetClass��Ŀ������,value��Ҫת����ֵ
	public Object convert(Class targetClass, Object value) {
		String[] channelIds = null;
		if(value instanceof String){
			channelIds = new String[]{(String)value};
		}
		if(value instanceof String[]){
			channelIds = (String[]) value;
		}
		if(channelIds != null){
		Channel channel = null;
			for(String channelId:channelIds){
				channel = new Channel();
				channel.setId(channelId);
			}
			return channel;
		}
		return null;
	}

}
