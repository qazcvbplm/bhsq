package com.medusa.bhsq.wxentity;

import com.medusa.bhsq.entity.User;

public class Mine {
    private User u;
    private int tz;
    private int gz;
    private int fs;
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	public int getTz() {
		return tz;
	}
	public void setTz(int tz) {
		this.tz = tz;
	}
	public int getGz() {
		return gz;
	}
	public void setGz(int gz) {
		this.gz = gz;
	}
	public int getFs() {
		return fs;
	}
	public void setFs(int fs) {
		this.fs = fs;
	}
	public Mine(User u, int tz, int gz, int fs) {
		super();
		this.u = u;
		this.tz = tz;
		this.gz = gz;
		this.fs = fs;
	}
    
}
