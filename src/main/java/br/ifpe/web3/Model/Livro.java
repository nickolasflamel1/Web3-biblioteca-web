package br.ifpe.web3.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Livro {
    @Id
    private Integer codigo;
    @Column
    private String titulo;
    @Column
    private String autores;
    // anotações de relacionamento (cardinalidade) chaves estrangeiras
    // 1-1, 1-N, N-1, N-N
    @ManyToOne
    private Categoria categoria;


    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
