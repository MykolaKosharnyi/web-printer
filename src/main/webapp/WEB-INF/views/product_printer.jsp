<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style_product.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style_head_and_footer.css"/>
	
	<title>Output product</title>
	<script src="<%=request.getContextPath()%>/resources/js/jquery-2.1.4.min.js"></script>
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
         <div id="product">
           <p>${printer.name}</p>
            <div id="pictures_and_descriptions">
			<div id="pictures">
				<div class="image_container">
					<img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt="">
				</div>
				<div class="small_pictures">
					<div><img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt=""></div>
					<div><img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt=""></div>
					<div><img src="<%=request.getContextPath()%>/resources/images/head/progo1.jpg" alt=""></div>
					<div></div>
					<div></div>
					<div></div>
					<div></div>
					<div></div>
					<div></div>
					<div></div>
					<div></div>
				</div>
			</div>
                <div id="descriptions">
                    <table>
                       <caption></caption> 
                       <tr><td>Цена:</td><td>$ ${printer.prise}.</td></tr>
                       <tr><td>Тип принтера:</td><td>${printer.typePrinter}</td></tr>
                       <tr><td>Партный номер принтера:</td><td>${printer.partNumber}</td></tr>
                       <tr><td>Модель:</td><td>${printer.equipmentModel}</td></tr>
                       <tr><td>Ширина печати в миллиметрах:</td><td>${printer.weightPrintMM} mm</td></tr>
                       <tr><td>Предыдущее использование:</td><td>${printer.previouslyUsed}</td></tr>
                       <tr><td>Тип печати:</td><td>
	                   		<c:forEach var="tp" items="${printer.typePrint}">  
	    						${tp}<br>  
							</c:forEach>
                       </td></tr>
                       <tr><td>Подача материала:</td><td>
	                   		<c:forEach var="tp" items="${printer.feed}">  
	    						${tp}<br>  
							</c:forEach>
                       </td></tr>
                       <tr><td>Цветность:</td><td>
	                   		<c:forEach var="tp" items="${printer.chromaticity}">  
	    						${tp}<br>  
							</c:forEach>                       
                       </td></tr>
                       <tr><td>Производитель печатающей головки:</td><td>${printer.manufacturerPrinthead}</td></tr>
                       <tr><td>Тип печатающей головки:</td><td>${printer.typeOfPrinthead}</td></tr>
                       <tr><td>Совместимые чернила:</td><td>
	                   		<c:forEach var="tp" items="${printer.compatibleInk}">  
	    						${tp}<br>  
							</c:forEach>                       
                       </td></tr>
                       <tr><td>Тип капли:</td><td>
	                   		<c:forEach var="tp" items="${printer.typeDrops}">  
	    						${tp}<br>  
							</c:forEach>                        
                       </td></tr>
                       <tr><td>Размер капли:</td><td>
	                   		<c:forEach var="tp" items="${printer.sizeDrops}">  
	    						${tp} мм<br>  
							</c:forEach>                        
                       </td></tr>
                       <tr><td>Скорость печати:</td><td>${printer.speedPrint} м.кв./ч.</td></tr>
                       <tr><td>Разрешение печати:</td><td>
	                   		<c:forEach var="tp" items="${printer.printResolution}">  
	    						${tp}<br>  
							</c:forEach>                        
                       </td></tr>
                       <tr><td>Производитель оборудования:</td><td>${printer.equipmentManufacturer}</td></tr>
                       <tr><td>Интерфейс подключения:</td><td>
	                   		<c:forEach var="tp" items="${printer.interfaceConnection}">  
	    						${tp}<br>  
							</c:forEach>                       
                       </td></tr>
                       <tr><td>Максимальная толщина носителя:</td><td>${printer.maximumMediaThickness} мм</td></tr>
                       <tr><td>Максимальный вес носителя:</td><td>${printer.maximumWeightOfVehicle} кг</td></tr>
                       <tr><td>П/О RIP:</td><td>
	                   		<c:forEach var="tp" items="${printer.rip}">  
	    						${tp}<br>  
							</c:forEach>                        
                       </td></tr>
                       <tr><td>Максимальная потребляемая мощность:</td><td>${printer.maxPowerConsumption} кВт</td></tr>
                       <tr><td>Вес:</td><td>${printer.weight} кг</td></tr>
                       <tr><td>Ширина:</td><td>${printer.width} м</td></tr>
                       <tr><td>Высота:</td><td>${printer.heigth} м</td></tr>
                       <tr><td>Глубина:</td><td>${printer.depth} м</td></tr>
                       <tr><td>Описание:</td><td>${printer.description}</td></tr>
                  </table>
                </div>
            </div>
            <div id="tabs">
                <ul>
                    <li>Описание</li>
                    <li>Технические характеристики</li>
                    <li>Отзывы</li>
                    <li>Используется с другими товарами</li>
                </ul>
                <div>
                    <div>Первое содержимое</div>
                    <div>
                        <table>
                           <caption>Характеристики:</caption>
                           <tr><td>Характеристика:</td><td>значение</td></tr>
                           <tr><td>Характеристика:</td><td>значение</td></tr>
                           <tr><td>Характеристика:</td><td>значение</td></tr>
                           <tr><td>Характеристика:</td><td>значение</td></tr>
                           <tr><td>Характеристика:</td><td>значение</td></tr>
                           <tr><td>Характеристика:</td><td>значение</td></tr>
                           <tr><td>Характеристика:</td><td>значение</td></tr>
                           <tr><td>Характеристика:</td><td>значение</td></tr>
                           <tr><td>Характеристика:</td><td>значение</td></tr>
                           <tr><td>Характеристика:</td><td>значение</td></tr>
                           <tr><td>Характеристика:</td><td>значение</td></tr>
                           <tr><td>Характеристика:</td><td>значение</td></tr>
                           <tr><td>Характеристика:</td><td>значение</td></tr>
                           <tr><td>Характеристика:</td><td>значение</td></tr>
                           <tr><td>Характеристика:</td><td>значение</td></tr>
                           <tr><td>Характеристика:</td><td>значение</td></tr>
                        </table>
                    </div>
                    <div>Третье содержимое</div>
                    <div>Четвертое содержимое</div>
                </div>            
            </div> 
        </div>
    </div>
    <div id="footer">
	</div>
    <script type="text/javascript">
        $( function() {
           $("#full_menu").click(function(){
               if ( $(".menu").css('display') == 'none' ) {
                     $(".menu").slideDown(1400);
                      } else {
                     $(".menu").slideUp(1400);
                     }
              });
        } );       
    </script>
    <script>
(function($){				
    jQuery.fn.lightTabs = function(options){
        
        var createTabs = function(){
            tabs = this;
            i = 0;
            
            showPage = function(i){
                $(tabs).children("div").children("div").hide();
                $(tabs).children("div").children("div").eq(i).show();
                $(tabs).children("ul").children("li").removeClass("active");
                $(tabs).children("ul").children("li").eq(i).addClass("active");
            }
            
            showPage(0);				
            
            $(tabs).children("ul").children("li").each(function(index, element){
                $(element).attr("data-page", i);
                i++;                        
            });
            
            $(tabs).children("ul").children("li").click(function(){
                showPage(parseInt($(this).attr("data-page")));
            });				
        };		
        return this.each(createTabs);
    };	
})(jQuery);
$(document).ready(function(){
    $("#tabs").lightTabs();
});
    </script>
</body>
</html>