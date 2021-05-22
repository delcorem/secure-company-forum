package ca.sheridancollege.delcorem.beans;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class User {

	private Long userId;
	@NonNull
	private String email;
	@NonNull
	private String encryptedPassword;
	@NonNull
	private Boolean enabled;
	
	private Long discussionId;
	
	private String userDiscussion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate discussionDate;
	
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime discussionTime;
}
