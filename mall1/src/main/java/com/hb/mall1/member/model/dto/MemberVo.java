package com.hb.mall1.member.model.dto;


public class MemberVo {
	private String userid;
	private String userpw;
	private String username;
	private String email1;
	private String email2;
	private String zipcode;	
	private String addr;
	private String addr2;	
	private String tel1;
	private String tel2;
	private String tel3;
	
	
	public MemberVo() {
		// TODO Auto-generated constructor stub
	}


	public MemberVo(String userid, String userpw, String username,
			String email1, String email2, String zipcode, String addr,
			String addr2, String tel1, String tel2, String tel3) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.email1 = email1;
		this.email2 = email2;
		this.zipcode = zipcode;
		this.addr = addr;
		this.addr2 = addr2;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.tel3 = tel3;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getUserpw() {
		return userpw;
	}


	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail1() {
		return email1;
	}


	public void setEmail1(String email1) {
		this.email1 = email1;
	}


	public String getEmail2() {
		return email2;
	}


	public void setEmail2(String email2) {
		this.email2 = email2;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public String getAddr2() {
		return addr2;
	}


	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}


	public String getTel1() {
		return tel1;
	}


	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}


	public String getTel2() {
		return tel2;
	}


	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}


	public String getTel3() {
		return tel3;
	}


	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}


	@Override
	public String toString() {
		return "MemberVo [userid=" + userid + ", userpw=" + userpw
				+ ", username=" + username + ", email1=" + email1 + ", email2="
				+ email2 + ", zipcode=" + zipcode + ", addr=" + addr
				+ ", addr2=" + addr2 + ", tel1=" + tel1 + ", tel2=" + tel2
				+ ", tel3=" + tel3 + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result + ((addr2 == null) ? 0 : addr2.hashCode());
		result = prime * result + ((email1 == null) ? 0 : email1.hashCode());
		result = prime * result + ((email2 == null) ? 0 : email2.hashCode());
		result = prime * result + ((tel1 == null) ? 0 : tel1.hashCode());
		result = prime * result + ((tel2 == null) ? 0 : tel2.hashCode());
		result = prime * result + ((tel3 == null) ? 0 : tel3.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((userpw == null) ? 0 : userpw.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVo other = (MemberVo) obj;
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
			return false;
		if (addr2 == null) {
			if (other.addr2 != null)
				return false;
		} else if (!addr2.equals(other.addr2))
			return false;
		if (email1 == null) {
			if (other.email1 != null)
				return false;
		} else if (!email1.equals(other.email1))
			return false;
		if (email2 == null) {
			if (other.email2 != null)
				return false;
		} else if (!email2.equals(other.email2))
			return false;
		if (tel1 == null) {
			if (other.tel1 != null)
				return false;
		} else if (!tel1.equals(other.tel1))
			return false;
		if (tel2 == null) {
			if (other.tel2 != null)
				return false;
		} else if (!tel2.equals(other.tel2))
			return false;
		if (tel3 == null) {
			if (other.tel3 != null)
				return false;
		} else if (!tel3.equals(other.tel3))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (userpw == null) {
			if (other.userpw != null)
				return false;
		} else if (!userpw.equals(other.userpw))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}

}
