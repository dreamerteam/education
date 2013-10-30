package com.dreamer.education.bean.ro;

import java.io.Serializable;

/*
* @author Owen
* @version 创建时间：2013年10月28日 下午2:59:03 
*/ 
public class CourseResponse implements Serializable{


	private static final long serialVersionUID = -6683111716618301937L;
	private String cname;
	private String utypeid;
	private String utypename;
	private String cdescription;
	private	String uuid;
	
	public String getCname(){
		return cname;
	}
	
	public void setCname(String cname){
		this.cname=cname;
	}
	
	public String getUtypeid(){
		return utypeid;
	}

	public void setUtypeid(String utypeid){
		this.utypeid=utypeid;
	}
	
	public String getUtypename(){
		return utypename;
	}
	
	public void setUtypename(String utypename){
		this.utypename=utypename;
	}
	
	public String getCdescription(){
		return cdescription;
	}
	
	public void setCdescription(String cdescription){
		this.cdescription=cdescription;
	}
	
	public String getUuid() {
        return uuid;
    }
    
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
