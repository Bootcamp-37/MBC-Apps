/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Deo Lahara
 */
@Entity
@Table(name = "interviewer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Interviewer.findAll", query = "SELECT i FROM Interviewer i")
    , @NamedQuery(name = "Interviewer.findById", query = "SELECT i FROM Interviewer i WHERE i.id = :id")
    , @NamedQuery(name = "Interviewer.findByName", query = "SELECT i FROM Interviewer i WHERE i.name = :name")
    , @NamedQuery(name = "Interviewer.findByPhoneNumber", query = "SELECT i FROM Interviewer i WHERE i.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "Interviewer.findByEmail", query = "SELECT i FROM Interviewer i WHERE i.email = :email")})
public class Interviewer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "interviewer", fetch = FetchType.LAZY)
    private List<Schedule> scheduleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "interview", fetch = FetchType.LAZY)
    private List<Site> siteList;

    public Interviewer() {
    }

    public Interviewer(String id) {
        this.id = id;
    }

    public Interviewer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Interviewer(String id, String name, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @XmlTransient
    public List<Site> getSiteList() {
        return siteList;
    }

    public void setSiteList(List<Site> siteList) {
        this.siteList = siteList;
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
        if (!(object instanceof Interviewer)) {
            return false;
        }
        Interviewer other = (Interviewer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bootcamp37.mbc.entities.Interviewer[ id=" + id + " ]";
    }
    
}
