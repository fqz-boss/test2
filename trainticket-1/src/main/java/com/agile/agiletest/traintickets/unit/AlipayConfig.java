package com.agile.agiletest.traintickets.unit;

import org.springframework.context.annotation.Configuration;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
@Configuration
public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101200669606";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDK+jzZeU7yG8I9H0YxhpdoV/i7ztJh9EWFdBo7Joq8NSBMpJGDJPEjbK6MaoknfKiGZndrJbt05dlERgKi2MPYwEcg80lzpZOAo8dh062pAuLyQuh3J2R/weG9Y4UHod+K7EMy1YYjnQriHsy1K5dMbIbXhNkcqeKw6v/N8RRkx10pa2u5z3C5yTnh6WSaLNwfS7p2iJYG119o564D0tp+GUpnEtzAZMUd09ejXIMm+HbqbNn881qJUtiliI4qDZtSRvivUStbQ4rUOT+9HsZUiWNAdvouyTW3yTU4o4B+kf6WNQ5OrAiYxZ6Vjv2jkHBKMv1Fb2nCk8XUcuIKaMB3AgMBAAECggEBAJPraQzTasTlldgVQoI1I4HXGl1Di+32pfNrePJCVDh0PuWbyK9Z7KF0Qn/x46HzJp1LbxuWk9XM61jl7GXgsljzRuKsaYrtz2Cf+l1Adf4FLH6AZAjxnDu+f1QVgozdWptTMmWJVgf+GkBPUb911PzM2jeViONqqtljaKgcWFBX69Y0sUm0dc8rVuLt7Hx250Rabtxx2FQCeZh9ddWMue00XudMRWNGmTlzyPSOyUgkGztAL2YJDwy/6nTQTbiD/AUPObPpmHKb4MZDx6tECWafXwdqbPA5NOne/kXCq7UVpQrX10uOmy7ri4biceF4I+BxJbRA6UjxXVRp3oC4vQECgYEA+ebt+OQ1yFGycLf12DdynUz4bXxx8QdBpPQ3VsfwrNR6ZzkiNTe4Dezn7OOAaYTE/QvtHHdyb8iHDufeKfP0W2aKPh4wzMOOx4yj4wYP+erANvRX7CPCooQsDdXsmpVzXwskS1YHL1NM1b5dQ6W8CjQrH4CIiWcGdRU1Uf9JSA8CgYEAz+4u2av5iuKNGueLsYz9doGzKmC98N3Si+n5P2A7oY9NAWQU8xe/WECL2blM45D6FUYJ2JbIPm0DEOXqhyeuc5ZCAoEoMYCG8pvc/BD1pSmsq3I8Gtmt9IZwbZls9pe5Xp5g8BBeUOw+PR7875Jm2hOERjLQP5Yn/ygA09MU2RkCgYAU426kzT6JnfqSXW4ZQpk7+METNcG4aejcxuURRekiKSiKFEZ9uEiUMWc5b9K9/zEQDb0mEf3oxhQz9MGnNBMKyMlpY9CkbPw0Rdc1FL6lHzAt58KppFuShgXAqk76pN9d5GqGOYykMgxMGXtmOiY7nBy2p2HCSnBJvRoV3obblQKBgQDGywBtyZa16u1fGJqc8J/vagcicAWIwHsom1RZ/CZmyvujZc0FsOGWfXd3fEp/kz8VkbWeJmJiFJUG1doIx65pAfIwNM15rljWoJ+BOrGv640TCQ9f2FgQ3WulzTa498wZIzCos+2ITqUeiH7oiT7eJiSjfLdO479vmg5YdomLGQKBgQDpfWjbzgRqTf1l8Cjx4b6MK/3QQuh6uCq9ZUJMvTp0PlcWUkNXpwpdC5MdnfzFUR3dwjtSVU8tCqWTwmZLCMbsby3kSTbYnKad3EC2saP2hVSjZ/KXWX/0/NIXbX1efY8aMNuiHfEy2DYZbCpgFIIZ1CSbgUn6dNHbf+tl5S6FHA==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoPjjgaLp+o/S5LhMGjg4eH/5tBogUt6zdxvQTlU7fAccAevRtkwIpGHMYVi6mCc5S5iA+JWGu9m3+eT9gq1j1v+pIFHDpx8RgoaVH7jTy31nOq6EJB6Fb6cFKHp2UsHy91wb2ddcYdyM7uXdHodHQlx2jg5iaKyalK3YgP4BuUsCFFmlmc0v+Do40QPtkBRp9519wsivNDaIJRQQ01x9+/yyKiJSEt2VOyD5a7VbTLIg3Aqy8HJ0awLHm4YkczN7/nRSRWd2xkxyBwEelPwZWprW2Mq0N/jxFFRp1A2tSV5s3qOrGPPUwW4evWsHhnF6n+5A20lanybVXt3BrAfDnwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/paysuccess";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
        	System.out.println("in");
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

