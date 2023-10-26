package pessoas;
import java.util.Date;

public abstract class Pessoa{
    private String nome;
    private Date dataNascimento;
    private static int total;

    public Pessoa(String nome, Date nascimento) {
        this.nome = nome;
        this.dataNascimento = nascimento;
    }


    @Override
    public String toString(){
        String s = "";
        
        s += "Nome:" + this.getNome() + "\n"
        + "Data de Nascimento: " + this.getDataNascimento().toString() + "\n";

        return s;
    }

    public static int getTotal(){
        return total;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public static void setTotal() {
		total++;
	}
    
    
}