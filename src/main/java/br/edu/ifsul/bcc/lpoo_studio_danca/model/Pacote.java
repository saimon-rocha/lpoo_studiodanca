package br.edu.ifsul.bcc.lpoo_studio_danca.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Saimon AS Rocha
 */
@Entity
@Table(name = "tb_pacote")
@NamedQueries({
    @NamedQuery(name = "Pacote.orderbyid", query = "select p from Pacote p "
            + "order by p.id asc")})
public class Pacote {

    @Id
    @SequenceGenerator(name = "seq_pacote", sequenceName = "seq_pacote_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_pacote", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false, length = 120)
    private String descricao;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double valor;

    @ManyToMany
    @JoinTable(
            name = "pacote_modalidade",
            joinColumns = @JoinColumn(name = "pacote_id"),
            inverseJoinColumns = @JoinColumn(name = "modalidade_id")
    )
    private Set<Modalidade> modalidades = new HashSet<>();

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Set<Modalidade> getModalidades() {
        return modalidades;
    }
}
