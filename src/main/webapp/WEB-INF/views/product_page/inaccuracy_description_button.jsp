<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<button class="btn btn-warning" style="margin-left: 30px;"
	onclick="openModalInaccuracyInDescription('${type}', ${product.id}, '${product.name}', '${product.pathPictures.get(0)}')">уточнение описания</button>