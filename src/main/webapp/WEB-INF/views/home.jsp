<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE>
<html lang="ru">
<head>
<meta charset="utf-8">
	<title><spring:message code="home.title"/></title>
</head>
<body>
	<div class="reklam_animation">
		<div class="col-md-10">
			<div class="row">
	            <div class="sider_container">
					<div class="next_button"><i class="fa fa-angle-right"></i></div>
				    <div class="pause_button"><i class="fa fa-pause" aria-hidden="true"></i></div>
				    <div class="play_button" style="display: none;"><i class="fa fa-play" aria-hidden="true"></i></div>
				    <div class="prev_button"><i class="fa fa-angle-left"></i></div>
				    <div class="carousel">
						<c:forEach items="${homeJSON.listPicturesOfCentralReklam}" var="picture">
	                		<div class="slide_item">
	                			<a class="fancybox" 
	                			data-fancybox-group="group" href="/images/home/big_reklam/${picture}">
	                				<img src="/images/home/big_reklam/${picture}" alt="alt" />
	                			</a>
	                		</div>
	
					    </c:forEach>
				   </div>
				</div>
			</div>
		</div>
		<div class="col-md-2">
			<div class="row">
              <div class="rigt_of_reklam_animation">
            
                <div><img src="/images/home/right_of_reklam/1/${homeJSON.listPicturesRightOfReklam1.fileNameArray.get(0)}" alt="Надпись" />
                <c:if test="${homeJSON.listPicturesRightOfReklam1.description!='1'}"><p>${homeJSON.listPicturesRightOfReklam1.description}</p></c:if></div>
         
                <div><img src="/images/home/right_of_reklam/2/${homeJSON.listPicturesRightOfReklam2.fileNameArray.get(0)}" alt="Надпись" />
                <c:if test="${homeJSON.listPicturesRightOfReklam2.description!='1'}"><p>${homeJSON.listPicturesRightOfReklam2.description}</p></c:if></div>
	    
                <div><img src="/images/home/right_of_reklam/3/${homeJSON.listPicturesRightOfReklam3.fileNameArray.get(0)}" alt="Надпись" />
                <c:if test="${homeJSON.listPicturesRightOfReklam3.description!='1'}"><p>${homeJSON.listPicturesRightOfReklam3.description}</p></c:if></div>

              </div>
			</div>
		</div>

	</div>

<div class="goods">   
        
<c:if test="${fn:length(listVideo) > 0}">         
	<div class="video_content">
		<div class="sider_container">
			<div class="next_button_video"><i class="fa fa-angle-right"></i></div>
			<div class="pause_button_video"><i class="fa fa-pause" aria-hidden="true"></i></div>
			<div class="play_button_video" style="display: none;"><i class="fa fa-play" aria-hidden="true"></i></div>
			<div class="prev_button_video"><i class="fa fa-angle-left"></i></div>
			<div class="carousel_video">
				
			<c:forEach items="${listVideo}" var="video">
				<div class="slide-item-video">
					<iframe style="width: inherit;" src="http://www.youtube.com/embed/${video.path}"></iframe> 
					<p>${video.description}</p>
		         </div>	
	           </c:forEach>
	
			</div>
		</div>
	</div>
</c:if>
        
<c:if test="${fn:length(printers) > 0}">        
            <div class="advertising">
				<div class="col-md-4">
					<div class="row">
						<a href="<c:if test="${homeJSON.list_printer_top1.href!='1'}">${homeJSON.list_printer_top1.href}</c:if>">
		                			<img src="/images/home/three_big_pictures/printer_top/1/${homeJSON.list_printer_top1.fileNameArray.get(0)}" alt="" ></a>
					</div>
				</div>
				<div class="col-md-4">
					<div class="row">
						<a href="<c:if test="${homeJSON.list_printer_top2.href!='1'}">${homeJSON.list_printer_top2.href}</c:if>">
		                			<img src="/images/home/three_big_pictures/printer_top/2/${homeJSON.list_printer_top2.fileNameArray.get(0)}" alt="" ></a>
					</div>
				</div>
				<div class="col-md-4">
					<div class="row">
						<a href="<c:if test="${homeJSON.list_printer_top3.href!='1'}">${homeJSON.list_printer_top3.href}</c:if>">
		                			<img src="/images/home/three_big_pictures/printer_top/3/${homeJSON.list_printer_top3.fileNameArray.get(0)}" alt="" ></a>
					</div>
				</div>
            </div>




