<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <header>
        <div id="second_row">
            <a id="second_row_logo" href="<c:url value='/' />"><img class="second_row_image" src="<%=request.getContextPath()%>/resources/images/head/Logo_Print_Master.jpg" alt=""></a>
            <a id="second_row_contact" href=""><img class="second_row_image" src="<%=request.getContextPath()%>/resources/images/head/Contact.png" alt=""></a>
            <div class="phone_numbers">
                <p>тел.: (044)-274-22-99 </p>
                <p>(044)-405-96-11 </p>
                <p>(044)-405-96-88</p>
            </div>
            <div id="second_row_search">
                <input id="second_row_search_field" placeholder="Введите слово или фразу..." size="50" type="search">
                <a id="second_row_search_button" href="" ><img src="<%=request.getContextPath()%>/resources/images/head/Search.jpg" alt=""></a>
            </div>
            <a id="second_row_basket" href=""><img class="second_row_image" src="<%=request.getContextPath()%>/resources/images/head/Basket_full.png" alt=""></a>
            <a id="second_row_price_equality" href=""><img class="second_row_image" src="<%=request.getContextPath()%>/resources/images/head/$.jpg" alt=""></a>
            <a id="second_row_language" href=""><img class="second_row_image" src="<%=request.getContextPath()%>/resources/images/head/Langiuge_1.jpg" alt=""></a>
            <a id="second_row_user" href=""><img class="second_row_image" src="<%=request.getContextPath()%>/resources/images/head/User.jpg" alt=""></a> 
        </div>
        <div id="head_memu_background">
                    <div id="mainmenu">
                       <div id="full_menu">
                         <div class="toggle-menu">
						<!--   <span class="menu-text hide-on-med-and-down">Меню</span>   -->
							<span class="icon-bar skew-clock"></span>
							<span class="icon-bar hide-closed"></span>
							<span class="icon-bar skew-counter"></span>
						</div>
                        </div>
                                <ul>
                                <!-- Пункт меню 1 -->
                                <li><a href="<c:url value='/printers' />">Принтеры</a>
                                  <div class="head_menu_point_1">
                                      <div class="head_menu_point_element">
                                          <a href="<c:url value='/printers/dissolving' />"><img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt="" ><p>Сольвентные принтеры</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="<c:url value='/printers/ecosolvent' />"><img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt=""><p>Экосольвентные принтеры</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="<c:url value='/printers/UV_roll' />"><img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt="" ><p>UV рулонные принтеры</p></a>
                                      </div>                                       
                                      <div class="head_menu_point_element">
                                          <a href="<c:url value='/printers/UV_flatbed' />"><img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt="" ><p>UV плоскопечатные принтеры</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="<c:url value='/printers/sublimation' />"><img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt="" ><p>Сублимационные принтеры</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="<c:url value='/printers/textile' />"><img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt="" ><p>Текстильные принтеры</p></a>
                                      </div>
                                  </div>

                                </li>
                                <!-- Пункт меню 2 -->
                                <li><a href="<c:url value='/printers_3d' />">3D Принтеры</a>
                                  <div class="head_menu_point_2">
                                      <div class="head_menu_point_element">
                                          <a href="<c:url value='/printers_3d/FDM-extruder' />"><img src="<%=request.getContextPath()%>/resources/images/head/Edit/3D_Print_Master_Slide_1.jpg" alt="" ><p>Экструдные FDM</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="<c:url value='/printers_3d/photo_printing_polyjet' />"><img src="<%=request.getContextPath()%>/resources/images/head/Edit/3D_Print_Master_Slide_10.jpg" alt="" ><p>Фото печать Polyjet</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="<c:url value='/printers_3d/laser_sintering_LENS' />"><img src="<%=request.getContextPath()%>/resources/images/head/Edit/3D_Print_Master_Slide_11.jpg" alt="" ><p>Лазерного спекания LENS</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="<c:url value='/printers_3d/lamination_LOM' />"><img src="<%=request.getContextPath()%>/resources/images/head/Edit/3D_Print_Master_Slide_12.jpg" alt="" ><p>Ламинация LOM</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="<c:url value='/printers_3d/stereolithography_SL' />"><img src="<%=request.getContextPath()%>/resources/images/head/Edit/3D_Print_Master_Slide_13.jpg" alt="" ><p>Стереолитография SL</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="<c:url value='/printers_3d/laser_sintering_LS' />"><img src="<%=request.getContextPath()%>/resources/images/head/Edit/3D_Print_Master_Slide_14.jpg" alt="" ><p>Лазерное спекание LS</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="<c:url value='/printers_3d/powder_bonding_3DP' />"><img src="<%=request.getContextPath()%>/resources/images/head/Edit/3D_Print_Master_Slide_15.jpg" alt="" ><p>Порошкового склеивания 3DP</p></a>
                                      </div>                                      
                                  </div>
                                </li>
                                <!-- Пункт меню 3 -->
                                <li><a href="#">Ламинаторы</a>
                                    <div class="head_menu_point_3">
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/lam1.bmp" alt="" ><p>Горячего ламинирования</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/lam1.bmp" alt="" ><p>Холодного ламинирования</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/lam1.bmp" alt="" ><p>Жидкостные</p></a>
                                      </div>                                                                            
                                  </div>
                                </li>
                                <!-- Пункт меню 4 -->
                                <li><a href="#">Лазеры</a>
                                    <div class="head_menu_point_4">
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/hqdefault.jpg" alt="" ><p>Газовые лазеры СО2</p></a>
                                      </div>
                                       <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/hqdefault.jpg" alt="" ><p>Твердотельные лазеры</p></a>
                                      </div>     
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/hqdefault.jpg" alt="" ><p>Для обработки метала</p></a>
                                      </div>
                                       <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/hqdefault.jpg" alt="" ><p>С диодной накачкой</p></a>
                                      </div>                                 
                                  </div>
                                </li>
                                <!-- Пункт меню 5 -->
                                <li><a href="#">Фрезеры</a>
                                    <div class="head_menu_point_5">
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/maxresdefault.jpg" alt="" ><p>Для обработки дерева</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/maxresdefault.jpg" alt="" ><p>Для обработки метала</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/maxresdefault.jpg" alt="" ><p>Для обработки камня</p></a>
                                      </div>                                                                            
                                  </div>
                                </li>
                                <!-- Пункт меню 6 -->
                                <li><a href="#">Сканеры</a>
                                   <div class="head_menu_point_6">
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/SD_series.png" alt="" ><p>Широкоформатные сканеры</p></a>
                                      </div>
                                  </div>
                                </li>
                                <!-- Пункт меню 7 -->
                                <li><a href="#">Б/У Оборудование</a>
                                    <div class="head_menu_point_7">
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/maxresdefault.jpg" alt="" ><p>Сольвентное оборудование</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/maxresdefault.jpg" alt="" ><p>Экосольвентное оборудовние</p></a>
                                      </div>                                                                           
                                  </div>
                                </li>
                                <!-- Пункт меню 8 -->
                                <li><a href="#">ПО</a>
                                    <div class="head_menu_point_8">
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt="" ><p>RIP системы</p></a>
                                      </div>
                                    </div>
                                </li>

                                </ul><!-- Конец списка -->
                        </div><!-- Конец блока #mainmenu -->
        </div>    
 </header>