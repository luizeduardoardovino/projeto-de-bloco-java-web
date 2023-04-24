package br.edu.infnet.appAgricola.model.domain;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Fruta extends Agricola {

    private String tipo;
    private int qtdFruta;
    

    public Fruta() {
    }

    public Fruta(String nome, float preco) {
        super(nome, preco);
    }
    
    public Fruta(String tipo, int qtdVegetal){
        super();
        this.tipo = tipo;
        this.qtdFruta = qtdVegetal;    
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(";");
        sb.append(this.tipo);
        sb.append(";");
        sb.append(this.qtdFruta);
        sb.append(";");
        

        return sb.toString();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQtdFruta() {
        return qtdFruta;
    }

    public void setQtdFruta(int quantidade) {
        this.qtdFruta = quantidade;
    }



}