<div class="categories_of_goods">
<div class="row">

                <div class="col-md-3 col-lg-3" style="padding: 0px;">
                  <div class="list-group">
                    <a href="<c:url value='/printers' />" class="list-group-item active">
                      <spring:message code="head.printer"/>
                    </a>
                    <a href="<c:url value='/printers/dissolving' />" class="list-group-item"><spring:message code="head.printer.dissolving"/></a>

                            <a href="<c:url value='/printers/ecosolvent' />" class="list-group-item"><spring:message code="head.printer.ecosolvent"/></a>

                            <a href="<c:url value='/printers/UV_roll' />" class="list-group-item"><spring:message code="head.printer.uv_roll"/></a>

                            <a href="<c:url value='/printers/UV_flatbed' />" class="list-group-item"><spring:message code="head.printer.flatbed"/></a>

                            <a href="<c:url value='/printers/sublimation' />" class="list-group-item"><spring:message code="head.printer.sublimation"/></a>

                            <a href="<c:url value='/printers/textile' />" class="list-group-item"><spring:message code="head.printer.textile"/></a>
                            
                            <a href="<c:url value='/printers/water_pigment' />" class="list-group-item"><spring:message code="head.printer.water_pigment"/></a>
                            
                            <a href="<c:url value='/printers/SAPR-GIS' />" class="list-group-item"><spring:message code="head.printer.SAPR-GIS"/></a>
                  </div>
                </div>

			
<%--
              <div class="col-md-9 col-lg-9">
                <div class="row">
                  <div class="sider_container">
                     <div class="next_button_printer"><i class="fa fa-angle-right"></i></div>
                     <div class="pause_button_printer" style="display: none;"><i class="fa fa-pause" aria-hidden="true"></i></div>
			         <div class="play_button_printer"><i class="fa fa-play" aria-hidden="true"></i></div>
                     <div class="prev_button_printer"><i class="fa fa-angle-left"></i></div>
                     <div class="carousel_printer">
                        <c:forEach items="${printers}" var="product">
                              <div class="slide-item">
                                  <a class="slider_image" href="<c:url value='/printer/${product.id}' />">
                                  	<div class="outer_a_img"><img src="/images/printers/${product.id}/${product.pathPictures.get(0)}" alt="" /></div>
                                  </a>
                                  
                                  
                                  <div class="name_price_cart_block">
                                               
                                      <a href="<c:url value='/printer/${product.id}' />" class="slide-title">${product.name}</a>         
                                                                    
	                                  <div class="product_price"><span style="float: left;">Цена:&nbsp;</span> 
										<input type="hidden" name="price_value" value="${product.prise}">
							       		<c:if test="${product.prise < 0.1}"><a href="#callback" class="fancybox">уточняйте</a></c:if>
										<c:if test="${!(product.prise < 0.1)}">					
						   					<div></div>
										</c:if>
					           		 </div>
					           		 
					           		 <i class="fa fa-cart-plus add_to_cart" aria-hidden="true" 
					           		 	style="padding-right: 5px; top: 3px; right: 5px; position: absolute; font-size: 40px;"
									onclick="addToCart('printer', ${product.id}, '${product.name}', '${product.prise}','${product.pathPictures.get(0)}');"></i>
					
								</div>

                              </div>
                     	</c:forEach>
                     </div>
                  </div>
                </div>
              </div>
              
                <h:home_section_of_product type="printer" arrayOfProduct="${printers}"/>--%>
              
             <jsp:include page="home_section_of_product.jsp" flush="true">
			     <jsp:param name="type" value="printer"/>
			     <jsp:param name="arrayOfProduct" value="${printers}" />
			</jsp:include>
             

            </div>
</div>
</c:if>


<c:if test="${fn:length(printers3D) > 0}">
            <div class="advertising_second_variant">

		<div class="col-md-6">
			<div class="row">
			<a href="${homeJSON.list_3d_printer_top1.href}">
                <img src="/images/home/two_narrow_pictures/3d_printer_top/1/${homeJSON.list_3d_printer_top1.fileNameArray.get(0)}" alt="" ></a>
			</div>
		</div>

		<div class="col-md-6">
			<div class="row">
			<a href="${homeJSON.list_3d_printer_top2.href}">
                <img src="/images/home/two_narrow_pictures/3d_printer_top/2/${homeJSON.list_3d_printer_top2.fileNameArray.get(0)}" alt="" ></a>
			</div>
		</div>

            </div>







            <div class="categories_of_goods">
