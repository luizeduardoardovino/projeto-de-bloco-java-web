package br.edu.infnet.appAgricola.model.domain;



import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Erva extends Agricola{

    private String tipoFolha;
    private int qtdErva;
   
    

    public Erva(){}
    
    public Erva(String nome, float preco) {
        super(nome, preco);
    }


    public Erva(String tipoFolha, int qtdErva) {
        super();
        this.tipoFolha = tipoFolha;
        this.qtdErva = qtdErva;   
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(";");
        sb.append(this.tipoFolha);
        sb.append(";");
        sb.append(this.qtdErva);
        sb.append(";");

        return sb.toString();
    }

    public String getTipoFolha() {
        return tipoFolha;
    }

    public void setTipoFolha(String tipoFolha) {
        this.tipoFolha = tipoFolha;
    }

    
    public int getQtdErva() {
        return qtdErva;
    }

    public void setQtdErva(int qtdErva) {
        this.qtdErva = qtdErva;
    }



}
