package spring.springboot2.Until;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 身份证号码验证
 *
 * @author
 */
public class IdCardValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(IdCardValidator.class);

    private static final int MAX_MONTH_VAL = 12;

    private static final int OLD_CARD_LENGTH = 15;

    private static final int CARD_LENGTH = 18;

    private static final int VALID_MONTH = 2;

    /**
     * 省，直辖市代码表： { 11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古", 21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",
     * 33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南", 42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",
     * 51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃", 63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"}
     */
    private static Map<String, String> proviceMap = new HashMap<String, String>();
    private static Map<String, Integer> dateMap = new HashMap<String, Integer>();

    private static String[][] codeAndCity = {{"11", "北京"}, {"12", "天津"}, {"13", "河北"}, {"14", "山西"}, {"15", "内蒙古"},
            {"21", "辽宁"}, {"22", "吉林"}, {"23", "黑龙江"}, {"31", "上海"}, {"32", "江苏"}, {"33", "浙江"}, {"34", "安徽"}, {"35", "福建"},
            {"36", "江西"}, {"37", "山东"}, {"41", "河南"}, {"42", "湖北"}, {"43", "湖南"}, {"44", "广东"}, {"45", "广西"}, {"46", "海南"},
            {"50", "重庆"}, {"51", "四川"}, {"52", "贵州"}, {"53", "云南"}, {"54", "西藏"}, {"61", "陕西"}, {"62", "甘肃"}, {"63", "青海"},
            {"64", "宁夏"}, {"65", "新疆"}, {"71", "台湾"}, {"81", "香港"}, {"82", "澳门"}, {"91", "国外"}};

    // private static String cityCode[] = { "11", "12", "13", "14", "15", "21", "22",
    // "23", "31", "32", "33", "34", "35", "36", "37", "41", "42", "43",
    // "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63",
    // "64", "65", "71", "81", "82", "91" };

    /**
     * 每位加权因子
     */
    private static int[] power = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    /**
     * 第18位校检码
     */
    private static String[] verifyCode = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};

    static {
        for (String[] oneCodeAndCity : codeAndCity) {
            proviceMap.put(oneCodeAndCity[0], oneCodeAndCity[1]);
        }
        dateMap = new HashMap<String, Integer>();
        dateMap.put("01", 31);
        dateMap.put("03", 31);
        dateMap.put("04", 30);
        dateMap.put("05", 31);
        dateMap.put("06", 30);
        dateMap.put("07", 31);
        dateMap.put("08", 31);
        dateMap.put("09", 30);
        dateMap.put("10", 31);
        dateMap.put("11", 30);
        dateMap.put("12", 31);
    }

    /**
     * <p>
     * 判断18位身份证的合法性
     * </p>
     * 根据〖中华人民共和国国家标准GB11643-1999〗中有关公民身份号码的规定，公民身份号码是特征组合码，由十七位数字本体码和一位数字校验码组成。
     * 排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码。
     * <p>
     * 顺序码: 表示在同一地址码所标识的区域范围内，对同年、同月、同 日出生的人编定的顺序号，顺序码的奇数分配给男性，偶数分配 给女性。
     * </p>
     * <p>
     * 1.前1、2位数字表示：所在省份的代码； 2.第3、4位数字表示：所在城市的代码； 3.第5、6位数字表示：所在区县的代码； 4.第7~14位数字表示：出生年、月、日； 5.第15、16位数字表示：所在地的派出所的代码；
     * 6.第17位数字表示性别：奇数表示男性，偶数表示女性； 7.第18位数字是校检码：也有的说是个人信息码，一般是随计算机的随机产生，用来检验身份证的正确性。校检码可以是0~9的数字，有时也用x表示。
     * </p>
     * <p>
     * 第十八位数字(校验码)的计算方法为： 1.将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
     * </p>
     * <p>
     * 2.将这17位数字和系数相乘的结果相加。
     * </p>
     * <p>
     * 3.用加出来和除以11，看余数是多少？
     * </p>
     * 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2。
     * <p>
     * 5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证的最后一位号码就是2。
     * </p>
     *
     * @param idcard
     * @return
     */

    /**
     * 15位和18位身份证号码的基本数字和位数验校
     *
     * @param idcard
     * @return
     */
    private static boolean isIdcard(String idcard) {
        return idcard == null || "".equals(idcard) ? false
                : Pattern.matches("(^\\d{15}$)|(\\d{17}(?:\\d|x|X)$)", idcard);
    }

    /**
     * 1.判断是15还是18
     *
     */

    /**
     * 1.判断是15还是18合法的身份证 验证所有的身份证的合法性
     *
     * @param idcard
     * @return
     */
    public static boolean isValidIdcard(String idcard) {
        /*
         * 15转18 申请一个15转18变量
         */
        // 是否为15位身份证
        boolean is15bitCard = false;
        // 身份证格式验证
        if (idcard == null || !isIdcard(idcard)) {
            LOGGER.debug("身份证格式验证失败！");
            return false;
        }
        // 将15位的身份证转成18位身份证
        if (idcard.length() == OLD_CARD_LENGTH) {
            is15bitCard = true;
            LOGGER.info("将15位的身份证转成18位身份证!");
            // 15位转18位
            idcard = idcard.substring(0, 6) + "19" + idcard.substring(6) + "0";
        }
        // 验证18位身份证是否合法
        if (idcard.length() == CARD_LENGTH) {
            return isValid18Idcard(idcard, is15bitCard);
        }
        LOGGER.debug("将15位的身份证转成18位身份证,身份证格式验证失败！");
        return false;

    }

    public static boolean isValid18Idcard(String idcard) {
        return isValid18Idcard(idcard, false);
    }

    /**
     * 第十八位是否合法
     *
     * @param idcard
     * @return
     */
    private static boolean isValid18Idcard(String idcard, boolean is15bitCard) {
        if (idcard == null || !isIdcard(idcard)) {
            LOGGER.debug("身份证格式验证失败！");
            return false;
        }
        // 省位前两位
        String provinceid = idcard.substring(0, 2);
        // 生日
        String birthday = idcard.substring(6, 14);
        int year = Integer.parseInt(idcard.substring(6, 10));
        String strMonth = idcard.substring(10, 12);
        int month = Integer.parseInt(strMonth);
        int day = Integer.parseInt(idcard.substring(12, 14));

        // 判断是否为合法的省份
        if (proviceMap.get(provinceid) == null) {
            LOGGER.debug("省有误!");
            return false;
        }

        // 判断是否为合法的月份
        if (month < 1 || month > MAX_MONTH_VAL) {
            LOGGER.debug("月有误!");
            return false;
        }
        // 判断是否为合法的天
        if (month != VALID_MONTH) {
            if (day > dateMap.get(strMonth)) {
                LOGGER.debug("日有误!");
                return false;
            }
        } else {
            // 判断是否为闰年
            boolean isLeap = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
            boolean flag = isLeap ? day > 29 : day > 28;
            if (flag) {
                LOGGER.debug("将身份证的第18位与算出来的校码进行匹配，不相等!");
                return false;
            }
        }
        // 该身份证生出日期在当前日期之后时为假
        Date birthdate = null;
        try {
            birthdate = new SimpleDateFormat("yyyyMMdd").parse(birthday);
        } catch (ParseException e) {
            return false;
        }
        if (birthdate == null || new Date().before(birthdate)) {
            return false;
        }
        // 如果是15位通过
        if (is15bitCard) {
            return true;
        }
        // 获取前17位
        String idcard17 = idcard.substring(0, 17);
        // 获取第18位
        final String idcard18Code = idcard.substring(17, 18);
        char[] c = null;
        c = idcard17.toCharArray();
        int[] bit = converCharToInt(c);

        int sum17 = 0;

        sum17 = getPowerSum(bit);
        if (sum17 == 0) {
            LOGGER.debug("检验有误!");
            return false;
        }

        // 将和值与11取模得到余数进行校验码判断
        String checkCode = "";
        checkCode = sum17 > 0 ? verifyCode[sum17 % 11] : null;
        if (null == checkCode) {
            LOGGER.debug("将和值与11取模得到余数进行校验码返回空!");
            return false;
        }
        // 将身份证的第18位与算出来的校码进行匹配，不相等就为假
        if (!idcard18Code.equalsIgnoreCase(checkCode)) {
            LOGGER.debug("将身份证的第18位与算出来的校码进行匹配，不相等!");
            return false;
        }
        return true;

    }

    /**
     * 数字验证
     *
     * @param str
     * @return
     */
    public static boolean isDigital(String str) {
        return str == null || "".equals(str) ? false : str.matches("^[0-9]*$");
    }

    /**
     * 将身份证的每位和对应位的加权因子相乘之后，再得到和值
     *
     * @param bit
     * @return
     */
    private static int getPowerSum(int[] bit) {

        int sum = 0;

        if (power.length != bit.length) {
            return sum;
        }

        for (int i = 0; i < bit.length; i++) {
            for (int j = 0; j < power.length; j++) {
                if (i == j) {
                    sum = sum + bit[i] * power[j];
                }
            }
        }
        return sum;
    }

    /**
     * 将字符数组转为整型数组
     *
     * @param c
     * @return
     * @throws NumberFormatException
     */
    private static int[] converCharToInt(char[] c) throws NumberFormatException {
        int[] a = new int[c.length];
        int k = 0;
        for (char temp : c) {
            // 修改
            a[k++] = temp - 48;
        }
        return a;
    }

}
