<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page session="true"%>
<html lang="ru">
<head>
	<title>${title}</title>
	<meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>	
</head>
<body>
	<div id="product">
	
		<c:url var="addAction" value="/admin/internationalization/{subType}/update" ></c:url>
		<form action="${addAction}" method="POST">
						
			<c:forEach var="item" items="${descriptions}">  
		    	
			</c:forEach>
			
			
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Имя:</label>
				<div class="col-sm-10">
					<input type="text" value="">
				</div>
		  	</div>






			<p>Цена за доллар в гривнах</p><form:input path="dollarInGrivna"/>
			<form:errors path="dollarInGrivna" cssClass="error"></form:errors>
			<hr>
			<p>Цена за евро в гривнах</p><form:input path="euroInGrivna"/>
			<form:errors path="euroInGrivna" cssClass="error"></form:errors>
			<hr>
			<p>Цена за авиа доставку учитывая габариты, в долларах</p><form:input path="priceAviaSize"/>
			<form:errors path="priceAviaSize" cssClass="error"></form:errors>
			<hr>
			<p>Цена за авиа доставку учитывая вес, в долларах</p><form:input path="priceAviaWeight"/>
			<form:errors path="priceAviaWeight" cssClass="error"></form:errors>
			<hr>
			<p>Цена за доставку морем учитывая габариты, в долларах</p><form:input path="priceSeaSize"/>
			<form:errors path="priceSeaSize" cssClass="error"></form:errors>
			<hr>
			<p>Цена за доставку морем учитывая вес, в долларах</p><form:input path="priceSeaWeight"/>
			<form:errors path="priceSeaWeight" cssClass="error"></form:errors>
			<hr>
			<p>Цена за доставку по украине учитывая габариты, в долларах</p><form:input path="priceUkraineSize"/>
			<form:errors path="priceUkraineSize" cssClass="error"></form:errors>
			<hr>
			<p>Цена за доставку по украине учитывая вес, в долларах</p><form:input path="priceUkraineWeight"/>
			<form:errors path="priceUkraineWeight" cssClass="error"></form:errors>
			<hr>
			<p>Цена за доставку по Киеву учитывая габариты, в долларах</p><form:input path="priceKyivSize"/>
			<form:errors path="priceKyivSize" cssClass="error"></form:errors>
			<hr>
			<p>Цена за доставку по Киеву учитывая вес, в долларах</p><form:input path="priceKyivWeight"/>
			<form:errors path="priceKyivWeight" cssClass="error"></form:errors>
			<hr>
			<p>Страхование груза по Украине (указывать процент от 1 до 100%)</p><form:input path="percentInsuranceUkraine"/>
			<form:errors path="percentInsuranceUkraine" cssClass="error"></form:errors>
			<hr>
			<p>Страхование груза международная перевозка (указывать процент от 1 до 100%)</p><form:input path="percentInsuranceInternational"/>
			<form:errors path="percentInsuranceInternational" cssClass="error"></form:errors>
		
			<input id="submit" type="submit" value="изменить" style="background:blue; color: azure; margin-bottom: 40px;"/>
		</form>
	</div>
</body>
</html>










<!DOCTYPE>
<html>

