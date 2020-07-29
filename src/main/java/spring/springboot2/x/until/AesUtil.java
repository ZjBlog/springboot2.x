package spring.springboot2.x.until;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/7/29 17:10
 * @Description 加密工具
 */
public class AesUtil {

    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    private static final String PASSWD = "test";

    /**
     * AES加密
     *
     * @param passwd  加密的密钥
     * @param content 需要加密的字符串
     * @return 返回Base64转码后的加密数据
     * @throws Exception
     */
    public static String encrypt(String passwd, String content) throws Exception {
        // 创建密码器
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

        byte[] byteContent = content.getBytes("utf-8");

        // 初始化为加密模式的密码器
        cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(passwd));

        // 加密
        byte[] result = cipher.doFinal(byteContent);

        //通过Base64转码返回
        return Base64.encodeBase64String(result);
    }

    /**
     * AES解密
     *
     * @param passwd    加密的密钥
     * @param encrypted 已加密的密文
     * @return 返回解密后的数据
     * @throws Exception
     */
    public static String decrypt(String passwd, String encrypted) throws Exception {
        //实例化
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

        //使用密钥初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, getSecretKey(passwd));

        //执行操作
        byte[] result = cipher.doFinal(Base64.decodeBase64(encrypted));

        return new String(result, "utf-8");
    }

    /**
     * 生成加密秘钥
     *
     * @return
     */
    private static SecretKeySpec getSecretKey(final String password) throws NoSuchAlgorithmException {
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(password.getBytes());
        //AES 要求密钥长度为 128
        kg.init(128, random);

        //生成一个密钥
        SecretKey secretKey = kg.generateKey();
        // 转换为AES专用密钥
        return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
    }


    /**
     * 解密配置文件中的密文
     *
     * @param props
     */
    public static void decrypt(Properties props) {

        List<String> fails = new ArrayList<String>(props.size());

        for (String key : props.stringPropertyNames()) {
            try {
                String value = props.getProperty(key);
                String $value = decrypt(PASSWD, value);
                props.setProperty(key, $value);
            } catch (Exception e) {
                fails.add(key);
            }
        }
        if (fails.size() != 0) {
            System.out.println("解密失败: " + fails);
        } else {
            System.out.println("解密成功: " + fails);
        }
    }

    public static void main(String[] args) throws Exception {
        String encrypt = encrypt(PASSWD, "123");
        System.out.println(encrypt);
        String decrypt = decrypt(PASSWD, encrypt);
        System.out.println(decrypt);
    }


}
