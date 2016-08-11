<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page session="true"%>
<!DOCTYPE>
<html>
<head>
	<meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="/css/admin/add_change_printer.css">
	<script src="<%=request.getContextPath()%>/resources/js/admin/add_change_printer.js"></script>

<c:if test="${empty product.id}">
	<title>
		<spring:message text="Добавление нового товара" />
	</title>
</c:if>
<c:if test="${!empty product.id}">
	<title>
		<spring:message text="Изменение" />
	</title>
</c:if>
</head>
<body>
	
	<div id="product">
	
		<c:if test="${empty product.id}">
			<label id="head_of_page"><spring:message text="Добавление нового товара" /></label>
			<c:url var="addAction" value="/admin/${type}/add" ></c:url>
		</c:if>
			
		<c:if test="${!empty product.id}">
			<label id="head_of_page"><spring:message text="Изменение ${product.name}, код товара: ${product.partNumber} " /></label>
			<c:url var="addAction" value="/admin/${type}/update" ></c:url>
		</c:if>
		
		<jsp:include page="product/pictures.jsp" />

	<form:form method="POST" commandName="product" action="${addAction}">
		<div class="save_button_keeper">	
			<c:if test="${empty product.id}">
				<c:url value="/admin/${type}/save_add" var="saveLoad" />
				<input id="submit" type="submit" formaction="${saveLoad}" value="сохранить" style="background: gold; color: black;"/>
				<input id="submit" type="submit" value="загрузить" style="background: green; color: azure;"/>
			</c:if>
			
			<c:if test="${!empty product.id}">
				<c:url value="/admin/${type}/save_update" var="saveUpdate" />
				<input id="submit" type="submit" formaction="${saveUpdate}" value="сохранить" style="background: gold; color: black;"/>
				<input id="submit" type="submit" value="изменить" style="background:blue; color: azure;"/>
			</c:if>
			
			<c:if test="${!empty product.id}">
					<input type="hidden" name="id" value="${product.id}">
			</c:if>
		</div>
			<div class="product_characteristic">
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Название товара</p>
						<form:errors path="name" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="name"/>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Код товара</p>
						<form:errors path="partNumber" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="partNumber" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Цена</p>
						<form:errors path="prise" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<p>$</p><form:input path="prise" class="amount-prise" value="${product.prise}"/>
						</div>
							<div class="slider-range-prise"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип товара</p>
						<form:errors path="typeProduct" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${use_with_product.type_product}" path="typeProduct" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Наличие (информация для пользователя)</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${use_with_product.availability}" path="availability" element="li"/>
						
						<div class="text_output">
							<form:input path="availabilitySpecialCase"/>
						</div>
					</ul>
				</div>
				<div class="product_option">
					<div class="block_title">
						<i class="opened"></i>
						<p>Опции (с заданием цены и описания за дополнительную услугу)</p>
					</div>
					<ul class="check_boxes" style="display: block;">
						<div class="text_output">
							<p class="option_name">Инсталяция:&nbsp;</p>
							<form:input path="optionInstallation" class="option"/>
							<form:errors path="optionInstallation" cssClass="error"></form:errors>
							<form:input path="descriptionOptionInstallation"  class="option_description"/>
							<form:errors path="descriptionOptionInstallation" cssClass="error"></form:errors>
						</div>
						<hr>
						<div class="text_output">
							<p class="option_name">НДС:&nbsp;</p>
							<form:input path="optionVAT" class="option"/>
							<form:errors path="optionVAT" cssClass="error"></form:errors>
							<form:input path="descriptionOptionVAT"  class="option_description"/>
							<form:errors path="descriptionOptionVAT" cssClass="error"></form:errors>
						</div>
						<hr>
						<div class="text_output">
							<form:input path="nameAddedOption" class="option"/>
							<p>:&nbsp;</p>
							<form:input path="priceAddedOption" class="option"/>
							<form:errors path="priceAddedOption" cssClass="error"></form:errors>
							<form:input path="descriptionOptionAddedOption"  class="option_description"/>
							<form:errors path="descriptionOptionAddedOption" cssClass="error"></form:errors>
						</div>
						<hr>
						<div class="text_output">
							<form:input path="nameAddedOption2" class="option"/>
							<p>:&nbsp;</p>
							<form:input path="priceAddedOption2" class="option"/>
							<form:errors path="priceAddedOption2" cssClass="error"></form:errors>
							<form:input path="descriptionOptionAddedOption2"  class="option_description"/>
							<form:errors path="descriptionOptionAddedOption2" cssClass="error"></form:errors>
						</div>
						<hr>
						<div class="text_output">
							<form:input path="nameAddedOption3" class="option"/>
							<p>:&nbsp;</p>
							<form:input path="priceAddedOption3" class="option"/>
							<form:errors path="priceAddedOption3" cssClass="error"></form:errors>
							<form:input path="descriptionOptionAddedOption3"  class="option_description"/>
							<form:errors path="descriptionOptionAddedOption3" cssClass="error"></form:errors>
						</div>
						
					</ul>
				</div>
			</div>

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
		
			<c:if test="${empty product.id}">
				<input id="submit" type="submit" value="загрузить" style="background:green; color: azure;"/>
			</c:if>
			
			<c:if test="${!empty product.id}">
				<input id="submit" type="submit" value="изменить" style="background:blue; color: azure;"/>
			</c:if>

		</form:form>
	</div>
	
	<jsp:include page="product/js_code.jsp" />
	
</body>
</html>