package com.mykoshar.shop.api.beans;

public class Delivery {

	private boolean checked;
	private String name;
	private double priceSize;
	private double priceWeight;
	private String description;
	
	public Delivery(){}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPriceSize() {
		return priceSize;
	}

	public void setPriceSize(double priceSize) {
		this.priceSize = priceSize;
	}

	public double getPriceWeight() {
		return priceWeight;
	}

	public void setPriceWeight(double priceWeight) {
		this.priceWeight = priceWeight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (checked ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(priceSize);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(priceWeight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Delivery other = (Delivery) obj;
		if (checked != other.checked)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(priceSize) != Double.doubleToLongBits(other.priceSize))
			return false;
		if (Double.doubleToLongBits(priceWeight) != Double.doubleToLongBits(other.priceWeight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[checked=" + checked + ", name=" + name + ", priceSize=" + priceSize + ", priceWeight="
				+ priceWeight + ", description=" + description + "]";
	}
	
}
