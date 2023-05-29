package com.vo;

import java.io.Serializable;

public class StaffCountVO implements Serializable {

	private static final long serialVersionUID = 4480402142625157127L;

	private Integer StaffInStore;
	private String addressName;

	public StaffCountVO(String addressName, Integer staffInStore) {
		this.addressName = addressName;
		StaffInStore = staffInStore;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public Integer getStaffInStore() {
		return StaffInStore;
	}

	public void setStaffInStore(Integer staffInStore) {
		StaffInStore = staffInStore;
	}

	@Override
	public String toString() {
		return "StaffCountVO [addressName=" + addressName + ", StaffInStore=" + StaffInStore + "]";
	}

}
