package com.infoSecurity.dto;
import java.util.List;

public class DadosBaseBDto {

    public Integer idade;
    public List<String> bens;
    public String fonteRenda;

    public DadosBaseBDto(Integer idade, List<String> bens, String fonteRenda) {
		super();
		this.idade = idade;
		this.bens = bens;
		this.fonteRenda = fonteRenda;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public List<String> getBens() {
		return bens;
	}

	public void setBens(List<String> bens) {
		this.bens = bens;
	}

	public String getFonteRenda() {
		return fonteRenda;
	}

	public void setFonteRenda(String fonteRenda) {
		this.fonteRenda = fonteRenda;
	}

	public static DadosBaseBDto build() {
        return new DadosBaseBDto(25,List.of("Casa na praia", "Carro 2023"),"Trabalho CLT");
    }
}
