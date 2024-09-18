package com.mrbonk97.hanadangdangbe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
