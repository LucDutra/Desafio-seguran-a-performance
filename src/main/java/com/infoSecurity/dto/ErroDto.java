package com.infoSecurity.dto;

public class ErroDto {

	private Integer status;
	private String erro;
	
	public ErroDto(Integer status, String erro) {
		this.status = status;
		this.erro = erro;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	
	
	
}
