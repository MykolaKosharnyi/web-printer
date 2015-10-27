<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/home.css"/>
    
	<title>Print Master</title>
	
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
	<script type="text/javascript">
		$(function() {
			$('#gallery').jGallery({
				mode : 'slider',
				utostart : true,
				width : '100%',
				height : '100%',
				transitionBackward : 'auto',
				transition : 'rotateFoldTop_moveFromBottomFade',
				transitionCols : '6',
				transitionRows : '1',
				thumbnailsPosition : 'bottom',
				thumbType : 'square',
				backgroundColor : 'FFFFFF',
			});
		});
	</script>
</body>
</html>