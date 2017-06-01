<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<header class="top_header">
		<div class="header_topline">
			<div class="container">
				<div class="col-md-12">
					<div class="row">
						<div class="top_information"><i class="fa fa-phone"></i> (044)-274-22-99</div>
						<div class="top_information"><i class="fa fa-phone"></i> (044)-405-96-11</div>
						<div class="top_information"><i class="fa fa-phone"></i> (044)-405-96-88</div>
						<div class="top_information map_top_information" data-toggle="modal" data-target="#myAdress">
							<i class="fa fa-map-marker"></i> г. Киев, ул. В.Покотыла, д. 7/2</div>
						<div class="top_information"><i class="fa fa-envelope-o"></i> office@forprint.net.ua</div>
						<div class="top_information" style="float:right;">
							<a href="https://www.youtube.com/channel/UCg5OBQp5r2Kwz3S6P0N45fA"><i class="fa fa-youtube"></i></a>							
							<a href="https://www.facebook.com/profile.php?id=100009816581722"><i class="fa fa-facebook-square"></i></a>
							<a href="https://plus.google.com/+Print-masterNetUa"><i class="fa fa-google-plus" aria-hidden="true"></i></a>
						</div>

					</div>
				</div>
			</div>
		</div>
		<div class="header_secondline">
			<div class="container">
				<div class="col-md-4 col-sm-4 col-xs-4">
					<div class="row">
						<a href="<c:url value='/' />" class="logo">E-Machine</a>
						

						<div class="btn-group">
  							<button type="button" class="btn btn-primary" style="margin-left:15px;">Стоимость в:</button>
  							<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    								<span class="caret"></span>
    								<span class="sr-only">Toggle Dropdown</span>
  							</button>
  							<ul class="dropdown-menu">
    								<li><a href="javascript:convertPriceOnSite('dollar', ${ constants.dollar_in_grivna })"><i class="fa fa-usd"></i> ( ${ constants.dollar_in_grivna } грн. )</a></li>
    								<li><a href="javascript:convertPriceOnSite('euro', ${ constants.euro_in_grivna })"><i class="fa fa-eur"></i> ( ${ constants.euro_in_grivna } грн. )</a></li>
    								<li><a href="javascript:convertPriceOnSite('grinva', 1)">&#8372;, UAH</a></li>
    							</ul>
    						</div>
					</div>
				</div>
				


				<div class="col-md-4  col-sm-4 col-xs-4">
					<div class="row">
						<div class="input-group" id="search_area_by_phrase">
		  					<input id="search_input_by_phrase" type="text" class="form-control" aria-label="..." placeholder="<spring:message code="head.search.pleaceholder"/>">
						  	<div class="input-group-btn">
						    	<div class="btn-group">
								  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								    Поиск <span class="caret"></span>
								  </button>
								  <ul class="dropdown-menu">
								    <li><a href="javascript:searchByPhraseIncludeType('printer')">Принтеры</a></li>
								    <li><a href="javascript:searchByPhraseIncludeType('3d_printer')">3Д принтеры</a></li>
								    <li><a href="javascript:searchByPhraseIncludeType('digital_printer')">Цыфровые принтеры</a></li>
								    <li><a href="javascript:searchByPhraseIncludeType('laminator')">Ламинаторы</a></li>
								    <li><a href="javascript:searchByPhraseIncludeType('laser')">Лазеры</a></li>
								    <li><a href="javascript:searchByPhraseIncludeType('cutter')">Фрезеры</a></li>
								    <li><a href="javascript:searchByPhraseIncludeType('scanner')">Сканеры</a></li>
								    <li><a href="javascript:searchByPhraseIncludeType('rip')">ПО</a></li>
								    <li><a href="javascript:searchByPhraseIncludeType('use_with_product')">Сопутствующие товары</a></li>
								    <li role="separator" class="divider"></li>
								    <li><a href="javascript:searchByPhraseIncludeType('all')">По всех разделах</a></li>
								  </ul>
								</div>
							</div>
						</div>
					</div>
				</div>




				<div class="col-md-3  col-sm-3 col-xs-3 col-md-offset-1">
					<div class="row">
						<div class="btn-group">
  							<button type="button" class="btn btn-info"><i class="fa fa-globe"></i></button>
  							<button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    								<span class="caret"></span>
    								<span class="sr-only">Toggle Dropdown</span>
  							</button>
  							<ul class="dropdown-menu">
    							<li><a href="?lang=en">English</a></li>
    							<li><a href="?lang=ru">Русский</a></li>
    						</ul>
    					</div>


						<div class="btn-group">
  						<button type="button" class="btn btn-success"><i class="fa fa-user"></i></button>
  							<button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    								<span class="caret"></span>
    								<span class="sr-only">Toggle Dropdown</span>
  							</button>
  							<ul class="dropdown-menu">




						<c:url value="/logout" var="logoutUrl" />
							<!-- csrt for log out-->
						<form action="${logoutUrl}" method="post" id="logoutForm" style="display: none;">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						</form>
				
						<script>
							function formSubmit() {
								document.getElementById("logoutForm").submit();
							}
						</script>
			
							<c:if test="${pageContext.request.userPrincipal.name != null}">
								<li><a href="<c:url value='/user' />">Вы вошли как: ${pageContext.request.userPrincipal.name}</a></li>
								<li><a href="javascript:formSubmit()">Выход</a></li>
							</c:if>
							<c:if test="${pageContext.request.userPrincipal.name == null}">
								<li><a href="<c:url value='/login' />">Войти</a></li>
    							<li><a href="<c:url value='/registration' />">Зарегистрироваться</a></li>
							</c:if>
    							<%--<li role="separator" class="divider"></li>
    							<li><a href="#">Еще что-то</a></li> --%>
    						</ul>
    					</div>
    					
    					<div class="btn-group" style="padding-top: 7px; margin-bottom: -7px;">
	    					<table class="table" style="margin: 0px; font-size: 13px;">
	    						<tr>
	    							<td style="padding: 3px 6px; border-top:none;">1 <i class="fa fa-usd"></i></td>
	    							<td style="padding: 3px 6px;border-top:none;"><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${ constants.dollar_in_grivna }" /> грн.</td>
	    							
	    						</tr>
	    						<tr>
	    							<td style="padding: 3px 6px;">1 <i class="fa fa-eur"></i></td>
	    							<td style="padding: 3px 6px;"><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${ constants.euro_in_grivna }" /> грн.</td>
	    							
	    						</tr>
	    					</table>
    					</div>
    					
    					   <!-- Button trigger modal -->
						<button class="btn btn-primary btn-lg cart-modal-window" data-toggle="modal" data-target="#myModal">
						  <i class="fa fa-shopping-basket" aria-hidden="true"></i>
						  <i id="quantity_products_in_cart">${cart.getTotalQuantity()}</i>
						</button> 
    					
					</div>
				</div>


			</div>
		</div>


		<div class="header_menu">
			<div class="container">
				<div class="col-md-12">
					<div class="row">
						<div id="mainmenu">
        					<div id="full_menu">
								<div class="toggle-menu">
									<i class="fa fa-bars" aria-hidden="true"></i>
								</div> 
            				</div>
            <ul>
            
            <!-- PRINTERS -->
            	<li><a href="<c:url value='/printers' />"><spring:message code="head.printer"/></a>
                	<div class="head_menu_point_1">
                    	<div class="head_menu_point_element">
                        	<a href="<c:url value='/printers/dissolving' />">
                            <img src="/images/menu/printers/${picturesInHeadMenu.printersJSON.listPicturesDissolvingPrinters[0]}" alt="" >
                            <p><spring:message code="head.printer.dissolving"/></p></a>
                        </div>
                        <div class="head_menu_point_element">
                        	<a href="<c:url value='/printers/ecosolvent' />">
                        	<img src="/images/menu/printers/${picturesInHeadMenu.printersJSON.listPicturesEcosolventPrinters[0]}" alt="">
                        	<p><spring:message code="head.printer.ecosolvent"/></p></a>
                        </div>
                        <div class="head_menu_point_element">
                        	<a href="<c:url value='/printers/UV_roll' />">
                        	<img src="/images/menu/printers/${picturesInHeadMenu.printersJSON.listPicturesUvRollPrinters[0]}" alt="" >
                        	<p><spring:message code="head.printer.uv_roll"/></p></a>
                        </div>                                       
                        <div class="head_menu_point_element">
                            <a href="<c:url value='/printers/UV_flatbed' />">
                            <img src="/images/menu/printers/${picturesInHeadMenu.printersJSON.listPicturesUvFlatbedPrinters[0]}" alt="" >
                            <p><spring:message code="head.printer.flatbed"/></p></a>
                        </div>
                        <div class="head_menu_point_element">
                            <a href="<c:url value='/printers/sublimation' />">
                            <img src="/images/menu/printers/${picturesInHeadMenu.printersJSON.listPicturesSublimationPrinters[0]}" src="" alt="" >
                            <p><spring:message code="head.printer.sublimation"/></p></a>
                        </div>
                        <div class="head_menu_point_element">
                            <a href="<c:url value='/printers/textile' />">
                            <img src="/images/menu/printers/${picturesInHeadMenu.printersJSON.listPicturesTextilePrinters[0]}" alt="" >
                            <p><spring:message code="head.printer.textile"/></p></a>
                        </div>
                        <div class="head_menu_point_element">
                            <a href="<c:url value='/printers/water_pigment' />">
                            <img src="/images/menu/printers/${picturesInHeadMenu.printersJSON.listPicturesWaterPigmentPrinters[0]}" alt="" >
                            <p><spring:message code="head.printer.water_pigment"/></p></a>
                        </div>
                        <div class="head_menu_point_element">
                            <a href="<c:url value='/printers/SAPR-GIS' />">
                            <img src="/images/menu/printers/${picturesInHeadMenu.printersJSON.listPictures_SAPR_GIS_Printers[0]}" alt="" >
                            <p><spring:message code="head.printer.SAPR-GIS"/></p></a>
                        </div>
					</div>
				</li>
				
            <!-- 3D PRINTERS -->
                <li><a href="<c:url value='/3d_printers' />"><spring:message code="head.3dprinter"/></a>
                	<div class="head_menu_point_2">
                    	<div class="head_menu_point_element">
                    	<a href="<c:url value='/3d_printers/FDM-extruder' />">
                    	<img src="/images/menu/printers3d/${picturesInHeadMenu.printers3dJSON.list_3dPrintersFDM_Extruder[0]}" alt="" >
                    	<p><spring:message code="head.3dprinter.FDM-extruder"/></p></a>
                	</div>
                	<div class="head_menu_point_element">
                		<a href="<c:url value='/3d_printers/photo_printing_polyjet' />">
                		<img src="/images/menu/printers3d/${picturesInHeadMenu.printers3dJSON.list_3d_printers_photo_printing_polyjet[0]}" alt="" >
                		<p><spring:message code="head.3dprinter.photo_printing_polyjet"/></p></a>
                	</div>
                	<div class="head_menu_point_element">
                		<a href="<c:url value='/3d_printers/laser_sintering_LENS' />">
                    	<img src="/images/menu/printers3d/${picturesInHeadMenu.printers3dJSON.list_3d_printers_laser_sintering_LENS[0]}" alt="" >
                    	<p><spring:message code="head.3dprinter.laser_sintering_LENS"/></p></a>
                	</div>
                	<div class="head_menu_point_element">
                		<a href="<c:url value='/3d_printers/lamination_LOM' />">
                		<img src="/images/menu/printers3d/${picturesInHeadMenu.printers3dJSON.list_3d_printers_lamination_LOM[0]}" alt="" >
                		<p><spring:message code="head.3dprinter.lamination_LOM"/></p></a>
                	</div>
                	<div class="head_menu_point_element">
                		<a href="<c:url value='/3d_printers/stereolithography_SL' />">
                		<img src="/images/menu/printers3d/${picturesInHeadMenu.printers3dJSON.list_3d_printers_stereolithography_SL[0]}" alt="" >
                		<p><spring:message code="head.3dprinter.stereolithography_SL"/></p></a>
                	</div>
                	<div class="head_menu_point_element">
                		<a href="<c:url value='/3d_printers/laser_sintering_LS' />">
                		<img src="/images/menu/printers3d/${picturesInHeadMenu.printers3dJSON.list_3d_printers_laser_sintering_LS[0]}" alt="" >
                		<p><spring:message code="head.3dprinter.laser_sintering_LS"/></p></a>
                	</div>
                	<div class="head_menu_point_element">
                		<a href="<c:url value='/3d_printers/powder_bonding_3DP' />">
                		<img src="/images/menu/printers3d/${picturesInHeadMenu.printers3dJSON.list_3d_printers_powder_bonding_3DP[0]}" alt="" >
                    	<p><spring:message code="head.3dprinter.powder_bonding_3DP"/></p></a>
                	</div>                                      
            	</div>
			</li>
			
			<!-- Пункт меню 3 цыфровые принтера-->
            <li><a href="<c:url value='/digital_printers' />"><spring:message code="head.digital_printer"/></a>
            	<div class="head_menu_point_3">
                	<div class="head_menu_point_element">
                    	<a href="<c:url value='/digital_printers/full_color_laser_printers' />">
                        	<img src="/images/menu/digital_printers/${picturesInHeadMenu.digital_printersJSON.list_full_color_laser_printers[0]}" alt="" >
                        	<p><spring:message code="head.digital_printer.full_color_laser_printers"/></p>
                        </a>
                   	</div>
                    <div class="head_menu_point_element">
                    	<a href="<c:url value='/digital_printers/monochrome_laser_printers' />">
                    		<img src="/images/menu/digital_printers/${picturesInHeadMenu.digital_printersJSON.list_monochrome_laser_printers[0]}" alt="" >
                    		<p><spring:message code="head.digital_printer.monochrome_laser_printers"/></p>
                    	</a>
                    </div>
                    <div class="head_menu_point_element">
                    	<a href="<c:url value='/digital_printers/full-color_inkjet_printers' />">
                    		<img src="/images/menu/digital_printers/${picturesInHeadMenu.digital_printersJSON.list_full_color_inkjet_printers[0]}" alt="" >
                    		<p><spring:message code="head.digital_printer.full_color_inkjet_printers"/></p>
                    	</a>
                    </div>                                                                            
				</div>
			</li>
			
		<!-- Пункт меню 4 Ламинирование-->
            <li><a href="<c:url value='/laminators' />"><spring:message code="head.laminator"/></a>
            	<div class="head_menu_point_34">
                	<div class="head_menu_point_element">
                    	<a href="<c:url value='/laminators/hot_lamination' />">
                        <img src="/images/menu/laminator/${picturesInHeadMenu.laminatorJSON.list_hot_lamination[0]}" alt="" >
                        <p><spring:message code="head.laminator.hot_lamination"/></p></a>
                   	</div>
                    <div class="head_menu_point_element">
                    	<a href="<c:url value='/laminators/cold_laminating' />">
                    	<img src="/images/menu/laminator/${picturesInHeadMenu.laminatorJSON.list_cold_laminating[0]}" alt="" >
                    	<p><spring:message code="head.laminator.cold_laminating"/></p></a>
                    </div>
                    <div class="head_menu_point_element">
                    	<a href="<c:url value='/laminators/liquid' />">
                    	<img src="/images/menu/laminator/${picturesInHeadMenu.laminatorJSON.list_liquid[0]}" alt="" >
                    	<p><spring:message code="head.laminator.liquid"/></p></a>
                    </div>     
                    <div class="head_menu_point_element">
                    	<a href="<c:url value='/laminators/flatbed_laminating_machine' />">
                    	<img src="/images/menu/laminator/${picturesInHeadMenu.laminatorJSON.list_flatbed_laminating_machine[0]}" alt="" >
                    	<p><spring:message code="head.laminator.flatbed_laminating_machine"/></p></a>
                    </div>                                                                       
				</div>
			</li>
			
		<!-- Пункт меню 5 Лазеры-->
            <li><a href="<c:url value='/lasers' />"><spring:message code="head.laser"/></a>
            	<div class="head_menu_point_4">
            		<div class="head_menu_point_element">
                    	<a href="<c:url value='/lasers/CO2_gas_lasers' />">
                    	<img src="/images/menu/laser/${picturesInHeadMenu.laserJSON.list_CO2_gas_lasers[0]}" alt="" >
                    	<p><spring:message code="head.laser.CO2_gas_lasers"/></p></a>
                	</div>
                	<div class="head_menu_point_element">
                		<a href="<c:url value='/lasers/solid_state_lasers' />">
                    	<img src="/images/menu/laser/${picturesInHeadMenu.laserJSON.list_solid_state_lasers[0]}" alt="" >
                    	<p><spring:message code="head.laser.solid_state_lasers"/></p></a>
                	</div>     
                	<div class="head_menu_point_element">
                		<a href="<c:url value='/lasers/for_the_treatment_of_metal' />">
                    	<img src="/images/menu/laser/${picturesInHeadMenu.laserJSON.list_for_the_treatment_of_metal[0]}" alt="" >
                    	<p><spring:message code="head.laser.for_the_treatment_of_metal"/></p></a>
                	</div>
                	<div class="head_menu_point_element">
                		<a href="<c:url value='/lasers/diode_pumped' />">
                    	<img src="/images/menu/laser/${picturesInHeadMenu.laserJSON.list_diode_pumped[0]}" alt="" >
                    	<p><spring:message code="head.laser.diode_pumped"/></p></a>
                	</div>  
                	<div class="head_menu_point_element">
                		<a href="<c:url value='/lasers/fiber_lasers' />">
                    	<img src="/images/menu/laser/${picturesInHeadMenu.laserJSON.list_fiber_lasers[0]}" alt="" >
                    	<p><spring:message code="head.laser.fiber_lasers"/></p></a>
                	</div>
                	<div class="head_menu_point_element">
                		<a href="<c:url value='/lasers/plasma_lasers' />">
                    	<img src="/images/menu/laser/${picturesInHeadMenu.laserJSON.list_plasma_lasers[0]}" alt="" >
                    	<p><spring:message code="head.laser.plasma_lasers"/></p></a>
                	</div>                               
               </div>
			</li>
			
		<!-- Пункт меню 6 Фрезеры -->
        	<li><a href="<c:url value='/cutters' />"><spring:message code="head.cutter"/></a>
            	<div class="head_menu_point_5">
                	<div class="head_menu_point_element">
                    	<a href="<c:url value='/cutters/for_wood' />">
                        	<img src="/images/menu/cutter/${picturesInHeadMenu.cutterJSON.list_for_wood[0]}" alt="" >
                        <p><spring:message code="head.cutter.for_wood"/></p></a>
                    </div>
                    <div class="head_menu_point_element">
                    	<a href="<c:url value='/cutters/for_the_treatment_of_metal' />">
                    		<img src="/images/menu/cutter/${picturesInHeadMenu.cutterJSON.list_for_the_treatment_of_metal[0]}" alt="" >
                    	<p><spring:message code="head.cutter.for_the_treatment_of_metal"/></p></a>
                    </div>
                    <div class="head_menu_point_element">
                    	<a href="<c:url value='/cutters/stone_processing' />">
                        	<img src="/images/menu/cutter/${picturesInHeadMenu.cutterJSON.list_stone_processing[0]}" alt="" >
                        <p><spring:message code="head.cutter.stone_processing"/></p></a>
                    </div>                                                                            
                    </div>
			</li>
				
			<!-- Пункт меню 7 Сканеры-->
                <li><a href="<c:url value='/scanners' />"><spring:message code="head.scanner"/></a>
                	<div class="head_menu_point_6">
                    	<div class="head_menu_point_element">
                        	<a href="<c:url value='/scanners/large_format_scanners' />">
                        	<img src="/images/menu/scanner/${picturesInHeadMenu.scannerJSON.list_large_format_scanners[0]}" alt="" >
                            <p><spring:message code="head.scanner.large_format_scanners"/></p></a>
                        </div>
                        <div class="head_menu_point_element">
                        	<a href="<c:url value='/scanners/3d_scanners' />">
                        	<img src="/images/menu/scanner/${picturesInHeadMenu.scannerJSON.list_3d_scanners[0]}" alt="" >
                            <p><spring:message code="head.scanner.3d_scanners"/></p></a>
                        </div>
                    </div>
				</li>
				
			<!-- Пункт меню 8 Бывшего употребления-->
				<li><a href="<c:url value='/previous_use_equipments' />"><spring:message code="head.previouslyUsed"/></a>
					<!--  <div class="head_menu_point_7">
                    	<div class="head_menu_point_element">
                        	<a href="#">
                            <img src="/images/menu/previouslyUsed/${picturesInHeadMenu.previouslyUsedJSON.list_solvent_equipment[0]}" alt="" >
                            <p><spring:message code="head.previouslyUsed.solvent_equipment"/></p></a>
                        </div>
                    	<div class="head_menu_point_element">
                        	<a href="#">
                            <img src="/images/menu/previouslyUsed/${picturesInHeadMenu.previouslyUsedJSON.list_ecosolvent_oborudovnie[0]}" alt="" >
                            <p><spring:message code="head.previouslyUsed.ecosolvent_oborudovnie"/></p></a>
                        </div>                                                                           
					</div>	-->
				</li>
				
			<!-- Пункт меню 9 ПО rip-->
                <li><a href="<c:url value='/rips' />"><spring:message code="head.rip"/></a></li>

			</ul><!-- Конец списка -->
		</div><!-- Конец блока #mainmenu -->
					</div>
				</div>
			</div>
		</div>
</header>
