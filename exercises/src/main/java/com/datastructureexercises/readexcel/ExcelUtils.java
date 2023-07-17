package com.datastructureexercises.readexcel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author Liu Tianlong
 * @program data-structure-exercises
 * @create 2023-07-11 09:46
 * @description Excel工具类
 */
public class ExcelUtils {

    @Test
    public void testWrite() throws Exception {
        HSSFWorkbook wookbook = new HSSFWorkbook();
        //1、创建工作簿
        HSSFSheet sheet = wookbook.createSheet("shermin");
        //2、创建工作表，名字是shermin
        HSSFRow row = sheet.createRow(0);
        //3、创建行；创建第一行，索引从0开始
        HSSFCell cell = row.createCell(0);
        //4、创建单元格；创建第1行第1列
        cell.setCellValue("hello world");
        //输出到硬盘，把excel输出到具体的地址
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/liutianlong/Downloads/测试.xls");
        wookbook.write(fileOutputStream);
        wookbook.close();
        fileOutputStream.close();
    }


    @Test
    public void testRead() throws Exception {
        FileInputStream finFileInputStream = new FileInputStream("/Users/liutianlong/Downloads/测试.xls");
        HSSFWorkbook wookbook = new HSSFWorkbook(finFileInputStream);
        //1、读取工作簿
        HSSFSheet sheet = wookbook.getSheet("shermin");
        //2、读取第"shermin"工作表
        HSSFRow row = sheet.getRow(0);
        HSSFCell cell = row.getCell(0);
        //读取单元格；读取第0行第0列
        System.out.println(cell.getStringCellValue());
        wookbook.close();
        finFileInputStream.close();
    }

    //下面是一个通用的程序，可以读写 *.xls和 *.xlsx文件。先用正则表达式判断文件是否为excel文件，再判断是xls还是xlsx。用统一的接口Workbook接受XSSFWorkbook或HSSFWorkbook。然后在处理。
    @Test
    public void testToRead() throws Exception {
        String filePath = "/Users/liutianlong/Downloads/测试.xls";
        if (filePath.matches("^.+\\.(?i)(xls|xlsx)$")) {
            //判断是否excel文档
            FileInputStream fileInputStream = new FileInputStream(filePath);
            boolean is03Excel = filePath.matches("^.+\\.(?i)(xlsx)$");
            Workbook workbook = is03Excel ? new XSSFWorkbook(fileInputStream) : new HSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(0);
            Cell cell = row.getCell(0);
            System.out.println(cell.getStringCellValue());
            workbook.close();
            fileInputStream.close();
        }
    }
    // 下面通过java代码修改excel数据的格式。

    @Test
    public void testStyle() throws Exception {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("shermin");

        // 创建合并单元格对象，合并0行0列到0行
        //  cellRangeAddress = new CellRangeAddress(0, 0, 0, 1);
        //  sheet.addMergedRegion(cellRangeAddress);
        // 选择行
        HSSFRow row = sheet.createRow(1);

        CellStyle style = workbook.createCellStyle();
        CellStyle styleDate = workbook.createCellStyle();
        Font font = workbook.createFont();
        Font fontDate = workbook.createFont();
        HSSFDataFormat dataFormat = workbook.createDataFormat();
        Drawing d = sheet.createDrawingPatriarch();
        String comment = "错误信息";
        // 选择列
        for (int i = 0; i < 10; i++) {
            HSSFCell cell = row.createCell(i);
            CellStyle cellStyle;
            if (i == 2) {
                cellStyle = setErrorCellStyleDate(workbook, styleDate, fontDate, dataFormat, cell, d, comment);
            } else {
                cellStyle = setErrorCellStyle(workbook, style, font, dataFormat, cell, d, comment);
            }
            cell.setCellStyle(cellStyle);
            cell.setCellValue("第" + i + "处错误");
        }
        //样式加到单元格中
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/liutianlong/Downloads/测试.xls");
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();
    }

    public CellStyle setErrorCellStyle(HSSFWorkbook wb, CellStyle style, Font font, HSSFDataFormat dataFormat, Cell cell, Drawing d, String comment) {
        // 设为默认格式:文本
        style.setDataFormat(dataFormat.getFormat("@"));
        // 居中,边框
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        // 设置填充背景色
        style.setFillBackgroundColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
        // 设置自定义填充前景色
        HSSFPalette palette = wb.getCustomPalette();
        palette.setColorAtIndex(HSSFColor.HSSFColorPredefined.LIME.getIndex(), (byte) 255, (byte) 217, (byte) 218);
        style.setFillForegroundColor(IndexedColors.LIME.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        // 设置字体及其高度
        font.setFontName("Microsoft YaHei");
        font.setFontHeightInPoints((short) 12);
        style.setFont(font);
        // 添加批注
        Comment c = d.createCellComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 3, 2, (short) 1, 1));
        RichTextString textString = new HSSFRichTextString(comment);
        c.setString(textString);
        c.setVisible(false);
        cell.setCellComment(c);
        return style;
    }

    public CellStyle setErrorCellStyleDate(HSSFWorkbook workbook, CellStyle style, Font font, HSSFDataFormat dataFormat, Cell cell, Drawing d, String comment) {

        // 设为日期格式
        style.setDataFormat(dataFormat.getFormat("yyyy/MM/dd"));
        // 居中,边框
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        // 设置填充背景色
        style.setFillBackgroundColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
        // 设置填充前景色
        HSSFPalette palette = workbook.getCustomPalette();
        palette.setColorAtIndex(HSSFColor.HSSFColorPredefined.LIME.getIndex(), (byte) 255, (byte) 217, (byte) 218);
        style.setFillForegroundColor(IndexedColors.LIME.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        // 设置字体及其高度
        font.setFontHeightInPoints((short) 12);
        font.setFontName("Microsoft YaHei");
        style.setFont(font);
        //添加批注
        Comment c = d.createCellComment(new HSSFClientAnchor(0, 0, cell.getRowIndex(), cell.getColumnIndex(), (short) 3, 2, (short) 1, 1));
        RichTextString textString = new HSSFRichTextString(comment);
        c.setString(textString);
        c.setVisible(false);
        cell.setCellComment(c);
        return style;
    }
}


