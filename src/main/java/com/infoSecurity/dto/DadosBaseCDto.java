package com.infoSecurity.dto;

import com.infoSecurity.Types.TypeOperacao;
import java.util.Date;
import java.util.List;


public class DadosBaseCDto {

    public Date ultimaConsultaRealizadaBureau;
    public List<String> movimentacaoFinanceiraCpf;
    public DadosUltimaCompraDto dadosUltimaCompra;

    public DadosBaseCDto(Date ultimaConsultaRealizadaBureau, List<String> movimentacaoFinanceiraCpf,
			DadosUltimaCompraDto dadosUltimaCompra) {
		this.ultimaConsultaRealizadaBureau = ultimaConsultaRealizadaBureau;
		this.movimentacaoFinanceiraCpf = movimentacaoFinanceiraCpf;
		this.dadosUltimaCompra = dadosUltimaCompra;
	}
   
	public Date getUltimaConsultaRealizadaBureau() {
		return ultimaConsultaRealizadaBureau;
	}

	public void setUltimaConsultaRealizadaBureau(Date ultimaConsultaRealizadaBureau) {
		this.ultimaConsultaRealizadaBureau = ultimaConsultaRealizadaBureau;
	}

	public List<String> getMovimentacaoFinanceiraCpf() {
		return movimentacaoFinanceiraCpf;
	}

	public void setMovimentacaoFinanceiraCpf(List<String> movimentacaoFinanceiraCpf) {
		this.movimentacaoFinanceiraCpf = movimentacaoFinanceiraCpf;
	}

	public DadosUltimaCompraDto getDadosUltimaCompra() {
		return dadosUltimaCompra;
	}

	public void setDadosUltimaCompra(DadosUltimaCompraDto dadosUltimaCompra) {
		this.dadosUltimaCompra = dadosUltimaCompra;
	}

	public static DadosBaseCDto build() {
        return new DadosBaseCDto(new Date(), List.of("Compra Debito na farmacia", "Compra mercado"),
                    new DadosUltimaCompraDto("Mercado da esquina",new Date(), TypeOperacao.DEBITO));
    }
}

