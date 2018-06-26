package com.kyung.model;

public class ResultModel {

	Boolean result;

	String explain;

	public ResultModel(){}

	public ResultModel(Boolean result, String explain){
		this.result = result;
		this.explain = explain;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

}
