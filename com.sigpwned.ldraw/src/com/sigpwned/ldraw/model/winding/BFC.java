package com.sigpwned.ldraw.model.winding;

public enum BFC {
	CERTIFY("CERTIFY"), CERTIFY_CW("CERTIFY CW"), CERTIFY_CCW("CERTIFY CCW"), NOCERTIFY("NOCERTIFY"),
	CW("CW"), CCW("CCW"), CLIP("CLIP"), NOCLIP("NOCLIP"), INVERTNEXT("INVERTNEXT");

	private String value;
	
	private BFC(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return getValue();
	}
}
