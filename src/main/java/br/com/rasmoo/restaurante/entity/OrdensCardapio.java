package br.com.rasmoo.restaurante.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ordens_cardapio")
public class OrdensCardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Ordem ordem;
    @ManyToOne
    private Cardapio cardapio;

    private BigDecimal valor;

    private Integer quatidade;

    public OrdensCardapio(Ordem ordem, Cardapio cardapio, Integer quatidade) {
        this.ordem = ordem;
        this.cardapio = cardapio;
        this.quatidade = quatidade;
        this.valor = cardapio.getValor();
    }

    public OrdensCardapio() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ordem getOrdem() {
        return ordem;
    }

    public void setOrdem(Ordem ordem) {
        this.ordem = ordem;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getQuatidade() {
        return quatidade;
    }

    public void setQuatidade(Integer quatidade) {
        this.quatidade = quatidade;
    }

    @Override
    public String toString() {
        return "OrdensCardapio{" +
                "id=" + id +
                ", ordem=" + ordem +
                ", cardapio=" + cardapio +
                ", valor=" + valor +
                ", quatidade=" + quatidade +
                '}';
    }
}
