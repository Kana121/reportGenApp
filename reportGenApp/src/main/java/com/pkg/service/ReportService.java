package com.pkg.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pkg.entity.CitizenPlan;
import com.pkg.request.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;
@Component
public interface ReportService {
public List<String>getPlanNames();
public List<String>getPlanStatus();
public List<CitizenPlan>search(SearchRequest request);

public boolean exportExcel(HttpServletResponse response) throws Exception;
public boolean exportPdf(HttpServletResponse response) throws Exception;
}
