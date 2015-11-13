<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/search.css">

	<style>
			.amount-sizePrintableAreaX0,
			.amount-sizePrintableAreaY0,
			.amount-sizePrintableAreaZ0,
            .amount-sizePrintableAreaX1,
            .amount-sizePrintableAreaY1,
            .amount-sizePrintableAreaZ1,
            .amount-speedPrint0,
            .amount-speedPrint1{
                width: 30px;
            }
            
            .amount-meltingPointOfThePrintingMaterial0,
            .amount-meltingPointOfThePrintingMaterial1,
            .amount-sizeExtruder0,
            .amount-sizeExtruder1,
            .amount-thicknessOfThePrintingLayer0,
            .amount-thicknessOfThePrintingLayer1,
            .amount-maximumWeightOfThePrintedModel0,
            .amount-maximumWeightOfThePrintedModel1,
            .amount-maxPowerConsumption0,
            .amount-maxPowerConsumption1{
            	width: 25px;
            }
           
	</style>

	<div id="display_search">
		<i class="opened"></i>
		<p>Критерии поиска</p>
	</div>

	<div id="search_product">
	<form:form method="POST" commandName="search" action="/nk/printers_3d/search">
			<input type="submit" value="показать" />
		<div class="search_criteria">
			<div class="block_title">
				<i class="opened"></i>
				<p>Цена</p>
			</div>
			<ul class="check_boxes" style="display: block;">
				<div class="text_output">
					<p>$</p>
					<form:input path="prise0" class="amount-prise0" value="${search.prise0}" />
					<p>-&nbsp; $</p>
					<form:input path="prise1" class="amount-prise1" value="${search.prise1}" />
				</div>
				<div class="slider-range-prise"/>
			</ul>
		</div>
		<div class="search_criteria" style="display: none;">
			<div class="block_title">
				<i></i>
				<p>Тип принтера</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${typePrinter3D}" path="typePrinter3D" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Б/У оборудование</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${previouslyUsed}" path="previouslyUsed" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Размер запечатываемой области</p>
			</div>
			<ul class="check_boxes">
				<p style="float: none; margin: 10px auto 0px;"> По оси Х:</p>
				<div class="text_output">
					<form:input path="sizePrintableAreaX0" class="amount-sizePrintableAreaX0" value="${search.sizePrintableAreaX0}"/>
					<p >&nbsp;мм -&nbsp;</p>
					<form:input path="sizePrintableAreaX1" class="amount-sizePrintableAreaX1" value="${search.sizePrintableAreaX1}" />
					<p>&nbsp;мм</p>
				</div>
					<div class="slider-range-sizePrintableAreaX"></div>

				<p style="float: none; margin: 10px auto 0px;"> По оси Y:</p>
				<div class="text_output">
					<form:input path="sizePrintableAreaY0" class="amount-sizePrintableAreaY0" value="${search.sizePrintableAreaY0}" />
					<p>&nbsp;мм -&nbsp;</p>
					<form:input path="sizePrintableAreaY1" class="amount-sizePrintableAreaY1" value="${search.sizePrintableAreaY1}" />
					<p>&nbsp;мм</p>
				</div>
					<div class="slider-range-sizePrintableAreaY"></div>

				<p style="float: none; margin: 10px auto 0px;"> По оси Z:</p>
				<div class="text_output">
					<form:input path="sizePrintableAreaZ0" class="amount-sizePrintableAreaZ0" value="${search.sizePrintableAreaZ0}" />
					<p>&nbsp;мм -&nbsp;</p>
					<form:input path="sizePrintableAreaZ1" class="amount-sizePrintableAreaZ1" value="${search.sizePrintableAreaZ1}" />
					<p>&nbsp;мм</p>
				</div>
					<div class="slider-range-sizePrintableAreaZ"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Технология печати</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${printTechnology}" path="printTechnology" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Цветность</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${chromaticity}" path="chromaticity" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип печатающей головки</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${typeOfPrinthead}" path="typeOfPrinthead" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Температура плавления печатного материала</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="meltingPointOfThePrintingMaterial0" class="amount-meltingPointOfThePrintingMaterial0" value="${search.meltingPointOfThePrintingMaterial0}" />
					<p>&nbsp;С -&nbsp;</p>
					<form:input path="meltingPointOfThePrintingMaterial1" class="amount-meltingPointOfThePrintingMaterial1" value="${search.meltingPointOfThePrintingMaterial1}" />
					<p>&nbsp;С</p>
				</div>
					<div class="slider-range-meltingPointOfThePrintingMaterial"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Материал для печати</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${media}" path="media" element="li" />
			</ul>
		</div> 
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Размер эктрудера</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="sizeExtruder0" class="amount-sizeExtruder0" value="${search.sizeExtruder0}" />
					<p>&nbsp;мм -&nbsp;</p>
					<form:input path="sizeExtruder1" class="amount-sizeExtruder1" value="${search.sizeExtruder1}" />
					<p>&nbsp;мм</p>
				</div>
					<div class="slider-range-sizeExtruder"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Скорость печати</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="speedPrint0" class="amount-speedPrint0" value="${search.speedPrint0}" />
					<p>&nbsp;мм/с -&nbsp;</p>
					<form:input path="speedPrint1" class="amount-speedPrint1" value="${search.speedPrint1}" />
					<p>&nbsp;мм/с</p>
				</div>
					<div class="slider-range-speedPrint"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Толщина слоя печати</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="thicknessOfThePrintingLayer0" class="amount-thicknessOfThePrintingLayer0" value="${search.thicknessOfThePrintingLayer0}" />
					<p>&nbsp;микрон -&nbsp;</p>
					<form:input path="thicknessOfThePrintingLayer1" class="amount-thicknessOfThePrintingLayer1" value="${search.thicknessOfThePrintingLayer1}" />
					<p>&nbsp;микрон</p>
				</div>
					<div class="slider-range-thicknessOfThePrintingLayer"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Интерфейс подключения</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${interfaceConnection}" path="interfaceConnection" element="li" />
			</ul>
		</div> 		
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тыпы файлов</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${typesOfFiles}" path="typesOfFiles" element="li" />
			</ul>
		</div> 		
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>П/О</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${rip}" path="rip" element="li" />
			</ul>
		</div> 		
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Максимальная масса распечатываемой модели</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="maximumWeightOfThePrintedModel0" class="amount-maximumWeightOfThePrintedModel0" value="${search.maximumWeightOfThePrintedModel0}" />
					<p>&nbsp;кг -&nbsp;</p>
					<form:input path="maximumWeightOfThePrintedModel1" class="amount-maximumWeightOfThePrintedModel1" value="${search.maximumWeightOfThePrintedModel1}" />
					<p>&nbsp;кг</p>
				</div>
					<div class="slider-range-maximumWeightOfThePrintedModel"></div>
			</ul>
		</div>		
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Производитель оборудования</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${equipmentManufacturer}" path="equipmentManufacturer" element="li" />
			</ul>
		</div>		
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Максимальная потребляемая мощность</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="maxPowerConsumption0" class="amount-maxPowerConsumption0" value="${search.maxPowerConsumption0}" />
					<p>&nbsp;кВт -&nbsp;</p>
					<form:input path="maxPowerConsumption1" class="amount-maxPowerConsumption1" value="${search.maxPowerConsumption1}" />
					<p>&nbsp;кВт</p>
				</div>
					<div class="slider-range-maxPowerConsumption"></div>
			</ul>
		</div>		
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Вес</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="weight0" class="amount-weight0" value="${search.weight0}" />
					<p>&nbsp;кг -&nbsp;</p>
					<form:input path="weight1" class="amount-weight1" value="${search.weight1}" />
					<p>&nbsp;кг</p>
				</div>
					<div class="slider-range-weight"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Ширина</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="width0" class="amount-width0" value="${search.width0}" />
					<p>&nbsp;м -&nbsp;</p>
					<form:input path="width1" class="amount-width1" value="${search.width1}" />
					<p>&nbsp;м</p>
				</div>
				<div class="slider-range-width"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Высота</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="heigth0" class="amount-heigth0" value="${search.heigth0}" />
					<p>&nbsp;м -&nbsp;</p>
					<form:input path="heigth1" class="amount-heigth1" value="${search.heigth1}" />
					<p>&nbsp;м</p>
				</div>
					<div class="slider-range-heigth"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Глубина</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="depth0" class="amount-depth0" value="${search.depth0}" />
					<p>&nbsp;м -&nbsp;</p>
					<form:input path="depth1" class="amount-depth1" value="${search.depth1}" />
					<p>&nbsp;м</p>
				</div>
					<div class="slider-range-depth"></div>
			</ul>
		</div>	
		</form:form>
	</div>
 	<script>	
		$(document).ready(function() {
			
			$('#search').ajaxForm( {
				type: 'post',
				success: function(products) { 
					$("#out_result_of_search").empty();
					
	                $(products).each(function(i, product) {
	                	$("#out_result_of_search").append(
	                			$('<a/>').addClass("products").attr("href", "/nk/printer/" + product.id)
	                				.append($('<div/>').addClass("products_image").append($('<img/>')
	                						.attr("src", "/nk/resources/images/printers/" + product.id + "/" + product.pathPictures[0])))
	                				.append($('<p/>').addClass("products_title").text(product.name))
	                				.append($('<p/>').addClass("products_price").text(product.prise))
	                                .append($('<div/>').addClass("products_buy").append($('<img/>')
	                                		.attr("src", "/nk/resources/images/button_buy.jpg")))		
	                            )//end $("#out_result_of_search").append()
	                });
				}
				
				}); 
		});
		
        $(function() {
            $( ".slider-range-prise" ).slider({
              range: true,
              min: 0,
              max: 100000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-prise0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-prise1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-prise0" ).val(ui.values[ 0 ]);
                $( ".amount-prise1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-prise0" ).val( $( ".slider-range-prise" ).slider("values", 0 ));             
            $( ".amount-prise1" ).val( $( ".slider-range-prise" ).slider("values", 1 ));
                
            $( ".amount-prise0" ).change(function() {
            $(".slider-range-prise").slider('values',0,this.value);
                });
                
            $( ".amount-prise1" ).change(function() {
            $(".slider-range-prise").slider('values',1,this.value);
                });
          });
		
		$(function() {
            $( ".slider-range-sizePrintableAreaX" ).slider({
              range: true,
              min: 1,
              max: 1000,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizePrintableAreaX0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizePrintableAreaX1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-sizePrintableAreaX0" ).val( ui.values[ 0 ]);
                $( ".amount-sizePrintableAreaX1" ).val( ui.values[ 1 ]);
              }
            });
              
            $( ".amount-sizePrintableAreaX0" ).val($( ".slider-range-sizePrintableAreaX" ).slider( "values", 0 ));
            $( ".amount-sizePrintableAreaX1" ).val($( ".slider-range-sizePrintableAreaX" ).slider( "values", 1 ));
              
              
            $( ".amount-sizePrintableAreaX0" ).change(function() {
            $(".slider-range-sizePrintableAreaX").slider('values',0,this.value);
                });
                
            $( ".amount-sizePrintableAreaX1" ).change(function() {
            $(".slider-range-sizePrintableAreaX").slider('values',1,this.value);
                });  
          });
		
		$(function() {
            $( ".slider-range-sizePrintableAreaY" ).slider({
              range: true,
              min: 1,
              max: 1000,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizePrintableAreaY0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizePrintableAreaY1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-sizePrintableAreaY0" ).val( ui.values[ 0 ]);
                $( ".amount-sizePrintableAreaY1" ).val( ui.values[ 1 ]);
              }
            });
              
            $( ".amount-sizePrintableAreaY0" ).val($( ".slider-range-sizePrintableAreaY" ).slider( "values", 0 ));
            $( ".amount-sizePrintableAreaY1" ).val($( ".slider-range-sizePrintableAreaY" ).slider( "values", 1 ));
              
              
            $( ".amount-sizePrintableAreaY0" ).change(function() {
            $(".slider-range-sizePrintableAreaY").slider('values',0,this.value);
                });
                
            $( ".amount-sizePrintableAreaY1" ).change(function() {
            $(".slider-range-sizePrintableAreaY").slider('values',1,this.value);
                });  
          });
		
		$(function() {
            $( ".slider-range-sizePrintableAreaZ" ).slider({
              range: true,
              min: 1,
              max: 1000,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizePrintableAreaZ0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizePrintableAreaZ1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-sizePrintableAreaZ0" ).val( ui.values[ 0 ]);
                $( ".amount-sizePrintableAreaZ1" ).val( ui.values[ 1 ]);
              }
            });
              
            $( ".amount-sizePrintableAreaZ0" ).val($( ".slider-range-sizePrintableAreaZ" ).slider( "values", 0 ));
            $( ".amount-sizePrintableAreaZ1" ).val($( ".slider-range-sizePrintableAreaZ" ).slider( "values", 1 ));
              
              
            $( ".amount-sizePrintableAreaZ0" ).change(function() {
            $(".slider-range-sizePrintableAreaZ").slider('values',0,this.value);
                });
                
            $( ".amount-sizePrintableAreaZ1" ).change(function() {
            $(".slider-range-sizePrintableAreaZ").slider('values',1,this.value);
                });  
          });
		
		$(function() {
            $( ".slider-range-meltingPointOfThePrintingMaterial" ).slider({
              range: true,
              min: 1,
              max: 500,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-meltingPointOfThePrintingMaterial0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-meltingPointOfThePrintingMaterial1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-meltingPointOfThePrintingMaterial0" ).val( ui.values[ 0 ]);
                $( ".amount-meltingPointOfThePrintingMaterial1" ).val( ui.values[ 1 ]);
              }
            });
              
            $( ".amount-meltingPointOfThePrintingMaterial0" ).val($( ".slider-range-meltingPointOfThePrintingMaterial" ).slider( "values", 0 ));
            $( ".amount-meltingPointOfThePrintingMaterial1" ).val($( ".slider-range-meltingPointOfThePrintingMaterial" ).slider( "values", 1 ));
              
              
            $( ".amount-meltingPointOfThePrintingMaterial0" ).change(function() {
            $(".slider-range-meltingPointOfThePrintingMaterial").slider('values',0,this.value);
                });
                
            $( ".amount-meltingPointOfThePrintingMaterial1" ).change(function() {
            $(".slider-range-meltingPointOfThePrintingMaterial").slider('values',1,this.value);
                });  
          });
		
		$(function() {
            $( ".slider-range-sizeExtruder" ).slider({
              range: true,
              min: 0,
              max: 2,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizeExtruder0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizeExtruder1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-sizeExtruder0" ).val( ui.values[ 0 ]);
                $( ".amount-sizeExtruder1" ).val( ui.values[ 1 ]);
              }
            });
              
            $( ".amount-sizeExtruder0" ).val($( ".slider-range-sizeExtruder" ).slider( "values", 0 ));
            $( ".amount-sizeExtruder1" ).val($( ".slider-range-sizeExtruder" ).slider( "values", 1 ));
              
              
            $( ".amount-sizeExtruder0" ).change(function() {
            $(".slider-range-sizeExtruder").slider('values',0,this.value);
                });
                
            $( ".amount-sizeExtruder1" ).change(function() {
            $(".slider-range-sizeExtruder").slider('values',1,this.value);
                });  
          });
		
		$(function() {
            $( ".slider-range-speedPrint" ).slider({
              range: true,
              min: 1,
              max: 1000,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-speedPrint0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-speedPrint1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-speedPrint0" ).val( ui.values[ 0 ]);
                $( ".amount-speedPrint1" ).val( ui.values[ 1 ]);
              }
            });
              
            $( ".amount-speedPrint0" ).val($( ".slider-range-speedPrint" ).slider( "values", 0 ));
            $( ".amount-speedPrint1" ).val($( ".slider-range-speedPrint" ).slider( "values", 1 ));
              
              
            $( ".amount-speedPrint0" ).change(function() {
            $(".slider-range-speedPrint").slider('values',0,this.value);
                });
                
            $( ".amount-sizeExtruder1" ).change(function() {
            $(".slider-range-speedPrint").slider('values',1,this.value);
                });  
          });
		
		$(function() {
            $( ".slider-range-thicknessOfThePrintingLayer" ).slider({
              range: true,
              min: 1,
              max: 500,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-thicknessOfThePrintingLayer0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-thicknessOfThePrintingLayer1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-thicknessOfThePrintingLayer0" ).val( ui.values[ 0 ]);
                $( ".amount-thicknessOfThePrintingLayer1" ).val( ui.values[ 1 ]);
              }
            });
              
            $( ".amount-thicknessOfThePrintingLayer0" ).val($( ".slider-range-thicknessOfThePrintingLayer" ).slider( "values", 0 ));
            $( ".amount-thicknessOfThePrintingLayer1" ).val($( ".slider-range-thicknessOfThePrintingLayer" ).slider( "values", 1 ));
              
              
            $( ".amount-thicknessOfThePrintingLayer0" ).change(function() {
            $(".slider-range-thicknessOfThePrintingLayer").slider('values',0,this.value);
                });
                
            $( ".amount-thicknessOfThePrintingLayer1" ).change(function() {
            $(".slider-range-thicknessOfThePrintingLayer").slider('values',1,this.value);
                });  
          });
		
		$(function() {
            $( ".slider-range-maximumWeightOfThePrintedModel" ).slider({
              range: true,
              min: 0,
              max: 100,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-maximumWeightOfThePrintedModel0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-maximumWeightOfThePrintedModel1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-maximumWeightOfThePrintedModel0" ).val( ui.values[ 0 ]);
                $( ".amount-maximumWeightOfThePrintedModel1" ).val( ui.values[ 1 ]);
              }
            });
              
            $( ".amount-maximumWeightOfThePrintedModel0" ).val($( ".slider-range-maximumWeightOfThePrintedModel" ).slider( "values", 0 ));
            $( ".amount-maximumWeightOfThePrintedModel1" ).val($( ".slider-range-maximumWeightOfThePrintedModel" ).slider( "values", 1 ));
              
              
            $( ".amount-maximumWeightOfThePrintedModel0" ).change(function() {
            $(".slider-range-maximumWeightOfThePrintedModel").slider('values',0,this.value);
                });
                
            $( ".amount-maximumWeightOfThePrintedModel1" ).change(function() {
            $(".slider-range-maximumWeightOfThePrintedModel").slider('values',1,this.value);
                });  
          });

		$(function() {
            $( ".slider-range-maxPowerConsumption" ).slider({
              range: true,
              min: 0,
              max: 100,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-maxPowerConsumption0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-maxPowerConsumption1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-maxPowerConsumption0" ).val( ui.values[ 0 ]);
                $( ".amount-maxPowerConsumption1" ).val( ui.values[ 1 ]);
              }
            });
              
            $( ".amount-maxPowerConsumption0" ).val($( ".slider-range-maxPowerConsumption" ).slider( "values", 0 ));
            $( ".amount-maxPowerConsumption1" ).val($( ".slider-range-maxPowerConsumption" ).slider( "values", 1 ));
              
              
            $( ".amount-maxPowerConsumption0" ).change(function() {
            $(".slider-range-maxPowerConsumption").slider('values',0,this.value);
                });
                
            $( ".amount-maxPowerConsumption1" ).change(function() {
            $(".slider-range-maxPowerConsumption").slider('values',1,this.value);
                });  
          });
		
		/*--- для веса ----*/
        $(function() {
          $( ".slider-range-weight" ).slider({
            range: true,
            min: 50,
            max: 5000,
            create: function () {
        	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-weight0').val() );
        	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-weight1').val() );
        	},
            slide: function( event, ui ) {
              $( ".amount-weight0" ).val( ui.values[ 0 ] );
              $( ".amount-weight1" ).val( ui.values[ 1 ] );
            }
          });
            
          $( ".amount-weight0" ).val($( ".slider-range-weight" ).slider( "values", 0 ));
          $( ".amount-weight1" ).val($( ".slider-range-weight" ).slider( "values", 1 ));
            
          $( ".amount-weight0" ).change(function() {
          $(".slider-range-weight").slider('values',0,this.value);
              });
              
          $( ".amount-weight1" ).change(function() {
          $(".slider-range-weight").slider('values',1,this.value);
              });  
            
        });
