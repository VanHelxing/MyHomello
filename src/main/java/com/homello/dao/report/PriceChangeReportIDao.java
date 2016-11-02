package com.homello.dao.report;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.homello.domian.report.PriceChangeReport;

@Repository
public interface PriceChangeReportIDao {

	
	/*
	 * 获取所有金额明细数据 
	 * 
	 * @return List<PriceChangeReport>
	 */
	public List<PriceChangeReport> queryAllPriceChangeReport();
}
