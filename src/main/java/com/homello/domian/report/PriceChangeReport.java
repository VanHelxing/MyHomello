package com.homello.domian.report;

public class PriceChangeReport {
	
	/*
	 * 厂编
	 */
	private String supId;
	
	/*
	 * 厂商合同号
	 */
	private String contractId;
	
	/*
	 * 调价机构
	 */
	private String deptName;
	
	/*
	 * 调价单号
	 */
	private String id;
	
	/*
	 * 调价执行日期, 调价生效日期
	 */
	private String executeDate;
	private String validDate;
	
	/*
	 * 制单人, 审核人, 执行人
	 */
	private String createrName;
	private String checkerName;
	private String executerName;
	
	/*
	 * 单据状态
	 */
	private String status;
	
	
	/*
	 * 套餐商品, 套餐商品名称
	 */
	private String groupId;
	private String groupName;
	
	/*
	 * 商品编号, 名称, 规格, 采购单位, 类别, 品牌
	 */
	private String proId;
	private String proName;
	private String proSpec;
	private String proPurchaseUnit;
	private String proType;
	private String proBand;
	
	/*
	 * 数量
	 */
	private double qty;

	/*
	 * 原价, 新价
	 */
	private double oldPrice;
	private double newPrice;
	
	
	public double getQty() {
		return qty;
	}
	public void setQty(double qty) {
		this.qty = qty;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getSupId() {
		return supId;
	}
	public void setSupId(String supId) {
		this.supId = supId;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExecuteDate() {
		return executeDate;
	}
	public void setExecuteDate(String executeDate) {
		this.executeDate = executeDate;
	}
	public String getValidDate() {
		return validDate;
	}
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
	public String getCreaterName() {
		return createrName;
	}
	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}
	public String getCheckerName() {
		return checkerName;
	}
	public void setCheckerName(String checkerName) {
		this.checkerName = checkerName;
	}
	public String getExecuterName() {
		return executerName;
	}
	public void setExecuterName(String executerName) {
		this.executerName = executerName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProSpec() {
		return proSpec;
	}
	public void setProSpec(String proSpec) {
		this.proSpec = proSpec;
	}
	public String getProPurchaseUnit() {
		return proPurchaseUnit;
	}
	public void setProPurchaseUnit(String proPurchaseUnit) {
		this.proPurchaseUnit = proPurchaseUnit;
	}
	public String getProType() {
		return proType;
	}
	public void setProType(String proType) {
		this.proType = proType;
	}
	public String getProBand() {
		return proBand;
	}
	public void setProBand(String proBand) {
		this.proBand = proBand;
	}
	public double getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}
	public double getNewPrice() {
		return newPrice;
	}
	public void setNewPrice(double newPrice) {
		this.newPrice = newPrice;
	}

}
