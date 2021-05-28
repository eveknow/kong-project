package com.thanhtk.service.tracking.db.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_event", catalog = "")
public class ProductEventEntity {
    private int id;
    private String userName;
    private String productId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
