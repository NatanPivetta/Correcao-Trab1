package pessoas;

import java.util.Comparator;
import java.util.Date;
public class Dependente extends Pessoa implements Comparable<Dependente> {

	
    public Dependente(String _nome, Date _nascimento){
        super(_nome, _nascimento);
    }
    @Override
    public String toString(){
        String s = "";

        return s;
    }
    
    public int compareTo(Dependente dep) {
    	return this.getNome().compareTo(dep.getNome());
    }
    
}
