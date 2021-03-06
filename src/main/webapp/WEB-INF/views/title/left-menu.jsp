<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
            <ul class="menu">
                <li class="menu_list"><a href="<c:url value='/printers' />"><custom:getDescriptionByLocale description="${descriptions.printers}"/></a>
                    <ul class="menu_drop">
                        <li id="list_dissolving"><a href="<c:url value='/printers/dissolving' />"><custom:getDescriptionByLocale description="${descriptions.printer_dissolving}"/></a>
							<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.printersJSON.listDissolvingPrinters}" var="link">
									<li><a href="<c:url value='/printer/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_ecosolvent"><a href="<c:url value='/printers/ecosolvent' />"><custom:getDescriptionByLocale description="${descriptions.printer_ecosolvent}"/></a>
							<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.printersJSON.listEcosolventPrinters}" var="link">
									<li><a href="<c:url value='/printer/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
						</li>
                        <li id="list_UV_roll"><a href="<c:url value='/printers/UV_roll' />"><custom:getDescriptionByLocale description="${descriptions.printer_uv_roll}"/></a>
							<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.printersJSON.listUvRollPrinters}" var="link">
									<li><a href="<c:url value='/printer/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>                        
                        </li>
                        <li id="list_UV_flatbed"><a href="<c:url value='/printers/UV_flatbed' />"><custom:getDescriptionByLocale description="${descriptions.printer_flatbed}"/></a>
							<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.printersJSON.listUvFlatbedPrinters}" var="link">
									<li><a href="<c:url value='/printer/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_sublimation"><a href="<c:url value='/printers/sublimation' />"><custom:getDescriptionByLocale description="${descriptions.printer_sublimation}"/></a>
                             <ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.printersJSON.listSublimationPrinters}" var="link">
									<li><a href="<c:url value='/printer/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_textile"><a href="<c:url value='/printers/textile' />"><custom:getDescriptionByLocale description="${descriptions.printer_textile}"/></a>
                             <ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.printersJSON.listTextilePrinters}" var="link">
									<li><a href="<c:url value='/printer/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_water_pigment"><a href="<c:url value='/printers/water_pigment' />"><custom:getDescriptionByLocale description="${descriptions.printer_water_pigment}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.printersJSON.listWaterPigmentPrinters}" var="link">
									<li><a href="<c:url value='/printer/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_SAPR-GIS_printers"><a href="<c:url value='/printers/SAPR-GIS' />"><custom:getDescriptionByLocale description="${descriptions.printer_SAPR_GIS}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.printersJSON.listSAPRGISPrinters}" var="link">
									<li><a href="<c:url value='/printer/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                    </ul>
                </li>
<!--------------------------------------------------------------------------------------------------------------------------------->               
                <li class="menu_list"><a href="<c:url value='/3d_printers' />"><custom:getDescriptionByLocale description="${descriptions.printers_3d}"/></a>
                    <ul class="menu_drop">
                        <li id="list_3d_printers_FDM-extruder"><a href="<c:url value='/3d_printers/FDM-extruder' />"><custom:getDescriptionByLocale description="${descriptions.printers_3d_FDM_extruder}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.printers3dJSON.list_3dPrintersFDM_Extruder}" var="link">
									<li><a href="<c:url value='/3d_printer/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_3d_printers_photo_printing_polyjet"><a href="<c:url value='/3d_printers/photo_printing_polyjet' />"><custom:getDescriptionByLocale description="${descriptions.printers_3d_photo_printing_polyjet}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.printers3dJSON.list_3d_printers_photo_printing_polyjet}" var="link">
									<li><a href="<c:url value='/3d_printer/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_3d_printers_laser_sintering_LENS"><a href="<c:url value='/3d_printers/laser_sintering_LENS' />"><custom:getDescriptionByLocale description="${descriptions.printers_3d_laser_sintering_LENS}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.printers3dJSON.list_3d_printers_laser_sintering_LENS}" var="link">
									<li><a href="<c:url value='/3d_printer/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_3d_printers_lamination_LOM"><a href="<c:url value='/3d_printers/lamination_LOM' />"><custom:getDescriptionByLocale description="${descriptions.printers_3d_lamination_LOM}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.printers3dJSON.list_3d_printers_lamination_LOM}" var="link">
									<li><a href="<c:url value='/3d_printer/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_3d_printers_stereolithography_SL"><a href="<c:url value='/3d_printers/stereolithography_SL' />"><custom:getDescriptionByLocale description="${descriptions.printers_3d_stereolithography_SL}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.printers3dJSON.list_3d_printers_stereolithography_SL}" var="link">
									<li><a href="<c:url value='/3d_printer/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>                        
                        </li>
                        <li id="list_3d_printers_laser_sintering_LS"><a href="<c:url value='/3d_printers/laser_sintering_LS' />"><custom:getDescriptionByLocale description="${descriptions.printers_3d_laser_sintering_LS}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.printers3dJSON.list_3d_printers_laser_sintering_LS}" var="link">
									<li><a href="<c:url value='/3d_printer/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>                        
                        </li>
                        <li id="list_3d_printers_powder_bonding_3DP"><a href="<c:url value='/3d_printers/powder_bonding_3DP' />"><custom:getDescriptionByLocale description="${descriptions.printers_3d_powder_bonding_3DP}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.printers3dJSON.list_3d_printers_powder_bonding_3DP}" var="link">
									<li><a href="<c:url value='/3d_printer/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>                        
                        </li>
                    </ul>
                </li>
