package com.yongqin.mybank.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class TransactionDto {
    @NotBlank
    private String reference;

    @NotNull
    private BigDecimal amount;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
