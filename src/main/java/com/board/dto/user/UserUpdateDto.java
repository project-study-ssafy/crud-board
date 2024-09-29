package com.board.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상, 20자 이하로 입력해주세요")
    private String password;

    @NotBlank(message = "닉네임을 입력해주세요")
    @Size(max = 10, message = "닉네임은 최대 10자까지 입력 가능합니다")
    private String nickname;
}
