package pessoas;

import java.util.Date;
import java.util.TreeSet;

public class Socio extends Pessoa{
    private String endereco;
    private String email;
    private TreeSet<Dependente> dependentes = new TreeSet<>();


    
    
    public Socio(String _nome, String endereco, String email, Date _nascimento){
        super(_nome, _nascimento);
        this.endereco = endereco;
        this.email = email;
    }


    

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void addDependente(Dependente d) {
		System.out.println("Dependente " + d.getNome() + " adicionado");
		dependentes.add(d);
	}

	@Override
	public String toString() {
		String s = "";
		
		s += this.getNome() +"\n";
		s += this.getDataNascimento().toString()+"\n";
		s += this.getEndereco()+"\n";
		s += this.getEmail()+"\n";
		s += "Dependentes: \n";
		for (Dependente dependente : dependentes) {
			s += dependente.getNome();
		}
		s += "\n";
		
		return s;
	}
    
    

}
