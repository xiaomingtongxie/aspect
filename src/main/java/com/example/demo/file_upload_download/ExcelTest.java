package com.example.demo.file_upload_download;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试Excel upload以及 download
 */
public class ExcelTest {

    /**
     * 最简单的读
     * <p>1. 创建excel对应的实体对象 参照{@link }
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link }
     * <p>3. 直接读即可
     */
//    public void simpleRead() {
//        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
//        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();
//    }
    public static void main(String[] args) {

        List<BigDecimal> bigDecimalList = new ArrayList<>();
        bigDecimalList.add(BigDecimal.ONE);
        bigDecimalList.add(BigDecimal.TEN);

        BigDecimal bigDecimal = BigDecimal.valueOf(0.145123);
        BigDecimal bigDecimal1 = BigDecimal.valueOf(13.0000);

        BigDecimal bigDecimal2 = bigDecimal.setScale(2, RoundingMode.HALF_UP);

        System.out.println(bigDecimal1.setScale(2, RoundingMode.HALF_UP).subtract(bigDecimal.setScale(2, RoundingMode.HALF_UP)));


    }
}
