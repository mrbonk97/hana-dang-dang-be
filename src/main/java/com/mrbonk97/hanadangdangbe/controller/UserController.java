package com.mrbonk97.hanadangdangbe.controller;

import com.mrbonk97.hanadangdangbe.controller.request.UserCreateRequest;
import com.mrbonk97.hanadangdangbe.controller.request.UserSignInRequest;
import com.mrbonk97.hanadangdangbe.controller.response.UserCreateResponse;
import com.mrbonk97.hanadangdangbe.model.Account;
import com.mrbonk97.hanadangdangbe.model.User;
import com.mrbonk97.hanadangdangbe.service.AccountService;
import com.mrbonk97.hanadangdangbe.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<UserCreateResponse> createUser(@RequestBody UserCreateRequest userCreateRequest) {
        User user = userService.saveUser(
                userCreateRequest.getName(),
                userCreateRequest.getMobileNo(),
                userCreateRequest.getUsername(),
                userCreateRequest.getPassword()
        );

        Account account = accountService.createAccount(user);
        log.info("사용자 계좌 생성 이름:{} 계좌번호:{}",user.getName(), account.getAccountNo());

        return ResponseEntity.ok(UserCreateResponse.from(user, account));
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<UserCreateResponse> signInUser(@RequestBody UserSignInRequest userSignInRequest) {
        User user = userService.signInUser(userSignInRequest.getUsername(), userSignInRequest.getPassword());
        Account account = accountService.getAccountByUser(user);
        log.info("유저 로그인 함 {}", user.getId());

        return ResponseEntity.ok(UserCreateResponse.from(user, account));

    }
}