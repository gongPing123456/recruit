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
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * @time 2020/2/18 14:14
 * @Author gp
 */
public class CommonUtils {


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


}
