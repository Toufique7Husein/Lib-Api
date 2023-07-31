package practice.api.libapi.helper;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import practice.api.libapi.entity.Employee;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper {
    public static boolean checkExcelFormat(MultipartFile file) {
        String contentType = file.getContentType();
        return true;
    }

    public static List<Employee> convertExcelToListOfEmployee(InputStream is) {
        List<Employee> list = new ArrayList<>();

        try {
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
            XSSFSheet sheet = xssfWorkbook.getSheet("data");

            int row = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row r = iterator.next();
                if (row == 0) {
                    row++;
                    continue;
                }

                Iterator<Cell> cells = r.iterator();
                Employee employee =  new Employee();
                int cnt = 0;
                while (cells.hasNext()) {
                    Cell c = cells.next();
                    if (cnt == 0)employee.setEmployeeId((int)c.getNumericCellValue());
                    if (cnt == 1) employee.setDate(c.getStringCellValue());
                    if (cnt == 2) employee.setName(c.getStringCellValue());
                    if (cnt == 3) employee.setStartTime(c.getStringCellValue());
                    if (cnt == 4) employee.setEndTime(c.getStringCellValue());
                    if (cnt == 5) employee.setShiftName(c.getStringCellValue());
                    if (cnt == 6) employee.setExpectedValue(c.getStringCellValue());
                    cnt++;
                }
                list.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
