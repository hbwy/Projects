package cms.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
	public static String format(Date date,String pattern){
		return new SimpleDateFormat(pattern).format(date);
	}
}
