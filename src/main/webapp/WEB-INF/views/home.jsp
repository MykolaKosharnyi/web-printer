<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			         <div class="prev_button"><i class="fa fa-angle-left"></i></div>
			         <div class="carousel">
				          <c:forEach items="${homeJSON.listPicturesOfCentralReklam}" var="picture">
                    <div class="slide_item"><a class="fancybox" data-fancybox-group="group" href="/images/home/big_reklam/${picture}"><img src="/images/home/big_reklam/${picture}" alt="alt" /></a></div>

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

              <div class="col-md-9 col-lg-9">
                <div class="row">
                  <div class="sider_container">
                     <div class="next_button_printer"><i class="fa fa-angle-right"></i></div>
                     <div class="prev_button_printer"><i class="fa fa-angle-left"></i></div>
                     <div class="carousel_printer">
                        <c:forEach items="${printers}" var="printer">
                              <div class="slide-item1">
                                  <a class="slider_image" href="<c:url value='/printer/${printer.id}' />"><div class="outer_a_img"><img src="/images/printers/${printer.id}/${printer.pathPictures.get(0)}" alt="" /></div></a>
                                  <a class="slide-buy1" href="javascript:void(0)" onclick="addToCart('printer', ${printer.id});">
                                    <img src="/images/button_buy.png" alt="" />
                                  </a>
                                  <a href="<c:url value='/printer/${printer.id}' />" class="slide-title1">${printer.name}</a>
                                  <div class="slide-price1">Цена: 
                                    <c:if test="${printer.prise < 0.1}"> уточняйте</c:if>
                    <c:if test="${!(printer.prise < 0.1)}">         
                        $<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${printer.prise}" />
                    </c:if>
                                  </div>
                              </div>
                            </c:forEach>
                     </div>
                  </div>
                </div>
              </div>

            </div>
</div>




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
                            <a href="<c:url value='/3d_printers/FDM-extruder' />" class="list-group-item"><spring:message code="head.3dprinter.FDM-extruder"/></a>

                            <a href="<c:url value='/3d_printers/photo_printing_polyjet' />" class="list-group-item"><spring:message code="head.3dprinter.photo_printing_polyjet"/></a>

                            <a href="<c:url value='/3d_printers/laser_sintering_LENS' />" class="list-group-item"><spring:message code="head.3dprinter.laser_sintering_LENS"/></a>

                            <a href="<c:url value='/3d_printers/lamination_LOM' />" class="list-group-item"><spring:message code="head.3dprinter.lamination_LOM"/></a>

                            <a href="<c:url value='/3d_printers/stereolithography_SL' />" class="list-group-item"><spring:message code="head.3dprinter.stereolithography_SL"/></a>

                            <a href="<c:url value='/3d_printers/laser_sintering_LS' />" class="list-group-item"><spring:message code="head.3dprinter.laser_sintering_LS"/></a>
                            
                            <a href="<c:url value='/3d_printers/powder_bonding_3DP' />" class="list-group-item"><spring:message code="head.3dprinter.powder_bonding_3DP"/></a>
                  </div>
                </div>

              <div class="col-md-9 col-lg-9">
                <div class="row">
                  <div class="sider_container">
                     <div class="next_button_printer_3d"><i class="fa fa-angle-right"></i></div>
                     <div class="prev_button_printer_3d"><i class="fa fa-angle-left"></i></div>
                     <div class="carousel_printer_3d">
                        <c:forEach items="${printers3D}" var="printer3D">
                              <div class="slide-item2">
                                  <a class="slider_image" href="<c:url value='/3d_printer/${printer3D.id}' />">
                                  <div class="outer_a_img"><img src="/images/3d_printers/${printer3D.id}/${printer3D.pathPictures.get(0)}" alt="" /></div></a>
                                  <a class="slide-buy2" href="javascript:void(0)" onclick="addToCart('3d_printer', ${printer3D.id});">
                                    <img src="/images/button_buy.png" alt="" />
                                  </a>
                                  <a href="<c:url value='/3d_printer/${printer3D.id}' />" class="slide-title2">${printer3D.name}</a>
                                  <div class="slide-price2">Цена:
                                    <c:if test="${printer3D.prise < 0.1}"> уточняйте</c:if>
                    <c:if test="${!(printer3D.prise < 0.1)}">         
                        $<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${printer3D.prise}" />
                    </c:if>
                        </div>
                              </div>
                          </c:forEach>
                     </div>
                  </div>
                </div>
              </div>

            </div>
