/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "condominio")
public class Condominio implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_condominio", sequenceName = "seq_condominio_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_condominio", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @NotBlank(message = "O enedereço deve ser informada")
    @Length(max = 200, message = "O endereço não pode ter mais que {max} caracteres")
    @Column(name = "endereco", length = 50, nullable = false)
    private String endereco;
        
    @NotBlank(message = "O numero deve ser informada")
    @Length(max = 6, message = "O numero não pode ter mais que {max} caracteres")
    @Column(name = "numero", length = 50, nullable = false)
    private String numero;
        
    @NotBlank(message = "O CEP deve ser informada")
    @Length(max = 10, message = "O CEP não pode ter mais que {max} caracteres")
    @Column(name = "cep", length = 50, nullable = false)
    private String cep;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "recursos", joinColumns = @JoinColumn(name = "nome",
                                                            referencedColumnName = "nome",
                                                            nullable = false),
                                  inverseJoinColumns = @JoinColumn(name = "recurso",
                                                            referencedColumnName = "descricao",
                                                            nullable = false))
    private Set<Recurso> recursos = new HashSet<>();
    
    @NotNull(message = "A unidade condominial deve ser informada")
    @ManyToOne
    @JoinColumn(name = "unidadecondominial", referencedColumnName = "id", nullable = false)
    private UnidadeCondominial unidadecondominial;
    
    public Condominio(){
        
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Condominio other = (Condominio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the recursos
     */
    public Set<Recurso> getRecursos() {
        return recursos;
    }

    /**
     * @param recursos the recursos to set
     */
    public void setRecursos(Set<Recurso> recursos) {
        this.recursos = recursos;
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
    
}
