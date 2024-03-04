package com.motivity.factorydesign.excelExporter;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.motivity.factorydesign.model.Emp;

public class EmpExcelExporter {
	private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Emp> listEmp;
     
    public EmpExcelExporter(List<Emp> listEmp) {
        this.listEmp = listEmp;
        workbook = new XSSFWorkbook();
    }
 
 
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Emp");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
         
        createCell(row, 0, "empId", style);      
        createCell(row, 1, "fname", style);       
        createCell(row, 2, "lname", style);    
        createCell(row, 3, "salary", style);
        createCell(row, 4, "dept", style);
        createCell(row, 5, "year", style);
         
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
     
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (Emp emp : listEmp) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            createCell(row, columnCount++, emp.getEmpId(), style);
            createCell(row, columnCount++, emp.getFname(), style);
            createCell(row, columnCount++, emp.getLname(), style);
            createCell(row, columnCount++, emp.getSalary(), style);
            createCell(row, columnCount++, emp.getDept(), style);
            createCell(row, columnCount++, emp.getYear(), style);

             
        }
    }
     
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
         
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
         
    }

}
