package jp.ddo.chiroru.javaee.sample.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import jp.ddo.chiroru.javaee.sample.presentation.format.TimestampAdapter;

public class Bookshelf
implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @XmlElement(name = "createdAt", required = true) 
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    @Column(name = "CREATED_AT")
    private Timestamp createdAt;

    @Column(name = "CREATED_USER")
    private String createdUser;

    @XmlElement(name = "updatedAt", required = true)
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    @Column(name = "UPDATED_AT")
    private Timestamp updatedAt;

    @Column(name = "UPDATED_USER")
    private String updatedUser;

    public Bookshelf() {}

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
