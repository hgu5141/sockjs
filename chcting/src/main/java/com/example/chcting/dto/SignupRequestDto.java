package com.example.chcting.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;


@Setter
@Getter
@ToString
@NoArgsConstructor

public class SignupRequestDto {
    @NotBlank(message = "이메일을 입력해주세요.")
    @Email
    private String username;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,12}$", message = "비밀번호를 6~12자로 입력해주세요.(특수문자 제외)")
    private String password;

    @NotBlank(message = "비밀번호 확인을 입력해주세요.")
    private String passwordcheck;

    @NotNull
    private String nickname;

}