<div class="row">

                <div class="col-md-3" style="padding: 0px;">
                  <div class="list-group">

                    <a href="<c:url value='/3d_printers' />" class="list-group-item active">
                      <spring:message code="head.3dprinter"/>
                    </a>
                            <a href="<c:url value='/3d_printers/FDM-extruder' />" class="list-group-item">
                            <spring:message code="head.3dprinter.FDM-extruder"/></a>

                            <a href="<c:url value='/3d_printers/photo_printing_polyjet' />" class="list-group-item">
                            <spring:message code="head.3dprinter.photo_printing_polyjet"/></a>

                            <a href="<c:url value='/3d_printers/laser_sintering_LENS' />" class="list-group-item">
                            <spring:message code="head.3dprinter.laser_sintering_LENS"/></a>

                            <a href="<c:url value='/3d_printers/lamination_LOM' />" class="list-group-item">
                            <spring:message code="head.3dprinter.lamination_LOM"/></a>

                            <a href="<c:url value='/3d_printers/stereolithography_SL' />" class="list-group-item">
                            <spring:message code="head.3dprinter.stereolithography_SL"/></a>

                            <a href="<c:url value='/3d_printers/laser_sintering_LS' />" class="list-group-item">
                            <spring:message code="head.3dprinter.laser_sintering_LS"/></a>
                            
                            <a href="<c:url value='/3d_printers/powder_bonding_3DP' />" class="list-group-item">
                            <spring:message code="head.3dprinter.powder_bonding_3DP"/></a>
                  </div>
                </div>

              <div class="col-md-9 col-lg-9">
                <div class="row">
                  <div class="sider_container">
                     <div class="next_button_printer_3d"><i class="fa fa-angle-right"></i></div>
                     <div class="pause_button_printer_3d" style="display: none;"><i class="fa fa-pause" aria-hidden="true"></i></div>
			         <div class="play_button_printer_3d"><i class="fa fa-play" aria-hidden="true"></i></div>
                     <div class="prev_button_printer_3d"><i class="fa fa-angle-left"></i></div>
                     <div class="carousel_printer_3d">
                        <c:forEach items="${printers3D}" var="product">
                              <div class="slide-item">
                                  <a class="slider_image" href="<c:url value='/3d_printer/${product.id}' />">
                                  	<div class="outer_a_img"><img src="/images/3d_printers/${product.id}/${product.pathPictures.get(0)}" alt="" /></div>
                                  </a>
                                  
                                  <div class="name_price_cart_block">
                                               
                                      <a href="<c:url value='/3d_printer/${product.id}' />" class="slide-title">${product.name}</a>         
                                                                    
	                                  <div class="product_price"><span style="float: left;">Цена:&nbsp;</span> 
										<input type="hidden" name="price_value" value="${product.prise}">
							       		<c:if test="${product.prise < 0.1}"><a href="#callback" class="fancybox">уточняйте</a></c:if>
										<c:if test="${!(product.prise < 0.1)}">					
						   					<div></div>
										</c:if>
					           		 </div>
					           		 
					           		 <i class="fa fa-cart-plus add_to_cart" aria-hidden="true" 
					           		 	style="padding-right: 5px; top: 3px; right: 5px; position: absolute; font-size: 40px;"
									onclick="addToCart('3d_printer', ${product.id}, '${product.name}', '${product.prise}','${product.pathPictures.get(0)}');"></i>
					
								</div>

                              </div>
                          </c:forEach>
                     </div>
                  </div>
                </div>
              </div>

            </div>
</div>
</c:if>


<c:if test="${fn:length(digitalPrinters) > 0}">
<div class="advertising">
		<div class="col-md-4">
			<div class="row">
				<a href="${homeJSON.list_digital_printer_top1.href}">
                	<img src="/images/home/three_big_pictures/digital_printer_top/1/${homeJSON.list_digital_printer_top1.fileNameArray.get(0)}" alt="" ></a>
			</div>
		</div>
		<div class="col-md-4">
			<div class="row">
				<a href="${homeJSON.list_digital_printer_top2.href}">
                	<img src="/images/home/three_big_pictures/digital_printer_top/2/${homeJSON.list_digital_printer_top2.fileNameArray.get(0)}" alt="" ></a>
			</div>
		</div>
		<div class="col-md-4">
			<div class="row">
				<a href="${homeJSON.list_digital_printer_top3.href}">
                	<img src="/images/home/three_big_pictures/digital_printer_top/3/${homeJSON.list_digital_printer_top3.fileNameArray.get(0)}" alt="" ></a>
			</div>
		</div>

            </div>
            

           <div class="categories_of_goods">
