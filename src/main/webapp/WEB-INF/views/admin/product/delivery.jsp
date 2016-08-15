<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page session="true"%>				
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
							<form:input path="airDeliveryPriceSize" class="delivery_option" style="float: none;"/>
							<br>
							<p class="delivery_last_price_description">цена по весу - &nbsp;</p>
							<form:input path="airDeliveryPriceWeight" style="left: 90px; position: relative;" class="delivery_option"/>
							
							<form:errors path="airDeliveryPriceSize" cssClass="error"></form:errors>
							<form:errors path="airDeliveryPriceWeight" cssClass="error"></form:errors>
							
						</div>
						<hr>
						<div class="delivery_text_output">
							<p class="delivery_option_name">Морем:&nbsp;</p>
							
							<p>цена по габаритам - &nbsp;</p>
							<form:input path="seaDeliveryPriceSize" class="delivery_option" style="float: none;"/>
							<br>
							<p class="delivery_last_price_description">цена по весу - &nbsp;</p>
							<form:input path="seaDeliveryPriceWeight" style="left: 90px; position: relative;" class="delivery_option"/>
							
							<form:errors path="seaDeliveryPriceSize" cssClass="error"></form:errors>
							<form:errors path="seaDeliveryPriceWeight" cssClass="error"></form:errors>
							
						</div>
						<hr>
						<div class="delivery_text_output">
							<p class="delivery_option_name">По Украине:&nbsp;</p>
							
							<p>цена по габаритам - &nbsp;</p>
							<form:input path="ukraineDeliveryPriceSize" class="delivery_option" style="float: none;"/>
							<br>
							<p class="delivery_last_price_description">цена по весу - &nbsp;</p>
							<form:input path="ukraineDeliveryPriceWeight" style="left: 90px; position: relative;" class="delivery_option"/>
							
							<form:errors path="ukraineDeliveryPriceSize" cssClass="error"></form:errors>
							<form:errors path="ukraineDeliveryPriceWeight" cssClass="error"></form:errors>
							
						</div>
						<hr>
						<div class="delivery_text_output">
							<p class="delivery_option_name">По Киеву:&nbsp;</p>

							<p>цена по габаритам - &nbsp;</p>
							<form:input path="kyivDeliveryPriceSize" class="delivery_option" style="float: none;"/>
							<br>
							<p class="delivery_last_price_description">цена по весу - &nbsp;</p>
							<form:input path="kyivDeliveryPriceWeight" style="left: 90px; position: relative;" class="delivery_option"/>

							<form:errors path="kyivDeliveryPriceSize" cssClass="error"></form:errors>
							<form:errors path="kyivDeliveryPriceWeight" cssClass="error"></form:errors>
							
						</div>
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
						<hr>
						
					</div>
				</div>