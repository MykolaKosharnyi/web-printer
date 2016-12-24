<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page session="true"%>

<div id="tree_links">
<a href="<c:url value='/admin' />">Главная</a>
<ul class="Container">
  <li class="Node IsRoot ExpandClosed">
    <div class="Expand"></div>
    <div class="Content"><a href="<c:url value='/admin/printers' />">Принтеры</a></div>
    <ul class="Container">
    
    <!-- Пошли подпункты принтеров -->
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/printers/dissolving' />">Сольвентные принтера</a></div>
        <ul class="Container">
        
			<c:forEach items="${listLeftLinks.printersJSON.listDissolvingPrinters}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach>    
			    
        </ul>
      </li>
      
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/printers/ecosolvent' />">Экосольвентные принтера</a></div>
        <ul class="Container"> 
			
			<c:forEach items="${listLeftLinks.printersJSON.listEcosolventPrinters}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach>  
						     
        </ul>
      </li>
      
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/printers/UV_roll' />">UV рулонные принтера</a></div>
        <ul class="Container">
			
			<c:forEach items="${listLeftLinks.printersJSON.listUvRollPrinters}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach> 
			
        </ul>
      </li>

      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/printers/UV_flatbed' />">UV плоскопечатные принтера</a></div>
        <ul class="Container">
			
			<c:forEach items="${listLeftLinks.printersJSON.listUvFlatbedPrinters}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach> 
			
        </ul>
      </li>
      
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/printers/sublimation' />">Сублимационные принтера</a></div>
        <ul class="Container">
			
			<c:forEach items="${listLeftLinks.printersJSON.listSublimationPrinters}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach> 
			 
        </ul>
      </li>

      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/printers/textile' />">Текстильные принтера</a></div>
        <ul class="Container">
			
			<c:forEach items="${listLeftLinks.printersJSON.listTextilePrinters}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach> 
			
        </ul>
      </li>      
      
       <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/printers/water_pigment' />">Водные/пигментные принтера</a></div>
        <ul class="Container">
			
			<c:forEach items="${listLeftLinks.printersJSON.listWaterPigmentPrinters}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach> 
			
        </ul>
      </li> 
      
      <li class="Node ExpandClosed IsLast">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/printers/SAPR-GIS' />">САПР/ГИС принтера</a></div>
        <ul class="Container">
			
			<c:forEach items="${listLeftLinks.printersJSON.listSAPRGISPrinters}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach> 
			
        </ul>
      </li>
      
    </ul>
  </li>
  
  <li class="Node IsRoot ExpandClosed">
    <div class="Expand"></div>
    <div class="Content"><a href="<c:url value='/admin/3d_printers' />">3D принтеры</a></div>
    <ul class="Container">
    
    <!-- Пошли подпункты принтеров -->
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/3d_printers/FDM-extruder' />">Экструдные FDM</a></div>
        <ul class="Container">
        
			<c:forEach items="${listLeftLinks.printers3dJSON.list_3dPrintersFDM_Extruder}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/3d_printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/3d_printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach>    
			    
        </ul>
      </li>
      
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/3d_printers/photo_printing_polyjet' />">Фото печать Polyjet</a></div>
        <ul class="Container"> 
			
			<c:forEach items="${listLeftLinks.printers3dJSON.list_3d_printers_photo_printing_polyjet}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/3d_printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/3d_printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach>  
						     
        </ul>
      </li>
      
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/3d_printers/laser_sintering_LENS' />">3D принтеры лазерного спекания</a></div>
        <ul class="Container">
			
			<c:forEach items="${listLeftLinks.printers3dJSON.list_3d_printers_laser_sintering_LENS}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/3d_printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/3d_printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach> 
			
        </ul>
      </li>

      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/3d_printers/lamination_LOM' />">Ламинация LOM</a></div>
        <ul class="Container">
			
			<c:forEach items="${listLeftLinks.printers3dJSON.list_3d_printers_lamination_LOM}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/3d_printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/3d_printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach> 
			
        </ul>
      </li>
      
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/3d_printers/stereolithography_SL' />">Стереолитография SL</a></div>
        <ul class="Container">
			
			<c:forEach items="${listLeftLinks.printers3dJSON.list_3d_printers_stereolithography_SL}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/3d_printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/3d_printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach> 
			 
        </ul>
      </li>

      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/3d_printers/laser_sintering_LS' />">Лазерное спекание LS</a></div>
        <ul class="Container">
			
			<c:forEach items="${listLeftLinks.printers3dJSON.list_3d_printers_laser_sintering_LS}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/3d_printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/3d_printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach> 
			
        </ul>
      </li>      
      
       <li class="Node ExpandClosed IsLast">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/3d_printers/powder_bonding_3DP' />">Порошкового склеивания 3DP</a></div>
        <ul class="Container">
			
			<c:forEach items="${listLeftLinks.printers3dJSON.list_3d_printers_powder_bonding_3DP}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/3d_printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/3d_printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach> 
			
        </ul>
      </li> 
      
    </ul>
  </li>

