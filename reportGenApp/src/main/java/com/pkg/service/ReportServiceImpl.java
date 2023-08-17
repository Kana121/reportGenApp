package com.pkg.service;

import java.awt.Color;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.pkg.entity.CitizenPlan;
import com.pkg.repo.CitizenPlanRepository;
import com.pkg.request.SearchRequest;
import com.pkg.utility.EmailSender;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	private CitizenPlanRepository planRepo;
	@Autowired
	private EmailSender email;
	
	@Override
	public List<String> getPlanNames() {
		return planRepo.getPlanName();
	}

	@Override
	public List<String> getPlanStatus() {
		return planRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
	CitizenPlan entity=new CitizenPlan();
	if(request.getPlanName()!=null&&!"".equals(request.getPlanName())) {
		entity.setPlanName(request.getPlanName());
	}
	if(request.getPlanStatus()!=null&&!"".equals(request.getPlanStatus())) {
		entity.setPlanStatus(request.getPlanStatus());
	}
	if(request.getGender()!=null&&!"".equals(request.getGender())) {
		entity.setGender(request.getGender());
	}
	if(request.getPlanStartDate()!=null&&!"".equals(request.getPlanStartDate())) {
		String startDate = request.getPlanStartDate();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
		
		//convert String to LocalDate
		LocalDate localDate = LocalDate.parse(startDate);
		entity.setPlanStartDate(localDate);
	}
	if(request.getPlanEndDate()!=null&&!"".equals(request.getPlanEndDate())) {
		String endDate = request.getPlanEndDate();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
		//convert String to LocalDate
		LocalDate localDate = LocalDate.parse(endDate);
		entity.setPlanEndDate(localDate);
	}
	
		return planRepo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception{
		
		Workbook workbook=new HSSFWorkbook();
		Sheet sheet= workbook.createSheet("plans-data");
		
		Row headerRow=sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue("Plan Name");
		headerRow.createCell(3).setCellValue("Plan Status");
		headerRow.createCell(4).setCellValue("Plan Start Date");
		headerRow.createCell(5).setCellValue("Plan End Date");
		headerRow.createCell(6).setCellValue("Benefit Amt");
		
		
		List<CitizenPlan>list= planRepo.findAll();
		int index=1;
		for(CitizenPlan plan:list) {
			Row dataRow=sheet.createRow(index);
			dataRow.createCell(0).setCellValue(plan.getCitizenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(5).setCellValue(plan.getPlanName());
			dataRow.createCell(2).setCellValue(plan.getPlanStatus());
			dataRow.createCell(3).setCellValue(plan.getPlanStartDate());
			dataRow.createCell(4).setCellValue(plan.getPlanEndDate());
			if(plan.getBenifitAmt()!=null)
			dataRow.createCell(6).setCellValue(plan.getBenifitAmt());
			else
				dataRow.createCell(6).setCellValue("N/A");
			index++;
		}
		ServletOutputStream outputStream=response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		String subject="Test mail subject";
		String body="<h1>Test mail body</h1>";
		String to="dharukanhaiya@gmail.com";
		email.sendMail(subject, body, to);
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		
		Document document=new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		// Creating font
				// Setting font style and size
				Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
				fontTiltle.setSize(20);
				fontTiltle.setColor(Color.BLUE);
				// Creating paragraph
				 Paragraph p=new Paragraph("Citizen Plan Info",fontTiltle);
			        p.setAlignment(Paragraph.ALIGN_CENTER);
				// Aligning the paragraph in document
				p.setAlignment(Paragraph.ALIGN_CENTER);
				 Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			        font.setSize(18);
			       
			         
			       
		
		document.add(p);
		PdfPTable table=new PdfPTable(7);
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Plan Start Date");
		table.addCell("Plan End Date");
		table.addCell("Benefit Amt");
		
		List<CitizenPlan>list= planRepo.findAll();
		
		for(CitizenPlan plan:list) {
		
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getPlanStartDate()+"");
			table.addCell(plan.getPlanEndDate()+"");
			table.addCell(plan.getBenifitAmt()+"");
			
		}
		
		document.add(table);
		
		document.close();
		return false;
	}

}
