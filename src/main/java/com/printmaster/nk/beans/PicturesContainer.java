package com.printmaster.nk.beans;

import java.util.LinkedList;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode  = ScopedProxyMode.TARGET_CLASS)
public class PicturesContainer {
	private LinkedList<FileMeta> files = new LinkedList<FileMeta>();
	
	public LinkedList<FileMeta> getFiles() {
		return files;
	}

	public void setFiles(LinkedList<FileMeta> files) {
		this.files = files;
	}

	public boolean add(FileMeta fm){
		return files.add(fm);
	}
	
	public FileMeta get(int index){
		return files.get(index);
	}
	
	public int size(){
		return files.size();
	}
	
	public void clear(){
		files.clear();
	}
}
