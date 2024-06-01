// 해당하는 데이터가 없을경우
// DataNotFoundException은 데이터베이스에서 특정 엔티티 또는 데이터를 찾을 수 없을 때 발생시키는 예외 클래스
// 이 예외가 발생하면 스프링 부트는 설정된 HTTP 상태 코드(HttpStatus.NOT_FOUND)와 이유("entity not found")를 포함한 응답을 생성하여 클라이언트에게 반환하게 된다.
// 여기서는 404 오류를 반환하도록 작성

package com.example.recipe;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class DataNotFoundException extends RuntimeException {
	// RuntimeException 클래스: 사용자 정의 예외 클래스를 정의하는 방법, 의미: 실행시 예외
	@Serial
	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String message) {
		super(message);
	}
}
