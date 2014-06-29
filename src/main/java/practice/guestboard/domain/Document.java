package practice.guestboard.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Document {
	private Long id;
	
	@NotNull
	@Pattern(regexp = "^([^@\\s])+[@][^@\\s]+[.][^@\\s]+", message = "올바른 이메일 형식이 아닙니다.")
	private String mail;
	
	@NotNull
	@Size(min = 1, message = "비밀번호는 필수입니다.")
	private String password;
	
	@NotNull
	@Size(min = 1, message = "내용을 입력하세요.")
	private String content;
	
	private Timestamp time;
	private Timestamp updatetime;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	
}