<div class="row">

                <div class="col-md-3" style="padding: 0px;">
                  <div class="list-group">

                     <a href="<c:url value='/digital_printers' />" class="list-group-item active"><spring:message code="head.digital_printer"/></a>

                            <a href="<c:url value='/digital_printers/full_color_laser_printers' />" class="list-group-item">
                            <spring:message code="head.digital_printer.full_color_laser_printers"/></a>

                            <a href="<c:url value='/digital_printers/monochrome_laser_printers' />" class="list-group-item">
                            <spring:message code="head.digital_printer.monochrome_laser_printers"/></a>

                            <a href="<c:url value='/digital_printers/full-color_inkjet_printers' />" class="list-group-item">
                            <spring:message code="head.digital_printer.full_color_inkjet_printers"/></a>
                  </div>
                </div>

              <div class="col-md-9 col-lg-9">
                <div class="row">
                  <div class="sider_container">
                     <div class="next_button_printer_d"><i class="fa fa-angle-right"></i></div>
                     <div class="pause_button_printer_d" style="display: none;"><i class="fa fa-pause" aria-hidden="true"></i></div>
			         <div class="play_button_printer_d"><i class="fa fa-play" aria-hidden="true"></i></div>
                     <div class="prev_button_printer_d"><i class="fa fa-angle-left"></i></div>
                     <div class="carousel_printer_d">
                        <c:forEach items="${digitalPrinters}" var="product">
                              <div class="slide-item">
                                  <a class="slider_image" href="<c:url value='/digital_printer/${product.id}' />">
                                  	<div class="outer_a_img"><img src="/images/digital_printers/${product.id}/${product.pathPictures.get(0)}" alt="" /></div>
                                  </a>
                                  
                                  <div class="name_price_cart_block">
                                               
                                      <a href="<c:url value='/digital_printer/${product.id}' />" class="slide-title">${product.name}</a>         
                                                                    
	                                  <div class="product_price"><span style="float: left;">Цена:&nbsp;</span> 
										<input type="hidden" name="price_value" value="${product.prise}">
							       		<c:if test="${product.prise < 0.1}"><a href="#callback" class="fancybox">уточняйте</a></c:if>
										<c:if test="${!(product.prise < 0.1)}">					
						   					<div></div>
										</c:if>
					           		 </div>
					           		 
					           		 <i class="fa fa-cart-plus add_to_cart" aria-hidden="true" 
					           		 	style="padding-right: 5px; top: 3px; right: 5px; position: absolute; font-size: 40px;"
									onclick="addToCart('digital_printer', ${product.id}, '${product.name}', '${product.prise}','${product.pathPictures.get(0)}');"></i>
					
								</div>

                              </div>
                          </c:forEach>
                     </div>
                  </div>
                </div>
              </div>

            </div>
</div>
</c:if>


<c:if test="${fn:length(laminators) > 0}">
	<div class="advertising_second_variant">

		<div class="col-md-6">
			<div class="row">
			<a href="${homeJSON.list_laminator_top1.href}">
                <img src="/images/home/two_narrow_pictures/laminator_top/1/${homeJSON.list_laminator_top1.fileNameArray.get(0)}" alt="" ></a>
			</div>
		</div>

		<div class="col-md-6">
			<div class="row">
			<a href="${homeJSON.list_laminator_top2.href}">
                <img src="/images/home/two_narrow_pictures/laminator_top/2/${homeJSON.list_laminator_top2.fileNameArray.get(0)}" alt="" ></a>
			</div>
		</div>

            </div>        

            <div class="categories_of_goods">
<div class="row">

                <div class="col-md-3" style="padding: 0px;">
                  <div class="list-group">

                     <a href="<c:url value='/laminators' />" class="list-group-item active"><spring:message code="head.laminator"/></a>

                            <a href="<c:url value='/laminators/hot_lamination' />" class="list-group-item">
                            <spring:message code="head.laminator.hot_lamination"/></a>

                            <a href="<c:url value='/laminators/cold_laminating' />" class="list-group-item">
                            <spring:message code="head.laminator.cold_laminating"/></a>

                            <a href="<c:url value='/laminators/liquid' />" class="list-group-item">
                            <spring:message code="head.laminator.liquid"/></a>
                            
                            <a href="<c:url value='/laminators/flatbed_laminating_machine' />" class="list-group-item">
                            <spring:message code="head.laminator.flatbed_laminating_machine"/></a>
                  </div>
                </div>

              <div class="col-md-9 col-lg-9">
                <div class="row">
                  <div class="sider_container">
                     <div class="next_button_laminator"><i class="fa fa-angle-right"></i></div>
                     <div class="pause_button_laminator" style="display: none;"><i class="fa fa-pause" aria-hidden="true"></i></div>
			         <div class="play_button_laminator"><i class="fa fa-play" aria-hidden="true"></i></div>
                     <div class="prev_button_laminator"><i class="fa fa-angle-left"></i></div>
                     <div class="carousel_laminator">
                         <c:forEach items="${laminators}" var="product">
                              <div class="slide-item">
                                  <a class="slider_image" href="<c:url value='/laminator/${product.id}' />">
                                  	<div class="outer_a_img"><img src="/images/laminators/${product.id}/${product.pathPictures.get(0)}" alt="" /></div>
                                  </a>
                                  
                                  <div class="name_price_cart_block">
                                               
                                      <a href="<c:url value='/laminator/${product.id}' />" class="slide-title">${product.name}</a>         
                                                                    
	                                  <div class="product_price"><span style="float: left;">Цена:&nbsp;</span> 
										<input type="hidden" name="price_value" value="${product.prise}">
							       		<c:if test="${product.prise < 0.1}"><a href="#callback" class="fancybox">уточняйте</a></c:if>
										<c:if test="${!(product.prise < 0.1)}">					
						   					<div></div>
										</c:if>
					           		 </div>
					           		 
					           		 <i class="fa fa-cart-plus add_to_cart" aria-hidden="true" 
					           		 	style="padding-right: 5px; top: 3px; right: 5px; position: absolute; font-size: 40px;"
									onclick="addToCart('laminator', ${product.id}, '${product.name}', '${product.prise}','${product.pathPictures.get(0)}');"></i>
					
								</div>

                              </div>
                          </c:forEach>


                     </div>
                  </div>
                </div>
              </div>

            </div>
