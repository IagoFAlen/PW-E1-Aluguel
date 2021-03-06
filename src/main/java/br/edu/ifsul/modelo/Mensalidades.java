/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Iago Figueira
 */
@Entity
@Table(name = "mensalidades")
public class Mensalidades implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_mensalidades", sequenceName = "seq_mensalidades_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_mensalidades", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "valorpagamento", nullable = false, columnDefinition = "numeric(10,2)")
    private Double valorPagamento;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de vencimento deve ser informada")
    @Column(name = "vencimento", nullable = false)
    private Calendar vencimento;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data do fim de contrato deve ser informada")
    @Column(name = "datapagamento", nullable = false)
    private Calendar dataPagamento;
    
    @Column(name = "valor", nullable = false, columnDefinition = "numeric(10,2)")
    private Double valor;
    
    
    @NotNull(message = "O aluguel deve ser informado")
    @ManyToOne
    @JoinColumn(name = "aluguel", referencedColumnName = "id", nullable = false)
    private Aluguel aluguel;
    
    public Mensalidades(){
        
    }
    
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
     * @return the valorPagamento
     */
    public Double getValorPagamento() {
        return valorPagamento;
    }

    /**
     * @param valorPagamento the valorPagamento to set
     */
    public void setValorPagamento(Double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    /**
     * @return the vencimento
     */
    public Calendar getVencimento() {
        return vencimento;
    }

    /**
     * @param vencimento the vencimento to set
     */
    public void setVencimento(Calendar vencimento) {
        this.vencimento = vencimento;
    }

    /**
     * @return the dataPagamento
     */
    public Calendar getDataPagamento() {
        return dataPagamento;
    }

    /**
     * @param dataPagamento the dataPagamento to set
     */
    public void setDataPagamento(Calendar dataPagamento) {
        this.dataPagamento = dataPagamento;
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
     * @return the aluguel
     */
    public Aluguel getAluguel() {
        return aluguel;
    }

    /**
     * @param aluguel the aluguel to set
     */
    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    
}