<!--------------------------------------------------------------------------------------------------------------------------------->
                <li class="menu_list"><a href="<c:url value='/digital_printers' />"><custom:getDescriptionByLocale description="${descriptions.digital_printers}"/></a>
                    <ul class="menu_drop">
                        <li id="list_digital_printer_FullColorLaserPrinters"><a href="<c:url value='/digital_printers/full_color_laser_printers' />"><custom:getDescriptionByLocale description="${descriptions.digital_printers_full_color_laser_printers}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.digital_printersJSON.listFullColorLaserPrinters}" var="link">
									<li><a href="<c:url value='/digital_printer/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_digital_printer_MonochromeLaserPrinters"><a href="<c:url value='/digital_printers/monochrome_laser_printers' />"><custom:getDescriptionByLocale description="${descriptions.digital_printers_monochrome_laser_printers}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.digital_printersJSON.listMonochromeLaserPrinters}" var="link">
									<li><a href="<c:url value='/digital_printer/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_digital_printer_FullColorInkjetPrinters"><a href="<c:url value='/digital_printers/full-color_inkjet_printers' />"><custom:getDescriptionByLocale description="${descriptions.digital_printers_full_color_inkjet_printers}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.digital_printersJSON.listFullColorInkjetPrinters}" var="link">
									<li><a href="<c:url value='/digital_printer/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                    </ul>
                </li>
<!--------------------------------------------------------------------------------------------------------------------------------->
                <li class="menu_list"><a href="<c:url value='/laminators' />"><custom:getDescriptionByLocale description="${descriptions.laminators}"/></a>
                    <ul class="menu_drop">
                        <li id="list_laminators_hot_lamination"><a href="<c:url value='/laminators/hot_lamination' />"><custom:getDescriptionByLocale description="${descriptions.laminators_hot_lamination}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.laminatorsJSON.list_hot_lamination}" var="link">
									<li><a href="<c:url value='/laminator/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_laminators_cold_laminating"><a href="<c:url value='/laminators/cold_laminating' />"><custom:getDescriptionByLocale description="${descriptions.laminators_cold_laminating}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.laminatorsJSON.list_cold_laminating}" var="link">
									<li><a href="<c:url value='/laminator/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_laminators_liquid"><a href="<c:url value='/laminators/liquid' />"><custom:getDescriptionByLocale description="${descriptions.laminators_liquid}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.laminatorsJSON.list_liquid}" var="link">
									<li><a href="<c:url value='/laminator/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_laminators_flatbed_laminating_machine"><a href="<c:url value='/laminators/flatbed_laminating_machine' />"><custom:getDescriptionByLocale description="${descriptions.laminators_flatbed_laminating_machine}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.laminatorsJSON.list_flatbed_laminating_machine}" var="link">
									<li><a href="<c:url value='/laminator/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                    </ul>
                </li>