</div>
</c:if>




<c:if test="${fn:length(lasers) > 0}">
<div class="advertising">
		<div class="col-md-4">
			<div class="row">
				<a href="${homeJSON.list_laser_top1.href}">
                			<img src="/images/home/three_big_pictures/laser_top/1/${homeJSON.list_laser_top1.fileNameArray.get(0)}" alt="" ></a>
			</div>
		</div>
		<div class="col-md-4">
			<div class="row">
				<a href="${homeJSON.list_laser_top2.href}">
                			<img src="/images/home/three_big_pictures/laser_top/2/${homeJSON.list_laser_top2.fileNameArray.get(0)}" alt="" ></a>
			</div>
		</div>
		<div class="col-md-4">
			<div class="row">
				<a href="${homeJSON.list_laser_top3.href}">
                			<img src="/images/home/three_big_pictures/laser_top/3/${homeJSON.list_laser_top3.fileNameArray.get(0)}" alt="" ></a>
			</div>
		</div>

</div>


            <div class="categories_of_goods">
<div class="row">

                <div class="col-md-3" style="padding: 0px;">
                  <div class="list-group">

                     <a href="<c:url value='/lasers' />" class="list-group-item active"><spring:message code="head.laser"/></a>

                            <a href="<c:url value='/lasers/CO2_gas_lasers' />" class="list-group-item">
                            <spring:message code="head.laser.CO2_gas_lasers"/></a>

                            <a href="<c:url value='/lasers/solid_state_lasers' />" class="list-group-item">
                            <spring:message code="head.laser.solid_state_lasers"/></a>

                            <a href="<c:url value='/lasers/for_the_treatment_of_metal' />" class="list-group-item">
                            <spring:message code="head.laser.for_the_treatment_of_metal"/></a>

                            <a href="<c:url value='/lasers/diode_pumped' />" class="list-group-item">
                            <spring:message code="head.laser.diode_pumped"/></a>
                            
                            <a href="<c:url value='/lasers/fiber_lasers' />" class="list-group-item">
                            <spring:message code="head.laser.fiber_lasers"/></a>
                            
                            <a href="<c:url value='/lasers/plasma_lasers' />" class="list-group-item">
                            <spring:message code="head.laser.plasma_lasers"/></a>
                  </div>
                </div>

              <div class="col-md-9 col-lg-9">
                <div class="row">
                  <div class="sider_container">
                     <div class="next_button_laser"><i class="fa fa-angle-right"></i></div>
                     <div class="pause_button_laser" style="display: none;"><i class="fa fa-pause" aria-hidden="true"></i></div>
			         <div class="play_button_laser"><i class="fa fa-play" aria-hidden="true"></i></div>
                     <div class="prev_button_laser"><i class="fa fa-angle-left"></i></div>
                     <div class="carousel_laser">
                        <c:forEach items="${lasers}" var="product">
                              <div class="slide-item">
                                  <a class="slider_image" href="<c:url value='/laser/${product.id}' />">
                                  	<div class="outer_a_img"><img src="/images/lasers/${product.id}/${product.pathPictures.get(0)}" alt="" /></div>
                                  </a>
                                  
                                  <div class="name_price_cart_block">
                                               
                                      <a href="<c:url value='/laser/${product.id}' />" class="slide-title">${product.name}</a>         
                                                                    
	                                  <div class="product_price"><span style="float: left;">Цена:&nbsp;</span> 
										<input type="hidden" name="price_value" value="${product.prise}">
							       		<c:if test="${product.prise < 0.1}"><a href="#callback" class="fancybox">уточняйте</a></c:if>
										<c:if test="${!(product.prise < 0.1)}">					
						   					<div></div>
										</c:if>
					           		 </div>
					           		 
					           		 <i class="fa fa-cart-plus add_to_cart" aria-hidden="true" 
					           		 	style="padding-right: 5px; top: 3px; right: 5px; position: absolute; font-size: 40px;"
									onclick="addToCart('laser', ${product.id}, '${product.name}', '${product.prise}','${product.pathPictures.get(0)}');"></i>
					
								</div>
								
                              </div>
                          </c:forEach>

                     </div>
                  </div>
                </div>
              </div>
              
            </div>
