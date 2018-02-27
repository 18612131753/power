package com.ray.base.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 网络工具包，可用于向服务器发送get或post请求
 * 
 * @author yanweixin
 * @date 2014-5-5
 */
public class WebUtils {
	
	private static Log logger = LogFactory.getLog(WebUtils.class);
	
	public static String get(String path , String code ) throws Exception {
		logger.info( "请求链接："+path );
		//http://blog.csdn.net/woxueliuyun/article/details/43267365
		HttpURLConnection httpConn = null;
		BufferedReader in = null;
		try {
			URL url = new URL(path);
			httpConn = (HttpURLConnection) url.openConnection();
			// 设定请求的方法为"POST"，默认是GET    
			//httpConn.setRequestMethod("POST"); 
			httpConn.setConnectTimeout(60000); //设置连接主机超时
			httpConn.setReadTimeout(60000);  //设置从主机读取数据超时
			System.out.println( "== conn：" + httpConn.getContentEncoding()+" " +  httpConn.getResponseCode() );
			// 读取响应
			if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				StringBuffer content = new StringBuffer();
				String tempStr = "";
				in = new BufferedReader(new InputStreamReader(
					httpConn.getInputStream(), code ));
				while ((tempStr = in.readLine()) != null) {
					content.append(tempStr);
				}
				return content.toString();
			} else {
				throw new Exception("请求出现了问题!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		    if( in != null )  in.close();
			httpConn.disconnect();
		}
		return null;
	}

	/**
	 * 向远程的url服务器进行post一个数据包
	 * 
	 * @param url
	 *            需要进行post的服务器
	 * @return
	 * @throws Exception
	 */
	public static String postString(String url) throws Exception {
		return postString(url, null);
	}

	/**
	 * 向远程的url服务器进行post一个数据包
	 * 
	 * @param url
	 *            需要进行post的服务器
	 * @param paras
	 *            数据包中的参数
	 * @return
	 * @throws Exception
	 */
	public static String postString(String url, List<NameValuePair> paras)
			throws Exception {
		return postString(url, paras, "UTF-8", "UTF-8");
	}

	/**
	 * 向远程的url服务器进行post一个数据包
	 * 
	 * @param url
	 *            需要进行post的服务器
	 * @param paras
	 *            数据包中的参数
	 * @return
	 * @throws Exception
	 */
	public static String postString(String url, List<NameValuePair> paras,
			String uploadEncoding, String responseEncoding) throws Exception {
		RequestConfig config = RequestConfig.custom().build();
		HttpClient client = HttpClients.custom()
				.setDefaultRequestConfig(config).build();
		HttpClientContext context = HttpClientContext.create();
		HttpPost post = new HttpPost(url);
		if (paras != null) {
			post.setEntity(new UrlEncodedFormEntity(paras, uploadEncoding));
		}
		CloseableHttpResponse response = (CloseableHttpResponse) client
				.execute(post, context);
		return EntityUtils.toString(response.getEntity(), responseEncoding);
	}

	public static String postData(String url, String data,
			String uploadEncoding, String responseEncoding) throws Exception {
		RequestConfig config = RequestConfig.custom().build();
		HttpClient client = HttpClients.custom()
				.setDefaultRequestConfig(config).build();
		HttpClientContext context = HttpClientContext.create();
		HttpPost post = new HttpPost(url);
		if (StringUtils.isNotBlank(data)) {
			post.setEntity(new StringEntity(data, uploadEncoding));
		}
		CloseableHttpResponse response = (CloseableHttpResponse) client
				.execute(post, context);
		return EntityUtils.toString(response.getEntity(), responseEncoding);
	}

}
