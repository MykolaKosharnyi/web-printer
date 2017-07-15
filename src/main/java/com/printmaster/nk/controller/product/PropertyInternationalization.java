package com.printmaster.nk.controller.product;

import java.io.Serializable;

import org.json.simple.JSONObject;

public class PropertyInternationalization implements Serializable{
	private static final long serialVersionUID = -2092388795690335576L;
	
	private boolean show;
	private String ru;
	private String en;
	
	public PropertyInternationalization(){}
	
	public PropertyInternationalization(boolean show, String ru, String en) {
		this.show = show;
		this.ru = ru;
		this.en = en;
	}
	public boolean isShow() {
		return show;
	}
	public void setShow(boolean show) {
		this.show = show;
	}
	public String getRu() {
		return ru;
	}
	public void setRu(String ru) {
		this.ru = ru;
	}
	public String getEn() {
		return en;
	}
	public void setEn(String en) {
		this.en = en;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getJSONObject(){
		JSONObject result = new JSONObject();
		result.put("show", this.isShow());
		result.put("ru", this.getRu());
		result.put("en", this.getEn());
		return result;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((en == null) ? 0 : en.hashCode());
		result = prime * result + ((ru == null) ? 0 : ru.hashCode());
		result = prime * result + (show ? 1231 : 1237);
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
		PropertyInternationalization other = (PropertyInternationalization) obj;
		if (en == null) {
			if (other.en != null)
				return false;
		} else if (!en.equals(other.en))
			return false;
		if (ru == null) {
			if (other.ru != null)
				return false;
		} else if (!ru.equals(other.ru))
			return false;
		if (show != other.show)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "{show=" + show + ", ru=" + ru + ", en=" + en + "}";
	}

}