</div>




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

                            <a href="<c:url value='/digital_printers/full_color_laser_printers' />" class="list-group-item"><spring:message code="head.digital_printer.full_color_laser_printers"/></a>


                            <a href="<c:url value='/digital_printers/monochrome_laser_printers' />" class="list-group-item"><spring:message code="head.digital_printer.monochrome_laser_printers"/></a>

                            <a href="<c:url value='/digital_printers/full-color_inkjet_printers' />" class="list-group-item"><spring:message code="head.digital_printer.full_color_inkjet_printers"/></a>
                  </div>
                </div>

              <div class="col-md-9 col-lg-9">
                <div class="row">
                  <div class="sider_container">
                     <div class="next_button_printer_d"><i class="fa fa-angle-right"></i></div>
                     <div class="prev_button_printer_d"><i class="fa fa-angle-left"></i></div>
                     <div class="carousel_printer_d">
                        <c:forEach items="${digitalPrinters}" var="printer">
                              <div class="slide-item2">
                                  <a class="slider_image" href="<c:url value='/digital_printer/${printer.id}' />"><div class="outer_a_img"><img src="/images/digital_printers/${printer.id}/${printer.pathPictures.get(0)}" alt="" /></div></a>
                                  <a class="slide-buy2" href="javascript:void(0)" onclick="addToCart('digital_printer', ${printer.id});">
                                    <img src="/images/button_buy.png" alt="" />
                                  </a>
                                  <a href="<c:url value='/digital_printer/${printer.id}' />" class="slide-title2">${printer.name}</a>
                                  <div class="slide-price2">Цена:
                                    <c:if test="${printer.prise < 0.1}"> уточняйте</c:if>
                    <c:if test="${!(printer.prise < 0.1)}">         
                        $<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${printer.prise}" />
                    </c:if>
                        </div>
                              </div>
                          </c:forEach>
                     </div>
                  </div>
                </div>
              </div>

            </div>
</div>



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

                            <a href="<c:url value='/laminators/hot_lamination' />" class="list-group-item"><spring:message code="head.laminator.hot_lamination"/></a>

                            <a href="<c:url value='/laminators/cold_laminating' />" class="list-group-item"><spring:message code="head.laminator.cold_laminating"/></a>

                            <a href="<c:url value='/laminators/liquid' />" class="list-group-item"><spring:message code="head.laminator.liquid"/></a>
                            
                            <a href="<c:url value='/laminators/flatbed_laminating_machine' />" class="list-group-item"><spring:message code="head.laminator.flatbed_laminating_machine"/></a>
                  </div>
                </div>

              <div class="col-md-9 col-lg-9">
                <div class="row">
                  <div class="sider_container">
                     <div class="next_button_laminator"><i class="fa fa-angle-right"></i></div>
                     <div class="prev_button_laminator"><i class="fa fa-angle-left"></i></div>
                     <div class="carousel_laminator">
                         <c:forEach items="${laminators}" var="product">
                              <div class="slide-item2">
                                  <a class="slider_image" href="<c:url value='/laminator/${product.id}' />"><div class="outer_a_img"><img src="/images/laminators/${product.id}/${product.pathPictures.get(0)}" alt="" /></div></a>
                                  <a class="slide-buy2" href="javascript:void(0)" onclick="addToCart('laminator', ${product.id});">
                                    <img src="/images/button_buy.png" alt="" />
                                  </a>
                                  <a href="<c:url value='/laminator/${product.id}' />" class="slide-title2">${product.name}</a>
                                  <div class="slide-price2">Цена:
                                    <c:if test="${product.prise < 0.1}"> уточняйте</c:if>
                    				<c:if test="${!(product.prise < 0.1)}">         
                        				$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" />
                    				</c:if>
                        		</div>
                              </div>
                          </c:forEach>


                     </div>
                  </div>
                </div>
              </div>

            </div>
