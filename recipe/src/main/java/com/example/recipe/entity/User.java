package com.example.recipe.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;

@Entity // 엔티티 클래스임을 선언
@Table(name="USER_INFO") //해당 엔티티 클래스와 매핑될 데이터베이스 이름 지정
@Getter
@Setter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_NO")
    private Long id;  // USER_NuMBER

    @Column(name = "USER_NAME" ,unique = true) // unique = true는 유일한 값만 저장할 수 있음
    private String username;  // 사용자ID

    @Column(name = "USER_NICKNAME" ,unique = true) // unique = true는 유일한 값만 저장할 수 있음
    private String usernickname;  // 닉네임

    @Column(name = "USER_PWD")
    private String password;  // 비밀번호

    @Column(name = "USER_EMAIL", unique = true)
    private String email;  // 이메일
}