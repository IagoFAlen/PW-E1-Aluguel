/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Iago Figueira
 */
@Entity
@Table(name = "locatario")
public class Locatario extends Pessoa implements Serializable{
    @Column(name = "peso", nullable = false, columnDefinition = "numeric(12,2)")
    private Double renda;
    
    @NotBlank(message = "O local de trabalho deve ser informado")
    @Length(max = 150, message = "O local de trabalho não pode ter mais que {max} caracteres")
    @Column(name = "localtrabalho", length = 150, nullable = false)
    private String localTrabalho;
    
    @NotBlank(message = "O telefone deve ser informado")
    @Length(max = 14, message = "O telefone não pode ter mais que {max} caracteres")
    @Column(name = "telefonetrabalho", length = 14, nullable = false)
    private String telefoneTrabalho;

    public Locatario(){
        
    }
    /**
     * @return the renda
     */
    public Double getRenda() {
        return renda;
    }

    /**
     * @param renda the renda to set
     */
    public void setRenda(Double renda) {
        this.renda = renda;
    }

    /**
     * @return the localTrabalho
     */
    public String getLocalTrabalho() {
        return localTrabalho;
    }

    /**
     * @param localTrabalho the localTrabalho to set
     */
    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    /**
     * @return the telefoneTrabalho
     */
    public String getTelefoneTrabalho() {
        return telefoneTrabalho;
    }

    /**
     * @param telefoneTrabalho the telefoneTrabalho to set
     */
    public void setTelefoneTrabalho(String telefoneTrabalho) {
        this.telefoneTrabalho = telefoneTrabalho;
    }

}