</div>






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

                            <a href="<c:url value='/lasers/CO2_gas_lasers' />" class="list-group-item"><spring:message code="head.laser.CO2_gas_lasers"/></a>

                            <a href="<c:url value='/lasers/solid_state_lasers' />" class="list-group-item"><spring:message code="head.laser.solid_state_lasers"/></a>

                            <a href="<c:url value='/lasers/for_the_treatment_of_metal' />" class="list-group-item"><spring:message code="head.laser.for_the_treatment_of_metal"/></a>

                            <a href="<c:url value='/lasers/diode_pumped' />" class="list-group-item"><spring:message code="head.laser.diode_pumped"/></a>
                            
                            <a href="<c:url value='/lasers/fiber_lasers' />" class="list-group-item"><spring:message code="head.laser.fiber_lasers"/></a>
                            
                            <a href="<c:url value='/lasers/plasma_lasers' />" class="list-group-item"><spring:message code="head.laser.plasma_lasers"/></a>
                  </div>
                </div>

              <div class="col-md-9 col-lg-9">
                <div class="row">
                  <div class="sider_container">
                     <div class="next_button_laser"><i class="fa fa-angle-right"></i></div>
                     <div class="prev_button_laser"><i class="fa fa-angle-left"></i></div>
                     <div class="carousel_laser">
                        <c:forEach items="${lasers}" var="laser">
                              <div class="slide-item2">
                                  <a class="slider_image" href="<c:url value='/laser/${laser.id}' />"><div class="outer_a_img"><img src="/images/lasers/${laser.id}/${laser.pathPictures.get(0)}" alt="" /></div></a>
                                  <a class="slide-buy2" href="javascript:void(0)" onclick="addToCart('laser', ${laser.id});">
                                    <img src="/images/button_buy.png" alt="" />
                                  </a>
                                  <a href="<c:url value='/laser/${laser.id}' />" class="slide-title2">${laser.name}</a>
                                  <div class="slide-price2">Цена:
                                    <c:if test="${laser.prise < 0.1}"> уточняйте</c:if>
                    <c:if test="${!(laser.prise < 0.1)}">         
                        $<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${laser.prise}" />
                    </c:if>
                        </div>
                              </div>
                          </c:forEach>

                     </div>
                  </div>
                </div>
              </div>
              
            </div>
