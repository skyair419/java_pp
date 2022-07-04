package game4;

public class Member {
	// 필드
	private String id;
	private String pwd;

	// 생성자
	public Member(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	

	// 게터세터
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
