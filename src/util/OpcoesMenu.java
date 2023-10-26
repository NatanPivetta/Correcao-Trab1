package util;
public enum OpcoesMenu{
    CADASTRA_LOC(1, "Cadastrar Locação"),
    PESQ_LOC(2, "Pesquisar Locação"), 
    CADASTRA_SOC(3, "Cadastrar Sócio"), 
    PESQ_SOC(4, "Pesquisar Sócio"),
    LIST_LOC(5, "Listar Locações"),
    LIST_SOC(6, "Listar Sócios"),
    SAIR(7, "SAIR");

    private final int valor;
    private final String descricao;

    private OpcoesMenu(int valor, String descricao){
        this.valor = valor;
        this.descricao = descricao;
    }

    public int getValor(){
        return valor;
    }

    public String getDescricao(){
        return descricao;
    }

    public String getOpcao(){
        return this.getValor() + " - " + this.getDescricao();
    }
}

