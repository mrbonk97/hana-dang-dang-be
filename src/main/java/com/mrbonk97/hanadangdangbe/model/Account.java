package com.mrbonk97.hanadangdangbe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity(name = "TB_ACCOUNT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    private String accountNo;
    private String title;
    private Long balance = 0L;
    private Long withDrawAmount = 0L;
    @JsonIgnore
    @OneToOne
    private User user;

    @Transient
    private Long totalBalance = 0L;
    @Transient
    private Long stockInitBalance = 0L;
    @Transient
    private Long stockCurrentBalance = 0L;
    @Transient
    private Long stockProfit = 0L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNo, account.accountNo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accountNo);
    }
}
