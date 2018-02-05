package com.maskbor.cakemanager.model;

import javax.persistence.*;
/**
 *
 * @author root
 */

@Entity
@Table(name = "cake")
public class Cake {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusType status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

}