<li class="Node IsRoot ExpandClosed">
    <div class="Expand"></div>
    <div class="Content"><a href="<c:url value='/admin/digital_printers' />">Цыфровые принтеры</a></div>
    <ul class="Container">
    
    <!-- Пошли подпункты цыфровых принтеров -->
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/digital_printers/full_color_laser_printers' />">Полноцветное лазерное оборудование</a></div>
        <ul class="Container">
        
			<c:forEach items="${listLeftLinks.digital_printersJSON.listFullColorLaserPrinters}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/digital_printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/digital_printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach>    
			    
        </ul>
      </li>
      
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/digital_printers/monochrome_laser_printers' />">Монохромное лазерное оборудование</a></div>
        <ul class="Container"> 
			
			<c:forEach items="${listLeftLinks.digital_printersJSON.listMonochromeLaserPrinters}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/digital_printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/digital_printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach>  
						     
        </ul>
      </li>
      
       <li class="Node ExpandClosed IsLast">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/digital_printers/full-color_inkjet_printers' />">Полноцветное струйное оборудование</a></div>
        <ul class="Container">
			
			<c:forEach items="${listLeftLinks.digital_printersJSON.listFullColorInkjetPrinters}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/digital_printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/digital_printer/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach> 
			
        </ul>
      </li> 
      
    </ul>
  </li>

<li class="Node IsRoot ExpandClosed">
    <div class="Expand"></div>
    <div class="Content"><a href="<c:url value='/admin/lasers' />">Лазеры</a></div>
    <ul class="Container">
    
    <!-- Пошли подпункты лазеров -->
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/lasers/CO2_gas_lasers' />">Газовые лазеры СО2</a></div>
        <ul class="Container">
        
			<c:forEach items="${listLeftLinks.laserJSON.list_CO2_gas_lasers}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/laser/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/laser/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach>    
			    
        </ul>
      </li>
      
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/lasers/solid_state_lasers' />">Твердотельные лазеры</a></div>
        <ul class="Container"> 
			
			<c:forEach items="${listLeftLinks.laserJSON.list_solid_state_lasers}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/laser/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/laser/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach>  
						     
        </ul>
      </li>
 
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/lasers/for_the_treatment_of_metal' />">Для обработки метала</a></div>
        <ul class="Container"> 
			
			<c:forEach items="${listLeftLinks.laserJSON.list_for_the_treatment_of_metal}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/laser/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/laser/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach>  
						     
        </ul>
      </li> 
      
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/lasers/fiber_lasers' />">Оптоволоконные лазеры</a></div>
        <ul class="Container"> 
			
			<c:forEach items="${listLeftLinks.laserJSON.list_fiber_lasers}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/laser/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/laser/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach>  
						     
        </ul>
      </li> 
      
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/lasers/plasma_lasers' />">Плазменные лазеры</a></div>
        <ul class="Container"> 
			
			<c:forEach items="${listLeftLinks.laserJSON.list_plasma_lasers}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/laser/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/laser/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach>  
						     
        </ul>
      </li> 
      
       <li class="Node ExpandClosed IsLast">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/lasers/diode_pumped' />">С диодной накачкой</a></div>
        <ul class="Container">
			
			<c:forEach items="${listLeftLinks.laserJSON.list_diode_pumped}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/laser/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/laser/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach> 
			
        </ul>
      </li> 
      
    </ul>
  </li>

