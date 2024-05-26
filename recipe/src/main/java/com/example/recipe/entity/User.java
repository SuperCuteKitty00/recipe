package com.example.recipe.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;

@Entity // 엔티티 클래스임을 선언
@Table(name="USER_INFO") //해당 엔티티 클래스와 매핑될 데이터베이스 이름 지정
@Getter
@Setter
@ToString
@SequenceGenerator(
    name = "USER_SEQ_GENERATOR",
    sequenceName = "USER_SEQ", //매핑할 데이터베이스 시퀀스 이름
    initialValue = 1,
    allocationSize = 1)
public class User {
    @Id // 엔티티 클래스의 주요 식별자(PK)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,
//                    generator = "USER_SEQ_GENERATOR")
    private int userSeq;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String userName;
}
