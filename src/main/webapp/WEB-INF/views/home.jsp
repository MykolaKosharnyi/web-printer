<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style_head_and_footer.css"/>
    
	<title>Print Master</title>
	
	<script src="<%=request.getContextPath()%>/resources/js/jquery-2.1.4.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/jquery.cycle.lite.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/animation.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/slider.js"></script>
    
    <!-- for reklam_anamation -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/jgallery.min.css?v=1.5.0"/>

    <script src="<%=request.getContextPath()%>/resources/js/jgallery.min.js?v=1.5.0"></script>
    <script src="<%=request.getContextPath()%>/resources/js/touchswipe.min.js"></script>
</head>
<body>
	<c:url var="search-printer" value="/printers/search" ></c:url>
    <header>
        <div id="second_row">
            <a id="second_row_logo" href="index.html"><img class="second_row_image" src="<%=request.getContextPath()%>/resources/images/head/Logo_Print_Master.jpg" alt=""></a>
            <a id="second_row_contact" href=""><img class="second_row_image" src="<%=request.getContextPath()%>/resources/images/head/Contact.png" alt=""></a>
            <div class="phone_numbers">
                <p>тел.: (044) 274 22 99, </p>
                <p>(044) 405 96 11, </p>
                <p>(044) 405 96 88</p>
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
                                <li><a href="<c:url value='/printers/search' />">Принтеры</a>
                                  <div class="head_menu_point_1">
                                      <div class="head_menu_point_element">
                                          <a href="<c:url value='/printers/search' />"><img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt="" ><p>Сольвентные принтеры</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="<c:url value='/printers/search' />"><img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt=""><p>Экосольвентные принтеры</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="<c:url value='/printers/search' />"><img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt="" ><p>UV рулонные принтеры</p></a>
                                      </div>                                       
                                      <div class="head_menu_point_element">
                                          <a href="<c:url value='/printers/search' />"><img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt="" ><p>UV плоскопечатные принтеры</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="<c:url value='/printers/search' />"><img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt="" ><p>Сублимационные принтеры</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="<c:url value='/printers/search' />"><img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt="" ><p>Текстильные принтеры</p></a>
                                      </div>
                                  </div>

                                </li>
                                <!-- Пункт меню 2 -->
                                <li><a href="#">3D Принтеры</a>
                                  <div class="head_menu_point_2">
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit/3D_Print_Master_Slide_1.jpg" alt="" ><p>Экструдные FDM</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit/3D_Print_Master_Slide_10.jpg" alt="" ><p>Фото печать Polyjet</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit/3D_Print_Master_Slide_11.jpg" alt="" ><p>Лазерного спекания LENS</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit/3D_Print_Master_Slide_12.jpg" alt="" ><p>Ламинация LOM</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit/3D_Print_Master_Slide_13.jpg" alt="" ><p>Стереолитография SL</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit/3D_Print_Master_Slide_14.jpg" alt="" ><p>Лазерное спекание LS</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit/3D_Print_Master_Slide_15.jpg" alt="" ><p>Порошкового склеивания 3DP</p></a>
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
    <div id="the_main_part">  
        <div class="left_field">
            <ul class="menu">
                <li class="menu_list"><a href="<c:url value='/printers/search' />">Принтеры</a>
                    <ul class="menu_drop">
                        <li class="menu_list_list"><a href="<c:url value='/printers/search' />">Сольвентные принтеры</a>
                            <ul class="menu_drop_drop">
                                <li><a href="#">Оборудование Anhui LIYU</a></li>
                                <li><a href="#">Оборудование Infinity Digital Printers</a></li>
                                <li><a href="#">Оборудование Fei Yeung Union</a></li>
                                <li><a href="#">Оборудование Zhongye Technology</a></li>
                                <li><a href="#">Оборудование Flora Digital Printing</a></li>
                                <li><a href="#">Оборудование Teckwin</a></li>
                                <li><a href="#">Оборудование Hewllet-Pacard/Scitex Vision</a></li>
                                <li><a href="#">Оборудование VUTEk</a></li>
                                <li><a href="#">Оборудование Mimaki</a></li>
                                <li><a href="#">Оборудование Roland</a></li>
                                <li><a href="#">Оборудование Mutoh</a></li>
                                <li><a href="#">Оборудование OCE</a></li>
                                <li><a href="#">Оборудование SKY JET</a></li>
                                <li><a href="#">Оборудование Kodak-Encad</a></li>
                                <li><a href="#">Оборудование JHF</a></li>
                             </ul>
                        </li>
                        <li><a href="<c:url value='/printers/search' />">Экосольвентные принтеры</a></li>
                        <li><a href="<c:url value='/printers/search' />">UV рулонные принтеры</a></li>
                        <li><a href="<c:url value='/printers/search' />">UV плоскопечатные принтеры</a></li>
                        <li><a href="<c:url value='/printers/search' />">Сублимационные принтеры</a></li>
                        <li><a href="<c:url value='/printers/search' />">Текстильные принтеры</a></li>
                    </ul>
                </li>
                <li class="menu_list"><a href="#">3D Принтеры</a>
                    <ul class="menu_drop">
                        <li class="menu_list_list"><a href="#">Экструдные FDM (fused deposition modeling)</a>
                            <ul class="menu_drop_drop">
                            <li><a href="#">Wasatch SoftRIP</a></li>
                            <li><a href="#">Roland VersaWorks</a></li>
                            <li><a href="#">RIP Ergosoft</a></li>
                        </ul>
                        </li>
                        <li><a href="#">Фото печать Polyjet</a></li>
                        <li><a href="#">Лазерного спекания LENS (LASER ENGINEERED NET SHAPING)</a></li>
                        <li><a href="#">Ламинация LOM (laminated object manufacturing)</a></li>
                        <li><a href="#">Стереолитография SL (Stereolithography)</a></li>
                        <li><a href="#">Лазерное спекание LS (laser sintering)</a></li>
                        <li><a href="#">Порошкового склеивания 3DP (three dimensional printing)</a></li>
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
            <div id="reklam">
               	        <div class="slide-item">
					        <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/1.png" alt="" /></div>
					        <div class="slide-title">Name of product: </div>
                            <div class="slide-price">Prise: </div>
                            <input class="slide-buy" type="button" value="Добавить в корзину" >
				        </div>
				       <div class="slide-item">
					        <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/2.png" alt="" /></div>
					        <div class="slide-title">Name of product: </div>
                            <div class="slide-price">Prise: </div>
                            <input class="slide-buy" type="button" value="Добавить в корзину" >
				        </div>
				        
				        <div class="slide-item">
					        <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/3.png" alt="" /></div>
					        <div class="slide-title">Name of product: </div>
                            <div class="slide-price">Prise: </div>
                            <input class="slide-buy" type="button" value="Добавить в корзину" >
				        </div>
				        <div class="slide-item">
					        <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/1.png" alt="" /></div>
					        <div class="slide-title">Name of product: </div>
                            <div class="slide-price">Prise: </div>
                            <input class="slide-buy" type="button" value="Добавить в корзину" >
				        </div>
				       <div class="slide-item">
					        <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/2.png" alt="" /></div>
					        <div class="slide-title">Name of product: </div>
                            <div class="slide-price">Prise: </div>
                            <input class="slide-buy" type="button" value="Добавить в корзину" >
				        </div>
				        <div class="slide-item">
					        <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/2.png" alt="" /></div>
					        <div class="slide-title">Name of product: </div>
                            <div class="slide-price">Prise: </div>
                            <input class="slide-buy" type="button" value="Добавить в корзину" >
				        </div>
				        
				        <div class="slide-item">
					        <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/3.png" alt="" /></div>
					        <div class="slide-title">Name of product: </div>
                            <div class="slide-price">Prise: </div>
                            <input class="slide-buy" type="button" value="Добавить в корзину" >
				        </div>
				        <div class="slide-item">
					        <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/1.png" alt="" /></div>
					        <div class="slide-title">Name of product: </div>
                            <div class="slide-price">Prise: </div>
                            <input class="slide-buy" type="button" value="Добавить в корзину" >
				        </div>
           </div>
        </div>
        <div class="reklam_animation">
               <div id="gallery">   
                    <img src="<%=request.getContextPath()%>/resources/images/reklam_animation/Slide_1.jpg" alt="First image" />
                    <img src="<%=request.getContextPath()%>/resources/images/reklam_animation/Slide_2.jpg" alt="First image" />
                    <img src="<%=request.getContextPath()%>/resources/images/reklam_animation/Slide_4.jpg" alt="First image" />
                    <img src="<%=request.getContextPath()%>/resources/images/reklam_animation/Slide_5.jpg" alt="First image" />
                    <img src="<%=request.getContextPath()%>/resources/images/reklam_animation/Slide_6.jpg" alt="First image" />
                    <img src="<%=request.getContextPath()%>/resources/images/reklam_animation/Slide_7.jpg" alt="First image" />
                    <img src="<%=request.getContextPath()%>/resources/images/reklam_animation/Slide_8.png" alt="First image" />
                    <img src="<%=request.getContextPath()%>/resources/images/reklam_animation/Slide_9.png" alt="First image" />
                    <img src="<%=request.getContextPath()%>/resources/images/reklam_animation/Slide_10.jpg" alt="First image" />
                </div>
            </div>
        <div id="rigt_of_reklam_animation">
            <div class="rigt_of_reklam_animation_position">
                <a href=""><div class="for_right_reklam_image"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_46.jpg" alt="" /></div><p>Надпись</p></a>
            </div>
            <div class="rigt_of_reklam_animation_position">
                <a href=""><div class="for_right_reklam_image"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_46.jpg" alt="" /></div><p>Надпись</p></a>
            </div>
        </div>
        <div id="goods">   
            <div class="advertising">
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_20.jpg" alt="" ></a></div>
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_32.jpg" alt="" ></a></div>
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_40.jpg" alt="" ></a></div>
            </div>
            <div class="advertising_second_variant">
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_13.jpg" alt="" ></a></div>
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_54.jpg" alt="" ></a></div>
            </div>
            <div class="categories_of_goods">
                <div class="description_slider">
                        <label> Принтеры </label>
                    <div class="body_description">
                        <ul>
                            <li><a href="">Сольвентные</a></li>
                            <li><a href="">Экосольвентные</a></li>
                            <li><a href="">UV рулонные</a></li>
                            <li><a href="">UV плоскопечатные</a></li>
                            <li><a href="">Сублимационные</a></li>
                            <li><a href="">Текстильные</a></li>
                        </ul>
                    </div>
                </div>
                <div class="slider1">
                     <div class="slide-list1">
                         <div class="slide-wrap1">
                            <div class="slide-item1">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/1.png" alt="" /></div>
                                <div class="slide-title1">Name of product: </div>
                                <div class="slide-price1">Prise: </div>
                                <input class="slide-buy1" type="button" value="Добавить в корзину" >
                            </div>
                            <div class="slide-item1">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/2.png" alt="" /></div>
                                <div class="slide-title1">Name of product: </div>
                                <div class="slide-price1">Prise: </div>
                                <input class="slide-buy1" type="button" value="Добавить в корзину" >
                             </div>
                             <div class="slide-item1">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/3.png" alt="" /></div>
                                <div class="slide-title1">Name of product: </div>
                                <div class="slide-price1">Prise: </div>
                                <input class="slide-buy1" type="button" value="Добавить в корзину" >
                             </div>
                             <div class="slide-item1">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/img-2.jpg" alt="" /></div>
                                <div class="slide-title1">Name of product: </div>
                                <div class="slide-price1">Prise: </div>
                                <input class="slide-buy1" type="button" value="Добавить в корзину" >
                             </div>
                             <div class="slide-item1">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/img-4.jpg" alt="" /></div>
                                <div class="slide-title1">Name of product: </div>
                                <div class="slide-price1">Prise: </div>
                                <input class="slide-buy1" type="button" value="Добавить в корзину" >
                             </div>
                             <div class="slide-item1">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/img-5.jpg" alt="" /></div>
                                <div class="slide-title1">Name of product: </div>
                                <div class="slide-price1">Prise: </div>
                                <input class="slide-buy1" type="button" value="Добавить в корзину" >
                             </div>
                          </div>
                          <div class="clear1"></div>
                      </div>
                      <div class="bottom_of_slider">
                          <div class="navy1 prev-slide1"></div>
                          <div class="auto1 play1"></div>
                          <div class="navy1 next-slide1"></div>
                      </div>
                </div>
                <div class="reklam_right_of_slider1"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_48.jpg" alt="" /></div>
            </div>
            <div class="advertising_third_variant">
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_58.jpg" alt="" ></a></div>
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_57.jpg" alt="" ></a></div>
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_55.jpg" alt="" ></a></div>
            </div>
            <div class="categories_of_goods">
                 <div class="description_slider">
                        <label> 3D Принтеры </label>
                    <div class="body_description">
                        <ul>
                            <li><a href="">Экструдные FDM</a></li>
                            <li><a href="">Фото печать Polyjet</a></li>
                            <li><a href="">Лазерного спекания LENS</a></li>
                            <li><a href="">Ламинация LOM</a></li>
                            <li><a href="">Стереолитография SL</a></li>
                            <li><a href="">Лазерное спекание LS</a></li>
                            <li><a href="">Порошкового склеивания 3DP</a></li>
                        </ul>
                    </div>
                </div>
                <div class="slider2">
                     <div class="slide-list2">
                         <div class="slide-wrap2">
                            <div class="slide-item2">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/1.png" alt="" /></div>
                                <div class="slide-title2">Name of product: </div>
                                <div class="slide-price2">Prise: </div>
                                <input class="slide-buy2" type="button" value="Добавить в корзину" >
                            </div>
                           <div class="slide-item2">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/2.png" alt="" /></div>
                                <div class="slide-title2">Name of product: </div>
                                <div class="slide-price2">Prise: </div>
                                <input class="slide-buy2" type="button" value="Добавить в корзину" >
                            </div>
                            <div class="slide-item2">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/3.png" alt="" /></div>
                                <div class="slide-title2">Name of product: </div>
                                <div class="slide-price2">Prise: </div>
                                <input class="slide-buy2" type="button" value="Добавить в корзину" >
                            </div>
                            <div class="slide-item2">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/3.png" alt="" /></div>
                                <div class="slide-title2">Name of product: </div>
                                <div class="slide-price2">Prise: </div>
                                <input class="slide-buy2" type="button" value="Добавить в корзину" >
                            </div>
                          </div>
                          <div class="clear2"></div>
                      </div>
                      <div class="bottom_of_slider">
                          <div class="navy2 prev-slide2"></div>
                          <div class="auto2 play2"></div>
                          <div class="navy2 next-slide2"></div>
                      </div>
                </div>
                <div class="reklam_right_of_slider2"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_18.jpg" alt="" /></div>
            </div>
            <div class="advertising_fourth_variant">
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_58.jpg" alt="" ></a></div>
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_57.jpg" alt="" ></a></div>
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_55.jpg" alt="" ></a></div>
            </div>
            <div class="advertising_second_variant">
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_13.jpg" alt="" ></a></div>
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_54.jpg" alt="" ></a></div>
            </div>           
            <div class="categories_of_goods">
                <div class="description_slider">
                        <label> Ламинаторы </label>
                    <div class="body_description">
                        <ul>
                            <li><a href="">Горячего ламинирования</a></li>
                            <li><a href="">Холодного ламинирования</a></li>
                            <li><a href="">Жидкостные</a></li>
                        </ul>
                    </div>
                </div>
                <div class="slider3">
                     <div class="slide-list3">
                         <div class="slide-wrap3">
                            <div class="slide-item3">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/1.png" alt="" /></div>
                                <div class="slide-title3">Name of product: </div>
                                <div class="slide-price3">Prise: </div>
                                <input class="slide-buy3" type="button" value="Добавить в корзину" >
                            </div>
                           <div class="slide-item3">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/2.png" alt="" /></div>
                                <div class="slide-title3">Name of product: </div>
                                <div class="slide-price3">Prise: </div>
                                <input class="slide-buy3" type="button" value="Добавить в корзину" >
                            </div>

                            <div class="slide-item3">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/3.png" alt="" /></div>
                                <div class="slide-title3">Name of product: </div>
                                <div class="slide-price3">Prise: </div>
                                <input class="slide-buy3" type="button" value="Добавить в корзину" >
                            </div>
                          </div>
                          <div class="clear3"></div>
                      </div>
                      <div class="bottom_of_slider">
                          <div class="navy3 prev-slide3"></div>
                          <div class="auto3 play3"></div>
                          <div class="navy3 next-slide3"></div>
                      </div>
                </div>
                <div class="reklam_right_of_slider3"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_33.jpg" alt="" /></div>
            </div>
            <div class="advertising_second_variant">
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_13.jpg" alt="" ></a></div>
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_54.jpg" alt="" ></a></div>
            </div>
            <div class="categories_of_goods">
                <div class="description_slider">
                        <label> Лазерно-гравировальное </label>
                    <div class="body_description">
                        <ul>
                            <li><a href="">Газовые лазеры СО2</a></li>
                            <li><a href="">Твердотельные лазеры</a></li>
                        </ul>
                    </div>
                </div>
                <div class="slider4">
                     <div class="slide-list4">
                         <div class="slide-wrap4">
                            <div class="slide-item4">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/1.png" alt="" /></div>
                                <div class="slide-title4">Name of product: </div>
                                <div class="slide-price4">Prise: </div>
                                <input class="slide-buy4" type="button" value="Добавить в корзину" >
                            </div>
                           <div class="slide-item4">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/2.png" alt="" /></div>
                                <div class="slide-title4">Name of product: </div>
                                <div class="slide-price4">Prise: </div>
                                <input class="slide-buy4" type="button" value="Добавить в корзину" >
                            </div>

                            <div class="slide-item4">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/3.png" alt="" /></div>
                                <div class="slide-title4">Name of product: </div>
                                <div class="slide-price4">Prise: </div>
                                <input class="slide-buy4" type="button" value="Добавить в корзину" >
                            </div>
                          </div>
                          <div class="clear4"></div>
                      </div>
                      <div class="bottom_of_slider">
                          <div class="navy4 prev-slide4"></div>
                          <div class="auto4 play4"></div>
                          <div class="navy4 next-slide4"></div>
                      </div>
                </div>
                <div class="reklam_right_of_slider4"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_57.jpg" alt="" /></div>
            </div>
            <div class="advertising_second_variant">
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_13.jpg" alt="" ></a></div>
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_54.jpg" alt="" ></a></div>
            </div>
            <div class="categories_of_goods">
                <div class="description_slider">
                        <label>Фрезеры</label>
                    <div class="body_description">
                        <ul>
                            <li><a href="">Для обробки дерева</a></li>
                            <li><a href="">Для обробки металла</a></li>
                            <li><a href="">Для обробки камня</a></li>
                        </ul>
                    </div>
                </div>
                <div class="slider5">
                     <div class="slide-list5">
                         <div class="slide-wrap5">
                            <div class="slide-item5">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/1.png" alt="" /></div>
                                <div class="slide-title5">Name of product: </div>
                                <div class="slide-price5">Prise: </div>
                                <input class="slide-buy5" type="button" value="Добавить в корзину" >
                            </div>
                           <div class="slide-item5">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/2.png" alt="" /></div>
                                <div class="slide-title5">Name of product: </div>
                                <div class="slide-price5">Prise: </div>
                                <input class="slide-buy5" type="button" value="Добавить в корзину" >
                            </div>

                            <div class="slide-item5">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/3.png" alt="" /></div>
                                <div class="slide-title5">Name of product: </div>
                                <div class="slide-price5">Prise: </div>
                                <input class="slide-buy5" type="button" value="Добавить в корзину" >
                            </div>
                          </div>
                          <div class="clear5"></div>
                      </div>
                      <div class="bottom_of_slider">
                          <div class="navy5 prev-slide5"></div>
                          <div class="auto5 play5"></div>
                          <div class="navy5 next-slide5"></div>
                      </div>
                </div>
                <div class="reklam_right_of_slider5"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_39.jpg" alt="" /></div>
            </div>
            <div class="advertising_second_variant">
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_13.jpg" alt="" ></a></div>
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_54.jpg" alt="" ></a></div>
            </div>
            <div class="categories_of_goods">
                    <div class="description_slider">
                            <label> Сканеры </label>
                        <div class="body_description">
                            <ul>
                                <li><a href="">Широкоформатные сканеры</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="slider6">
                     <div class="slide-list6">
                         <div class="slide-wrap6">
                            <div class="slide-item6">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/1.png" alt="" /></div>
                                <div class="slide-title6">Name of product: </div>
                                <div class="slide-price6">Prise: </div>
                                <input class="slide-buy6" type="button" value="Добавить в корзину" >
                            </div>
                           <div class="slide-item6">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/2.png" alt="" /></div>
                                <div class="slide-title6">Name of product: </div>
                                <div class="slide-price6">Prise: </div>
                                <input class="slide-buy6" type="button" value="Добавить в корзину" >
                            </div>

                            <div class="slide-item6">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/3.png" alt="" /></div>
                                <div class="slide-title6">Name of product: </div>
                                <div class="slide-price6">Prise: </div>
                                <input class="slide-buy6" type="button" value="Добавить в корзину" >
                            </div>
                          </div>
                          <div class="clear6"></div>
                      </div>
                      <div class="bottom_of_slider">
                          <div class="navy6 prev-slide6"></div>
                          <div class="auto6 play6"></div>
                          <div class="navy6 next-slide6"></div>
                      </div>
                </div>
                <div class="reklam_right_of_slider6"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_51.jpg" alt="" /></div>
            </div>
            <div class="advertising_second_variant">
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_13.jpg" alt="" ></a></div>
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_54.jpg" alt="" ></a></div>
            </div>
            <div class="categories_of_goods">
                    <div class="description_slider">
                            <label> Программное обеспечение </label>
                        <div class="body_description">
                            <ul>
                                <li><a href="">RIP системы</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="slider7">
                     <div class="slide-list7">
                         <div class="slide-wrap7">
                            <div class="slide-item7">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/1.png" alt="" /></div>
                                <div class="slide-title7">Name of product: </div>
                                <div class="slide-price7">Prise: </div>
                                <input class="slide-buy7" type="button" value="Добавить в корзину" >
                            </div>
                           <div class="slide-item7">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/2.png" alt="" /></div>
                                <div class="slide-title7">Name of product: </div>
                                <div class="slide-price7">Prise: </div>
                                <input class="slide-buy7" type="button" value="Добавить в корзину" >
                            </div>

                            <div class="slide-item7">
                                <div class="slider_image"><img src="<%=request.getContextPath()%>/resources/img/3.png" alt="" /></div>
                                <div class="slide-title7">Name of product: </div>
                                <div class="slide-price7">Prise: </div>
                                <input class="slide-buy7" type="button" value="Добавить в корзину" >
                            </div>
                          </div>
                          <div class="clear7"></div>
                      </div>
                      <div class="bottom_of_slider">
                          <div class="navy7 prev-slide7"></div>
                          <div class="auto7 play7"></div>
                          <div class="navy7 next-slide7"></div>
                      </div>
                </div>
                <div class="reklam_right_of_slider7"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_44.jpg" alt="" /></div>
        </div>
            <div class="advertising_second_variant">
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_13.jpg" alt="" ></a></div>
                <div class="advertising_image"><a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/Edit1/Laser_Print_Master_54.jpg" alt="" ></a></div>
            </div>
    </div>
    </div>
    <div id="footer">

</div>
    <script type="text/javascript">
        $( function() {
            $( '#gallery' ).jGallery( { mode: 'slider',
                                        utostart: true,
                                        width: '100%',
                                        height: '100%',
                                        transitionBackward: 'auto',
                                        transition:'rotateFoldTop_moveFromBottomFade',
                                        transitionCols:'6',
                                        transitionRows:'1',
                                        thumbnailsPosition:'bottom',
                                        thumbType:'square',
                                        backgroundColor:'FFFFFF',
                                      } );
           $("#full_menu").click(function(){
               if ( $(".menu").css('display') == 'none' ) {
                     $(".menu").slideDown(1400);
                      } else {
                     $(".menu").slideUp(1400);
                     }
              });
        } );       
    </script>
</body>
</html>