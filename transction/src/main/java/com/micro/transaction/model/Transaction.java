package com.micro.transaction.model;

import lombok.Data;
import jakarta.persistence.*;
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
