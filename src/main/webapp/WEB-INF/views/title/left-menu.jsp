<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
            <ul class="menu">
                <li class="menu_list"><a href="<c:url value='/printers' />">Принтеры</a>
                    <ul class="menu_drop">
                        <li class="menu_list_list"><a href="<c:url value='/printers/dissolving' />">Сольвентные принтеры</a>
                            <ul class="menu_drop_drop">
                                <li><a href="#">Оборудование Anhui LIYU</a></li>
                                <li><a href="#">Оборудование Infinity Digital Printers</a></li>
                                <li><a href="#">Оборудование Fei Yeung Union</a></li>
                                <li><a href="#">Оборудование Zhongye Technology</a></li>
                             </ul>
                        </li>
                        <li class="menu_list_list"><a href="<c:url value='/printers/ecosolvent' />">Экосольвентные принтеры</a>
							<ul class="menu_drop_drop">
								<c:forEach items="${links}" var="link">
									<li><a href="#">${link}</a></li>
								</c:forEach>
							</ul>
						</li>
                        <li><a href="<c:url value='/printers/UV_roll' />">UV рулонные принтеры</a></li>
                        <li><a href="<c:url value='/printers/UV_flatbed' />">UV плоскопечатные принтеры</a></li>
                        <li><a href="<c:url value='/printers/sublimation' />">Сублимационные принтеры</a></li>
                        <li><a href="<c:url value='/printers/textile' />">Текстильные принтеры</a></li>
                        <li><a href="<c:url value='/printers/water_pigment' />">Водные/пигментные принтеры</a></li>
                    </ul>
                </li>
                <li class="menu_list"><a href="<c:url value='/printers_3d' />">3D Принтеры</a>
                    <ul class="menu_drop">
                        <li class="menu_list_list"><a href="<c:url value='/printers_3d/FDM-extruder' />">Экструдные FDM (fused deposition modeling)</a>
                            <ul class="menu_drop_drop">
                            <li><a href="#">Wasatch SoftRIP</a></li>
                            <li><a href="#">Roland VersaWorks</a></li>
                            <li><a href="#">RIP Ergosoft</a></li>
                        </ul>
                        </li>
                        <li><a href="<c:url value='/printers_3d/photo_printing_polyjet' />">Фото печать Polyjet</a></li>
                        <li><a href="<c:url value='/printers_3d/laser_sintering_LENS' />">Лазерного спекания LENS (LASER ENGINEERED NET SHAPING)</a></li>
                        <li><a href="<c:url value='/printers_3d/lamination_LOM' />">Ламинация LOM (laminated object manufacturing)</a></li>
                        <li><a href="<c:url value='/printers_3d/stereolithography_SL' />">Стереолитография SL (Stereolithography)</a></li>
                        <li><a href="<c:url value='/printers_3d/laser_sintering_LS' />">Лазерное спекание LS (laser sintering)</a></li>
                        <li><a href="<c:url value='/printers_3d/powder_bonding_3DP' />">Порошкового склеивания 3DP (three dimensional printing)</a></li>
                    </ul>
                </li>
                <li class="menu_list"><a href="#">Ламинаторы</a>
                    <ul class="menu_drop">
                        <li><a href="#">Горячего ламинирования</a></li>
                        <li><a href="#">Холодного ламинирования</a></li>
                        <li><a href="#">Жидкостные</a></li>
                    </ul>
                </li>
                <li class="menu_list"><a href="#">Лазерно-гравировальное оборудование</a>
                    <ul class="menu_drop">
                        <li><a href="#">Газовые лазеры СО2</a></li>
                        <li><a href="#">Твердотельные лазеры</a></li>
                        <li><a href="#">Для обработки метала</a></li>
                        <li><a href="#">С диодной накачкой</a></li>
                    </ul>
                </li>
                <li class="menu_list"><a href="#">Фрезерно-гравировальное оборудование</a>
                    <ul class="menu_drop">
                        <li><a href="#">Для обработки дерева</a></li>
                        <li><a href="#">Для обработки метала</a></li>
                        <li><a href="#">Для обработки камня</a></li>
                    </ul>
                </li>
                <li class="menu_list"><a href="#">Сканеры</a>
                    <ul class="menu_drop">
                        <li><a href="#">Широкоформатные сканеры</a></li>
                    </ul>
                </li>
                <li class="menu_list"><a href="#">Б/У Оборудование</a>
                    <ul class="menu_drop">
                        <li><a href="#">Сольвентное оборудование</a></li>
                        <li><a href="#">Экосольвентное оборудовние</a></li>
                    </ul>
                </li>
                <li class="menu_list"><a href="#">Програмное обеспечение</a>
                    <ul class="menu_drop">
                        <li><a href="#">RIP системы</a></li>
                    </ul>
               </li>
           </ul>