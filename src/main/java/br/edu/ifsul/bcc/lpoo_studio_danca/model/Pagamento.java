/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.bcc.lpoo_studio_danca.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Saimon AS Rocha
 */
@Entity
@Table(name = "tb_pagamento")
@NamedQueries({
    @NamedQuery(name = "Pagamento.orderbyid", query = "select p from Pagamento p "
            + "order by p.id asc")})
public class Pagamento implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_pagamento", sequenceName = "seq_pagamento_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_pagamento", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar dataVcto;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar dataPgto;

    @Column(nullable = false)
    private Double valorPgto;

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
     * @return the dataVcto
     */
    public Calendar getDataVcto() {
        return dataVcto;
    }

    /**
     * @param dataVcto the dataVcto to set
     */
    public void setDataVcto(Calendar dataVcto) {
        this.dataVcto = dataVcto;
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

    /**
     * @return the dataPgto
     */
    public Calendar getDataPgto() {
        return dataPgto;
    }

    /**
     * @param dataPgto the dataPgto to set
     */
    public void setDataPgto(Calendar dataPgto) {
        this.dataPgto = dataPgto;
    }

    /**
     * @return the valorPgto
     */
    public Double getValorPgto() {
        return valorPgto;
    }

    /**
     * @param valorPgto the valorPgto to set
     */
    public void setValorPgto(Double valorPgto) {
        this.valorPgto = valorPgto;
    }
}
