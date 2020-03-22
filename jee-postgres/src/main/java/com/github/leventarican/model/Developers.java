package com.github.leventarican.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * created with netbeans: new > Entity Class from Database
 * 
 * @author Levent
 */
@Entity
@Table(name = "developers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Developers.findAll", query = "SELECT d FROM Developers d"),
    @NamedQuery(name = "Developers.findById", query = "SELECT d FROM Developers d WHERE d.id = :id"),
    @NamedQuery(name = "Developers.findByName", query = "SELECT d FROM Developers d WHERE d.name = :name")})
public class Developers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 40)
    @Column(name = "name")
    private String name;

    public Developers() {
    }

    public Developers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Developers)) {
            return false;
        }
        Developers other = (Developers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.github.leventarican.model.Developers[ id=" + id + " ]";
    }

}