<li class="Node IsRoot ExpandClosed">
    <div class="Expand"></div>
    <div class="Content"><a href="<c:url value='/admin/laminators' />">Ламинаторы</a></div>
    <ul class="Container">
    
    <!-- Пошли подпункты ламинаторов -->
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/laminators/hot_lamination' />">Горячего ламинирования</a></div>
        <ul class="Container">
        
			<c:forEach items="${listLeftLinks.laminatorsJSON.list_hot_lamination}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/laminator/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/laminator/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach>    
			    
        </ul>
      </li>
      
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/laminators/cold_laminating' />">Холодного ламинирования</a></div>
        <ul class="Container"> 
			
			<c:forEach items="${listLeftLinks.laminatorsJSON.list_cold_laminating}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/laminator/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/laminator/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach>  
						     
        </ul>
      </li>
      
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/laminators/flatbed_laminating_machine' />">Планшетный ламинатор</a></div>
        <ul class="Container"> 
			
			<c:forEach items="${listLeftLinks.laminatorsJSON.list_flatbed_laminating_machine}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/laminator/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/laminator/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach>  
						     
        </ul>
      </li>
      
       <li class="Node ExpandClosed IsLast">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/laminators/liquid' />">Жидкостные</a></div>
        <ul class="Container">
			
			<c:forEach items="${listLeftLinks.laminatorsJSON.list_liquid}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/laminator/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/laminator/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach> 
			
        </ul>
      </li> 
      
    </ul>
  </li>
  
  <li class="Node IsRoot ExpandClosed">
    <div class="Expand"></div>
    <div class="Content"><a href="<c:url value='/admin/cutters' />">Граверы/фрезеры</a></div>
    <ul class="Container">
    
    <!-- Пошли подпункты лазеров -->
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/cutters/for_wood' />">Для обработки дерева</a></div>
        <ul class="Container">
        
			<c:forEach items="${listLeftLinks.cuttersJSON.list_for_wood}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/cutter/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/cutter/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach>    
			    
        </ul>
      </li>
      
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/cutters/for_the_treatment_of_metal' />">Для обработки металла</a></div>
        <ul class="Container"> 
			
			<c:forEach items="${listLeftLinks.cuttersJSON.list_for_the_treatment_of_metal}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/cutter/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/cutter/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach>  
						     
        </ul>
      </li>
      
       <li class="Node ExpandClosed IsLast">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/cutters/stone_processing' />">Для обработки камня</a></div>
        <ul class="Container">
			
			<c:forEach items="${listLeftLinks.cuttersJSON.list_stone_processing}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/cutter/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/cutter/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach> 
			
        </ul>
      </li> 
      
    </ul>
  </li>
  
   <li class="Node IsRoot ExpandClosed">
    <div class="Expand"></div>
    <div class="Content"><a href="<c:url value='/admin/scanners' />">Сканеры</a></div>
    <ul class="Container">
    
    <!-- Пошли подпункты сканнеров -->
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/scanners/large_format_scanners' />">Широкоформатные сканеры</a></div>
        <ul class="Container">
        
			<c:forEach items="${listLeftLinks.scannersJSON.list_large_format_scanners}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/scanner/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/scanner/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach>    
			    
        </ul>
      </li>
      
      <li class="Node ExpandClosed IsLast">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/scanners/3d_scanners' />">3D Сканеры</a></div>
        <ul class="Container">
        
			<c:forEach items="${listLeftLinks.scannersJSON.list_3d_scanners}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/scanner/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/scanner/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach>    
			    
        </ul>
      </li>
      
    </ul>
  </li>
  
  <li class="Node IsRoot ExpandClosed">
    <div class="Expand"></div>
    <div class="Content"><a href="<c:url value='/admin/use_with_products' />">Сопутствующие товары</a></div>
    <ul class="Container">
    
    <!-- Пошли подпункты сопутствующих товаров -->
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/use_with_products/ink_for_inkjet' />">Чернила для струйной печати</a></div>
        <ul class="Container">
        
			<c:forEach items="${listLeftLinks.useWithProductsJSON.list_ink_for_inkjet}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/use_with_product/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/use_with_product/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach>    
			    
        </ul>
      </li>
      
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/use_with_products/consumables_for_digital_equipment' />">Расходные материалы для цифрового оборудования</a></div>
        <ul class="Container">
        
			<c:forEach items="${listLeftLinks.useWithProductsJSON.list_consumables_for_digital_equipment}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/use_with_product/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/use_with_product/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach>    
			    
        </ul>
      </li>
      
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/use_with_products/consumables_for_3D_equipment' />">Расходные материалы для 3D оборудования</a></div>
        <ul class="Container">
        
			<c:forEach items="${listLeftLinks.useWithProductsJSON.list_consumables_for_3D_equipment}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/use_with_product/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/use_with_product/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach>    
			    
        </ul>
      </li>
      
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/use_with_products/products_for_maintenance' />">Товары для обслуживания</a></div>
        <ul class="Container">
        
			<c:forEach items="${listLeftLinks.useWithProductsJSON.list_products_for_maintenance}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/use_with_product/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/use_with_product/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach>    
			    
        </ul>
      </li>
      
      <li class="Node ExpandClosed IsLast">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/use_with_products/parts_and_accessories' />">Запчасти и комплектующие</a></div>
        <ul class="Container">
			
			<c:forEach items="${listLeftLinks.useWithProductsJSON.list_parts_and_accessories}" var="link" varStatus="status">
				<c:if test="${ ! status.last}" >
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/use_with_product/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
				
				<c:if test="${ status.last}" >
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/use_with_product/edit/${link.id}' />">${link.name}</a></div>
          			</li>				
				</c:if>
			</c:forEach> 
			
        </ul>
      </li> 
      
    </ul>
  </li>

   <li class="Node IsRoot ExpandClosed">
    <div class="Expand"></div>
    <div class="Content"><a href="<c:url value='/admin/previous_use_equipments' />">Б/У Оборудование</a></div>
    <ul class="Container">
    
    <!-- Пошли подпункты -->
      <li class="Node ExpandLeaf">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/previous_use_equipments/printers' />">Принтеры</a></div>
      </li>
      
      <li class="Node ExpandLeaf">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/previous_use_equipments/3d_printers' />">3D Принтеры</a></div>
      </li>
      
      <li class="Node ExpandLeaf">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/previous_use_equipments/digital_printers' />">Цыфровое оборудование</a></div>
      </li>
      
      <li class="Node ExpandLeaf">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/previous_use_equipments/laminators' />">Ламинаторы</a></div>
      </li>
      
      <li class="Node ExpandLeaf">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/previous_use_equipments/lasers' />">Лазеры</a></div>
      </li>
      
      <li class="Node ExpandLeaf">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/previous_use_equipments/cutters' />">Фрезеры/граверы</a></div>
      </li>
      
      <li class="Node ExpandLeaf IsLast">
        <div class="Expand"></div>
        <div class="Content"><a href="<c:url value='/admin/previous_use_equipments/scanners' />">Сканеры</a></div>
      </li>
      
    </ul>
  </li>

