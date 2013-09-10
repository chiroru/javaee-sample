package jp.ddo.chiroru.javaee.sample.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD) 
@XmlRootElement(name = "Book")
@Entity
@Table(name = "BOOK", schema = "UT")
public class Book
implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    private Integer volume;

    private String description;

    private String picture;

    @Column(name ="BOOKSHELF_ID")
    private Integer bookshelfId;

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

    public Book() {}

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

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getBookshelfId() {
        return bookshelfId;
    }

    public void setBookshelfId(Integer bookshelfId) {
        this.bookshelfId = bookshelfId;
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
}
