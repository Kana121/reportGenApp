package com.pkg.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pkg.entity.CitizenPlan;
import com.pkg.request.SearchRequest;
@Component
public interface ReportService {
public List<String>getPlanNames();
public List<String>getPlanStatus();
public List<CitizenPlan>search(SearchRequest request);

public boolean exportExcel();
public boolean exportPdf();
}