<body>
<div id="product">
	<c:if test="${empty user.id}">
		<c:url var="addAction" value="/admin/user/create"></c:url>
	</c:if>

	<c:if test="${!empty user.id}">
		<c:url var="addAction" value="/admin/user/update"></c:url>
	</c:if>

		<form:form class="form-horizontal" style="padding: 10px 0px;" commandName="user" action="${addAction}" method="post">
		
			<c:if test="${!empty user.id}">
				<input type="hidden" name="id" value="${user.id}">
				<input type="hidden" name="timeRegistration" 
					value="<fmt:formatDate value="${user.timeRegistration}" pattern="dd/MM/yyyy hh:mm:ss" />">	
			</c:if>
		
		  <div class="form-group">
			<label for="firstName" class="col-sm-2 control-label">Имя:</label>
			<div class="col-sm-10">
			  <form:input path="firstName" class="form-control" value="${user.firstName}"/>
			</div>
		  </div>
		  <div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">Фамилия:</label>
			<div class="col-sm-10">
			  <form:input path="lastname" class="form-control" value="${user.lastname}"/>
			</div>
		  </div>
		  <div class="form-group">
			<label for="county" class="col-sm-2 control-label">Страна:</label>
			<div class="col-sm-10">
			  <form:input path="county" class="form-control" value="${user.county}"/>
			</div>
		  </div>
		  <div class="form-group">
			<label for="city" class="col-sm-2 control-label">Город:</label>
			<div class="col-sm-10">
			  <form:input path="city" class="form-control" value="${user.city}"/>
			</div>
		  </div>
		  <div class="form-group">
			<label for="telephone" class="col-sm-2 control-label">Номер телефона:</label>
			<div class="col-sm-10">
			  <form:input path="telephone" class="form-control" value="${user.telephone}" placeholder="+38(099) 99-99-999"/>
			</div>
		  </div>
		  <div class="form-group">
			<label for="company" class="col-sm-2 control-label">Компания:</label>
			<div class="col-sm-10">
			  <form:input path="company" class="form-control" value="${user.company}"/>
			</div>
		  </div>
		  <div class="form-group">
			<label for="email" class="col-sm-2 control-label">E-mail:</label>
			<div class="col-sm-10">
			  <form:input path="email" class="form-control" value="${user.email}"/>
			  <p class="bg-success info_of_adding">Введенное значение удовлетворяет требованиям!</p>
			  <p class="bg-danger info_of_adding">Есть повторение с раннее введенным e-mail или он не корректен!</p>
			</div>
		  </div>
		  <div class="form-group">
			<label for="email2" class="col-sm-2 control-label">E-mail (2):</label>
			<div class="col-sm-10">
			  <form:input path="email2" class="form-control" value="${user.email2}"/>
			  <p class="bg-success info_of_adding">Введенное значение удовлетворяет требованиям!</p>
			  <p class="bg-danger info_of_adding">Есть повторение с раннее введенным e-mail или он не корректен!</p>
			</div>
		  </div>
		  <div class="form-group">
			<label for="email3" class="col-sm-2 control-label">E-mail (3):</label>
			<div class="col-sm-10">
			  <form:input path="email3" class="form-control" value="${user.email3}"/>
			  <p class="bg-success info_of_adding">Введенное значение удовлетворяет требованиям!</p>
			  <p class="bg-danger info_of_adding">Есть повторение с раннее введенным e-mail или он не корректен!</p>
			</div>
		  </div>
		  <div class="form-group">
			<label for="date_sending" class="col-sm-2 control-label">День рождения:</label>
			<div class="col-sm-10">
				<div id="datetimepicker" class="input-group input-append date" style="height: 25px;">
					<input data-format="dd/MM/yyyy hh:mm:ss" name="dateOfBirthDay" value="<fmt:formatDate value="${user.dateOfBirthDay}" pattern="dd/MM/yyyy hh:mm:ss" />"
					 class="form-control" type="text"></input>
					<span class="add-on input-group-addon">
					  <span class="glyphicon glyphicon-calendar"></span>
					</span>
				</div>
			</div>
		  </div>
		  <div class="form-group">
			<label class="col-sm-2 control-label">Сфера деятельности:</label>
			<div class="col-sm-10">
				<ul class="list_without_dots" style="list-style-type: none; padding: 0px;">
					<form:checkboxes items="${listScopeOfActivities}" path="scopeOfActivities" element="li"/>
				</ul>
			</div>
		  </div>
		  <div class="form-group">
			<label class="col-sm-2 control-label">Подписки:</label>
				<div class="col-sm-10">
					<c:forEach var="subscr" items="${listSubscription}">

						<h4>${subscr.key}</h4>
						<c:forEach var="val" items="${subscr.value}">
							<div class="checkbox">
								<label> <input type="checkbox" name="subscription"
									value="${val}"
									<c:forEach items="${user.subscription}" var="tp"> <c:if test="${val eq tp}">checked</c:if> </c:forEach>>
									${val}
								</label>
							</div>
						</c:forEach>

					</c:forEach>
				</div>
			</div>
		  
		  <div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
			  <button type="submit" class="btn btn-primary">
			  	<c:if test="${empty user.id}">Сохранить</c:if>
			  	<c:if test="${!empty user.id}">Изменить</c:if>
			  </button>
			</div>
		  </div>

		</form:form>
	</div>

</body>
</html>