<li class="Node IsRoot ExpandClosed">
    <div class="Expand"></div>
    <div class="Content"><a href="<c:url value='/admin/rips' />">ПО</a></div>
    <ul class="Container">
    
    <!-- Пошли подпункты ПО -->
     
      
    
   
      
    </ul>
  </li>
  
<li class="Node IsRoot ExpandLeaf">
	<div class="Expand"></div>
	<div class="Content"><a href="<c:url value='/admin/video_on_home_page' />">Видео на главной странице</a></div>
</li>

<li class="Node IsRoot ExpandLeaf">
	<div class="Expand"></div>
	<div class="Content"><a href="<c:url value='/admin/constants' />">КОНСТАНТЫ</a></div>
</li>

<li class="Node IsRoot ExpandClosed IsLast">
    <div class="Expand"></div>
    <div class="Content">Изображения</a></div>
    <ul class="Container">
    
    <!-- Пошли подпункты для горизонтального меню -->
      <li class="Node ExpandClosed">
        <div class="Expand"></div>
        <div class="Content">ГЛАВНОЕ МЕНЮ</div>
        <ul class="Container">

        	<li class="Node ExpandClosed">
            	<div class="Expand"></div>
            	<div class="Content">Принтеры</div>
            	<ul class="Container">
            		<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/printers/dissolving' />">Изображение сольвентных принтеров</a></div>
          			</li>
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/printers/ecosolvent' />">Изображение экосольвентных принтеров</a></div>
          			</li>
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/printers/UV_roll' />">Изображение UV рулонных принтеров</a></div>
          			</li>
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/printers/UV_flatbed' />">Изображение UV плоскопечатных принтеров</a></div>
          			</li>
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/printers/sublimation' />">Изображение сублимационных принтеров</a></div>
          			</li>
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/printers/textile' />">Изображение текстильных принтеров</a></div>
          			</li>
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/printers/water_pigment' />">Изображение водных/пигментных принтеров</a></div>
          			</li>
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/printers/digital' />">Изображение цифровых принтеров</a></div>
          			</li>
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/printers/SAPR-GIS' />">Изображение САПР/ГИС принтеров</a></div>
          			</li>
            	</ul>
          	</li>	
          	
        	<li class="Node ExpandClosed">
            	<div class="Expand"></div>
            	<div class="Content">3D Принтеры</div>
            	<ul class="Container">
            		<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/printers3d/FDM-extruder' />">Изображение экструдных FDM принтеров</a></div>
          			</li>
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/printers3d/photo_printing_polyjet' />">Изображение фото печать Polyjet</a></div>
          			</li>
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/printers3d/laser_sintering_LENS' />">Изображение 3D принтеры лазерного спекания LENS</a></div>
          			</li>
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/printers3d/lamination_LOM' />">Изображение ламинации LOM</a></div>
          			</li>
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/printers3d/stereolithography_SL' />">Изображение стереолитография SL</a></div>
          			</li>
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/printers3d/laser_sintering_LS' />">Изображение лазерное спекание LS </a></div>
          			</li>
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/printers3d/powder_bonding_3DP' />">Изображение порошкового склеивания 3DP</a></div>
          			</li>
            	</ul>
          	</li>
          	
          	<li class="Node ExpandClosed">
            	<div class="Expand"></div>
            	<div class="Content">Цыфровые принтеры</div>
            	<ul class="Container">
            		<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/digital_printers/full_color_laser_printers' />">Изображение 'Полноцветные лазерные принтеры'</a></div>
          			</li>
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/digital_printers/monochrome_laser_printers' />">Изображение 'Монохромные лазерные принтеры'</a></div>
          			</li>
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/digital_printers/full-color_inkjet_printers' />">Изображение 'Полноцветные струйные принтеры'</a></div>
          			</li>
            	</ul>
          	</li>	

        	<li class="Node ExpandClosed">
            	<div class="Expand"></div>
            	<div class="Content">Ламинаторы</div>
            	<ul class="Container">
            		<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/laminator/hot_lamination' />">Изображение горячего ламинирования</a></div>
          			</li>
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/laminator/cold_laminating' />">Изображение холодного ламинирования</a></div>
          			</li>
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/laminator/liquid' />">Изображение жидкостных ламинаторов</a></div>
          			</li>
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/laminator/flatbed_laminating_machine' />">Изображение планшетных ламинаторов</a></div>
          			</li>
            	</ul>
          	</li>

        	<li class="Node ExpandClosed">
            	<div class="Expand"></div>
            	<div class="Content">Лазеры</div>
            	<ul class="Container">
            		<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/laser/CO2_gas_lasers' />">Газовые лазеры CO2</a></div>
          			</li>
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/laser/solid_state_lasers' />">Твердотельные лазеры</a></div>
          			</li>
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/laser/for_the_treatment_of_metal' />">Для обработки металла</a></div>
          			</li>
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/laser/diode_pumped' />">С диодной накачкой</a></div>
          			</li>
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/laser/fiber_lasers' />">Оптоволоконные лазеры</a></div>
          			</li>
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/laser/plasma_lasers' />">Плазменные лазеры</a></div>
          			</li>
            	</ul>
          	</li>
          	
        	<li class="Node ExpandClosed">
            	<div class="Expand"></div>
            	<div class="Content">Фрезеры</div>
            	<ul class="Container">
            		<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/cutter/for_wood' />">Для обработки дерева</a></div>
          			</li>
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/cutter/for_the_treatment_of_metal' />">Для обработки металла</a></div>
          			</li>
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/cutter/stone_processing' />">Для обработки камня</a></div>
          			</li>
            	</ul>
          	</li>

        	<li class="Node ExpandClosed">
            	<div class="Expand"></div>
            	<div class="Content">Сканеры</div>
            	<ul class="Container">
          			<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/scanner/large_format_scanners' />">Широкоформатные сканеры</a></div>
          			</li>
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/scanner/3d_scanners' />">3D Сканеры</a></div>
          			</li>
            	</ul>
          	</li>      

        	<li class="Node ExpandClosed">
            	<div class="Expand"></div>
            	<div class="Content">Б/У оборудование</div>
            	<ul class="Container">
            		<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/previouslyUsed/solvent_equipment' />">Сольвентное оборудование</a></div>
          			</li>
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/previouslyUsed/ecosolvent_oborudovnie' />">Экосольвентное оборудование</a></div>
          			</li>
            	</ul>
          	</li>		

        	<li class="Node ExpandClosed IsLast">
            	<div class="Expand"></div>
            	<div class="Content">Программное обеспечение</div>
            	<ul class="Container">
          			<li class="Node ExpandLeaf IsLast">
            			<div class="Expand"></div>
            			<div class="Content"><a href="<c:url value='/admin/pictures/menu/rip/RIP_system' />">RIP системы</a></div>
          			</li>
            	</ul>
          	</li> 
    
        </ul>
      </li>
      
      <!-- Для главной страницы -->
      <li class="Node ExpandClosed IsLast">
            	<div class="Expand"></div>
            	<div class="Content">ДОМАШНЯЯ СТРАНИЦА</div>
            	<ul class="Container">
            		<!-- Для большой рекламы в центре -->
            		<li class="Node ExpandLeaf">
            			<div class="Expand"></div>
            			<div class="Content"><a href="/admin/pictures/big_animation_reklam">Большая анимированная реклама</a></div>
          			</li>
          			<li class="Node ExpandClosed">
            			<div class="Expand"></div>
            			<div class="Content">Изображения справа от большой анимированной рекламы</div>
            				<ul class="Container">
            					<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/right_of_reklam/1' />">Верхнее</a></div>
          						</li>
            					<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/right_of_reklam/2' />">Центральное</a></div>
          						</li>
          						<li class="Node ExpandLeaf IsLast">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/right_of_reklam/3' />">Нижнее</a></div>
          						</li>
            				</ul>
          			</li>
          			<li class="Node ExpandClosed">
            			<div class="Expand"></div>
            			<div class="Content">Изображения справа в блоках товаров (ОТКЛЮЧЕНО!)</div>
            				<ul class="Container">
            					<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/home_products_block/printer_block' />">В блоке принтеров</a></div>
          						</li>
            					<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/home_products_block/3d_printer_block' />">В блоке 3Д принтеров</a></div>
          						</li>
          						<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/home_products_block/digital_printer_block' />">В блоке цыфровых принтеров</a></div>
          						</li>
            					<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/home_products_block/laminator_block' />">В блоке ламинаторов</a></div>
          						</li>
          						<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/home_products_block/laser_block' />">В блоке лазеров</a></div>
          						</li>
            					<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/home_products_block/cutter_block' />">В блоке фрезеров</a></div>
          						</li>
          						<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/home_products_block/scaner_block' />">В блоке сканеров</a></div>
          						</li>
            					<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/home_products_block/previously_used_block' />">В блоке б/у оборудования</a></div>
          						</li>
          						<li class="Node ExpandLeaf IsLast">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/home_products_block/rip_block' />">В блоке ПО</a></div>
          						</li>
            				</ul>
          			</li>
          			<li class="Node ExpandClosed">
            			<div class="Expand"></div>
            			<div class="Content">Три большых изображения над блоками товаров</div>
            				<ul class="Container">
          						<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/three_big_pictures/printer_top/1' />">№1 над блоком принтеров</a></div>
          						</li>
          						<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/three_big_pictures/printer_top/2' />">№2 над блоком принтеров</a></div>
          						</li>
          						<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/three_big_pictures/printer_top/3' />">№3 над блоком принтеров</a></div>
          						</li>
            					<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/three_big_pictures/digital_printer_top/1' />">№1 над блоком цыфровых принтеров</a></div>
          						</li>
          						<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/three_big_pictures/digital_printer_top/2' />">№2 над блоком цыфровых принтеров</a></div>
          						</li>
          						<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/three_big_pictures/digital_printer_top/3' />">№3 над блоком цыфровых принтеров</a></div>
          						</li>
          						<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/three_big_pictures/laser_top/1' />">№1 над блоком лазеров</a></div>
          						</li>
          						<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/three_big_pictures/laser_top/2' />">№2 над блоком лазеров</a></div>
          						</li>
          						<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/three_big_pictures/laser_top/3' />">№3 над блоком лазеров</a></div>
          						</li>
            					<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/three_big_pictures/scaner_top/1' />">№1 над блоком сканеров</a></div>
          						</li>
          						<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/three_big_pictures/scaner_top/2' />">№2 над блоком сканеров</a></div>
          						</li>
          						<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/three_big_pictures/scaner_top/3' />">№3 над блоком сканеров</a></div>
          						</li>
          						<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/three_big_pictures/rip_top/1' />">№1 над блоком ПО</a></div>
          						</li>
          						<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/three_big_pictures/rip_top/2' />">№2 над блоком ПО</a></div>
          						</li>
          						<li class="Node ExpandLeaf IsLast">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/three_big_pictures/rip_top/3' />">№3 над блоком ПО</a></div>
          						</li>
            				</ul>
          			</li>
          			<li class="Node ExpandClosed IsLast">
            			<div class="Expand"></div>
            			<div class="Content">Два узких изображения над блоками товаров</div>
            				<ul class="Container">
          						<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/two_narrow_pictures/3d_printer_top/1' />">№1 над 3Д принтерами</a></div>
          						</li>
          						<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/two_narrow_pictures/3d_printer_top/2' />">№2 над 3Д принтерами</a></div>
          						</li>
            					<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/two_narrow_pictures/laminator_top/1' />">№1 над ламинаторами</a></div>
          						</li>
          						<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/two_narrow_pictures/laminator_top/2' />">№2 над ламинаторами</a></div>
          						</li>
          						<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/two_narrow_pictures/cutter_top/1' />">№1 над фрезерами</a></div>
          						</li>
          						<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/two_narrow_pictures/cutter_top/2' />">№2 над фрезерами</a></div>
          						</li>
          						<li class="Node ExpandLeaf">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/two_narrow_pictures/previously_used_top/1' />">№1 б/у оборудования</a></div>
          						</li>
          						<li class="Node ExpandLeaf IsLast">
            						<div class="Expand"></div>
            						<div class="Content"><a href="<c:url value='/admin/pictures/two_narrow_pictures/previously_used_top/2' />">№2 б/у оборудования</a></div>
          						</li>
            				</ul>
          			</li>
            	</ul>
      </li>			
       
    </ul>
  </li>
  
</ul>
</div>
