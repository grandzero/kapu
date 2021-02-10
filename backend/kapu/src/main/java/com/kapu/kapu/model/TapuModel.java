package com.kapu.kapu.model;

//import javax.persistence.Entity;

import javax.persistence.*;

@Entity
@Table(name="tapular")
public class TapuModel {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;
    private String title;
    private String description;
    private String owner;
    private String imgUrl;
    private String status;
    private String state;
    private boolean archived;

    public TapuModel(){}
    public TapuModel(String title, String description, String owner, String imgUrl, String status, String state, boolean archived) {
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.imgUrl = imgUrl;
        this.status = status;
        this.state = state;
        this.archived = archived;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}
