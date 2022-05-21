package com.manisha.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manisha.reports.ExcelGenerator;
import com.manisha.reports.PdfGenerator;
import com.manisha.request.SearchRequest;
import com.manisha.response.SearchResponse;
import com.manisha.service.ReportService;
@RestController
public class ReportRestController {

	@Autowired
	private ReportService service;

	@GetMapping("/plan-names")
	public List<String> getPlanName() {
		return service.getPlanName();
	}

	@GetMapping("/plan-status")
	public List<String> getPlanStatus() {
		return service.getPlanStatus();
	}

	@PostMapping("/search")
	public List<SearchResponse> search(@RequestBody SearchRequest request) {
		return service.searchPlans(request);
	}

	@GetMapping("/excel")
	public void generateExcel(HttpServletResponse response) throws Exception {

		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Plans.xls";
		response.setHeader(headerKey, headerValue);

		List<SearchResponse> records = service.searchPlans(null);
		ExcelGenerator excel = new ExcelGenerator();
		excel.generateExcel(records, response);
	}

	@GetMapping("/pdf")
	public void generatePdf(HttpServletResponse httpResponse) throws Exception {

		httpResponse.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Plans.pdf";
		httpResponse.setHeader(headerKey, headerValue);

		List<SearchResponse> records = service.searchPlans(null);
		PdfGenerator pdfGen = new PdfGenerator();
		pdfGen.generatePdf(records, httpResponse);
	}
}
