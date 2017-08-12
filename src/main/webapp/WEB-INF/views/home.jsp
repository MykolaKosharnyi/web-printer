<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
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
                      <custom:getDescriptionByLocale description="${descriptions.printers}"/>
                    </a>
                    <a href="<c:url value='/printers/dissolving' />" class="list-group-item">
                    	<custom:getDescriptionByLocale description="${descriptions.printer_dissolving}"/></a>

                            <a href="<c:url value='/printers/ecosolvent' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.printer_ecosolvent}"/></a>

                            <a href="<c:url value='/printers/UV_roll' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.printer_uv_roll}"/></a>

                            <a href="<c:url value='/printers/UV_flatbed' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.printer_flatbed}"/></a>

                            <a href="<c:url value='/printers/sublimation' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.printer_sublimation}"/></a>

                            <a href="<c:url value='/printers/textile' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.printer_textile}"/></a>
                            
                            <a href="<c:url value='/printers/water_pigment' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.printer_water_pigment}"/></a>
                            
                            <a href="<c:url value='/printers/SAPR-GIS' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.printer_SAPR_GIS}"/></a>
                  </div>
                </div>			
                       
		         <jsp:include page="home_section_of_product.jsp">
					 <jsp:param name="type" value="printer"/>
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
                      <custom:getDescriptionByLocale description="${descriptions.printers_3d}"/>
                    </a>
                            <a href="<c:url value='/3d_printers/FDM-extruder' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.printers_3d_FDM_extruder}"/></a>

                            <a href="<c:url value='/3d_printers/photo_printing_polyjet' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.printers_3d_photo_printing_polyjet}"/></a>

                            <a href="<c:url value='/3d_printers/laser_sintering_LENS' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.printers_3d_laser_sintering_LENS}"/></a>

                            <a href="<c:url value='/3d_printers/lamination_LOM' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.printers_3d_lamination_LOM}"/></a>

                            <a href="<c:url value='/3d_printers/stereolithography_SL' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.printers_3d_stereolithography_SL}"/></a>

                            <a href="<c:url value='/3d_printers/laser_sintering_LS' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.printers_3d_laser_sintering_LS}"/></a>
                            
                            <a href="<c:url value='/3d_printers/powder_bonding_3DP' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.printers_3d_powder_bonding_3DP}"/></a>
                  </div>
                </div>

		         <jsp:include page="home_section_of_product.jsp">
					 <jsp:param name="type" value="3d_printer"/>
				</jsp:include>  

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

                     <a href="<c:url value='/digital_printers' />" class="list-group-item active">
                     <custom:getDescriptionByLocale description="${descriptions.digital_printers}"/></a>

                            <a href="<c:url value='/digital_printers/full_color_laser_printers' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.digital_printers_full_color_laser_printers}"/></a>

                            <a href="<c:url value='/digital_printers/monochrome_laser_printers' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.digital_printers_monochrome_laser_printers}"/></a>

                            <a href="<c:url value='/digital_printers/full-color_inkjet_printers' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.digital_printers_full_color_inkjet_printers}"/></a>
                  </div>
                </div>

				<jsp:include page="home_section_of_product.jsp">
					 <jsp:param name="type" value="digital_printer"/>
				</jsp:include> 

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

                     <a href="<c:url value='/laminators' />" class="list-group-item active">
                     <custom:getDescriptionByLocale description="${descriptions.laminators}"/></a>

                            <a href="<c:url value='/laminators/hot_lamination' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.laminators_hot_lamination}"/></a>

                            <a href="<c:url value='/laminators/cold_laminating' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.laminators_cold_laminating}"/></a>

                            <a href="<c:url value='/laminators/liquid' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.laminators_liquid}"/></a>
                            
                            <a href="<c:url value='/laminators/flatbed_laminating_machine' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.laminators_flatbed_laminating_machine}"/></a>
                  </div>
                </div>

              	<jsp:include page="home_section_of_product.jsp">
					 <jsp:param name="type" value="laminator"/>
				</jsp:include> 

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

                     <a href="<c:url value='/lasers' />" class="list-group-item active">
                     <custom:getDescriptionByLocale description="${descriptions.lasers}"/></a>

                            <a href="<c:url value='/lasers/CO2_gas_lasers' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.lasers_CO2_gas_lasers}"/></a>

                            <a href="<c:url value='/lasers/solid_state_lasers' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.lasers_solid_state_lasers}"/></a>

                            <a href="<c:url value='/lasers/for_the_treatment_of_metal' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.lasers_for_the_treatment_of_metal}"/></a>

                            <a href="<c:url value='/lasers/diode_pumped' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.lasers_diode_pumped}"/></a>
                            
                            <a href="<c:url value='/lasers/fiber_lasers' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.lasers_fiber_lasers}"/></a>
                            
                            <a href="<c:url value='/lasers/plasma_lasers' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.lasers_plasma_lasers}"/></a>
                  </div>
                </div>

              <jsp:include page="home_section_of_product.jsp">
				<jsp:param name="type" value="laser"/>
			  </jsp:include> 
              
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
                     <custom:getDescriptionByLocale description="${descriptions.cutters}"/></a>

                            <a href="<c:url value='/cutters/for_wood' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.cutters_for_wood}"/></a>

                            <a href="<c:url value='/cutters/for_the_treatment_of_metal' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.cutters_for_the_treatment_of_metal}"/></a>

                            <a href="<c:url value='/cutters/stone_processing' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.cutters_stone_processing}"/></a>
                  </div>
                </div>

              <jsp:include page="home_section_of_product.jsp">
				<jsp:param name="type" value="cutter"/>
			  </jsp:include>

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

                     <a href="<c:url value='/scanners' />" class="list-group-item active"><custom:getDescriptionByLocale description="${descriptions.scanners}"/></a>

                            <a href="<c:url value='/scanners/large_format_scanners' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.scanners_large_format_scanners}"/></a>
                            
                            <a href="<c:url value='/scanners/3d_scanners' />" class="list-group-item">
                            <custom:getDescriptionByLocale description="${descriptions.scanners_3d_scanners}"/></a>

                  </div>
                </div>

              <jsp:include page="home_section_of_product.jsp">
				<jsp:param name="type" value="scanner"/>
			  </jsp:include>

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

                     <a href="<c:url value='/previous_use_equipments' />" class="list-group-item active">
                     	<custom:getDescriptionByLocale description="${descriptions.previouslyUsed}"/></a>

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
                                               
                                      <a href="<c:url value='/${product.type}/${product.id}' />" class="slide-title">
										<c:choose>   
									         <c:when test = "${localeCode == 'en' && !empty product.engNameProduct}">
									            ${product.engNameProduct}
									         </c:when>
									         
									         <c:otherwise>
									            ${product.name}
									         </c:otherwise>
										</c:choose>
									</a>         
                                                                    
	                                  <div class="product_price"><span style="float: left;"><custom:getDescriptionByLocale description="${descriptions.price}"/></span> 
										<input type="hidden" name="price_value" value="${product.prise}">
							       		<c:if test="${product.prise < 0.1}"><a 
							       		href="javascript:openModalProposalPrise('${product.type}', ${product.id}, '${product.name}', '${product.pathPictures.get(0)}')"><custom:getDescriptionByLocale description="${descriptions.specify}"/></a></c:if>
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

                     <a href="<c:url value='/rips' />" class="list-group-item active"><custom:getDescriptionByLocale description="${descriptions.rips}"/></a>

                  </div>
                </div>

              <jsp:include page="home_section_of_product.jsp">
				<jsp:param name="type" value="rip"/>
			  </jsp:include>

            </div>
</div>
</c:if>

    </div>
</body>
</html>