package com.gp.project;

import com.alibaba.fastjson.JSON;
import com.gp.project.utils.CommonUtils;
import com.gp.project.utils.MD5;
import com.gp.project.pojo.Socket.Message;
import com.gp.project.pojo.vo.ResumeVo;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	/*	String filePath = "C:\\Users\\Gp\\Desktop\\java.pdf";
		String[] split = filePath.split("\\.");
		System.out.println(split.length);
		String a="."+filePath;
		System.out.println(a);
//		System.out.println(split[0]);*/
			String filePath = "C:\\Users\\Gp\\Pictures\\DSC_2189.jpg";
		Boolean picture = CommonUtils.isPicture(filePath);
		System.out.println(picture);
		String a="{\"status\":1,\"data\":{\n" +
				"\"手机号码\":\"16623033219\",\n" +
				"\"邮箱\":\"1292405328@qq.com\",\n" +
				"\"QQ号\":\"1292405328\",\"年龄\":\"21岁\",\n" +
				"\"姓名\":\"龚平\",\"出生年月\":\"2016.9\",\n" +
				"\"自我评价\":[\"骑行\",\"音乐\",\"游戏\",\"1．对软件开发工作有的兴趣；\"\n" +
				",\"2．具有一定的团队精神和沟通能力；\",\"3．在工作上认真负责、积极向上、吃苦耐劳和良好的职业素养；\",\n" +
				"\"4．性格随和，有一定的学习能力，善于思考\",\"5\\. 时刻保持良好的心态，踏实做事，能够很快适应新的环境。\",\n" +
				"\"**个人技能表**---\",\"**云计算虚拟化**|\",\"1） 虚拟云平台搭建\",\"2） 虚拟资源池配置，AD域控制器、DNS服务器、DHCP服务器的搭建\",\"3）\n" +
				" 虚拟桌面部署，View Connection Server、View Composer的安装与配置，模板计算机的配置****|\",\"**Windows系统**|\",\"1） 电脑蓝屏、黑屏\",\"2） 网络不能连接\",\"3）\n" +
				" 软件安装故障（CAD、PS、MySQL、3DMax等）\",\"4） 系统崩溃（修复与安装）\",\"5） 硬件损坏（检测与安装）\",\"6） 打印机维护****|\",\"**Linux系统**|\",\"1） 基本命令的使用\",\"2）\n" +
				" 光驱挂载，IP地址的配置\",\"3） DHCP服务器的搭建\",\"4） Yum仓库搭建\",\"5） MySQL、Oracle数据库的安装****|\",\"**双系统、三系统**|\",\"1） Windows系统与Windows系统\",\"2）\n" +
				" Windows系统与Linux系统\",\"3） Windows系统与Mac系统****|\",\"**网络方面**|\",\"1） 思科模拟器、H3C Cloud的使用，交换、路由的配置\",\"2）\n" +
				" 综合布线，网线 、光纤故障排查，熔接光纤、制作网线****|\",\"**专业软件**|\",\"Office、LabView、CAD、Protel、Visio、Eclipse、VC6****|\",\"**证书**|\",\"CET-4****|\",\"**自我定位**|\",\"1个桌面工程师，1/2个系统工程师，1/3个网络工程师\",\"文学\"],\"毕业院校\":\"重庆理工大学\",\"最高学历\":\"本科\",\"所学专业\":\"软件工程\",\"教育经历\":[{\"时间\":\"2016.9～2020.7\",\"学历\":\"本科\",\"毕业院校\":\"重庆理工大学\",\"专业\":\"软件工程\",\"批次\":\"2A,重点二本\",\"学校全国排名\":102}],\"工作经历\":[{\"企业名称\":\"(未被识别的公司名称)\",\"时间\":\"2019.6～2019.6\",\"工作描述\":[\"\"]},{\"企业名称\":\"重庆锦禹云科技能源有限公司\",\"时间\":\"2019.6～2019.9\",\"职位名称\":\"实习\",\"工作描述\":[\"Office\"]}],\"关键词\":[\"系统工程\",\"网络工程\",\"软件工程\",\"程序设\",\"安装）\"]}}\n";
		a.replace(".","");
		a.replace("\\","");
		String replace = "a.1".replace(".", "");
		System.out.println(replace);


		ResumeVo resumeVo=JSON.parseObject(a,ResumeVo.class);

		System.out.println(resumeVo.toString());
	}

}
