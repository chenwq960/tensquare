package org.tensquare_user.pojo;

import java.util.Date;

public class User {
	private String id;

	private String loginname;

	private String mobile;

	private String password;

	private String nickname;

	private String sex;

	private Date birthday;

	private String avatar;

	private String email;

	private Date regdate;

	private Date updatedate;

	private Date lastdate;

	private Long online;

	private String interest;

	private String personality;

	private Integer fanscount;

	private Integer followcount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname == null ? null : loginname.trim();
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname == null ? null : nickname.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar == null ? null : avatar.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public Date getLastdate() {
		return lastdate;
	}

	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}

	public Long getOnline() {
		return online;
	}

	public void setOnline(Long online) {
		this.online = online;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest == null ? null : interest.trim();
	}

	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality == null ? null : personality.trim();
	}

	public Integer getFanscount() {
		return fanscount;
	}

	public void setFanscount(Integer fanscount) {
		this.fanscount = fanscount;
	}

	public Integer getFollowcount() {
		return followcount;
	}

	public void setFollowcount(Integer followcount) {
		this.followcount = followcount;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", loginname=" + loginname + ", mobile=" + mobile + ", password=" + password
				+ ", nickname=" + nickname + ", sex=" + sex + ", birthday=" + birthday + ", avatar=" + avatar
				+ ", email=" + email + ", regdate=" + regdate + ", updatedate=" + updatedate + ", lastdate=" + lastdate
				+ ", online=" + online + ", interest=" + interest + ", personality=" + personality + ", fanscount="
				+ fanscount + ", followcount=" + followcount + "]";
	}

}