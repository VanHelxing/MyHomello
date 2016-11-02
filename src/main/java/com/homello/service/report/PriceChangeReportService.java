package com.homello.service.report;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.homello.dao.report.PriceChangeReportIDao;
import com.homello.domian.report.PriceChangeReport;

@Service
public class PriceChangeReportService {

	@Resource
	private PriceChangeReportIDao priceChangeReportDao;
	
	
	/*
	 * 获取所有金额明细数据 
	 * 
	 * @return List<PriceChangeReport>
	 */
	public List<PriceChangeReport> queryAllPriceChangeReport() {
		
		List<PriceChangeReport> listPriceChangeReports = priceChangeReportDao.queryAllPriceChangeReport();
		return listPriceChangeReports;
	}
	
}
