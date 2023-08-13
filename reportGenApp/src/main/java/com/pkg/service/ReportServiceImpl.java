package com.pkg.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.pkg.entity.CitizenPlan;
import com.pkg.repo.CitizenPlanRepository;
import com.pkg.request.SearchRequest;

@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	private CitizenPlanRepository planRepo;

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
	public boolean exportExcel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exportPdf() {
		// TODO Auto-generated method stub
		return false;
	}

}
