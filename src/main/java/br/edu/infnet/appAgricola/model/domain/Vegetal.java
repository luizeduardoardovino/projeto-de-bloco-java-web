package br.edu.infnet.appAgricola.model.domain;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Vegetal extends Agricola{
    private String tipo;
    private int qtdVegetal;
    

    public Vegetal(){}

    public Vegetal(String nome, float preco) {
        super(nome, preco);
    }

    public Vegetal(String tipo, int qtdVegetal, boolean vidro){
        super();
        this.tipo = tipo;
        this.qtdVegetal = qtdVegetal;    
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(";");
        sb.append(this.tipo);
        sb.append(";");
        sb.append(this.qtdVegetal);
        sb.append(";");

        return sb.toString();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQtdVegetal() {
        return qtdVegetal;
    }

    public void setQtdVegetal(int qtdVegetal) {
        this.qtdVegetal = qtdVegetal;
    }


}
