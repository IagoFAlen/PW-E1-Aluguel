/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
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
@Table(name = "aluguel")
public class Aluguel implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_aluguel", sequenceName = "seq_aluguel_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_aluguel", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "valor", nullable = false, columnDefinition = "numeric(10,2)")
    private Double valor;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data do inicio de contrato deve ser informada")
    @Column(name = "iniciocontrato", nullable = false)
    private Calendar inicioContrato;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data do fim de contrato deve ser informada")
    @Column(name = "fimcontrato", nullable = false)
    private Calendar fimContrato;
    
    @Column(name = "diavencimento", nullable = false)
    private Integer diaVencimento;
    
    @NotNull(message = "O locatário deve ser informado")
    @ManyToOne
    @JoinColumn(name = "locatario", referencedColumnName = "id", nullable = false)
    private Locatario locatario;
    
    @NotNull(message = "A unidade condominial deve ser informada")
    @ManyToOne
    @JoinColumn(name = "unidadecondominial", referencedColumnName = "id", nullable = false)
    private UnidadeCondominial unidadecondominial;
    
    @NotNull(message = "A mensalidade deve ser informada")
    @ManyToOne
    @JoinColumn(name = "mensalidade", referencedColumnName = "id", nullable = false)
    private Mensalidades mensalidade;
    
    public Aluguel(){
        
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
     * @return the inicioContrato
     */
    public Calendar getInicioContrato() {
        return inicioContrato;
    }

    /**
     * @param inicioContrato the inicioContrato to set
     */
    public void setInicioContrato(Calendar inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    /**
     * @return the fimContrato
     */
    public Calendar getFimContrato() {
        return fimContrato;
    }

    /**
     * @param fimContrato the fimContrato to set
     */
    public void setFimContrato(Calendar fimContrato) {
        this.fimContrato = fimContrato;
    }

    /**
     * @return the diaVencimento
     */
    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    /**
     * @param diaVencimento the diaVencimento to set
     */
    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluguel other = (Aluguel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the locatario
     */
    public Locatario getLocatario() {
        return locatario;
    }

    /**
     * @param locatario the locatario to set
     */
    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    /**
     * @return the unidadecondominial
     */
    public UnidadeCondominial getUnidadecondominial() {
        return unidadecondominial;
    }

    /**
     * @param unidadecondominial the unidadecondominial to set
     */
    public void setUnidadecondominial(UnidadeCondominial unidadecondominial) {
        this.unidadecondominial = unidadecondominial;
    }

    /**
     * @return the mensalidade
     */
    public Mensalidades getMensalidade() {
        return mensalidade;
    }

    /**
     * @param mensalidade the mensalidade to set
     */
    public void setMensalidade(Mensalidades mensalidade) {
        this.mensalidade = mensalidade;
    }
    
    
}
