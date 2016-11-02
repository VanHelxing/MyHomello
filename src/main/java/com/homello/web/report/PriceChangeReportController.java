package com.homello.web.report;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.homello.service.report.PriceChangeReportService;

@Controller
public class PriceChangeReportController {

	@Resource
	private PriceChangeReportService priceChangeReportService;
	
	
}
