package com.gp.project.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @time 2020/2/17 11:00
 * @Author gp
 */
public class DateUtils {

	/**
	 * 将时间转换为时间戳
	 * @param s
	 * @return
	 * @throws ParseException
	 */
	public static String dateToStamp(String s) throws ParseException {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = simpleDateFormat.parse(s);
		long ts = date.getTime();
		res = String.valueOf(ts);
		return res;
	}

	/**
	 * 时间戳转为时间
	 * @param s
	 * @return
	 */
	public static String stampToDate(String s){
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long lt = new Long(s);
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}

	/**
	 * 时间戳转为Date类型
	 * @param date
	 * @return
	 */
	public static Date stampToSQLDate(long date) throws ParseException {
		SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d = format.format(date);
		Date redate=format.parse(d);
		return redate;
	}


}
