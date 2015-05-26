package cms.utils;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.beanutils.Converter;

import cms.model.Channel;

public class ChannelsSetConverter implements Converter {
	//定义类型转化器，把字符串数组装化成channel.id，并放到Channel对象中
	//返回Channel对象的集合
	//targetClass是目标类型,value是要转换的值
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
