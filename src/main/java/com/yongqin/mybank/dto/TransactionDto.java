package com.yongqin.mybank.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class TransactionDto {

    @NotNull
    private BigDecimal amount;

    @NotBlank
    private String reference;

    @NotBlank
    private String receivingUser;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReceivingUser() {
        return receivingUser;
    }

    public void setReceivingUser(String receivingUser) {
        this.receivingUser = receivingUser;
    }

}
