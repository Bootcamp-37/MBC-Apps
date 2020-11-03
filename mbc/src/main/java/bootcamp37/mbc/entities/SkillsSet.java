/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Deo Lahara
 */
@Entity
@Table(name = "skills_set")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SkillsSet.findAll", query = "SELECT s FROM SkillsSet s")
    , @NamedQuery(name = "SkillsSet.findById", query = "SELECT s FROM SkillsSet s WHERE s.id = :id")
    , @NamedQuery(name = "SkillsSet.findByName", query = "SELECT s FROM SkillsSet s WHERE s.name = :name")})
public class SkillsSet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public SkillsSet() {
    }

    public SkillsSet(String id) {
        this.id = id;
    }

    public SkillsSet(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        if (!(object instanceof SkillsSet)) {
            return false;
        }
        SkillsSet other = (SkillsSet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bootcamp37.mbc.entities.SkillsSet[ id=" + id + " ]";
    }
    
}
