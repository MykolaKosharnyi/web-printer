<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page session="true"%>		
			<!-- delivery -->		
			<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Доставка (в формате {Ш}x{В}x{Г}x{Ц}, {Вес}x{Ц})</p>
					</div>
					<div class="check_boxes">
							
							<p class="deliveryWHW">Ширина, м :&nbsp;</p><form:input path="deliveryWidth" class="delivery_option"/><br>
							<p class="deliveryWHW">Высота, м :&nbsp;</p><form:input path="deliveryHeight" class="delivery_option"/><br>
							<p class="deliveryWHW">Глубина, м :&nbsp;</p><form:input path="deliveryDepth" class="delivery_option"/><br>
							<p class="deliveryWHW">Вес, кг :&nbsp;</p><form:input path="deliveryWeight" class="delivery_option"/>
							<form:errors path="deliveryWidth" cssClass="error"></form:errors>
							<form:errors path="deliveryHeight" cssClass="error"></form:errors>
							<form:errors path="deliveryDepth" cssClass="error"></form:errors>
							<form:errors path="deliveryWeight" cssClass="error"></form:errors>
							<hr>
							
						<div class="delivery_text_output">
							<p class="delivery_option_name">Авиа:&nbsp;</p>
							
							<p>цена по габаритам - &nbsp;</p>
							<input name="airDeliveryPriceSize" type="checkbox" <c:if test="${product.airDeliveryPriceSize}">checked</c:if> style="float: none;"/>
							<br>
							<p class="delivery_last_price_description">цена по весу - &nbsp;</p>
							<input name="airDeliveryPriceWeight" type="checkbox" <c:if test="${product.airDeliveryPriceWeight}">checked</c:if>
							 style="left: 90px; position: relative;"/>
							
							<form:errors path="airDeliveryPriceSize" cssClass="error"></form:errors>
							<form:errors path="airDeliveryPriceWeight" cssClass="error"></form:errors>
							
						</div>
						<form:input path="airDeliveryDescription" style="width: 100%;"/>
						
						<hr>
						<div class="delivery_text_output">
							<p class="delivery_option_name">Морем:&nbsp;</p>
							
							<p>цена по габаритам - &nbsp;</p>
							<input name="seaDeliveryPriceSize" type="checkbox" <c:if test="${product.seaDeliveryPriceSize}">checked</c:if> style="float: none;"/>
							<br>
							<p class="delivery_last_price_description">цена по весу - &nbsp;</p>
							<input name="seaDeliveryPriceWeight" type="checkbox" <c:if test="${product.seaDeliveryPriceWeight}">checked</c:if>
							 style="left: 90px; position: relative;"/>
							
							<form:errors path="seaDeliveryPriceSize" cssClass="error"></form:errors>
							<form:errors path="seaDeliveryPriceWeight" cssClass="error"></form:errors>
							
						</div>
						<form:input path="seaDeliveryDescription" style="width: 100%;"/>
						
						<hr>
						<div class="delivery_text_output">
							<p class="delivery_option_name">По Украине:&nbsp;</p>
							
							<p>цена по габаритам - &nbsp;</p>
							<input name="ukraineDeliveryPriceSize" type="checkbox" <c:if test="${product.ukraineDeliveryPriceSize}">checked</c:if> style="float: none;"/>
							<br>
							<p class="delivery_last_price_description">цена по весу - &nbsp;</p>
							<input name="ukraineDeliveryPriceWeight" type="checkbox" <c:if test="${product.ukraineDeliveryPriceWeight}">checked</c:if>
							 style="left: 90px; position: relative;"/>
							
							<form:errors path="ukraineDeliveryPriceSize" cssClass="error"></form:errors>
							<form:errors path="ukraineDeliveryPriceWeight" cssClass="error"></form:errors>
							
						</div>
						<form:input path="ukraineDeliveryDescription" style="width: 100%;"/>
						
						<hr>
						<div class="delivery_text_output">
							<p class="delivery_option_name">По Киеву:&nbsp;</p>

							<p>цена по габаритам - &nbsp;</p>
							<input name="kyivDeliveryPriceSize" type="checkbox" <c:if test="${product.kyivDeliveryPriceSize}">checked</c:if> style="float: none;"/>
							<br>
							<p class="delivery_last_price_description">цена по весу - &nbsp;</p>
							<input name="kyivDeliveryPriceWeight" type="checkbox" <c:if test="${product.kyivDeliveryPriceWeight}">checked</c:if>
							 style="left: 90px; position: relative;"/>

							<form:errors path="kyivDeliveryPriceSize" cssClass="error"></form:errors>
							<form:errors path="kyivDeliveryPriceWeight" cssClass="error"></form:errors>
							
						</div>
						<form:input path="kyivDeliveryDescription" style="width: 100%;"/>
						
						<hr>
						<div class="delivery_text_output">
							<form:input path="variant1DeliveryName" class="delivery_custom_option_name"/>
							<p>:&nbsp;</p>

							<p>цена по габаритам - &nbsp;</p>
							<form:input path="variant1DeliveryPriceSize" class="delivery_option" style="float: none;"/>
							<br>
							<p class="delivery_last_price_description">цена по весу - &nbsp;</p>
							<form:input path="variant1DeliveryPriceWeight" style="left: 90px; position: relative;" class="delivery_option"/>

							<form:errors path="variant1DeliveryPriceSize" cssClass="error"></form:errors>
							<form:errors path="variant1DeliveryPriceWeight" cssClass="error"></form:errors>
							
						</div>
						<form:input path="variant1DeliveryDescription" style="width: 100%;"/>		
						
						<hr>
						<div class="delivery_text_output">
							<form:input path="variant2DeliveryName" class="delivery_custom_option_name"/>
							<p>:&nbsp;</p>

							<p>цена по габаритам - &nbsp;</p>
							<form:input path="variant2DeliveryPriceSize" class="delivery_option" style="float: none;"/>
							<br>
							<p class="delivery_last_price_description">цена по весу - &nbsp;</p>
							<form:input path="variant2DeliveryPriceWeight" style="left: 90px; position: relative;" class="delivery_option"/>

							<form:errors path="variant2DeliveryPriceSize" cssClass="error"></form:errors>
							<form:errors path="variant2DeliveryPriceWeight" cssClass="error"></form:errors>
							
						</div>
						<form:input path="variant2DeliveryDescription" style="width: 100%;"/>
						
						<hr>
						<div class="delivery_text_output">
							<form:input path="variant3DeliveryName" class="delivery_custom_option_name"/>
							<p>:&nbsp;</p>

							<p>цена по габаритам - &nbsp;</p>
							<form:input path="variant3DeliveryPriceSize" class="delivery_option" style="float: none;"/>
							<br>
							<p class="delivery_last_price_description">цена по весу - &nbsp;</p>
							<form:input path="variant3DeliveryPriceWeight" style="left: 90px; position: relative;" class="delivery_option"/>

							<form:errors path="variant3DeliveryPriceSize" cssClass="error"></form:errors>
							<form:errors path="variant3DeliveryPriceWeight" cssClass="error"></form:errors>
							
						</div>
						<form:input path="variant3DeliveryDescription" style="width: 100%;"/>
						
						<hr>
						
					</div>
				</div>
				
				<!-- insurance -->	
				<div class="characteristic">
					<div class="block_title">
						<i class="opened"></i>
						<p>Страхование</p>
					</div>
					<div class="check_boxes" style="display: block;">

						<div class="text_output" style="height: 75px;">
							<p class="option_name" style="width: 100%;">Страхование груза международная перевозка (указывать процент от 1 до 100%):&nbsp;</p>
							<form:input path="insuranceInternationalTransport" class="option"/>
							<form:errors path="insuranceInternationalTransport" cssClass="error"></form:errors>
							<form:input path="descriptionInsuranceInternationalTransport"  class="option_description"/>
							<form:errors path="descriptionInsuranceInternationalTransport" cssClass="error"></form:errors>
						</div>
						<hr>
						<div class="text_output" style="height: 60px;">
							<p class="option_name" style="width: 100%;">Страхование груза по Украине (указывать процент от 1 до 100%):&nbsp;</p>
							<form:input path="insuranceUkraineTransport" class="option"/>
							<form:errors path="insuranceUkraineTransport" cssClass="error"></form:errors>
							<form:input path="descriptionInsuranceUkraineTransport"  class="option_description"/>
							<form:errors path="descriptionInsuranceUkraineTransport" cssClass="error"></form:errors>
						</div>

					</div>
				</div>