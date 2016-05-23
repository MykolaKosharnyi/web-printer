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
		<spring:message text="Добавление нового ПО" />
	</title>
</c:if>
<c:if test="${!empty product.id}">
	<title>
		<spring:message text="Изменение" />
	</title>
</c:if>
</head>
<body>
	<c:url var="addPictures" value="/admin/rip/upload_pictures" ></c:url>
	
	<div id="product">
	
		<c:if test="${empty product.id}">
			<label id="head_of_page"><spring:message text="Добавление нового ПО" /></label>
			<c:url var="addAction" value="/admin/rip/add" ></c:url>
		</c:if>
			
		<c:if test="${!empty product.id}">
			<label id="head_of_page"><spring:message text="Изменение ${product.name}, код товара: ${product.partNumber} " /></label>
			<c:url var="addAction" value="/admin/rip/update" ></c:url>
		</c:if>
		
		<div id="pictures">
			<h3>Выберите файл(ы) для загрузки</h3>
				
			<form:form method="POST" commandName="add_picture" action="${addPictures}" enctype="multipart/form-data">
				<p><input id="files-upload" type="file" id="files" name="files" accept="image/*" ></p>
				<form:errors path="file" cssClass="error" />
			
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
							<img src="/images/rips/${product.id}/${pathPicture}" alt="">
						</li>
					</c:forEach>
				</c:if>
			</ul>
		</div>

	<form:form method="POST" commandName="product" action="${addAction}">
		<div class="save_button_keeper">	
			<c:if test="${empty product.id}">
				<c:url value="/admin/rip/save_add" var="saveLoad" />
				<input id="submit" type="submit" formaction="${saveLoad}" value="сохранить" style="background: gold; color: black;"/>
				<input id="submit" type="submit" value="загрузить" style="background: green; color: azure;"/>
			</c:if>
			
			<c:if test="${!empty product.id}">
				<c:url value="/admin/rip/save_update" var="saveUpdate" />
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
						<p>Название ПО</p>
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
				
			</div>


			<div class="product_characteristic">
				<div class="characteristic">
					<fieldset>
						   <legend>Тип оборудования</legend>
						   
						   <form:errors path="typeEquipment" cssClass="error"></form:errors>
						 <c:forEach items="${rip}" var="p">		
	  						
	  							<input type="radio" name="typeEquipment" value="${p['type_equipment']}"
	  								<c:if test="${product.typeEquipment==p['type_equipment']}">checked</c:if>
	  								onclick="setSoftwareMaker('${p['type_equipment']}', '${product.typeEquipment}', '${product.softwareClass}');"
	  						 		id="${p['type_equipment']}_11"><label for="${p['type_equipment']}_11">${p['type_equipment']}</label>
	  						 	</input>
								</br>
	  						 
						</c:forEach>
					</fieldset>
				
				
					<fieldset id="software_maker">
						   <legend>Производитель ПО</legend>
						   
						   <form:errors path="softwareMaker" cssClass="error"></form:errors>
						   <c:forEach items="${rip}" var="p">		
	  						
	  							<c:if test="${p['type_equipment']==product.typeEquipment}">
	  								<c:forEach items="${p.software_maker}" var="soft_marker">	
	  								
	  									<input type="radio" name="softwareMaker" value="${soft_marker.name}"
	  										<c:if test="${product.softwareMaker==soft_marker.name}">checked</c:if>
	  										onclick="setSoftwareClassFirstLoading('${product.typeEquipment}', '${soft_marker.name}', '${product.softwareClass}');"
	  						 				id="${soft_marker.name}_12"><label for="${soft_marker.name}_12">${soft_marker.name}</label>
	  						 			</input>
										</br>
	  									
	  								</c:forEach>
								</c:if>

							</c:forEach>
					</fieldset>
					
					<fieldset id="software_class">
						   <legend>Класс ПО</legend>
						   
						   <form:errors path="softwareClass" cssClass="error"></form:errors>
						   <c:forEach items="${rip}" var="p">		
	  						
	  							<c:if test="${p['type_equipment']==product.typeEquipment}">
	  								<c:forEach items="${p.software_maker}" var="soft_marker">	
	  								
	  									<c:if test="${soft_marker['name']==product.softwareMaker}">
	  										<c:forEach items="${soft_marker.software_class}" var="soft_class">
	  										
	  										<input type="radio" name="softwareClass" value="${soft_class}"
	  											<c:if test="${product.softwareClass==soft_class}">checked</c:if>
	  						 					id="${soft_class}_13"><label for="${soft_class}_13">${soft_class}</label>
	  						 				</input>
											</br>
	  										
	  										</c:forEach>
	  									</c:if>
	
	  								</c:forEach>
								</c:if>

							</c:forEach>
					</fieldset>

					<fieldset>
						<legend>Версия ПО</legend>
							<form:input path="softwareVersion" />
							<form:errors path="softwareVersion" cssClass="error"></form:errors>
					</fieldset>
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
	<script type="text/javascript">

	function setSoftwareMaker(typeEquipment, m, soft_class){
		var softvare_maker = $("#software_maker").html('').append($('<legend/>').text('Производитель ПО'));
		
		$.getJSON( "/images/rip.json", function( data ) {
  			
		$(data).each(function(i, maker) {

				if(maker.type_equipment==typeEquipment){
					
					$(maker.software_maker).each(function(k, column) {
						var inputRadio = $('<input/>').attr("type", "radio").attr("name", "softwareMaker")
							.attr("value", column.name).attr("id", column.name + k)
							.click(function() {
								setSoftwareClass(column.software_class, soft_class);
							});

						if(column.name==m){
	    	        		inputRadio.attr( "checked" );
	    				}

						var inputLabel =$('<label/>').attr("for", column.name + k).text(column.name).click(function() {
  							setSoftwareClass(column.software_class, soft_class);
						});

						softvare_maker.append(inputRadio).append(inputLabel).append('<br/>');
					});

					 $("#software_class").html('').append($('<legend/>').text('Класс ПО'));
					return;
				}
			
			});
		});
			
		}

