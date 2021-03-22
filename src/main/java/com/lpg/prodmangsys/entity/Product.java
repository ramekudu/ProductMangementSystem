package com.lpg.prodmangsys.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class Product {


    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "PRODUCT_NAME", length = 100, nullable = false)
    private String name;
    @Column(name = "PRODUCT_DESC", length = 100, nullable = false)
    private String description;
    @Column(name = "CREATION_DATE",  nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdDate;
    @Column(name = "UPDATED_DATE")
    @UpdateTimestamp
    private Date updatedDate;
    @Column(name = "LAST_PURCHASED_DATE")
    private Date lastPurchasedDate;

    @ManyToOne
    private Categories category;

    }

