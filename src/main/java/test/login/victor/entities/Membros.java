package test.login.victor.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import test.login.victor.entities.enums.Perfil;
import test.login.victor.entities.enums.TipoMembro;

@Entity
public class Membros implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String nome; 
	private Integer pin; 
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "idAccount")
	private Account account;
	private String nascimento;
	private String sexo; 
	private String parentesco; 
	private Double pontuacao; 
	@OneToMany(mappedBy = "membros", cascade = CascadeType.ALL)
	private List<Tarefas> tarefas = new ArrayList<>();
	private Integer tipo;
	
	public Membros() { 
	this.pin = 1234; 
	this.pontuacao =  0.0;

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


	public Integer getPin() {
		return pin;
	}


	public void setPin(Integer pin) {
		this.pin = pin;
	}
	
	
	
	public TipoMembro getTipo() {
		return TipoMembro.toEnum(tipo);
	}

	public void setTipo(TipoMembro tipo) {
		this.tipo = tipo.getCod();
	}
			


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
	
	
	public String getNascimento() {
		return nascimento;
	}


	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getParentesco() {
		return parentesco;
	}


	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}


	public Double getPontuacao() {
		return pontuacao;
	}


	public void setPontuacao(Double pontuacao) {
		this.pontuacao = pontuacao;
	}



	
	
	
	

	public List<Tarefas> getTarefas() {
		return tarefas;
	}






	public void setTarefas(List<Tarefas> tarefas) {
		this.tarefas = tarefas;
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
		Membros other = (Membros) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
	
}
