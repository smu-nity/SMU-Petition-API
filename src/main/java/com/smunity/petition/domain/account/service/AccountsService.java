package com.smunity.petition.domain.account.service;

import com.smunity.petition.domain.account.dto.UserRegisterRequestDto;
import com.smunity.petition.domain.account.dto.UserRegisterResponseDto;
import com.smunity.petition.domain.account.entity.Department;
import com.smunity.petition.domain.account.entity.User;
import com.smunity.petition.domain.account.entity.Year;
import com.smunity.petition.domain.account.exception.AccountsExceptionHandler;
import com.smunity.petition.domain.account.repository.DepartmentJpaRepository;
import com.smunity.petition.domain.account.repository.YearJpaRepository;
import com.smunity.petition.domain.account.repository.user.UserRepository;
import com.smunity.petition.global.common.code.status.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class AccountsService {

    private final UserRepository userRepository;
    private final YearJpaRepository yearJpaRepository;
    private final DepartmentJpaRepository departmentJpaRepository;
    private final PasswordEncoder passwordEncoder;

    public UserRegisterResponseDto register(UserRegisterRequestDto request) {

        if (!request.password().equals(request.passwordCheck()))
            throw new AccountsExceptionHandler(ErrorCode.PASSWORD_NOT_EQUAL);

        String encodedPw = passwordEncoder.encode(request.password());
        User newUser = request.toEntity(encodedPw);

        Year year = yearJpaRepository.findByYear(request.username().substring(0, 4))
                .orElseThrow(() -> new AccountsExceptionHandler(
                        ErrorCode.SAMNUL_ERROR));
        Department department = departmentJpaRepository.findByName(request.department())
                .orElseThrow(() -> new AccountsExceptionHandler(ErrorCode.SAMNUL_ERROR));

        newUser.setYear(year);
        newUser.setDepartment(department);

        return UserRegisterResponseDto.from(userRepository.save(newUser));
    }
}
