package com.gp.project.utils;

import com.gp.project.common.Constants;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.net.ssl.SSLContext;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

/**
 * @time 2020/2/18 14:14
 * @Author gp
 */
public class CommonUtils {
	/**
	 * 单位缩进字符串。
	 */
	private static String SPACE = " ";

	/**
	 * 简历解析
	 * 山卡拉
	 * 一级父字段	二级父字段	字段名	属性	备注
	 * 姓名	-	-	string	姓名
	 * 性别	-	-	string	性别
	 * 邮箱	-	-	string	邮箱
	 * 手机号码	-	-	string	手机号码
	 * 出生年月	-	-	string	出生年月
	 * 年龄	-	-	string	年龄
	 * 地址	-	-	string	地址
	 * 籍贯	-	-	string	籍贯
	 * 出生地	-	-	string	出生地
	 * 现居住在	-	-	string	现居住城市
	 * 工作经历	-	-	object	工作经历
	 * 工作经历	-	时间	string	工作时间区间
	 * 工作经历	-	公司名称	string	公司名称
	 * 工作经历	-	职位名称	string	职位名称
	 * 工作经历	-	工作描述	object	工作描述
	 * 教育经历	-	-	object	教育经历
	 * 教育经历	-	时间	string	教育时间区间
	 * 教育经历	-	学校名称	string	学校名称
	 * 教育经历	-	专业	string	专业
	 */
	public static String uploadResumeFile(String url, String filePath) throws Exception {
		File f = new File(filePath);
		HttpPost httpPost = new HttpPost(url);
		HttpEntity req = MultipartEntityBuilder.create()
				.addPart("resume", new FileBody(f))
				.setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
				.build();
		httpPost.setEntity(req);
		SSLContext sslContext = SSLContexts.custom()
				.loadTrustMaterial(null, new TrustSelfSignedStrategy())
				.build();
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
		ConnectionSocketFactory plainSF = new PlainConnectionSocketFactory();
		Registry<ConnectionSocketFactory> r = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("https", sslsf)
				.register("http", plainSF)
				.build();
		HttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(r);
		CloseableHttpClient httpClient = org.apache.http.impl.client.HttpClients.custom()
				.disableCookieManagement()
				.setRedirectStrategy(new DefaultRedirectStrategy())
				.setConnectionManager(cm)
				.build();
		CloseableHttpResponse response = httpClient.execute(httpPost);
		String result = "";
		try {
			HttpEntity responseEntity = response.getEntity();
			if (responseEntity != null) {
				result = EntityUtils.toString(responseEntity, "utf-8");
			}
		} finally {
			response.close();
		}
		return decodeUnicode(result);
	}

