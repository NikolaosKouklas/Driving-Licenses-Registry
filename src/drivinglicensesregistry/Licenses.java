/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivinglicensesregistry;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Nikolaos
 */
@Entity
@Table(name = "LICENSES")
@NamedQueries({
    @NamedQuery(name = "Licenses.findAll", query = "SELECT l FROM Licenses l"),
    @NamedQuery(name = "Licenses.findById", query = "SELECT l FROM Licenses l WHERE l.id = :id"),
    @NamedQuery(name = "Licenses.findByLicenseId", query = "SELECT l FROM Licenses l WHERE l.licenseId = :licenseId"),
    @NamedQuery(name = "Licenses.findByFirstname", query = "SELECT l FROM Licenses l WHERE l.firstname = :firstname"),
    @NamedQuery(name = "Licenses.findByLastname", query = "SELECT l FROM Licenses l WHERE l.lastname = :lastname"),
    @NamedQuery(name = "Licenses.findByMiddlename", query = "SELECT l FROM Licenses l WHERE l.middlename = :middlename"),
    @NamedQuery(name = "Licenses.findByBirthYear", query = "SELECT l FROM Licenses l WHERE l.birthYear = :birthYear"),
    @NamedQuery(name = "Licenses.findByFirstLicense", query = "SELECT l FROM Licenses l WHERE l.firstLicense = :firstLicense")})
public class Licenses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "LICENSE_ID")
    private int licenseId;
    @Basic(optional = false)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "LASTNAME")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "MIDDLENAME")
    private String middlename;
    @Basic(optional = false)
    @Column(name = "BIRTH_YEAR")
    private short birthYear;
    @Basic(optional = false)
    @Column(name = "FIRST_LICENSE")
    @Temporal(TemporalType.DATE)
    private Date firstLicense;

    public Licenses() {
    }

    public Licenses(Integer id) {
        this.id = id;
    }

    public Licenses(Integer id, int licenseId, String firstname, String lastname, String middlename, short birthYear, Date firstLicense) {
        this.id = id;
        this.licenseId = licenseId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.birthYear = birthYear;
        this.firstLicense = firstLicense;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(int licenseId) {
        this.licenseId = licenseId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public short getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(short birthYear) {
        this.birthYear = birthYear;
    }

    public Date getFirstLicense() {
        return firstLicense;
    }

    public void setFirstLicense(Date firstLicense) {
        this.firstLicense = firstLicense;
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
        if (!(object instanceof Licenses)) {
            return false;
        }
        Licenses other = (Licenses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "drivinglicensesregistry.Licenses[ id=" + id + " ]";
    }
    
}
