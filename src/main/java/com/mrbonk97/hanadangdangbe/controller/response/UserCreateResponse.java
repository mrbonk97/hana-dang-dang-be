package com.mrbonk97.hanadangdangbe.controller.response;

import com.mrbonk97.hanadangdangbe.model.Account;
import com.mrbonk97.hanadangdangbe.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateResponse {
    private User user;
    private Account account;

    public static UserCreateResponse from(final User user, final Account account) {
        String _accountNo = account.getAccountNo();
        String accountNo = _accountNo.substring(0, 8) + "-" + _accountNo.substring(8, 10);
        account.setAccountNo(accountNo);
        return new UserCreateResponse(user, account);
    }

}
