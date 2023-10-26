package util;
public enum Situacao{
    EM_DIA(1, "Locação em dia"),
    CANCELADA(2, "Locação cancelada"),
    ATRASADA (3, "Locação Atrasada");

    private final int valor;
    private final String descricao;

    private Situacao( int valor, String descricao){
        this.valor = valor;
        this.descricao = descricao;
    }

    public int getValor(){
        return valor;
    }

    public String getDescricao(){
        return descricao;
    }

    public String getSituacao(){
        return this.getValor() + " - " + this.getDescricao();
    }
}