</div>
</c:if>


<c:if test="${fn:length(cutters) > 0}">
<div class="advertising_second_variant">

		<div class="col-md-6">
			<div class="row">
			<a href="${homeJSON.list_cutter_top1.href}">
                	<img src="/images/home/two_narrow_pictures/cutter_top/1/${homeJSON.list_cutter_top1.fileNameArray.get(0)}" alt="" ></a>
			</div>
		</div>

		<div class="col-md-6">
			<div class="row">
			<a href="${homeJSON.list_cutter_top2.href}">
                	<img src="/images/home/two_narrow_pictures/cutter_top/2/${homeJSON.list_cutter_top2.fileNameArray.get(0)}" alt="" ></a>
			</div>
		</div>

            </div>

            <div class="categories_of_goods">
<div class="row">

                <div class="col-md-3" style="padding: 0px;">
                  <div class="list-group">

                     <a href="<c:url value='/cutters' />" class="list-group-item active">
                     <spring:message code="head.cutter"/></a>

                            <a href="<c:url value='/cutters/for_wood' />" class="list-group-item">
                            <spring:message code="head.cutter.for_wood"/></a>

                            <a href="<c:url value='/cutters/for_the_treatment_of_metal' />" class="list-group-item">
                            <spring:message code="head.cutter.for_the_treatment_of_metal"/></a>

                            <a href="<c:url value='/cutters/stone_processing' />" class="list-group-item">
                            <spring:message code="head.cutter.stone_processing"/></a>
                  </div>
                </div>

              <div class="col-md-9 col-lg-9">
                <div class="row">
                  <div class="sider_container">
                     <div class="next_button_cutter"><i class="fa fa-angle-right"></i></div>
                     <div class="pause_button_cutter" style="display: none;"><i class="fa fa-pause" aria-hidden="true"></i></div>
			         <div class="play_button_cutter"><i class="fa fa-play" aria-hidden="true"></i></div>
                     <div class="prev_button_cutter"><i class="fa fa-angle-left"></i></div>
                     <div class="carousel_cutter">
                        <c:forEach items="${cutters}" var="product">
                              <div class="slide-item">
                                  <a class="slider_image" href="<c:url value='/cutter/${product.id}' />">
                                  	<div class="outer_a_img"><img src="/images/cutters/${product.id}/${product.pathPictures.get(0)}" alt="" /></div>
                                  </a>
                                  
                                  <div class="name_price_cart_block">
                                               
                                      <a href="<c:url value='/cutter/${product.id}' />" class="slide-title">${product.name}</a>         
                                                                    
	                                  <div class="product_price"><span style="float: left;">Цена:&nbsp;</span> 
										<input type="hidden" name="price_value" value="${product.prise}">
							       		<c:if test="${product.prise < 0.1}"><a href="#callback" class="fancybox">уточняйте</a></c:if>
										<c:if test="${!(product.prise < 0.1)}">					
						   					<div></div>
										</c:if>
					           		 </div>
					           		 
					           		 <i class="fa fa-cart-plus add_to_cart" aria-hidden="true" 
					           		 	style="padding-right: 5px; top: 3px; right: 5px; position: absolute; font-size: 40px;"
									onclick="addToCart('cutter', ${product.id}, '${product.name}', '${product.prise}','${product.pathPictures.get(0)}');"></i>
					
								</div>
                            
                              </div>
                          </c:forEach>


                     </div>
                  </div>
                </div>
              </div>

            </div>
</div>
</c:if>




<c:if test="${fn:length(scanners) > 0}">
<div class="advertising">
		<div class="col-md-4">
			<div class="row">
				<a href="${homeJSON.list_scaner_top1.href}">
                			<img src="/images/home/three_big_pictures/scaner_top/1/${homeJSON.list_scaner_top1.fileNameArray.get(0)}" alt="" ></a>
			</div>
		</div>
		<div class="col-md-4">
			<div class="row">
				<a href="${homeJSON.list_scaner_top2.href}">
                			<img src="/images/home/three_big_pictures/scaner_top/2/${homeJSON.list_scaner_top2.fileNameArray.get(0)}" alt="" ></a>
			</div>
		</div>
		<div class="col-md-4">
			<div class="row">
				<a href="${homeJSON.list_scaner_top3.href}">
                			<img src="/images/home/three_big_pictures/scaner_top/3/${homeJSON.list_scaner_top3.fileNameArray.get(0)}" alt="" ></a>
			</div>
		</div>

            </div>

            <div class="categories_of_goods">
