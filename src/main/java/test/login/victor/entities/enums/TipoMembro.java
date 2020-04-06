package test.login.victor.entities.enums;

public enum TipoMembro {

	RESPONSAVEL(1, "Responsavel"),
	COMUM(2, "Comum");
	
	private int cod;
	private String descricao;
	
	private TipoMembro(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static TipoMembro toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoMembro x : TipoMembro.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