<!---------------------------------------------------------------------------------------------------------------------------------> 
                <li class="menu_list"><a href="<c:url value='/lasers' />"><custom:getDescriptionByLocale description="${descriptions.lasers}"/></a>
                    <ul class="menu_drop">
                        <li id="list_laser_CO2_gas_lasers"><a href="<c:url value='/lasers/CO2_gas_lasers' />"><custom:getDescriptionByLocale description="${descriptions.lasers_CO2_gas_lasers}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.laserJSON.list_CO2_gas_lasers}" var="link">
									<li><a href="<c:url value='/laser/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_laser_solid_state_lasers"><a href="<c:url value='/lasers/solid_state_lasers' />"><custom:getDescriptionByLocale description="${descriptions.lasers_solid_state_lasers}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.laserJSON.list_solid_state_lasers}" var="link">
									<li><a href="<c:url value='/laser/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_laser_for_the_treatment_of_metal"><a href="<c:url value='/lasers/for_the_treatment_of_metal' />"><custom:getDescriptionByLocale description="${descriptions.lasers_for_the_treatment_of_metal}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.laserJSON.list_for_the_treatment_of_metal}" var="link">
									<li><a href="<c:url value='/laser/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_laser_diode_pumped"><a href="<c:url value='/lasers/diode_pumped' />"><custom:getDescriptionByLocale description="${descriptions.lasers_diode_pumped}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.laserJSON.list_diode_pumped}" var="link">
									<li><a href="<c:url value='/laser/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_laser_fiber_lasers"><a href="<c:url value='/lasers/fiber_lasers' />"><custom:getDescriptionByLocale description="${descriptions.lasers_fiber_lasers}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.laserJSON.list_fiber_lasers}" var="link">
									<li><a href="<c:url value='/laser/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_laser_plasma_lasers"><a href="<c:url value='/lasers/plasma_lasers' />"><custom:getDescriptionByLocale description="${descriptions.lasers_plasma_lasers}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.laserJSON.list_plasma_lasers}" var="link">
									<li><a href="<c:url value='/laser/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                    </ul>
                </li>
<!---------------------------------------------------------------------------------------------------------------------------------> 
                <li class="menu_list"><a href="<c:url value='/cutters' />"><custom:getDescriptionByLocale description="${descriptions.cutters}"/></a>
                    <ul class="menu_drop">
                        <li id="list_cutter_for_wood"><a href="<c:url value='/cutters/for_wood' />"><custom:getDescriptionByLocale description="${descriptions.cutters_for_wood}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.cuttersJSON.list_for_wood}" var="link">
									<li><a href="<c:url value='/cutter/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_cutter_for_the_treatment_of_metal"><a href="<c:url value='/cutters/for_the_treatment_of_metal' />"><custom:getDescriptionByLocale description="${descriptions.cutters_for_the_treatment_of_metal}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.cuttersJSON.list_for_the_treatment_of_metal}" var="link">
									<li><a href="<c:url value='/cutter/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_cutter_stone_processing"><a href="<c:url value='/cutters/stone_processing' />"><custom:getDescriptionByLocale description="${descriptions.cutters_stone_processing}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.cuttersJSON.list_stone_processing}" var="link">
									<li><a href="<c:url value='/cutter/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                    </ul>
                </li>
<!---------------------------------------------------------------------------------------------------------------------------------> 
                <li class="menu_list"><a href="<c:url value='/scanners' />"><custom:getDescriptionByLocale description="${descriptions.scanners}"/></a>
                    <ul class="menu_drop">
                        <li id="list_scanner_large_format_scanners"><a href="<c:url value='/scanners/large_format_scanners' />"><custom:getDescriptionByLocale description="${descriptions.scanners_large_format_scanners}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.scannersJSON.list_large_format_scanners}" var="link">
									<li><a href="<c:url value='/scanner/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_scanner_3d_scanners"><a href="<c:url value='/scanners/3d_scanners' />"><custom:getDescriptionByLocale description="${descriptions.scanners_3d_scanners}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.scannersJSON.list_3d_scanners}" var="link">
									<li><a href="<c:url value='/scanner/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                    </ul>
                </li>
