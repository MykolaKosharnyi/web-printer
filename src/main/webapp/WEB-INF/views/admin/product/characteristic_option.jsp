<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page session="true"%>
			<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Опции (с заданием цены за дополнительную услугу)</p>
						<form:errors path="optionRIP" cssClass="error"></form:errors>
						<form:errors path="optionSNCP" cssClass="error"></form:errors>
						<form:errors path="optionDelivery" cssClass="error"></form:errors>
						<form:errors path="optionGuarantee" cssClass="error"></form:errors>
						<form:errors path="priceAddedOption" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<p>Програмное обеспечение:&nbsp;</p>
							<form:input path="optionRIP" class="option"/>
							<form:errors path="optionRIP" cssClass="error"></form:errors>
						</div>
						
						<div class="text_output">
							<p>СНЧП:&nbsp;</p>
							<form:input path="optionSNCP" class="option"/>
							<form:errors path="optionSNCP" cssClass="error"></form:errors>
						</div>
						
						<div class="text_output">
							<p>Доставка:&nbsp;</p>
							<form:input path="optionDelivery" class="option"/>
							<form:errors path="optionDelivery" cssClass="error"></form:errors>
						</div>
						
						<div class="text_output">
							<p>Гарантия:&nbsp;</p>
							<form:input path="optionGuarantee" class="option"/>
							<form:errors path="optionGuarantee" cssClass="error"></form:errors>
						</div>
						
						<div class="text_output">
							<form:input path="nameAddedOption" class="option"/>
							<p>:&nbsp;</p>
							<form:input path="priceAddedOption" class="option"/>
							<form:errors path="priceAddedOption" cssClass="error"></form:errors>
						</div>
						
					</ul>
				</div>