</div>




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

                     <a href="<c:url value='/cutters' />" class="list-group-item active"><spring:message code="head.cutter"/></a>

                            <a href="<c:url value='/cutters/for_wood' />" class="list-group-item"><spring:message code="head.cutter.for_wood"/></a>

                            <a href="<c:url value='/cutters/for_the_treatment_of_metal' />" class="list-group-item"><spring:message code="head.cutter.for_the_treatment_of_metal"/></a>

                            <a href="<c:url value='/cutters/stone_processing' />" class="list-group-item"><spring:message code="head.cutter.stone_processing"/></a>
                  </div>
                </div>

              <div class="col-md-9 col-lg-9">
                <div class="row">
                  <div class="sider_container">
                     <div class="next_button_cutter"><i class="fa fa-angle-right"></i></div>
                     <div class="prev_button_cutter"><i class="fa fa-angle-left"></i></div>
                     <div class="carousel_cutter">
                        <c:forEach items="${cutters}" var="cutter">
                              <div class="slide-item2">
                                  <a class="slider_image" href="<c:url value='/cutter/${cutter.id}' />"><div class="outer_a_img"><img src="/images/cutters/${cutter.id}/${cutter.pathPictures.get(0)}" alt="" /></div></a>
                                  <a class="slide-buy2" href="javascript:void(0)" onclick="addToCart('cutter', ${cutter.id});">
                                    <img src="/images/button_buy.png" alt="" />
                                  </a>
                                  <a href="<c:url value='/cutter/${cutter.id}' />" class="slide-title2">${cutter.name}</a>
                                  <div class="slide-price2">Цена:
                                    <c:if test="${cutter.prise < 0.1}"> уточняйте</c:if>
                    <c:if test="${!(cutter.prise < 0.1)}">         
                        $<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cutter.prise}" />
                    </c:if>
                        </div>
                              </div>
                          </c:forEach>


                     </div>
                  </div>
                </div>
              </div>

            </div>
</div>






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
                     <div class="prev_button_scaner"><i class="fa fa-angle-left"></i></div>
                     <div class="carousel_scaner">
                        <c:forEach items="${scanners}" var="scanner">
                              <div class="slide-item2">
                                  <a class="slider_image" href="<c:url value='/scanner/${cutter.id}' />"><div class="outer_a_img"><img src="/images/scanners/${scanner.id}/${scanner.pathPictures.get(0)}" alt="" /></div></a>
                                  <a class="slide-buy2" href="javascript:void(0)" onclick="addToCart('scanner', ${scanner.id});">
                                    <img src="/images/button_buy.png" alt="" />
                                  </a>
                                  <a href="<c:url value='/scanner/${scanner.id}' />" class="slide-title2">${scanner.name}</a>
                                  <div class="slide-price2">Цена:
                                    <c:if test="${scanner.prise < 0.1}"> уточняйте</c:if>
					                <c:if test="${!(scanner.prise < 0.1)}">         
					                	$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${scanner.prise}" />
					                </c:if>
                        		</div>
                              </div>
                          </c:forEach>

                     </div>
                  </div>
                </div>
              </div>

            </div>
</div>




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
                     <div class="prev_button_previously_used"><i class="fa fa-angle-left"></i></div>
                     <div class="carousel_previously_used">
                        <c:forEach items="${pue}" var="product">
                              <div class="slide-item2">
                                  <a class="slider_image" href="<c:url value='/${product.type}/${product.id}' />"><div class="outer_a_img"><img src="/images/${product.type}s/${product.id}/${product.pathPictures.get(0)}" alt="" /></div></a>
                                  <a class="slide-buy2" href="javascript:void(0)" onclick="addToCart(${product.type}, ${product.id});">
                                    <img src="/images/button_buy.png" alt="" />
                                  </a>
                                  <a href="<c:url value='/${product.type}/${product.id}' />" class="slide-title2">${product.name}</a>
                                  <div class="slide-price2">Цена:
                                    <c:if test="${product.prise < 0.1}"> уточняйте</c:if>
					                <c:if test="${!(product.prise < 0.1)}">         
					                	$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" />
					                </c:if>
                        		</div>
                              </div>
                          </c:forEach>

                     </div>
                  </div>
                </div>
              </div>

            </div>
</div>






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

                          <!--  <a href="#" class="list-group-item"><spring:message code="head.rip.RIP_system"/></a> --> 

                  </div>
                </div>

              <div class="col-md-9 col-lg-9">
                <div class="row">
                  <div class="sider_container">
                     <div class="next_button_rip"><i class="fa fa-angle-right"></i></div>
                     <div class="prev_button_rip"><i class="fa fa-angle-left"></i></div>
                     <div class="carousel_rip">
                        


                     </div>
                  </div>
                </div>
              </div>

            </div>
</div>

    </div>
</body>
</html>