<!---------------------------------------------------------------------------------------------------------------------------------> 
                <li><a href="<c:url value='/previous_use_equipments' />"><custom:getDescriptionByLocale description="${descriptions.previouslyUsed}"/></a>
                  <!--  <ul class="menu_drop">
                          <li><a href="#"><spring:message code="head.previouslyUsed.solvent_equipment"/></a></li>
                        <li><a href="#"><spring:message code="head.previouslyUsed.ecosolvent_oborudovnie"/></a></li>
                    </ul>-->
                </li>
<!---------------------------------------------------------------------------------------------------------------------------------> 
                <li class="menu_list"><a href="<c:url value='/rips' />"><custom:getDescriptionByLocale description="${descriptions.rips}"/></a>
                    <ul class="menu_drop">
                        <li id="list_rip_printing_equipment"><a href="<c:url value='/rips' />"><custom:getDescriptionByLocale description="${descriptions.rips_printing_equipment}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.ripsJSON.list_rip_printing_equipment}" var="link">
									<li><a href="<c:url value='/rip/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_rip_3D_printers"><a href="<c:url value='/rips' />"><custom:getDescriptionByLocale description="${descriptions.rips_3D_printers}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.ripsJSON.list_rip_3D_printers}" var="link">
									<li><a href="<c:url value='/rip/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_rip_laser_milling_equipment"><a href="<c:url value='/rips' />"><custom:getDescriptionByLocale description="${descriptions.rips_laser_milling_equipment}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.ripsJSON.list_rip_laser_milling_equipment}" var="link">
									<li><a href="<c:url value='/rip/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_rip_3D_scanners"><a href="<c:url value='/rips' />"><custom:getDescriptionByLocale description="${descriptions.rips_3D_scanners}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.ripsJSON.list_rip_3D_scanners}" var="link">
									<li><a href="<c:url value='/rip/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_rip_scanners"><a href="<c:url value='/rips' />"><custom:getDescriptionByLocale description="${descriptions.rips_scanners}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.ripsJSON.list_rip_scanners}" var="link">
									<li><a href="<c:url value='/rip/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                    </ul>
               </li>
<!--------------------------------------------------------------------------------------------------------------------------------->               
               <li class="menu_list"><a href="<c:url value='/use_with_products' />"><custom:getDescriptionByLocale description="${descriptions.useWithProducts}"/></a>
                    <ul class="menu_drop">
                        <li id="list_use_with_product_ink_for_inkjet"><a href="<c:url value='/use_with_products/ink_for_inkjet' />"><custom:getDescriptionByLocale description="${descriptions.useWithProducts_ink_for_inkjet}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.useWithProductsJSON.list_ink_for_inkjet}" var="link">
									<li><a href="<c:url value='/use_with_product/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                       <li id="list_use_with_product_consumables_for_digital_equipment">
                       		<a href="<c:url value='/use_with_products/consumables_for_digital_equipment' />"><custom:getDescriptionByLocale description="${descriptions.useWithProducts_consumables_for_digital_equipment}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.useWithProductsJSON.list_consumables_for_digital_equipment}" var="link">
									<li><a href="<c:url value='/use_with_product/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_use_with_product_consumables_for_3D_equipment">
                        	<a href="<c:url value='/use_with_products/consumables_for_3D_equipment' />"><custom:getDescriptionByLocale description="${descriptions.useWithProducts_consumables_for_3D_equipment}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.useWithProductsJSON.list_consumables_for_3D_equipment}" var="link">
									<li><a href="<c:url value='/use_with_product/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_use_with_product_products_for_maintenance">
                        	<a href="<c:url value='/use_with_products/products_for_maintenance' />"><custom:getDescriptionByLocale description="${descriptions.useWithProducts_products_for_maintenance}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.useWithProductsJSON.list_products_for_maintenance}" var="link">
									<li><a href="<c:url value='/use_with_product/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                        <li id="list_use_with_product_parts_and_accessories">
                        	<a href="<c:url value='/use_with_products/parts_and_accessories' />"><custom:getDescriptionByLocale description="${descriptions.useWithProducts_parts_and_accessories}"/></a>
                        	<ul class="menu_drop_drop">
								<c:forEach items="${listLeftLinks.useWithProductsJSON.list_parts_and_accessories}" var="link">
									<li><a href="<c:url value='/use_with_product/${link.id}' />">${link.name}</a></li>
								</c:forEach>
							</ul>
                        </li>
                    </ul>
               </li>
               
           </ul>      