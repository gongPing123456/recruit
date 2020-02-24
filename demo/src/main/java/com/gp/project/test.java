package com.gp.project;

import com.alibaba.fastjson.JSON;
import com.gp.project.common.Constants;
import com.gp.project.pojo.UserInfo;
import com.gp.project.pojo.UserResumeInfo;
import com.gp.project.utils.CommonUtils;
import com.gp.project.utils.MD5;
import com.gp.project.pojo.Socket.Message;
import com.gp.project.pojo.vo.ResumeVo;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @time 2019/11/11 16:10
 * @Author gp
 */
public class test {


	@Test
	public void  text(){
		System.out.println(System.currentTimeMillis());
		Long date=System.currentTimeMillis();
		String time=stampToDate(String.valueOf(date));
		System.out.println(time);
		String aa = MD5.MD5Lower("aa", "123");
		System.out.println(aa);
		System.out.println(MD5.valid("aa","123",aa));
	}
	public void  a(Object... a){
		String s = String.format("第一个参数： 第二个参数：",a );
		System.out.println(s);
	}

@Test
public  void aVoid() throws Exception {
	Message message=new Message();
	message.setName("1");
	System.out.println(message.toString());
}
	/*
	 * 将时间转换为时间戳
	 */
	public static String dateToStamp(String s) throws ParseException {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = simpleDateFormat.parse(s);
		long ts = date.getTime();
		res = String.valueOf(ts);

		return res;
	}

	/*
	 * 将时间戳转换为时间
	 */
	public static String stampToDate(String s){
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long lt = new Long(s);
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}

	@Test
	public void a() throws IOException {
		Map<String ,String> a=new HashMap<>();
		a.put("1","1");
		a.put("2","2");
	String a1=(String.valueOf(a));
	CommonUtils.jsonFile(a1, Constants.RESUME_PATH+"a.json");

	}

}
