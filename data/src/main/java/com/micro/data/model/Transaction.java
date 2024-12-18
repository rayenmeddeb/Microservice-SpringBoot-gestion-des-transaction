package com.micro.data.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    private Integer id;
    
    @Column(name = "user_id")
    private Integer userId;
    
    @Column(name = "user_name")
    private String userName;
    
    private Long timestamp;
    
    @Column(name = "txn_type")
    private String txnType;
    
    private BigDecimal amount;
    
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    
    private String ip;
}