	/**
	 * json格式Unicode转中文
	 */
	public static String decodeUnicode(String theString) {
		char aChar;
		int len = theString.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len; ) {
			aChar = theString.charAt(x++);
			if (aChar == '\\') {
				aChar = theString.charAt(x++);
				if (aChar == 'u') {
					// Read the xxxx
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = theString.charAt(x++);
						switch (aChar) {
							case '0':
							case '1':
							case '2':
							case '3':
							case '4':
							case '5':
							case '6':
							case '7':
							case '8':
							case '9':
								value = (value << 4) + aChar - '0';
								break;
							case 'a':
							case 'b':
							case 'c':
							case 'd':
							case 'e':
							case 'f':
								value = (value << 4) + 10 + aChar - 'a';
								break;
							case 'A':
							case 'B':
							case 'C':
							case 'D':
							case 'E':
							case 'F':
								value = (value << 4) + 10 + aChar - 'A';
								break;
							default:
								throw new IllegalArgumentException(
										"Malformed   \\uxxxx   encoding.");
						}

					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't') {
						aChar = '\t';
					} else if (aChar == 'r') {
						aChar = '\r';
					} else if (aChar == 'n') {
						aChar = '\n';
					} else if (aChar == 'f') {
						aChar = '\f';
					}
					outBuffer.append(aChar);
				}
			} else {
				outBuffer.append(aChar);
			}
		}
		return outBuffer.toString();
	}

	/**
	 * 接收文件
	 */
	public static void receiveFile(MultipartFile file, String finalPath) throws Exception {
		File path = new File(Constants.RESUME_PATH);
		if (!path.exists() || !path.isDirectory()) {
			path.mkdir();
		}
		File resume = new File(finalPath);
		file.transferTo(resume);
	}

	/**
	 * 删除文件
	 */
	public static void deleteFile(String finalPath) {
		File file1 = new File(finalPath);
		if (file1.exists()) {
			file1.delete();
		}
	}

	/**
	 * 判断是否为图片
	 * true  是图片
	 * false  不是图片
	 *
	 * @param filePath
	 */
	public static Boolean isPicture(String filePath) throws IOException {
		Boolean result;
		File file = new File(filePath);
		ImageInputStream iis = null;
		try {
			iis = ImageIO.createImageInputStream(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Iterator iter = ImageIO.getImageReaders(iis);
		if (!iter.hasNext()) {//文件不是图片
			System.out.println("此文件不为图片文件");
			result = false;
		} else {
			System.out.println("是");
			result = true;
		}

		BufferedImage bi = ImageIO.read(file);

		if (bi == null) {
			System.out.println("此文件不为图片文件");
			result = false;
		} else {
			result = true;
			System.out.println("是");
		}
		return result;
	}
	//获取文件的后缀
	public static String  fileExtension(MultipartFile file){
		String extension=file.getOriginalFilename();
		String[] split = extension.split("\\.");
		return split[1];

	}

	/**
	 * 将json数据写入json文件
	 * @param json
	 * @param path
	 */
	public static void  jsonFile(String json,String path) throws IOException {
		File file= new File(path);
		//父目录不存在 创建父目录
		if (!file.getParentFile().isDirectory())
		{
			file.getParentFile().mkdirs();
		}
		//如果文件存在 删掉旧文件
		if (file.exists()){
			deleteFile(path);
		}
		//创建文件
		file.createNewFile();
		if(json.indexOf("'")!=-1){
			//将单引号转义一下，因为JSON串中的字符串类型可以单引号引起来的
			json = json.replaceAll("'", "\\'");
		}
		if(json.indexOf("\"")!=-1){
			//将双引号转义一下，因为JSON串中的字符串类型可以单引号引起来的
			json = json.replaceAll("\"", "\\\"");
		}

		if(json.indexOf("\r\n")!=-1){
			//将回车换行转换一下，因为JSON串中字符串不能出现显式的回车换行
			json = json.replaceAll("\r\n", "\\u000d\\u000a");
		}
		if(json.indexOf("\n")!=-1){
			//将换行转换一下，因为JSON串中字符串不能出现显式的换行
			json = json.replaceAll("\n", "\\u000a");
		}

		// 格式化json字符串
		json = formatJson(json);

		// 将格式化后的字符串写入文件
		Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
		write.write(json);
		write.flush();
		write.close();

	}
	/**
	 * 返回格式化JSON字符串。
	 *
	 * @param json 未格式化的JSON字符串。
	 * @return 格式化的JSON字符串。
	 */
	public static String formatJson(String json) {
		StringBuffer result = new StringBuffer();

		int length = json.length();
		int number = 0;
		char key = 0;

		// 遍历输入字符串。
		for (int i = 0; i < length; i++) {
			// 1、获取当前字符。
			key = json.charAt(i);

			// 2、如果当前字符是前方括号、前花括号做如下处理：
			if ((key == '[') || (key == '{')) {
				// （1）如果前面还有字符，并且字符为“：”，打印：换行和缩进字符字符串。
				if ((i - 1 > 0) && (json.charAt(i - 1) == ':')) {
					result.append('\n');
					result.append(indent(number));
				}

				// （2）打印：当前字符。
				result.append(key);

				// （3）前方括号、前花括号，的后面必须换行。打印：换行。
				result.append('\n');

				// （4）每出现一次前方括号、前花括号；缩进次数增加一次。打印：新行缩进。
				number++;
				result.append(indent(number));

				// （5）进行下一次循环。
				continue;
			}

			// 3、如果当前字符是后方括号、后花括号做如下处理：
			if ((key == ']') || (key == '}')) {
				// （1）后方括号、后花括号，的前面必须换行。打印：换行。
				result.append('\n');

				// （2）每出现一次后方括号、后花括号；缩进次数减少一次。打印：缩进。
				number--;
				result.append(indent(number));

				// （3）打印：当前字符。
				result.append(key);

				// （4）如果当前字符后面还有字符，并且字符不为“，”，打印：换行。
				if (((i + 1) < length) && (json.charAt(i + 1) != ',')) {
					result.append('\n');
				}

				// （5）继续下一次循环。
				continue;
			}

			// 4、如果当前字符是逗号。逗号后面换行，并缩进，不改变缩进次数。
        /*if ((key == ',')) {
            result.append(key);
            result.append('\n');
            result.append(indent(number));
            continue;
        }*/

			// 5、打印：当前字符。
			result.append(key);
		}

		return result.toString();
	}

	/**
	 * 返回指定次数的缩进字符串。每一次缩进三个空格，即SPACE。
	 *
	 * @param number 缩进次数。
	 * @return 指定缩进次数的字符串。
	 */
	private static String indent(int number) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < number; i++) {
			result.append(SPACE);
		}
		return result.toString();
	}

}