/*--- для ширины ---*/
        $(function() {
          $( ".slider-range-width" ).slider({
            range: true,
            min: 1,
            max: 10,
            create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-width0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-width1').val() );
          	},
            slide: function( event, ui ) {
              $( ".amount-width0" ).val( ui.values[ 0 ] );
              $( ".amount-width1" ).val( ui.values[ 1 ] );
            }
          });
            
          $( ".amount-width0" ).val($( ".slider-range-width" ).slider( "values", 0 ));
          $( ".amount-width1" ).val($( ".slider-range-width" ).slider( "values", 1 ));
            
          $( ".amount-width0" ).change(function() {
          $(".slider-range-width").slider('values',0,this.value);
              });
              
          $( ".amount-width1" ).change(function() {
          $(".slider-range-width").slider('values',1,this.value);
              }); 
            
        });
/*--- для высоты ---*/
        $(function() {
          $( ".slider-range-heigth" ).slider({
            range: true,
            min: 1,
            max: 10,
            create: function () {
        	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-heigth0').val() );
        	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-heigth1').val() );
        	},
            slide: function( event, ui ) {
              $( ".amount-heigth0" ).val( ui.values[ 0 ] );
              $( ".amount-heigth1" ).val( ui.values[ 1 ] );
            }
          });
            
          $( ".amount-heigth0" ).val($( ".slider-range-heigth" ).slider( "values", 0 ));
          $( ".amount-heigth1" ).val($( ".slider-range-heigth" ).slider( "values", 1 ));
            
          $( ".amount-heigth0" ).change(function() {
          $(".slider-range-heigth").slider('values',0,this.value);
              });
              
          $( ".amount-heigth1" ).change(function() {
          $(".slider-range-heigth").slider('values',1,this.value);
              }); 
            
        });
/*--- для глубины ---*/
        $(function() {
          $( ".slider-range-depth" ).slider({
            range: true,
            min: 0,
            max: 10,
            create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-depth0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-depth1').val() );
          	},
            slide: function( event, ui ) {
              $( ".amount-depth0" ).val( ui.values[ 0 ] );
              $( ".amount-depth1" ).val( ui.values[ 1 ] );
            }
          });
            
          $( ".amount-depth0" ).val($( ".slider-range-depth" ).slider( "values", 0 ));
          $( ".amount-depth1" ).val($( ".slider-range-depth" ).slider( "values", 1 ));
            
          $( ".amount-depth0" ).change(function() {
          $(".slider-range-depth").slider('values',0,this.value);
              });
              
          $( ".amount-depth1" ).change(function() {
          $(".slider-range-depth").slider('values',1,this.value);
              }); 
            
        });
	</script> 
