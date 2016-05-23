<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page session="true"%>
		<div class="textarea_description">
			<div class="characteristic">
				<div class="block_title">
					<i></i>
					<p>Служебная информация</p>
				</div>
				<ul class="box_text_area">
					<form:textarea name="content" path="serviceInformation" value="${product.serviceInformation}"></form:textarea>
				</ul>
			</div>
		</div>

		<div class="textarea_description">
			<div class="characteristic">
				<div class="block_title">
					<i class="opened"></i>
					<p>Описание</p>
				</div>
				<ul class="box_text_area" style="display: block;">
					<form:textarea name="content" path="description" value="${product.description}"></form:textarea>
				</ul>
			</div>
		</div>
			
		<div class="textarea_description">
			<div class="characteristic">
				<div class="block_title">
					<i class="opened"></i>
					<p>Description(отображение при выборе английского языка на сайте)</p>
				</div>
				<ul class="box_text_area" style="display: block;">
					<form:textarea name="content" path="descriptionEng" value="${product.descriptionEng}"></form:textarea>
				</ul>
			</div>
		</div>
		
		<div class="textarea_description">
			<div class="characteristic">
				<div class="block_title">
					<i class="opened"></i>
					<p>Cопутствующие товары</p>
				</div>
				<div class="box_text_area" style="display: block;">
					<c:forEach items="${uwp}" var="uwProduct">
						<div class="use_with_product">
							<input class="input_uwp" type="checkbox" name="idUseWithProduct" value="${uwProduct.id}"  
									<c:forEach items="${product.idUseWithProduct}" var="tp"><c:if test="${tp==uwProduct.id}">checked</c:if></c:forEach>/>
						  	<div>	
								<p>Имя: ${uwProduct.name}</p>
								<p>Тип: ${uwProduct.typeProduct}</p>
								<p>Цена: $<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${uwProduct.prise}" /></p>
							</div>
							<img src="/images/use_with_products/${uwProduct.id}/${uwProduct.pathPictures.get(0)}" alt="">
						</div>
					</c:forEach>
				</div>
			</div>
		</div>