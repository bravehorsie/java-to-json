package info.grigoriadi.javatojson;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigNumberPojo {

    private Long id;

    private BigDecimal amount;

    private BigInteger count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }
}
