package com.micro.data.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class TransactionDTO {
    private Integer id;
    private Integer userId;
    private String userName;
    private Long timestamp;
    private String txnType;
    private BigDecimal amount;
    private LocationDTO location;
    private String ip;
}
