package com.printmaster.nk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="picture")
public class Picture extends Model{
	
	private static final long serialVersionUID = -7914406547800809890L;
	
	@Column(name="table_and_id")
	private String tableAndId = "";
	
	@Column(name="path_picture")
	private String pathPicture = "";

	public Picture() {
		super();
	}

	public Picture(int id) {
		super(id);
	}
	
	public String getTableAndId() {
		return tableAndId;
	}

	public void setTableAndId(String tableAndId) {
		this.tableAndId = tableAndId;
	}

	public String getPathPicture() {
		return pathPicture;
	}

	public void setPathPicture(String pathPicture) {
		this.pathPicture = pathPicture;
	}
	
}
