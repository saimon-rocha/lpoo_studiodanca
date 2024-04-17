package br.edu.ifsul.bcc.lpoo_studio_danca.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Saimon AS Rocha
 */
@Entity
@Table(name = "tb_contrato")
@NamedQueries({
    @NamedQuery(name = "Contrato.orderbyid", query = "select c from Contrato c "
            + "order by c.id asc")})
public class Contrato implements Serializable {

    @Enumerated(EnumType.STRING)
    private FormaPgto formaPagamento;
    
    @Id
    @SequenceGenerator(name = "seq_contrato", sequenceName = "seq_contrato_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_contrato", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataInicio;

    @OneToMany(mappedBy = "contrato", cascade = CascadeType.ALL)
    private List<Pagamento> pagamentos;

    @ManyToOne
    @JoinColumn(name = "pacote_id")
    private Pacote pacote;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the dataInicio
     */
    public Calendar getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public FormaPgto getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPgto formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    /**
     * @return the pagamentos
     */
    public List<Pagamento> getPagamentos() {
        if (pagamentos == null) {
            pagamentos = new ArrayList<>();
        }
        return pagamentos;
    }

    /**
     * @param pagamentos the pagamentos to set
     */
    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public void setPacote(Pacote pacote) {
        this.pacote = pacote;
    }

    public Set<Pacote> getPacotes() {
        Set<Pacote> pacotes = null;
        return pacotes;
    }
}
