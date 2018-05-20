package com.tounga.predictice.enumeration;

public enum BusinessErrorCode {

	TECHNICAL_ERROR(0,"error.technical"),USER_NOT_FOUND(1,"error.user.not.found"), PLAN_NOT_FOUND(2, "error.plan.not.found"), ORGANIZATION_NOT_FOUND(3,"error.organization.not.found");
	private int code;
	private String label;
	
	 BusinessErrorCode(int code, String label){
		this.code= code;
		this.label= label;
	}

	public int getCode() {
		return code;
	}

	public String getLabel() {
		return label;
	}
	 
	 
}
