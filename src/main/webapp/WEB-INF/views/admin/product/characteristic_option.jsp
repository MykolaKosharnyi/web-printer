<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page session="true"%>
			<div class="product_option">
					<div class="block_title">
						<i class="opened"></i>
						<p>Опции (с заданием цены и описания за дополнительную услугу)</p>
						<form:errors path="optionRIP" cssClass="error"></form:errors>
						<form:errors path="optionSNCP" cssClass="error"></form:errors>
						<form:errors path="optionDelivery" cssClass="error"></form:errors>
						<form:errors path="optionGuarantee" cssClass="error"></form:errors>
						<form:errors path="priceAddedOption" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes" style="display: block;">
						<div class="text_output">
							<p class="option_name">Програмное об.:&nbsp;</p>
							<form:input path="optionRIP" class="option"/>
							<form:errors path="optionRIP" cssClass="error"></form:errors>
							<form:input path="descriptionOptionRIP" class="option_description"/>
							<form:errors path="descriptionOptionRIP" cssClass="error"></form:errors>
						</div>
						<hr>
						<div class="text_output">
							<p class="option_name">СНЧП:&nbsp;</p>
							<form:input path="optionSNCP" class="option"/>
							<form:errors path="optionSNCP" cssClass="error"></form:errors>
							<form:input path="descriptionOptionSNCP"  class="option_description"/>
							<form:errors path="descriptionOptionSNCP" cssClass="error"></form:errors>
						</div>
						<hr>
						<div class="text_output">
							<p class="option_name">Доставка:&nbsp;</p>
							<form:input path="optionDelivery" class="option"/>
							<form:errors path="optionDelivery" cssClass="error"></form:errors>
							<form:input path="descriptionOptionDelivery"  class="option_description"/>
							<form:errors path="descriptionOptionDelivery" cssClass="error"></form:errors>
						</div>
						<hr>
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
							<p class="option_name">Гарантия:&nbsp;</p>
							<form:input path="optionGuarantee" class="option"/>
							<form:errors path="optionGuarantee" cssClass="error"></form:errors>
							<form:input path="descriptionOptionGuarantee"  class="option_description"/>
							<form:errors path="descriptionOptionGuarantee" cssClass="error"></form:errors>
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