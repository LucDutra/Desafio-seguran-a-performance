package com.infoSecurity.dto;

import java.util.List;


public class DadosBaseADto {

    public String cpf;
    public String nome;
    public String endereco;
    public List<String> dividas;
    
    public DadosBaseADto(String cpf, String nome, String endereco, List<String> dividas) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.dividas = dividas;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<String> getDividas() {
		return dividas;
	}

	public void setDividas(List<String> dividas) {
		this.dividas = dividas;
	}

	public static DadosBaseADto build(){
        return new DadosBaseADto("297.870.330-04", "Geraldo jovemzinho", "Blumenau", List.of("Emprestimo" +
                "R$4.000,00"));
    }

}
