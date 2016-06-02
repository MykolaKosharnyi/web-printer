<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page session="true"%>
		<div id="pictures">
			<h3>Выберите файл(ы) для загрузки (800х600pdi)</h3>
			
			<c:if test="${empty product.id}">
				<form:form method="POST" commandName="add_picture" action="/admin/${type}/upload_pictures" enctype="multipart/form-data">
					<p><input id="files-upload" type="file" id="files" name="files" accept="image/*" ></p>
				
					<p id="drop-area">
						<span class="drop-instructions">или перетащите файлы сюда!</span>
						<span class="drop-over"></span>
					</p>
				</form:form>
				
				<ul id="file-list">
					<c:if test="${empty product.id}">
						<li class="no-items">(ни одного файла еще не загружено)</li>
					</c:if>
					<c:if test="${!empty product.id}">
						<c:forEach items="${product.pathPictures}" var="pathPicture">
							<li class="ui-state-default" id="${pathPicture}">
								<div>
									<p class="delete_img">Удалить</p>
								</div>
								<img src="/images/${type}s/${product.id}/${pathPicture}" alt="">
							</li>
						</c:forEach>
					</c:if>
				</ul>
			</c:if>
			
			<c:if test="${!empty product.id}">
				<form:form method="POST" commandName="add_picture_update" action="/admin/${type}/upload_pictures_update/${product.id}" enctype="multipart/form-data">
					<p><input id="files-upload_update" type="file" id="files" name="files" accept="image/*" ></p>
				
					<p id="drop-area_update">
						<span class="drop-instructions">или перетащите файлы сюда!</span>
						<span class="drop-over"></span>
					</p>
				</form:form>
				
				<ul id="file-list_update">
					<c:if test="${empty product.id}">
						<li class="no-items">(ни одного файла еще не загружено)</li>
					</c:if>
					<c:if test="${!empty product.id}">
						<c:forEach items="${product.pathPictures}" var="pathPicture">
							<li class="ui-state-default" id="${pathPicture}">
								<div>
									<p class="delete_img_update">Удалить</p>
								</div>
								<img src="/images/${type}s/${product.id}/${pathPicture}" alt="">
							</li>
						</c:forEach>
					</c:if>
				</ul>
			</c:if>
		</div>