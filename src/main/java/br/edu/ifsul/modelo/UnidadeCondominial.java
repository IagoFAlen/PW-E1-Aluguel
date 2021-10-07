/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Iago Figueira
 */
@Entity 
@Table(name = "unidadecondominial")
public class UnidadeCondominial implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_unidadecondominial", sequenceName = "seq_unidadecondominial_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_unidadecondominial", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O número deve ser informada")
    @Length(max = 5, message = "A descricão não pode ter mais que {max} caracteres")
    @Column(name = "numero", length = 5, nullable = false)
    private String numero;
    
    @NotBlank(message = "A descrição deve ser informada")
    @Column(name = "descricao", columnDefinition = "text", nullable = false)
    private String descricao;
    
    @Column(name = "area", nullable = false, columnDefinition = "numeric(6,2)")
    private Double area;
    
    @Column(name = "numeroquarto", nullable = false)
    private Integer numeroQuarto;
    
    @NotNull(message = "O proprietário deve ser informado")
    @ManyToOne
    @JoinColumn(name = "proprietario", referencedColumnName = "id", nullable = false)
    private Pessoa proprietario;

    @NotNull(message = "O condomínio deve ser informado")
    @ManyToOne
    @JoinColumn(name = "condominio", referencedColumnName = "id", nullable = false)
    private Condominio condominio;
    
    public UnidadeCondominial(){
        
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
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

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
     * @return the area
     */
    public Double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Double area) {
        this.area = area;
    }

    /**
     * @return the numeroQuarto
     */
    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    /**
     * @param numeroQuarto the numeroQuarto to set
     */
    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    /**
     * @return the proprietario
     */
    public Pessoa getProprietario() {
        return proprietario;
    }

    /**
     * @param proprietario the proprietario to set
     */
    public void setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final UnidadeCondominial other = (UnidadeCondominial) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the condominio
     */
    public Condominio getCondominio() {
        return condominio;
    }

    /**
     * @param condominio the condominio to set
     */
    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    
    
}
