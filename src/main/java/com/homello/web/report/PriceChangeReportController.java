package com.homello.web.report;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.homello.domian.report.PriceChangeReport;
import com.homello.service.report.PriceChangeReportService;

@Controller("/priceChangeReport")
public class PriceChangeReportController {

	@Resource
	private PriceChangeReportService priceChangeReportService;
	
	
	@RequestMapping("/queryAll")
	public String queryAllPriceChangeReport(ModelMap modelMap) {
		
		List<PriceChangeReport> listParams = priceChangeReportService.queryAllPriceChangeReport();
		String jsonString = JSON.toJSONString(listParams);
		modelMap.addAttribute("jsonString", jsonString);
		
		return "forum/report/PurchReport/PriceChangeReport";
	}
}
