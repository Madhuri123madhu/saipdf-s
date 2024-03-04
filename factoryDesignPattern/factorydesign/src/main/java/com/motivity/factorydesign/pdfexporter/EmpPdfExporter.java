package com.motivity.factorydesign.pdfexporter;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.motivity.factorydesign.model.Emp;

public class EmpPdfExporter {
	 private List<Emp> listEmp;
     
	    public EmpPdfExporter(List<Emp> listEmp) {
	        this.listEmp = listEmp;
	    }
	 
	    private void writeTableHeader(PdfPTable table) {
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.BLUE);
	        cell.setPadding(6);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	         
	        cell.setPhrase(new Phrase("empId", font));
	         
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("fname", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("lname", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("salary", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("dept", font));
	        table.addCell(cell); 
	        
	        cell.setPhrase(new Phrase("year", font));
	        table.addCell(cell);    
	    }
	     
	    private void writeTableData(PdfPTable table) {
	        for (Emp emp : listEmp) {
	            table.addCell(String.valueOf(emp.getEmpId()));
	            table.addCell(emp.getFname());
	            table.addCell(emp.getLname());
	            table.addCell(String.valueOf(emp.getSalary()));
	            table.addCell(emp.getDept());
	            table.addCell(String.valueOf(emp.getYear()));

	            
	        }
	    }
	     
	    public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.BLUE);
	         
	        Paragraph p = new Paragraph("List of emps", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	         
	        document.add(p);
	         
	        PdfPTable table = new PdfPTable(6);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f, 1.5f});
	        table.setSpacingBefore(10);
	         
	        writeTableHeader(table);
	        writeTableData(table);
	         
	        document.add(table);
	         
	        document.close();
	         
	    }
}
