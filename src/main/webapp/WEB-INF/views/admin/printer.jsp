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
			<spring:message text="Добавление нового принтера" />
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
			<label id="head_of_page"><spring:message text="Добавление нового принтера" /></label>
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
						<p>Название принтера</p>
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
						<p>Тип принтера</p>
						<form:errors path="typePrinter" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${printer.type_printer}" path="typePrinter" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Акции. Ярлык слева(цвет текста/фона)</p>
					</div>
					<div class="check_boxes">
						<form:input path="leftSharesLink" style="width: 100px;"/>
						<input type="color" name="leftSharesLinkColorText" value="${product.leftSharesLinkColorText}"/>
						<input type="color" name="leftSharesLinkColorFone" value="${product.leftSharesLinkColorFone}"/>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Акции. Ярлык справа(цвет текста/фона)</p>
					</div>
					<div class="check_boxes">
						<form:input path="rightSharesLink" style="width: 100px;"/>
						<input type="color" name="rightSharesLinkColorText" value="${product.rightSharesLinkColorText}"/>
						<input type="color" name="rightSharesLinkColorFone" value="${product.rightSharesLinkColorFone}"/>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Таймер на акции, в формате "дд.мм.гггг"</p>
						<form:errors path="timeShares" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<input type="text" class= "date" name = "timeShares" 
						value = "<fmt:formatDate value="${product.timeShares}" pattern="dd.MM.yyyy" />"/>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Модель</p>
						<form:errors path="equipmentModel" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="equipmentModel" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Ширина печати в миллиметрах (для ввода вручную)</p>
						<form:errors path="inputFirstWeightPrintMM" cssClass="error"></form:errors>
						<form:errors path="inputSecondWeightPrintMM" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input style="width: 33px;" path="inputFirstWeightPrintMM" />
							<form:errors path="inputFirstWeightPrintMM" cssClass="error"></form:errors>	 
				    		<p>&nbsp;X&nbsp;</p><form:input style="width: 33px;" path="inputSecondWeightPrintMM" />
				    		<p>&nbsp; мм</p>
				    		<form:errors path="inputSecondWeightPrintMM" cssClass="error"></form:errors>
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Ширина печати в миллиметрах</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${printer.weight_print_mm}" path="weightPrintMM" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Состояние оборудования</p>
					</div>
					<ul class="check_boxes">					
						<form:radiobuttons items="${printer.previously_used}" path="previouslyUsed" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип печати</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${printer.type_print}" path="typePrint" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>UV Блок</p>
						<form:errors path="lengthWaveUVlamp" cssClass="error"></form:errors>	 
						<form:errors path="powerUVlamp" cssClass="error"></form:errors>	
						<form:errors path="lengthWaveLEDmodule" cssClass="error"></form:errors>
						<form:errors path="powerLEDmodule" cssClass="error"></form:errors>
						<form:errors path="quantityUVlamp" cssClass="error"></form:errors>
						<form:errors path="quantityLEDmodule" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<p>UV лампа:</p>	 
						</div>
						<div class="text_output">
							<p>длинна волны:&nbsp;</p><form:input style="width: 35px;" path="lengthWaveUVlamp" /><p>&nbsp;нм</p>
							<form:errors path="lengthWaveUVlamp" cssClass="error"></form:errors>	 
						</div>
						<div class="text_output">
							<p>мощность UV излучения:&nbsp;</p><form:input style="width: 35px;" path="powerUVlamp" /><p>&nbsp;Вт</p>
							<form:errors path="powerUVlamp" cssClass="error"></form:errors>	 
						</div>
						<div class="text_output">
							<p>количество:&nbsp;</p><form:input style="width: 35px;" path="quantityUVlamp" /><p>&nbsp;шт</p>
							<form:errors path="quantityUVlamp" cssClass="error"></form:errors>	 
						</div>
						<br/>
						<div class="text_output">
							<p>LED модуль:</p>	 
						</div>
						<div class="text_output">
							<p>длинна волны:&nbsp;</p><form:input style="width: 35px;" path="lengthWaveLEDmodule" /><p>&nbsp;нм</p>
							<form:errors path="lengthWaveLEDmodule" cssClass="error"></form:errors>	 
						</div>
						<div class="text_output">
							<p>мощность UV излучения:&nbsp;</p><form:input style="width: 35px;" path="powerLEDmodule" /><p>&nbsp;Вт</p>
							<form:errors path="powerLEDmodule" cssClass="error"></form:errors>	 
						</div>
						<div class="text_output">
							<p>количество:&nbsp;</p><form:input style="width: 35px;" path="quantityLEDmodule" /><p>&nbsp;шт</p>
							<form:errors path="quantityLEDmodule" cssClass="error"></form:errors>	 
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Подача метериала</p>
					</div>
					<ul class="check_boxes">					
						<form:checkboxes items="${printer.feeds}" path="feed" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Цветовая схема</p>
						<form:errors path="chromaticityCMYK" cssClass="error"></form:errors>
						<form:errors path="chromaticityCMYKx2" cssClass="error"></form:errors>
						<form:errors path="chromaticityCMYKLcLm" cssClass="error"></form:errors>
						<form:errors path="chromaticityCMYKLcLmOG" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<li><input type="checkbox" name="chromaticity" value="CMYK" id="chromaticity1" 
						<c:forEach items="${product.chromaticity}" var="tp"><c:if test="${tp=='CMYK'}">checked</c:if></c:forEach>>
						<label for="chromaticity1">CMYK + </label><form:input style="width: 28px;" path="chromaticityCMYK" /></input></li>
						
						<li><input type="checkbox" name="chromaticity" value="CMYK x 2" id="chromaticity2" 
						<c:forEach items="${product.chromaticity}" var="tp"><c:if test="${tp=='CMYK x 2'}">checked</c:if></c:forEach>>
						<label for="chromaticity2">CMYK x 2 + </label><form:input style="width: 28px;" path="chromaticityCMYKx2" /></input></li>
						
						<li><input type="checkbox" name="chromaticity" value="CMYKLcLm" id="chromaticity3" 
						<c:forEach items="${product.chromaticity}" var="tp"><c:if test="${tp=='CMYKLcLm'}">checked</c:if></c:forEach>>
						<label for="chromaticity3">CMYKLcLm + </label><form:input style="width: 28px;" path="chromaticityCMYKLcLm" /></input></li>
						
						<li><input type="checkbox" name="chromaticity" value="CMYKLcLmOG" id="chromaticity4" 
						<c:forEach items="${product.chromaticity}" var="tp"><c:if test="${tp=='CMYKLcLmOG'}">checked</c:if></c:forEach>>
						<label for="chromaticity4">CMYKLcLmOG + </label><form:input style="width: 28px;" path="chromaticityCMYKLcLmOG" /></input></li>

					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Производитель печатающей головки</p>
					</div>
					<ul class="check_boxes">					
						<c:forEach items="${printer.manufacturer_printhead}" var="item">
							<li>
								<input type="radio" name="manufacturerPrinthead" value="${item}"
		  							<c:if test="${product.manufacturerPrinthead==item}">checked</c:if>
		  								onclick="setTypeOfPrinthead('${item}', '${product.typeOfPrinthead}');"
		  						 		id="${item}_12"><label for="${item}_12">${item}</label>
		  						 </input>
	  						 </li>
						</c:forEach>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип печатающей головки</p>
					</div>
					<ul class="check_boxes" id="type_of_printhead">
					
						<c:forEach items="${printer.type_of_printhead}" var="item">
						
							   						   
							   <c:if test="${item.name == product.manufacturerPrinthead}">						
							   						   
							   <c:forEach items="${item.values}" var="value">
									<c:if test="${value.getClass().simpleName != 'String'}">
										<form:radiobuttons items="${value.values}" path="typeOfPrinthead" element="li"/>							
									</c:if>
											
									<c:if test="${value.getClass().simpleName == 'String'}">
										<li>
											<input type="radio" name="typeOfPrinthead" value="${value}" id="${value}_type_of_printhead"
									 		<c:if test="${product.typeOfPrinthead==value}">checked</c:if>>
											<label for="${value}_type_of_printhead">${value}</label></input>
										</li>
									</c:if>
				  				</c:forEach>
							   </c:if>

									
			  			</c:forEach>
						
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Количество печатающих головок</p>
						<form:errors path="numberOfPrintheads" cssClass="error"></form:errors>	 
						<form:errors path="onEachColorNumberOfPrintheads" cssClass="error"></form:errors>	
						<form:errors path="whiteColorNumberOfPrintheads" cssClass="error"></form:errors>
						<form:errors path="varnishNumberOfPrintheads" cssClass="error"></form:errors>
						<form:errors path="firstTypeNumberOfPrintheads" cssClass="error"></form:errors>
						<form:errors path="secondTypeNumberOfPrintheads" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input style="width: 35px;" path="numberOfPrintheads" /><p>&nbsp;шт</p>
							<form:errors path="numberOfPrintheads" cssClass="error"></form:errors>	 
						</div>
						<div class="text_output">
							<p>На каждый цвет:&nbsp;</p><form:input style="width: 35px;" path="onEachColorNumberOfPrintheads" />
							<form:errors path="onEachColorNumberOfPrintheads" cssClass="error"></form:errors>	 
						</div>
						<div class="text_output">
							<p>Белый цвет:&nbsp;</p><form:input style="width: 35px;" path="whiteColorNumberOfPrintheads" />
							<form:errors path="whiteColorNumberOfPrintheads" cssClass="error"></form:errors>	 
						</div>
						<div class="text_output">
							<p>Лак:&nbsp;</p><form:input style="width: 35px;" path="varnishNumberOfPrintheads" />
							<form:errors path="varnishNumberOfPrintheads" cssClass="error"></form:errors>	 
						</div>
						<div class="text_output">
							<form:input style="width: 70px;" path="firstEmptyNameTypeNumberOfPrintheads" />
							<p>:&nbsp;</p><form:input style="width: 35px;" path="firstTypeNumberOfPrintheads" />
							<form:errors path="firstTypeNumberOfPrintheads" cssClass="error"></form:errors>	 
						</div>
						<div class="text_output">
							<form:input style="width: 70px;" path="secondEmptyNameTypeNumberOfPrintheads" />
							<p>:&nbsp;</p><form:input style="width: 35px;" path="secondTypeNumberOfPrintheads" />
							<form:errors path="secondTypeNumberOfPrintheads" cssClass="error"></form:errors>	 
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Расход чернил</p>
						<form:errors path="averageConsumptionOfCMYKink" cssClass="error"></form:errors>	 
						<form:errors path="averageConsumptionOfWhiteInk" cssClass="error"></form:errors>	
						<form:errors path="averageDischarge1" cssClass="error"></form:errors>
						<form:errors path="averageDischarge2" cssClass="error"></form:errors>
						<form:errors path="averageDischarge3" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<p>Средний расход чернил CMYK:&nbsp;</p><form:input style="width: 35px;" path="averageConsumptionOfCMYKink" /><p>&nbsp;мл./м.кв.</p>
							<form:errors path="averageConsumptionOfCMYKink" cssClass="error"></form:errors>	 
						</div>
						<div class="text_output">
							<p>Средний расход белых черн.:&nbsp;</p><form:input style="width: 35px;" path="averageConsumptionOfWhiteInk" /><p>&nbsp;мл./м.кв.</p>
							<form:errors path="averageConsumptionOfWhiteInk" cssClass="error"></form:errors>	 
						</div>
						<div class="text_output">
							<p>Средний расход&nbsp;</p><form:input style="width: 70px;" path="nameOfAverageDischarge1" /><p>:&nbsp;</p>
							<form:input style="width: 35px;" path="averageDischarge1" /><p>&nbsp;мл./м.кв.</p>
							<form:errors path="averageDischarge1" cssClass="error"></form:errors>	 
						</div>
						<div class="text_output">
							<p>Средний расход&nbsp;</p><form:input style="width: 70px;" path="nameOfAverageDischarge2" /><p>:&nbsp;</p>
							<form:input style="width: 35px;" path="averageDischarge2" /><p>&nbsp;мл./м.кв.</p>
							<form:errors path="averageDischarge2" cssClass="error"></form:errors>	 
						</div>
						<div class="text_output">
							<p>Средний расход&nbsp;</p><form:input style="width: 70px;" path="nameOfAverageDischarge3" /><p>:&nbsp;</p>
							<form:input style="width: 35px;" path="averageDischarge3" /><p>&nbsp;мл./м.кв.</p>
							<form:errors path="averageDischarge3" cssClass="error"></form:errors>	 
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Совместимые чернила</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${printer.compatible_ink}" path="compatibleInk" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип капли</p>
					</div>
					<ul class="check_boxes">				
						<form:checkboxes items="${printer.type_drops}" path="typeDrops" element="li"/>
					</ul>
				</div>
			</div>

			<div class="product_characteristic">
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Размер капли (постоянная)</p>
						<form:errors path="sizeDropStatic" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<p>постоянная &nbsp;</p><form:input style="width: 28px;" path="sizeDropStatic" />
							<form:errors path="sizeDropStatic" cssClass="error"></form:errors>	 
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Размер капли (если диапазон)</p>
						<form:errors path="sizeDropRangeFrom" cssClass="error"></form:errors>
						<form:errors path="sizeDropRangeUntil" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<p>переменная от&nbsp;</p><form:input style="width: 28px;" path="sizeDropRangeFrom" />
							<form:errors path="sizeDropRangeFrom" cssClass="error"></form:errors>	 
				    		<p>&nbsp;до&nbsp;</p> <form:input style="width: 28px;" path="sizeDropRangeUntil" />
				    		<form:errors path="sizeDropRangeUntil" cssClass="error"></form:errors>
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Размер капли (с заданием типа капли)</p>
						<form:errors path="valueOfNewTypeDrop" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<p>&nbsp;</p><form:input style="width: 60px;" path="nameOfNewTypeDrop" />	 
				    		<p>&nbsp;-&nbsp;</p> <form:input style="width: 28px;" path="valueOfNewTypeDrop" />
				    		<form:errors path="valueOfNewTypeDrop" cssClass="error"></form:errors>
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Размер капли (для выбора с уже имеющихся)</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${printer.size_drops}" path="sizeDrops" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Скорость печати (м.кв./ч.)</p>
						<form:errors path="speedPrintDraft" cssClass="error"></form:errors>
						<form:errors path="speedPrintFast" cssClass="error"></form:errors>
						<form:errors path="speedPrintNormal" cssClass="error"></form:errors>
						<form:errors path="speedPrintQuality" cssClass="error"></form:errors>
						<form:errors path="speedPrintHiQual" cssClass="error"></form:errors>
						<form:errors path="speedPrint1" cssClass="error"></form:errors>
						<form:errors path="speedPrint2" cssClass="error"></form:errors>
						<form:errors path="speedPrint3" cssClass="error"></form:errors>
						<form:errors path="speedPrint4" cssClass="error"></form:errors>
						<form:errors path="speedPrint5" cssClass="error"></form:errors>
						<form:errors path="speedPrintDraftPass" cssClass="error"></form:errors>
						<form:errors path="speedPrintFastPass" cssClass="error"></form:errors>
						<form:errors path="speedPrintNormalPass" cssClass="error"></form:errors>
						<form:errors path="speedPrintQualityPass" cssClass="error"></form:errors>
						<form:errors path="speedPrintHiqualPass" cssClass="error"></form:errors>
						<form:errors path="speedPrintPass1" cssClass="error"></form:errors>
						<form:errors path="speedPrintPass2" cssClass="error"></form:errors>
						<form:errors path="speedPrintPass3" cssClass="error"></form:errors>
						<form:errors path="speedPrintPass4" cssClass="error"></form:errors>
						<form:errors path="speedPrintPass5" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<p>Draft Speed&nbsp;</p>
							<form:input path="speedPrintDraftPass" class="speed_print_pass"/>
							<p>&nbsp;pass</p>
							<form:select style="float: left; margin: 0px 5px;" path="speedPrintDraftResolution">
    							<form:options items="${printer.resolution}"></form:options>
  							</form:select>
							
							<form:input path="speedPrintDraft" class="amount-speed-print"/>
							<form:errors path="speedPrintDraft" cssClass="error"></form:errors>
							<form:errors path="speedPrintDraftPass" cssClass="error"></form:errors>
						</div>

						<div class="text_output">
							<p>Fast Speed&nbsp;</p>
							<form:input path="speedPrintFastPass" class="speed_print_pass"/>
							<p>&nbsp;pass</p>
							<form:select style="float: left; margin: 0px 5px;" path="speedPrintFastResolution">
    							<form:options items="${printer.resolution}"></form:options>
  							</form:select>
							<form:input path="speedPrintFast" class="amount-speed-print"/>
							<form:errors path="speedPrintFast" cssClass="error"></form:errors>
							<form:errors path="speedPrintFastPass" cssClass="error"></form:errors>
						</div>

						<div class="text_output">
							<p>Normal Sp.&nbsp;</p>
							<form:input path="speedPrintNormalPass" class="speed_print_pass"/>
							<p>&nbsp;pass</p>
							<form:select style="float: left; margin: 0px 5px;" path="speedPrintNormalResolution">
    							<form:options items="${printer.resolution}"></form:options>
  							</form:select>
							<form:input path="speedPrintNormal" class="amount-speed-print"/>
							<form:errors path="speedPrintNormal" cssClass="error"></form:errors>
							<form:errors path="speedPrintNormalPass" cssClass="error"></form:errors>
						</div>

						<div class="text_output">
							<p>Quality Sp.&nbsp;</p>
							<form:input path="speedPrintQualityPass" class="speed_print_pass"/>
							<p>&nbsp;pass</p>
							<form:select style="float: left; margin: 0px 5px;" path="speedPrintQualityResolution">
    							<form:options items="${printer.resolution}"></form:options>
  							</form:select>
							<form:input path="speedPrintQuality" class="amount-speed-print"/>
							<form:errors path="speedPrintQuality" cssClass="error"></form:errors>
							<form:errors path="speedPrintQualityPass" cssClass="error"></form:errors>
						</div>

						<div class="text_output">
							<p>Hi-Quality Sp.&nbsp;</p>
							<form:input path="speedPrintHiqualPass" class="speed_print_pass"/>
							<p>&nbsp;pass</p>
							<form:select style="float: left; margin: 0px 5px;" path="speedPrintHiqualResolution">
    							<form:options items="${printer.resolution}"></form:options>
  							</form:select>
							<form:input path="speedPrintHiQual" class="amount-speed-print"/>
							<form:errors path="speedPrintHiQual" cssClass="error"></form:errors>
							<form:errors path="speedPrintHiqualPass" cssClass="error"></form:errors>
						</div>
						
						<div class="text_output">
							<form:input path="speedPrintPass1" class="speed_print_pass"/>
							<p>&nbsp;pass</p>
							<form:select style="float: left; margin: 0px 5px;" path="speedPrintResolution1">
    							<form:options items="${printer.resolution}"></form:options>
  							</form:select>
							<form:input path="speedPrint1" class="amount-speed-print"/>
							<form:errors path="speedPrint1" cssClass="error"></form:errors>
							<form:errors path="speedPrintPass1" cssClass="error"></form:errors>
						</div>
						
						<div class="text_output">
							<form:input path="speedPrintPass2" class="speed_print_pass"/>
							<p>&nbsp;pass</p>
							<form:select style="float: left; margin: 0px 5px;" path="speedPrintResolution2">
    							<form:options items="${printer.resolution}"></form:options>
  							</form:select>
							<form:input path="speedPrint2" class="amount-speed-print"/>
							<form:errors path="speedPrint2" cssClass="error"></form:errors>
							<form:errors path="speedPrintPass2" cssClass="error"></form:errors>
						</div>
						
						<div class="text_output">
							<form:input path="speedPrintPass3" class="speed_print_pass"/>
							<p>&nbsp;pass</p>
							<form:select style="float: left; margin: 0px 5px;" path="speedPrintResolution3">
    							<form:options items="${printer.resolution}"></form:options>
  							</form:select>
							<form:input path="speedPrint3" class="amount-speed-print"/>
							<form:errors path="speedPrint3" cssClass="error"></form:errors>
							<form:errors path="speedPrintPass3" cssClass="error"></form:errors>
						</div>
						
						<div class="text_output">
							<form:input path="speedPrintPass4" class="speed_print_pass"/>
							<p>&nbsp;pass</p>
							<form:select style="float: left; margin: 0px 5px;" path="speedPrintResolution4">
    							<form:options items="${printer.resolution}"></form:options>
  							</form:select>
							<form:input path="speedPrint4" class="amount-speed-print"/>
							<form:errors path="speedPrint4" cssClass="error"></form:errors>
							<form:errors path="speedPrintPass4" cssClass="error"></form:errors>
						</div>
						
						<div class="text_output">
							<form:input path="speedPrintPass5" class="speed_print_pass"/>
							<p>&nbsp;pass</p>
							<form:select style="float: left; margin: 0px 5px;" path="speedPrintResolution5">
    							<form:options items="${printer.resolution}"></form:options>
  							</form:select>
							<form:input path="speedPrint5" class="amount-speed-print"/>
							<form:errors path="speedPrint5" cssClass="error"></form:errors>
							<form:errors path="speedPrintPass5" cssClass="error"></form:errors>
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Разрешение печати (для ввода вручную)</p>
						<form:errors path="inputFirstPrintResolution" cssClass="error"></form:errors>
						<form:errors path="inputSecondPrintResolution" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input style="width: 33px;" path="inputFirstPrintResolution" />
							<form:errors path="inputFirstPrintResolution" cssClass="error"></form:errors>	 
				    		<p>&nbsp;X&nbsp;</p><form:input style="width: 33px;" path="inputSecondPrintResolution" />
				    		<p>&nbsp;dpi</p>
				    		<form:errors path="inputSecondPrintResolution" cssClass="error"></form:errors>
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Разрешение печати</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${printer.print_resolution}" path="printResolution" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Производитель оборудования</p>
					</div>
					<ul class="check_boxes">					
						<form:radiobuttons items="${printer.equipment_manufacturer}" path="equipmentManufacturer" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Интерфейс подключения</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${printer.interface_connection}" path="interfaceConnection" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальная толщина носителя, мм</p>
						<form:errors path="maximumMediaThickness" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="maximumMediaThickness" class="amount-maximum_media_thickness"/>
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальный вес носителя, кг</p>
						<form:errors path="maximumWeightOfVehicle" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="maximumWeightOfVehicle" class="amount-maximum_weight_of_vehicle"/>
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Программное обеспечение</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${printer.rip}" path="rip" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Средняя потребляемая мощность, Вт</p>
						<form:errors path="averagePowerConsumption" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:input path="averagePowerConsumption"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальная потребляемая мощность</p>
						<form:errors path="maxPowerConsumption" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="maxPowerConsumption" class="amount-max_power_consumption" value="${product.maxPowerConsumption}"/>
							<p>&nbsp;Вт</p>
						</div>
						<div class="slider-range-max_power_consumption"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Вес</p>
						<form:errors path="weight" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="weight" class="amount-weight" value="${product.weight}"/>
							<p>&nbsp;кг</p>
						</div>
						<div class="slider-range-weight"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Ширина</p>
						<form:errors path="width" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="width" class="amount-width" value="${product.width}"/>
							<p>&nbsp;мм</p>
						</div>
						<div class="slider-range-width"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Глубина</p>
						<form:errors path="depth" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="depth" class="amount-depth" value="${product.depth}"/>
							<p>&nbsp;мм</p>
						</div>
						<div class="slider-range-depth"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Высота</p>
						<form:errors path="heigth" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="heigth" class="amount-heigth" value="${product.heigth}"/>
							<p>&nbsp;мм</p>
						</div>
						<div class="slider-range-heigth"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Доставка</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${printer.delivery}" path="delivery" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Гарантия, месяцев</p>
						<form:errors path="guarantee" cssclass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="guarantee" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Наличие (информация для пользователя)</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${printer.availability}" path="availability" element="li"/>
						
						<div class="text_output">
							<form:input path="availabilitySpecialCase"/>
						</div>
					</ul>
				</div>
				
				<!-- import option characteristic -->
				<jsp:include page="product/characteristic_option.jsp" />
				
			</div>

			<jsp:include page="product/textarea_descriptions.jsp" />
		
			<c:if test="${empty product.id}">
				<input id="submit" type="submit" value="загрузить" style="background:green; color: azure;"/>
			</c:if>
			
			<c:if test="${!empty product.id}">
				<input id="submit" type="submit" value="изменить" style="background:blue; color: azure;"/>
			</c:if>

		</form:form>
	</div>
	<script type="text/javascript">
	function setTypeOfPrinthead(name_manufacturer, type_printhead){
		var output = $("#type_of_printhead").html('');
		
		$.getJSON( "/products/printer.json", function( data ) {
  			
		$(data.type_of_printhead).each(function(i, maker) {

				if(maker.name==name_manufacturer){
					
					$(maker.values).each(function(k, value) {
						if(typeof value == 'object'){
							$(value.values).each(function(t, t_value) {
								var inputRadio = $('<input/>').attr("type", "radio").attr("name", "typeOfPrinthead")
								.attr("value", t_value).attr("id", t_value + t);

								if(t_value==type_printhead){
			    	        		inputRadio.attr( "checked" );
			    				}
							
								var inputLabel = $('<label/>').attr("for", t_value + t).text(t_value);
		
								output.append(inputRadio).append(inputLabel).append('<br/>');
							});
						} else {
							var inputRadio = $('<input/>').attr("type", "radio").attr("name", "typeOfPrinthead")
							.attr("value", value).attr("id", value + k);

							if(value==type_printhead){
		    	        		inputRadio.attr( "checked" );
		    				}
					
							var inputLabel = $('<label/>').attr("for", value + k).text(value);
	
							output.append(inputRadio).append(inputLabel).append('<br/>');
						}
					});
				}
			});
		});
			
		}
	</script>
	
	<jsp:include page="product/js_code.jsp" />
	
</body>
</html>