package com.printmaster.nk.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

//ignore "bytes" when return json format
@JsonIgnoreProperties({ "bytes" })
public class FileMeta {

	private String fileName;
	private int length;
	private String fileSize;
	private String fileType;

	private byte[] bytes;

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

}