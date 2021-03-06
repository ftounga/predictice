package com.tounga.predictice.enumeration;

public enum BusinessErrorCode {

	TECHNICAL_ERROR(0,"error.technical"),USER_NOT_FOUND(1,"error.user.not.found"), PLAN_NOT_FOUND(2, "error.plan.not.found"), ORGANIZATION_NOT_FOUND(3,"error.organization.not.found"), NO_PLAN_ATTACHED(4,"error.no.plan.attached"), ALREADY_ATTACHED_PLAN(5,"error.already.attached.plan"), STRIPE_PAYMENT_ERROR(6,"error.stripe.payment"), CREDIT_CARD_NOT_FOUND(7,"error.credit.card.not.found"), TOO_MUCH_USERS(8,"error.maximum.users.plan"),PLAN_REQUIRED_FIRST(9,"error.plan.required");
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
