package com.wadocoder.BlueSearch;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class BlueSearchApplicationTests {

	@Test
	void encryptPassword() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode("123123");
		System.out.println(encodedPassword);
	}
	@Test
	void unencode() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.matches("poop", "$2a$10$QDXMlYm5lhODIwkrhlpdA.hlcBkILuY8GmBz/AI0aLyd90EGQI3MC"));
	}

}
