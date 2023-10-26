package locacoes;
import pessoas.Dependente;
import pessoas.Socio;
import util.Situacao;
import util.ValidaData;
import java.util.Date;
import java.util.TreeSet;

import java.util.Collections;

public final class Locacao implements ValidaData, Comparable<Locacao>{
    private Date dataRetirada;
    private Date dataDevolucao;
    private double valor;
    private String titulo;
    private Situacao situacao;

    private Socio socio;
    

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
    
    @Override
    public String toString() {
    	String s =  "";
    	s += this.getTitulo() + " " + this.getValor() + "\n" +
    	this.socio.toString();
    	
    	return s;
    }
    
    @Override
    public int compareTo(Locacao loc) {
    	return Double.compare(this.valor, loc.valor);
    }
}