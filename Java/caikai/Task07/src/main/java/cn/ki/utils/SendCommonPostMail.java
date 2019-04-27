package cn.ki.utils; /**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SendCommonPostMail
 * Author:   Kawthy
 * Date:     2019/4/20 17:22
 * Description: 邮箱工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 〈一句话功能简述〉<br>
 * 〈邮箱工具类〉
 *
 * @author Kawthy
 * @create 2019/4/20
 * @since 1.0.0
 */
public class SendCommonPostMail {


	public static void SendMail(String rcpt_to) throws IOException {
		final String url = "http://api.sendcloud.net/apiv2/mail/send";
		final String apiUser = "kawthy_test_A3PAVa";
		final String apiKey = "mXNMa93PL8tVJGe1";
//		final String rcpt_to = "kawthy@163.com";

		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);

		List params = new ArrayList();
		// 您需要登录SendCloud创建API_USER，使用API_USER和API_KEY才可以进行邮件的发送。
		params.add(new BasicNameValuePair("apiUser", apiUser));
		params.add(new BasicNameValuePair("apiKey", apiKey));
		params.add(new BasicNameValuePair("from", "service@sendcloud.im"));
		params.add(new BasicNameValuePair("fromName", "SendCloud"));
		params.add(new BasicNameValuePair("to", rcpt_to));
		params.add(new BasicNameValuePair("subject", "来自SendCloud的第一封邮件！"));
		params.add(new BasicNameValuePair("html", "你太棒了！你已成功的从SendCloud发送了一封测试邮件，接下来快登录前台去完善账户信息吧！"));

		httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		// 请求
		HttpResponse response = httpclient.execute(httpPost);
		// 处理响应
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 正常返回
			// 读取xml文档
			String result = EntityUtils.toString(response.getEntity());
			System.out.println(result);
		} else {
			System.err.println("error");
		}
		httpPost.releaseConnection();
	}
}