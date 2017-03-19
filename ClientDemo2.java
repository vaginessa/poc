package httpjson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.junit.Test;

import sun.misc.BASE64Encoder;


public class ClientDemo2 {
	static String para = "{\"ProductId\":\"10075\"}";

	
	@Test
	public void test() throws UnsupportedEncodingException{
		String url = "http://testproductsvc.baosm.com/Services/api" ;
		doPostClient(url);
	}
	public static void doPostClient(String url) throws UnsupportedEncodingException{
		
//		  partnercode���̻��ţ��̶�ֵ��ÿ���̻������һ��key���ӿڼ����� 
//		  version���ӿڰ汾�ţ��̶�ֵ��Ŀǰȡֵ1.0 
//		  action���ӿ����� 
//		  source���ӿڵ��÷�����Դ ��1:���ԣ�2:�ͻ��ˣ���׿��IOS��H5���� 
//		  req��jsonҵ�������ַ��� 
//		  reqhash������ǩ�� UrlEncode(ToBase64String(md5(req�ڵ�json+key)))
		
		HttpClient httpClient = new HttpClient();
		PostMethod postMethod = new PostMethod(url);
		postMethod.setParameter("partnercode", "1143988");
		postMethod.setParameter("version", "1.0");
		postMethod.setParameter("action", "getproductmobile");
		postMethod.setParameter("source", "1");
		postMethod.setParameter("req", para);
		
		postMethod.setParameter("reqhash", encode(para, "id$339@jIDDV0"));
		
		HttpClientParams params = new HttpClientParams();
		params.setConnectionManagerTimeout(10000L);
		httpClient.setParams(params);
		try {
			httpClient.executeMethod(postMethod);
			//��ȡ�����Ƶ�byte��
			byte[] b = postMethod.getResponseBody();
			String str = new String(b,"UTF8");
			System.out.println(str);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			postMethod.releaseConnection();
		}
	}
	

	@SuppressWarnings("deprecation")
	public static String encode(String s, String key) {
		String retStr = "";
		try {
			System.out.println();
			retStr = URLEncoder.encode(new BASE64Encoder().encode(Coder.encryptHMAC(s, key)));
		} catch (Exception e) {
		}
		System.out.println(retStr);
		return retStr;
	}
}

