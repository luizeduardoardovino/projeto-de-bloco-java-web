package br.edu.infnet.appAgricola.model.domain;

import br.edu.infnet.appAgricola.model.exceptions.ErvaZeroException;
import br.edu.infnet.appAgricola.model.exceptions.ErroFrutasException;
import br.edu.infnet.appAgricola.model.exceptions.FrutaZeroException;
import br.edu.infnet.appAgricola.model.exceptions.Erro3Exception;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Agricola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private float valorBase;
    private boolean proprio;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToMany(mappedBy = "produtoList")
    private List<Encomenda> encomendaList;

    public Agricola(){
    }
    public Agricola(String nome, float valorBase) {
        this.nome = nome;
        this.valorBase = valorBase;
        
    }

    public String selecionarItemProduto() throws FrutaZeroException, Erro3Exception, ErvaZeroException, ErroFrutasException {
     

        StringBuilder sb = new StringBuilder();
        sb.append(this.nome);
        sb.append(";");
        sb.append(this.proprio ? "Idelma Criações" : "Outro fornecedor");
        sb.append(";");
        
        sb.append("\r\n");

        return sb.toString();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.nome);
        sb.append(";");
        sb.append(this.valorBase);
        sb.append(";");
        sb.append(this.proprio ? "Sim" : "Não");

        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValorBase() {
    	System.out.println(valorBase);
        return valorBase;
    }

    public void setValorBase(float valorBase) {
        this.valorBase = valorBase;
    }

    public boolean isProprio() {
        return proprio;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