<div class="row">

                <div class="col-md-3" style="padding: 0px;">
                  <div class="list-group">

                     <a href="<c:url value='/scanners' />" class="list-group-item active"><spring:message code="head.scanner"/></a>

                            <a href="<c:url value='/scanners/large_format_scanners' />" class="list-group-item">
                            <spring:message code="head.scanner.large_format_scanners"/></a>
                            
                            <a href="<c:url value='/scanners/3d_scanners' />" class="list-group-item">
                            <spring:message code="head.scanner.3d_scanners"/></a>

                  </div>
                </div>

              <div class="col-md-9 col-lg-9">
                <div class="row">
                  <div class="sider_container">
                     <div class="next_button_scaner"><i class="fa fa-angle-right"></i></div>
                     <div class="pause_button_scaner" style="display: none;"><i class="fa fa-pause" aria-hidden="true"></i></div>
			         <div class="play_button_scaner"><i class="fa fa-play" aria-hidden="true"></i></div>
                     <div class="prev_button_scaner"><i class="fa fa-angle-left"></i></div>
                     <div class="carousel_scaner">
                        <c:forEach items="${scanners}" var="product">
                              <div class="slide-item">
                                  <a class="slider_image" href="<c:url value='/scanner/${product.id}' />">
                                  	<div class="outer_a_img"><img src="/images/scanners/${product.id}/${product.pathPictures.get(0)}" alt="" /></div>
                                  </a>
                                  
                                  <div class="name_price_cart_block">
                                               
                                      <a href="<c:url value='/scanner/${product.id}' />" class="slide-title">${product.name}</a>         
                                                                    
	                                  <div class="product_price"><span style="float: left;">Цена:&nbsp;</span> 
										<input type="hidden" name="price_value" value="${product.prise}">
							       		<c:if test="${product.prise < 0.1}"><a href="#callback" class="fancybox">уточняйте</a></c:if>
										<c:if test="${!(product.prise < 0.1)}">					
						   					<div></div>
										</c:if>
					           		 </div>
					           		 
					           		 <i class="fa fa-cart-plus add_to_cart" aria-hidden="true" 
					           		 	style="padding-right: 5px; top: 3px; right: 5px; position: absolute; font-size: 40px;"
									onclick="addToCart('scanner', ${product.id}, '${product.name}', '${product.prise}','${product.pathPictures.get(0)}');"></i>
					
								</div>

                              </div>
                          </c:forEach>

                     </div>
                  </div>
                </div>
              </div>

            </div>
</div>
</c:if>




<c:if test="${fn:length(pue) > 0}">
<div class="advertising_second_variant">

		<div class="col-md-6">
			<div class="row">
			<a href="${homeJSON.list_previously_used_top1.href}">
      <img src="/images/home/two_narrow_pictures/previously_used_top/1/${homeJSON.list_previously_used_top1.fileNameArray.get(0)}" alt="" ></a>
			</div>
		</div>

		<div class="col-md-6">
			<div class="row">
			<a href="${homeJSON.list_previously_used_top2.href}">
      <img src="/images/home/two_narrow_pictures/previously_used_top/2/${homeJSON.list_previously_used_top2.fileNameArray.get(0)}" alt="" ></a>
			</div>
		</div>

            </div>


            <div class="categories_of_goods">