function setSoftwareClass(software_class, m){
		var softvare_cl = $("#software_class").html('').append($('<legend/>').text('Класс ПО'));
				
		$(software_class).each(function(i, soft_cl) {
					
						var inputRadio = $('<input/>').attr("type", "radio").attr("name", "softwareClass")
							.attr("value", soft_cl).attr("id", soft_cl + i);

						if(soft_cl==m){
	    	        		inputRadio.attr( "checked" );
	    				}

						var inputLabel =$('<label/>').attr("for", soft_cl + i).text(soft_cl);

						softvare_cl.append(inputRadio).append(inputLabel).append('<br/>');

			
			});
			
		}
		
function setSoftwareClassFirstLoading(typeEquipment, software_class_name, m){
	var softvare_cl = $("#software_class").html('').append($('<legend/>').text('Класс ПО'));
	
	$.getJSON( "/images/rip.json", function( data ) {
			
	$(data).each(function(i, maker) {

			if(maker.type_equipment==typeEquipment){

				$(maker.software_maker).each(function(k, column) {
					
					if(column.name==software_class_name){
					
						$(column.software_class).each(function(i, soft_cl) {
							
							var inputRadio = $('<input/>').attr("type", "radio").attr("name", "softwareClass")
								.attr("value", soft_cl).attr("id", soft_cl + i);
	
							if(soft_cl==m){
		    	        		inputRadio.attr( "checked" );
		    				}
	
							var inputLabel =$('<label/>').attr("for", soft_cl + i).text(soft_cl);
	
							softvare_cl.append(inputRadio).append(inputLabel).append('<br/>');
	
				
						});
					
						return;
					}
					
				});
			}
		
		});
	});
		
}

	</script>
</body>
</html>