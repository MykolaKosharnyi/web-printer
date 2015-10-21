<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="ru">
	<head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style_search.css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style_head_and_footer.css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/jquery-ui.css">

		<title>Search printer</title>
	    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-2.1.4.min.js"></script>
	    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui.js"></script>
	    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/search_printer.js"></script>
	</head>
<body>
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
                                <li><a href="search_printer.html">Принтеры</a>
                                  <div class="head_menu_point_1">
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt="" ><p>Сольвентные принтеры</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt=""><p>Экосольвентные принтеры</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt="" ><p>UV рулонные принтеры</p></a>
                                      </div>                                       
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt="" ><p>UV плоскопечатные принтеры</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt="" ><p>Сублимационные принтеры</p></a>
                                      </div>
                                      <div class="head_menu_point_element">
                                          <a href="#"><img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt="" ><p>Текстильные принтеры</p></a>
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
            <div id="navigation">
                <a href="index.html">Главная</a>
                <span> > </span>
                <p> Принтеры </p>
            </div>     
         </header>
   
    <div id="the_main_part">  
        <div class="left_field">
            <ul class="menu">
                <li class="menu_list"><a href="search_printer.html">Принтеры</a>
                    <ul class="menu_drop">
                        <li class="menu_list_list"><a href="#">Сольвентные принтеры</a>
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
                        <li><a href="#">Экосольвентные принтеры</a></li>
                        <li><a href="#">UV рулонные принтеры</a></li>
                        <li><a href="#">UV плоскопечатные принтеры</a></li>
                        <li><a href="#">Сублимационные принтеры</a></li>
                        <li><a href="#">Текстильные принтеры</a></li>
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
            <div id="display_search">
                <i class="opened"></i>
                <p>Критерии поиска</p>
            </div>
            <div id="search_printer">
                <div class="search_criteria">
                        <div class="block_title">
                            <i></i>
                            <p>Ширина печати</p>
                        </div>
                        <ul class="check_boxes">
                            <div id="tabs">
                                <ul>
                                    <li>миллиметр</li>
                                    <li>дюйм</li>
                                    <li>формат</li>
                                </ul>
                                <div>
                                    <div>
                                        <li><input type="checkbox" name="radio_weight_print_sm" checked>600</input></li>
                                        <li><input type="checkbox" name="radio_weight_print_sm">900</input></li>
                                        <li><input type="checkbox" name="radio_weight_print_sm">1070</input></li>
                                        <li><input type="checkbox" name="radio_weight_print_sm">1300</input></li>
                                        <li><input type="checkbox" name="radio_weight_print_sm">1600</input></li>
                                        <li><input type="checkbox" name="radio_weight_print_sm">1800</input></li>
                                        <li><input type="checkbox" name="radio_weight_print_sm">2500</input></li>
                                        <li><input type="checkbox" name="radio_weight_print_sm">2600</input></li>
                                        <li><input type="checkbox" name="radio_weight_print_sm">32000</input></li>
                                        <li><input type="checkbox" name="radio_weight_print_sm">50000</input></li>
                                    </div>
                                    <div>
                                        <li><input type="checkbox" name="radio_weight_print_inch" checked>24</input></li>
                                        <li><input type="checkbox" name="radio_weight_print_inch">36</input></li>
                                        <li><input type="checkbox" name="radio_weight_print_inch">42</input></li>
                                        <li><input type="checkbox" name="radio_weight_print_inch">60</input></li>
                                        <li><input type="checkbox" name="radio_weight_print_inch">70</input></li>
                                        <li><input type="checkbox" name="radio_weight_print_inch">100</input></li>
                                    </div>
                                    <div>
                                        <li><input type="checkbox" name="radio_weight_print_format" checked>A0</input></li>
                                        <li><input type="checkbox" name="radio_weight_print_format">A1</input></li>
                                        <li><input type="checkbox" name="radio_weight_print_format">A2</input></li>
                                        <li><input type="checkbox" name="radio_weight_print_format">A3</input></li>
                                        <li><input type="checkbox" name="radio_weight_print_format">A3+</input></li>
                                        <li><input type="checkbox" name="radio_weight_print_format">B0</input></li>
                                        <li><input type="checkbox" name="radio_weight_print_format">B1</input></li> 
                                    </div>
                                </div>            
                            </div>
                        </ul>       
                    </div>    
                <div class="search_criteria">
                        <div class="block_title">
                            <i class="opened"></i>
                            <p>Цена</p>
                        </div>
                        <ul class="check_boxes" style="display: block;">
                           <div class="text_output">
                               <p>$</p>
                                <input type="text" class="amount-prise0">
                                <p>-&nbsp; $</p>
                                <input type="text" class="amount-prise1">
                           </div>

                            <div class="slider" >
                                <div class="slider-range-prise"></div>
                            </div>
                        </ul>
                    </div>
                <div class="search_criteria">
                    <div class="block_title">
                        <i></i>
                        <p>Б/У оборудование</p>
                    </div>
                    <ul class="check_boxes">
                        <li><input type="checkbox" name="checkbox_former_use_equipment">новое</input></li>
                        <li><input type="checkbox" name="checkbox_former_use_equipment">Б/У</input></li>
                    </ul>  
                </div>
                <div class="search_criteria">
                    <div class="block_title">
                        <i></i>
                        <p>Тип печати</p>
                    </div>
                    <ul class="check_boxes">
                        <li><input type="checkbox" name="checkbox_type_print">Термо-струйная</input></li>
                        <li><input type="checkbox" name="checkbox_type_print">Пьезо-струйная</input></li>
                    </ul>  
                </div>
                <div class="search_criteria">
                        <div class="block_title">
                            <i></i>
                            <p>Подача метериала</p>
                        </div>
                        <ul class="check_boxes">
                            <li><input type="checkbox" name="checkbox_feed">Рулонный</input></li>
                            <li><input type="checkbox" name="checkbox_feed">Плоскопечатный</input></li>
                            <li><input type="checkbox" name="checkbox_feed">Гибридный</input></li>
                        </ul>
                    </div>
                <div class="search_criteria">
                        <div class="block_title">
                            <i></i>
                            <p>Цветность</p>
                        </div>
                        <ul class="check_boxes">
                                <li><input type="checkbox" name="checkbox_chromaticity">CMYK</input></li>
                                <li><input type="checkbox" name="checkbox_chromaticity">CMYK X 2</input></li>
                                <li><input type="checkbox" name="checkbox_chromaticity">CMYKLcLm</input></li>
                                <li><input type="checkbox" name="checkbox_chromaticity">CMYKLcLmOG</input></li>
                        </ul>
                    </div>
                <div class="search_criteria">
                        <div class="block_title">
                            <i></i>
                            <p>Производитель печатающей головки</p>
                        </div>
                        <ul class="check_boxes">
                                <li><input type="checkbox" name="checkbox_manufacturer_printhead">Spectra</input></li>
                                <li><input type="checkbox" name="checkbox_manufacturer_printhead">XAAR</input></li>
                                <li><input type="checkbox" name="checkbox_manufacturer_printhead">SPT</input></li>
                                <li><input type="checkbox" name="checkbox_manufacturer_printhead">Konika-Minolta</input></li>
                                <li><input type="checkbox" name="checkbox_manufacturer_printhead">Toshiba</input></li>
                                <li><input type="checkbox" name="checkbox_manufacturer_printhead">Ricoh</input></li>
                                <li><input type="checkbox" name="checkbox_manufacturer_printhead">Epson</input></li>
                                <li><input type="checkbox" name="checkbox_manufacturer_printhead">Lexmark</input></li>
                        </ul>
                    </div>
                <div class="search_criteria">
                        <div class="block_title">
                            <i></i>
                            <p>Тип печатающей головки</p>
                        </div>
                        <ul class="check_boxes">
                            <li><input type="checkbox" name="checkbox_type_printhead">Nova 256</input></li>
                            <li><input type="checkbox" name="checkbox_type_printhead">Galaxy 256</input></li>
                            <li><input type="checkbox" name="checkbox_type_printhead">Polyaris 512</input></li>
                            <li><input type="checkbox" name="checkbox_type_printhead">126/50</input></li>
                            <li><input type="checkbox" name="checkbox_type_printhead">126/80</input></li>
                            <li><input type="checkbox" name="checkbox_type_printhead">128/40</input></li>
                            <li><input type="checkbox" name="checkbox_type_printhead">128/80</input></li>
                            <li><input type="checkbox" name="checkbox_type_printhead">255</input></li>
                            <li><input type="checkbox" name="checkbox_type_printhead">256</input></li>
                            <li><input type="checkbox" name="checkbox_type_printhead">500</input></li>
                            <li><input type="checkbox" name="checkbox_type_printhead">510</input></li>
                            <li><input type="checkbox" name="checkbox_type_printhead">512</input></li>
                            <li><input type="checkbox" name="checkbox_type_printhead">512KN</input></li>
                            <li><input type="checkbox" name="checkbox_type_printhead">1020</input></li>                    
                            <li><input type="checkbox" name="checkbox_type_printhead">1024</input></li>
                            <li><input type="checkbox" name="checkbox_type_printhead">1024I</input></li>                    
                            <li><input type="checkbox" name="checkbox_type_printhead">CA3</input></li>
                            <li><input type="checkbox" name="checkbox_type_printhead">CA4</input></li>
                            <li><input type="checkbox" name="checkbox_type_printhead">Gen4</input></li>
                            <li><input type="checkbox" name="checkbox_type_printhead">Gen5</input></li>
                            <li><input type="checkbox" name="checkbox_type_printhead">DX2</input></li>
                            <li><input type="checkbox" name="checkbox_type_printhead">DX4</input></li>
                            <li><input type="checkbox" name="checkbox_type_printhead">DX5</input></li>
                            <li><input type="checkbox" name="checkbox_type_printhead">DX6</input></li>
                            <li><input type="checkbox" name="checkbox_type_printhead">DX7</input></li>
                        </ul>  
                    </div>
                <div class="search_criteria">
                        <div class="block_title">
                            <i></i>
                            <p>Совместимые чернила</p>
                        </div>
                        <ul class="check_boxes">
                                <li><input type="checkbox" name="checkbox_compatible_ink">Водные</input></li>
                                <li><input type="checkbox" name="checkbox_compatible_ink">Пигментные</input></li>
                                <li><input type="checkbox" name="checkbox_compatible_ink">Сублимационные </input></li>
                                <li><input type="checkbox" name="checkbox_compatible_ink">Экосольвентные</input></li>
                                <li><input type="checkbox" name="checkbox_compatible_ink">Сольвентные</input></li>
                                <li><input type="checkbox" name="checkbox_compatible_ink">UV-чернила</input></li>
                        </ul>
                    </div>
                <div class="search_criteria">
                        <div class="block_title">
                            <i></i>
                            <p>Тип капли</p>
                        </div>
                        <ul class="check_boxes">
                                <li><input type="checkbox" name="checkbox_type_drops">Постоянная</input></li>
                                <li><input type="checkbox" name="checkbox_type_drops">Переменная</input></li>
                        </ul>
                    </div>
                <div class="search_criteria">
                        <div class="block_title">
                            <i></i>
                            <p>Размер капли</p>
                        </div>
                        <ul class="check_boxes">
                            <li><input type="checkbox" name="checkbox_size_drops">1,5</input></li>
                            <li><input type="checkbox" name="checkbox_size_drops">2</input></li>
                            <li><input type="checkbox" name="checkbox_size_drops">4</input></li>
                            <li><input type="checkbox" name="checkbox_size_drops">8</input></li>
                            <li><input type="checkbox" name="checkbox_size_drops">12</input></li>
                            <li><input type="checkbox" name="checkbox_size_drops">15</input></li>
                            <li><input type="checkbox" name="checkbox_size_drops">20</input></li>
                            <li><input type="checkbox" name="checkbox_size_drops">30</input></li>
                            <li><input type="checkbox" name="checkbox_size_drops">35</input></li>
                            <li><input type="checkbox" name="checkbox_size_drops">40</input></li>
                            <li><input type="checkbox" name="checkbox_size_drops">80</input></li>   
                        </ul>
                    </div>
                <div class="search_criteria">
                        <div class="block_title">
                            <i></i>
                            <p>Скорость печати</p>
                        </div>
                        <ul class="check_boxes">
                           <div class="text_output">
                              <input type="text" class="amount-speed-print0">
                              <p>&nbsp;м.кв./ч. -&nbsp;</p>
                              <input type="text" class="amount-speed-print1">
                              <p>&nbsp;м.кв./ч.</p> 
                           </div>

                            <div class="slider" >
                                <div class="slider-range-speed-print" ></div>
                            </div>
                        </ul>
                    </div>
                <div class="search_criteria">
                        <div class="block_title">
                            <i></i>
                            <p>Разрешение печати</p>
                        </div>
                        <ul class="check_boxes">
                            <li><input type="checkbox" name="checkbox_print_resolution">360dpi</input></li>
                            <li><input type="checkbox" name="checkbox_print_resolution">600dpi</input></li>
                            <li><input type="checkbox" name="checkbox_print_resolution">720dpi</input></li>
                            <li><input type="checkbox" name="checkbox_print_resolution">1200dpi</input></li>
                            <li><input type="checkbox" name="checkbox_print_resolution">1440dpi</input></li>
                            <li><input type="checkbox" name="checkbox_print_resolution">2880dpi</input></li>
                        </ul>
                    </div>
                <div class="search_criteria">
                    <div class="block_title">
                        <i></i>
                        <p>Производитель оборудования</p>
                    </div>
                    <ul class="check_boxes">
                        <li><input type="checkbox" name="checkbox_equipment_manufacturer">Mimaki</input></li>
                        <li><input type="checkbox" name="checkbox_equipment_manufacturer">Roland</input></li>
                        <li><input type="checkbox" name="checkbox_equipment_manufacturer">Mutoh</input></li>
                        <li><input type="checkbox" name="checkbox_equipment_manufacturer">HP</input></li>
                        <li><input type="checkbox" name="checkbox_equipment_manufacturer">OCE</input></li>
                        <li><input type="checkbox" name="checkbox_equipment_manufacturer">Agfa</input></li>
                        <li><input type="checkbox" name="checkbox_equipment_manufacturer">LIYU</input></li>
                        <li><input type="checkbox" name="checkbox_equipment_manufacturer">Infinity</input></li>
                        <li><input type="checkbox" name="checkbox_equipment_manufacturer">Gonzeng</input></li>
                        <li><input type="checkbox" name="checkbox_equipment_manufacturer">Jong Ye</input></li>
                    </ul>
                </div>
                <div class="search_criteria">
                    <div class="block_title">
                        <i></i>
                        <p>Интерфейс подключения</p>
                    </div>
                    <ul class="check_boxes">
                        <li><input type="checkbox" name="checkbox_interface_connection">SCSI</input></li>
                        <li><input type="checkbox" name="checkbox_interface_connection">PCI Adapter</input></li>
                        <li><input type="checkbox" name="checkbox_interface_connection">USB</input></li>
                        <li><input type="checkbox" name="checkbox_interface_connection">Fire-Wire</input></li>
                    </ul>
                </div>
                <div class="search_criteria">
                    <div class="block_title">
                        <i></i>
                        <p>Максимальная толщина носителя</p>
                    </div>
                    <ul class="check_boxes">
                        <div class="text_output">
                          <input type="text" class="amount-maximum_media_thickness60_0">
                          <p>&nbsp;мм -&nbsp;</p>
                          <input type="text" class="amount-maximum_media_thickness60_1">
                          <p>&nbsp;мм</p> 
                        </div>
                        <div class="slider" >
                            <div class="slider-range-maximum_media_thickness60" ></div>
                        </div>
                        <br>
                        <div class="text_output">
                          <input type="text" class="amount-maximum_media_thickness500_0">
                          <p>&nbsp;мм -&nbsp;</p>
                          <input type="text" class="amount-maximum_media_thickness500_1">
                          <p>&nbsp;мм</p> 
                        </div>
                        <div class="slider" >
                            <div class="slider-range-maximum_media_thickness500" ></div>
                        </div>                   
                    </ul>
                </div>
                <div class="search_criteria">
                    <div class="block_title">
                        <i></i>
                        <p>Максимальный вес носителя</p>
                    </div>
                    <ul class="check_boxes">
                        <div class="text_output">
                            <input type="text" class="amount-maximum_weight_of_vehicle0">
                            <p>&nbsp;кг -&nbsp;</p>
                            <input type="text" class="amount-maximum_weight_of_vehicle1">
                            <p>&nbsp;кг</p> 
                        </div>
                        <div class="slider" >
                            <div class="slider-range-maximum_weight_of_vehicle" ></div>
                        </div>
                    </ul>
                </div>
                <div class="search_criteria">
                    <div class="block_title">
                        <i></i>
                        <p>П/О RIP</p>
                    </div>
                    <ul class="check_boxes">
                        <li><input type="checkbox" name="checkbox_RIP">ONYX Graphics</input></li>
                        <li><input type="checkbox" name="checkbox_RIP">SA International/PhotoPRINT™ Family</input></li>
                        <li><input type="checkbox" name="checkbox_RIP">Wasatch SOFTRIP</input></li>
                        <li><input type="checkbox" name="checkbox_RIP">ColorGATE Productionserver</input></li>
                        <li><input type="checkbox" name="checkbox_RIP">Poster Print</input></li>
                    </ul>
                </div>
                <div class="search_criteria">
                    <div class="block_title">
                        <i></i>
                        <p>Максимальная потребляемая мощность</p>
                    </div>
                    <ul class="check_boxes">
                        <div class="text_output">
                            <input type="text" class="amount-max_power_consumption0">
                            <p>&nbsp;кВт -&nbsp;</p>
                            <input type="text" class="amount-max_power_consumption1">
                            <p>&nbsp;кВт</p> 
                        </div>
                        <div class="slider" >
                            <div class="slider-range-max_power_consumption" ></div>
                        </div>
                    </ul>
                </div>
                <div class="search_criteria">
                    <div class="block_title">
                        <i></i>
                        <p>Вес</p>
                    </div>
                    <ul class="check_boxes">
                        <div class="text_output">
                            <input type="text" class="amount-weight0">
                            <p>&nbsp;кг -&nbsp;</p>
                            <input type="text" class="amount-weight1">
                            <p>&nbsp;кг</p> 
                        </div>
                        <div class="slider" >
                            <div class="slider-range-weight" ></div>
                        </div>
                    </ul>
                </div>
                <div class="search_criteria">
                    <div class="block_title">
                        <i></i>
                        <p>Ширина</p>
                    </div>
                    <ul class="check_boxes">
                        <div class="text_output">
                            <input type="text" class="amount-width0">
                            <p>&nbsp;м -&nbsp;</p>
                            <input type="text" class="amount-width1">
                            <p>&nbsp;м</p> 
                        </div>
                        <div class="slider" >
                            <div class="slider-range-width" ></div>
                        </div>
                    </ul>
                </div>
                <div class="search_criteria">
                    <div class="block_title">
                            <i></i>
                            <p>Высота</p>
                        </div>
                    <ul class="check_boxes">
                        <div class="text_output">
                            <input type="text" class="amount-heigth0">
                            <p>&nbsp;м -&nbsp;</p>
                            <input type="text" class="amount-heigth1">
                            <p>&nbsp;м</p> 
                        </div>
                        <div class="slider" >
                            <div class="slider-range-heigth" ></div>
                        </div>
                    </ul>
                </div>
                <div class="search_criteria">
                    <div class="block_title">
                        <i></i>
                        <p>Глубина</p>
                    </div>
                    <ul class="check_boxes">
                        <div class="text_output">
                            <input type="text" class="amount-depth0">
                            <p>&nbsp;м -&nbsp;</p>
                            <input type="text" class="amount-depth1">
                            <p>&nbsp;м</p> 
                        </div>
                        <div class="slider" >
                            <div class="slider-range-depth" ></div>
                        </div>
                    </ul>
                </div>
            </div>
            <div id="reklam">
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

        <div id="out_result_of_search">
            <c:forEach items="${listPrinters}" var="printer">
            	<a href="<c:url value='/product/printer/${printer.id}' />" class="printer">
				    <div class="printer_image"><img src="<%=request.getContextPath()%>/resources/img/1.png" alt="" /></div>
				    <p class="printer_title">${printer.name}</p>
                    <p class="printer_price">${printer.prise} $</p>
                    <div class="printer_buy"><img src="<%=request.getContextPath()%>/resources/images/button_buy.jpg" alt="" /></div>
				</a>
			</c:forEach>
        </div>
        
    </div>
    
<div id="footer"></div>
    <script>
        $( function() {
           $("#full_menu").click(function(){ 
              if ( $(".menu").css('display') == 'none' ) {
                     $(".menu").slideDown(1000);
                      } else {
                     $(".menu").slideUp(400);
                     }
              });
        } );       
    </script>
</body>
</html>