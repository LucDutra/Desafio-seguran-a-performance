package com.infoSecurity.dto;

import com.infoSecurity.Types.TypeOperacao;
import java.util.Date;

public class DadosUltimaCompraDto {

    public String estabelecimento;
    public Date dataHoraCompra;
    public TypeOperacao operacaoUtilizada;
	
    public DadosUltimaCompraDto(String estabelecimento, Date dataHoraCompra, TypeOperacao operacaoUtilizada) {
		this.estabelecimento = estabelecimento;
		this.dataHoraCompra = dataHoraCompra;
		this.operacaoUtilizada = operacaoUtilizada;
	}

	public String getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Date getDataHoraCompra() {
		return dataHoraCompra;
	}

	public void setDataHoraCompra(Date dataHoraCompra) {
		this.dataHoraCompra = dataHoraCompra;
	}

	public TypeOperacao getOperacaoUtilizada() {
		return operacaoUtilizada;
	}

	public void setOperacaoUtilizada(TypeOperacao operacaoUtilizada) {
		this.operacaoUtilizada = operacaoUtilizada;
	}
    
    
}
