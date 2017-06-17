package yrostami.service;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import yrostami.entity.Result;

import java.io.*;
import java.util.List;

/**
 * Created by Yousef.
 */
public class Service {

    public static boolean isValidResult(Result r)
    {
        System.out.println(r);
        if (r.getFirstName().isEmpty() || r.getLastName().isEmpty() ||
                r.getSexuality().isEmpty() || r.getMarried().isEmpty() ||
                r.getEducation().isEmpty() || r.getOccupation().isEmpty() ||
                r.getAge()<=0 || r.getAnswersCount()<0 || r.getCorrectAnswersCount()<0 ||
                r.getCorrectAnswersPercent()<0 || r.getWrongAnswersCount()<0 ||
                r.getTimeAverage()<0 || r.getTimeStandardDeviation()<0)
            return false;

        return true;
    }

    public static byte[] getXLSFile()
    {
        List<Result> list = DataBase.getAllResults();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] bytes = null;

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("results");

        sheet.setDefaultColumnWidth(14);
        sheet.setRightToLeft(true);

        // create style for header cells
        XSSFCellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontName("Arial");
        style.setAlignment(HorizontalAlignment.RIGHT);
        style.setFillBackgroundColor(HSSFColor.GOLD.index);
        style.setFillForegroundColor(HSSFColor.BLACK.index);
        font.setBold(true);
        style.setFont(font);

        XSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("نام");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("نام خانوادگی");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("جنسیت");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("سن");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("تحصیلات");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("شغل");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("وضعیت تاهل");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("تعداد پاسخ");
        header.getCell(7).setCellStyle(style);
        header.createCell(8).setCellValue("تعداد بی پاسخ");
        header.getCell(8).setCellStyle(style);
        header.createCell(9).setCellValue("تعداد پاسخ صحیح");
        header.getCell(9).setCellStyle(style);
        header.createCell(10).setCellValue("درصد پاسخ صحیح");
        header.getCell(10).setCellStyle(style);
        header.createCell(11).setCellValue("تعداد پاسخ غلط");
        header.getCell(11).setCellStyle(style);
        header.createCell(12).setCellValue("میانگین زمان");
        header.getCell(12).setCellStyle(style);
        header.createCell(13).setCellValue("انحراف معیار زمان");
        header.getCell(13).setCellStyle(style);

        int rowCount = 1;

        for (Result r : list){
            XSSFRow row =  sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(r.getFirstName());
            row.createCell(1).setCellValue(r.getLastName());
            row.createCell(2).setCellValue(r.getSexuality());
            row.createCell(3).setCellValue(r.getAge());
            row.createCell(4).setCellValue(r.getEducation());
            row.createCell(5).setCellValue(r.getOccupation());
            row.createCell(6).setCellValue(r.getMarried());
            row.createCell(7).setCellValue(r.getAnswersCount());
            row.createCell(8).setCellValue(r.getNoAnswersCount());
            row.createCell(9).setCellValue(r.getCorrectAnswersCount());
            double percent = r.getCorrectAnswersPercent();
            percent = Math.round(percent*100.0)/100.0;
            row.createCell(10).setCellValue(percent);
            row.createCell(11).setCellValue(r.getWrongAnswersCount());
            row.createCell(12).setCellValue(r.getTimeAverage());
            row.createCell(13).setCellValue(r.getTimeStandardDeviation());
        }

        try {
            workbook.write(bos);
            bos.flush();
            bos.close();
            bytes = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

}
