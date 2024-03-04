package com.motivity.factorydesign.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.lowagie.text.DocumentException;
import com.motivity.factorydesign.excelExporter.EmpExcelExporter;
import com.motivity.factorydesign.model.Emp;
import com.motivity.factorydesign.pdfexporter.EmpPdfExporter;
import com.motivity.factorydesign.service.EmpService;

@RestController
@RequestMapping("/emp")
public class EmpController {
	@Autowired
	private EmpService empService;
	
	@PostMapping("/save")
	public ResponseEntity<Emp> saveEmployee(@RequestBody Emp employee) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(empService.saves(employee));
	} 
	@GetMapping("/getall")
	public ResponseEntity<List<Emp>> getAllEmployees() {
		
		return ResponseEntity.status(HttpStatus.OK).body(empService.findAllEmployee());
		
	}
	
	 @GetMapping("/export/excel")
	    public void exportToExcel(HttpServletResponse response) throws IOException {
	        response.setContentType("application/octet-stream");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=employees_" + currentDateTime + ".xlsx";
	        response.setHeader(headerKey, headerValue);
	         
	        List<Emp> listEmp = empService.findAllEmployee();
	         
	        EmpExcelExporter excelExporter = new EmpExcelExporter(listEmp);
	         
	        excelExporter.export(response);    
	    }  
	 
	 @GetMapping("/export/pdf")
	    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=employees_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	         
	        List<Emp> listEmp = empService.findAllEmployee();
	         
	        EmpPdfExporter exporter = new EmpPdfExporter(listEmp);
	        exporter.export(response);
	         
	    }
	 
	  
	    @GetMapping("/export/csv")
	    public void exportToCSV(HttpServletResponse response) throws IOException {
	        response.setContentType("text/csv");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=employees_" + currentDateTime + ".csv";
	        response.setHeader(headerKey, headerValue);
	         
	        List<Emp> listEmp = empService.findAllEmployee();
	 
	        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
	        String[] csvHeader = {"empId" , "fname" , "lname" , "salary" , "dept" , "year"};
	        String[] nameMapping = {"empId" , "fname" , "lname" , "salary" , "dept" , "year"};
	         
	        csvWriter.writeHeader(csvHeader);
	         
	        for (Emp emp : listEmp) {
	            csvWriter.write(emp, nameMapping);
	        }
	         
	        csvWriter.close();
	         
	    }
}
