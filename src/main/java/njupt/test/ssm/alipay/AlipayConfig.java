package njupt.test.ssm.alipay;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2018/7/18
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016091900546124";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCY20C/gYFAO/PbDe1+vqVl8ZTvuHzp/UhrdF0l42xJgx39NeTxdrUuH0RNipz7zjPebYhdaLwHnW88nxQar4ifwHKjKCasyfBF/HGNR9+u4WHPWMBLCHk72i+tF5KM8ou6dXxQNE3yeiHle6fuWWXyM47VK0A+HQPm+nC0YbHw11PWSa3UwgmaVfqumveDYwF9qfm94P6XOxgWznuKWq+GcTnNRcxGfcaDIzs+Vbu73SztjBIBUoIUPAK6DZ//XINrbkssZvwW9SD8UEShSmXAIiKYIo/WDzdLsHGKESsiSANyvoAIoF+Vdjto31zEESrgPiiW35L7/H4l2sAtkYeHAgMBAAECggEAAIeJ4t/s9a7/ejvDHdRFOGQs0uO9swXIkW62v+HYxyxoFy9vmpKBsCY1k1sujgS500Rn24L4W8Jk1z3p0OnYvEzrWLtT3vdYGLX2IrokATQQpao2CEyANv/beGsDe+9/ImczxgdYWcWohmX2P/IZU0xwazaaI1zwXYVyjH1mI2JqKT3BjqK4Avp/HoFDlnkkYW3wV80CcrPItLqXVJqQ7OZQq5ATzkHtbi/MmkIbVglSBxnrOge6zFAXIXeCGFfwbMz0PjhacxWsmKJiF2f+N+8lwDDAYng/csK5qnDBPVk+2VncmtPUM4XI5qZ51EM9cEVsAWdxZOF66AzxE45OcQKBgQDpooFlDspAorORwFEzct7lNb5ggB2TFEzF8oHN2GvjwGtQod9TnUccX+K2cnVVsw9KD+mOfajbcjQSNYJsz1caRHaHVB10vTXl/zw3SyHFXO8iJjnKJqfIhdCIaE8jXGk9eLfUd/i6s8q7totJu7MT3tvRdM+zzaJiE6tPvzE+nwKBgQCnfS4CaS5Qo5uIgZd57dw9eA2wFwWtPwEIQmnu4or0+aDl7Ifja3zv7f0XVusBgLvFEZJa+P+Nxj6y/Z7dpUTTdFr1RQG5mwRiHK28YDaVMSpVxeyiea+zjmtFa7cdFWTAyvyR+iyvwzyAVW1400j/37V7atw5CUcthEJ3w6dWGQKBgH0gHkKcUC+bs6Y8pIB0ZfHF/ca69pvdxFxDS8eNwAKC/DZ76xph4kLNC6OA21xhgK++o+w/Wl7k5ARYihhyVwjnX7+MihYKe8JJFtvaLiUAZ8YXSN3+I9/d4tgbXT7n8CkO7Q0qj5iWT96GnkSH9RmQQpQEBnUajXwPYrFcCSirAoGARxPUhqlkQkxsIM3+HnxWzq83/9aFTjRCl+K3We1B0xxsr6ZlNJnU920jztfP+19KUCNY3Mp2iQ/sY8FFvgH451Ollhim1sF2ZryM7jhWcZHfyW6pMXo6mhSCaX+AwhLmIvsBnGFyvVQ5RKz8PB5OCGhDeBCtTHcngaVzH6gkR2ECgYB6qmwunysDdgV5VJZrE0guak8GtRxzYPqZHNeTq4Z+XAyi4Iu3tkE31xP4YHbCsXMh58dNHrkNSV9ZsIWlcYEZ4uGBp7WklBJ3zd/f3KhxA4QYi0woS7qXspAim9KBul+LjxVb8qmx29/GLel8qqohUOOxUsN9PhN66aJJpWqHPQ==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA+Ed/8+8C7ZwfE9gcglFXXKmXdDT/bHBrhBua95xA2s/Zit/FX0JbWktQr64qxNn3g5xcywal8vNvRzJzCyUWIX8baoiAD4h+jn+hvO7/E7wqgTxu0OTgyx/6OmGhCmUauKcsGjayoHpWvteHuoj43F7/ixr7kyJF29HJwLYD0tzaB8cYvTzwjwidMwdB5YE8d4aVwyYc2OctRaN/Sf1t8vQHK1jswvRhdjDToCg9CxvmtY0+qwzOgg2XzMWzXD7gRXg/JiAZYZVNfiXV+QqUaJMBx4+OfIt50N02vGUzTYYIAzrq9OQ396eoiiuWcKh0e6eMSQSmaAyQSAeoSSRqzwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/alipay.page/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/alipay.page/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "Z:\\";


    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
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
