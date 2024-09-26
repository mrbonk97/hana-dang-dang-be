package com.mrbonk97.hanadangdangbe.service;

import com.mrbonk97.hanadangdangbe.model.User;
import com.mrbonk97.hanadangdangbe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));
    }

    public User signInUser(String username, String password) {
        User user = findUserByUsername(username);
        if(!user.getPassword().equals(password)) throw new RuntimeException("패스워드가 일치하지 않습니다.");
        return user;
    }


    public User saveUser(String name, String mobileNo, String username, String password) {
        User user = new User();
        user.setName(name);
        user.setMobileNo(mobileNo);
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);
    }

    public User updateDividendInfo(Long id, Long dividendGoal, String dividendRiskType, String dividendPreference, String dividendArea) {
        User user = findUserById(id);
        user.setIsDividendCreated(true);
        user.setDividendGoal(dividendGoal);
        user.setDividendRiskType(dividendRiskType);
        user.setDividendPreference(dividendPreference);
        user.setDividendArea(dividendArea);
        return userRepository.save(user);
    }
}
