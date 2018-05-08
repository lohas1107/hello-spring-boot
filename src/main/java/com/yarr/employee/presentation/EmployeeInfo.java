package com.yarr.employee.presentation;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonView;

public interface EmployeeInfo {

	/** 姓名 */
	@JsonView(EmployeeView.List.class)
	public String getName();

	/** 員工編號 */
	@JsonView(EmployeeView.Id.class)
	public Long getId();

	/** 性別 */
	@JsonView(EmployeeView.List.class)
	public String getGender();

	/** 電話 */
	public String getPhone();

	/** 地址 */
	public String getAddress();

	/** 年齡 */
	public Integer getAge();

	/** 建立時間 */
	public Date getCreateDate();

	/** 最後一次修改時間 */
	public Date getAmendDate();

}
