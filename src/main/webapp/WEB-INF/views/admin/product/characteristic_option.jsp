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
							<p>Пр. обеспечение:&nbsp;</p>
							<form:input path="optionRIP" class="option"/>
							<form:errors path="optionRIP" cssClass="error"></form:errors>
							<form:input path="descriptionOptionRIP" />
							<form:errors path="descriptionOptionRIP" cssClass="error"></form:errors>
						</div>
						<hr>
						<div class="text_output">
							<p>СНЧП:&nbsp;</p>
							<form:input path="optionSNCP" class="option"/>
							<form:errors path="optionSNCP" cssClass="error"></form:errors>
							<form:input path="descriptionOptionSNCP" />
							<form:errors path="descriptionOptionSNCP" cssClass="error"></form:errors>
						</div>
						<hr>
						<div class="text_output">
							<p>Доставка:&nbsp;</p>
							<form:input path="optionDelivery" class="option"/>
							<form:errors path="optionDelivery" cssClass="error"></form:errors>
							<form:input path="descriptionOptionDelivery" />
							<form:errors path="descriptionOptionDelivery" cssClass="error"></form:errors>
						</div>
						<hr>
						<div class="text_output">
							<p>Инсталяция:&nbsp;</p>
							<form:input path="optionInstallation" class="option"/>
							<form:errors path="optionInstallation" cssClass="error"></form:errors>
							<form:input path="descriptionOptionInstallation" />
							<form:errors path="descriptionOptionInstallation" cssClass="error"></form:errors>
						</div>
						<hr>
						<div class="text_output">
							<p>НДС:&nbsp;</p>
							<form:input path="optionVAT" class="option"/>
							<form:errors path="optionVAT" cssClass="error"></form:errors>
							<form:input path="descriptionOptionVAT" />
							<form:errors path="descriptionOptionVAT" cssClass="error"></form:errors>
						</div>
						<hr>
						<div class="text_output">
							<p>Гарантия:&nbsp;</p>
							<form:input path="optionGuarantee" class="option"/>
							<form:errors path="optionGuarantee" cssClass="error"></form:errors>
							<form:input path="descriptionOptionGuarantee" />
							<form:errors path="descriptionOptionGuarantee" cssClass="error"></form:errors>
						</div>
						<hr>
						<div class="text_output">
							<form:input path="nameAddedOption" class="option"/>
							<p>:&nbsp;</p>
							<form:input path="priceAddedOption" class="option"/>
							<form:errors path="priceAddedOption" cssClass="error"></form:errors>
							<form:input path="descriptionOptionAddedOption" />
							<form:errors path="descriptionOptionAddedOption" cssClass="error"></form:errors>
						</div>
						<hr>
						<div class="text_output">
							<form:input path="nameAddedOption2" class="option"/>
							<p>:&nbsp;</p>
							<form:input path="priceAddedOption2" class="option"/>
							<form:errors path="priceAddedOption2" cssClass="error"></form:errors>
							<form:input path="descriptionOptionAddedOption2" />
							<form:errors path="descriptionOptionAddedOption2" cssClass="error"></form:errors>
						</div>
						<hr>
						<div class="text_output">
							<form:input path="nameAddedOption3" class="option"/>
							<p>:&nbsp;</p>
							<form:input path="priceAddedOption3" class="option"/>
							<form:errors path="priceAddedOption3" cssClass="error"></form:errors>
							<form:input path="descriptionOptionAddedOption3" />
							<form:errors path="descriptionOptionAddedOption3" cssClass="error"></form:errors>
						</div>
						
					</ul>
				</div>