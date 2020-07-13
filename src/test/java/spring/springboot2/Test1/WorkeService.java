package spring.springboot2.Test1;

import lombok.Data;
import lombok.SneakyThrows;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.BeanUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/6/26 15:32
 * @Description test
 */
public class WorkeService {

    public Boolean run() {
        System.out.println("==========================run");
        return Boolean.TRUE;
    }

    //MultipartFile file
    @SneakyThrows
    public static void main2(String[] args) {
        File file = new File("C:\\Users\\zhangjun486\\Desktop\\实名资料\\企业咚咚20200630103050.jpg");
//        String s = encodeFile(file);
//        System.out.println("===:"+s);

        byte[] bFile = Files.readAllBytes(file.toPath());
        String s = encodeFileByte(bFile);
        System.out.println("===:" + s);
    }

    public static String encodeFile(File file) throws IOException {
        byte[] readFileToByteArray = FileUtils.readFileToByteArray(file);
        return Base64.encodeBase64String(readFileToByteArray);
    }

    public static String encodeFile(String filePath) throws IOException {
        return encodeFile(new File(filePath));
    }

    public static String encodeFileByte(byte[] data) {
        return Base64.encodeBase64String(data);
    }

    public static void main(String[] args) {
        List<T1> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            T1 t1 = new T1();
            t1.setCode(i + "");
            t1.setName(i + "");
            list.add(t1);
        }


        List<T2> list1 = new ArrayList<>();
        T2 t2 = null;
        for (T1 t1 : list) {
            t2 = new T2();
            BeanUtils.copyProperties(t1, t2);
            list1.add(t2);
        }
        System.out.println(list1.toString());

    }
}

@Data
class T1 {
    private String name;
    private String code;
}

@Data
class T2 {
    private String name;
    private String code;
}