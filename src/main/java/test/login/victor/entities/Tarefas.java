package test.login.victor.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Tarefas implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String nome; 
	private Double pontuacao; 
	private Integer nivel; 
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "idMembros")
	private Membros membros;
	private Boolean status; 
	private String designar;
	private String dataInicial;
	private String dataFinal;
	
	public Tarefas() { 
		this.status = false;
		this.pontuacao = 0.0;
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getPontuacao() {
		return pontuacao;
	}


	public void setPontuacao(Double pontuacao) {
		this.pontuacao = pontuacao;
	}


	public Integer getNivel() {
		return nivel;
	}


	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}


	public Membros getMembros() {
		return membros;
	}


	public void setMembros(Membros membros) {
		this.membros = membros;
	}


	


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}


	
	
	
	public String getDesignar() {
		return designar;
	}


	public void setDesignar(String designar) {
		this.designar = designar;
	}
	
	
	


	public String getDataInicial() {
		return dataInicial;
	}


	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}


	public String getDataFinal() {
		return dataFinal;
	}


	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefas other = (Tarefas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
