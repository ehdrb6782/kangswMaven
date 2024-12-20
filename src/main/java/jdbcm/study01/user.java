package jdbcm.study01;

public class user {

	int no;
	String email;
	String pw;
	boolean isDel;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public boolean isisDel() {
		return isDel;
	}
	public void setisDel(boolean lsDel) {
		this.isDel = lsDel;
	}
	@Override
	public String toString() {
		return "user [no=" + no + ", email=" + email + ", pw=" + pw + ", lsDel=" + isDel + "]";
	}
	
}
