package com.gp.project;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.gp.project.Utils.CommonUtils;
import com.gp.project.Utils.DateUtils;
import com.gp.project.Utils.MD5;
import com.gp.project.mapper.UserInfoDAO;
import com.gp.project.pojo.vo.ResumeVo;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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
	String s = CommonUtils.uploadFile("http://cv-extract.com/api/extract",
			"C:\\Users\\Gp\\Desktop\\java.pdf"
	);
	System.out.println(s);
	ResumeVo resumeVo= JSON.parseObject(s,ResumeVo.class);
	resumeVo.toString();
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

}