<div class="row">

                <div class="col-md-3" style="padding: 0px;">
                  <div class="list-group">

                     <a href="<c:url value='/previous_use_equipments' />" class="list-group-item active"><spring:message code="head.previouslyUsed"/></a>

                        <!--     <a href="#" class="list-group-item"><spring:message code="head.previouslyUsed.solvent_equipment"/></a>

                            <a href="#" class="list-group-item"><spring:message code="head.previouslyUsed.ecosolvent_oborudovnie"/></a> --> 

                  </div>
                </div>

              <div class="col-md-9 col-lg-9">
                <div class="row">
                  <div class="sider_container">
                     <div class="next_button_previously_used"><i class="fa fa-angle-right"></i></div>
                     <div class="pause_button_previously_used" style="display: none;"><i class="fa fa-pause" aria-hidden="true"></i></div>
			         <div class="play_button_previously_used"><i class="fa fa-play" aria-hidden="true"></i></div>
                     <div class="prev_button_previously_used"><i class="fa fa-angle-left"></i></div>
                     <div class="carousel_previously_used">
                        <c:forEach items="${pue}" var="product">
                              <div class="slide-item">
                                  <a class="slider_image" href="<c:url value='/${product.type}/${product.id}' />">
                                  	<div class="outer_a_img"><img src="/images/${product.type}s/${product.id}/${product.pathPictures.get(0)}" alt="" /></div>
                                  </a>
                                  
                                  <div class="name_price_cart_block">
                                               
                                      <a href="<c:url value='/${product.type}/${product.id}' />" class="slide-title">${product.name}</a>         
                                                                    
	                                  <div class="product_price"><span style="float: left;">Цена:&nbsp;</span> 
										<input type="hidden" name="price_value" value="${product.prise}">
							       		<c:if test="${product.prise < 0.1}"><a href="#callback" class="fancybox">уточняйте</a></c:if>
										<c:if test="${!(product.prise < 0.1)}">					
						   					<div></div>
										</c:if>
					           		 </div>
					           		 
					           		 <i class="fa fa-cart-plus add_to_cart" aria-hidden="true" 
					           		 	style="padding-right: 5px; top: 3px; right: 5px; position: absolute; font-size: 40px;"
									onclick="addToCart(${product.type}, ${product.id}, '${product.name}', '${product.prise}','${product.pathPictures.get(0)}');"></i>
					
								</div>
                                  
                              </div>
                          </c:forEach>

                     </div>
                  </div>
                </div>
              </div>

            </div>
</div>
</c:if>




<c:if test="${fn:length(rips) > 0}">
<div class="advertising">
		<div class="col-md-4">
			<div class="row">
				<a href="${homeJSON.list_rip_top1.href}">
                			<img src="/images/home/three_big_pictures/rip_top/1/${homeJSON.list_rip_top1.fileNameArray.get(0)}" alt="" ></a>
			</div>
		</div>
		<div class="col-md-4">
			<div class="row">
				<a href="${homeJSON.list_rip_top2.href}">
                			<img src="/images/home/three_big_pictures/rip_top/2/${homeJSON.list_rip_top2.fileNameArray.get(0)}" alt="" ></a>
			</div>
		</div>
		<div class="col-md-4">
			<div class="row">
				<a href="${homeJSON.list_rip_top3.href}">
                			<img src="/images/home/three_big_pictures/rip_top/3/${homeJSON.list_rip_top3.fileNameArray.get(0)}" alt="" ></a>
			</div>
		</div>

            </div>



            <div class="categories_of_goods">
<div class="row">

                <div class="col-md-3" style="padding: 0px;">
                  <div class="list-group">

                     <a href="<c:url value='/rips' />" class="list-group-item active"><spring:message code="head.rip"/></a>

                  </div>
                </div>

              <div class="col-md-9 col-lg-9">
                <div class="row">
                  <div class="sider_container">
                     <div class="next_button_rip"><i class="fa fa-angle-right"></i></div>
                     <div class="pause_button_rip" style="display: none;"><i class="fa fa-pause" aria-hidden="true"></i></div>
			         <div class="play_button_rip"><i class="fa fa-play" aria-hidden="true"></i></div>
                     <div class="prev_button_rip"><i class="fa fa-angle-left"></i></div>
                     <div class="carousel_rip">
                        <c:forEach items="${rips}" var="product">
                              <div class="slide-item">
                                  <a class="slider_image" href="<c:url value='/rip/${product.id}' />">
                                  	<div class="outer_a_img"><img src="/images/rips/${product.id}/${product.pathPictures.get(0)}" alt="" /></div>
                                  </a>
                                  
                                  <div class="name_price_cart_block">
                                               
                                      <a href="<c:url value='/rip/${product.id}' />" class="slide-title">${product.name}</a>         
                                                                    
	                                  <div class="product_price"><span style="float: left;">Цена:&nbsp;</span> 
										<input type="hidden" name="price_value" value="${product.prise}">
							       		<c:if test="${product.prise < 0.1}"><a href="#callback" class="fancybox">уточняйте</a></c:if>
										<c:if test="${!(product.prise < 0.1)}">					
						   					<div></div>
										</c:if>
					           		 </div>
					           		 
					           		 <i class="fa fa-cart-plus add_to_cart" aria-hidden="true" 
					           		 	style="padding-right: 5px; top: 3px; right: 5px; position: absolute; font-size: 40px;"
									onclick="addToCart('rip', ${product.id}, '${product.name}', '${product.prise}','${product.pathPictures.get(0)}');"></i>
					
								</div>

                              </div>
                          </c:forEach>


                     </div>
                  </div>
                </div>
              </div>

            </div>
</div>
</c:if>

    </div>
</body>
</html>
