<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>	
	<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p>Общие характеристики</p>
			</div>
			<div class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Средняя потребляемая мощность</p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="averagePowerConsumption0" class="amount-averagePowerConsumption0" value="${search.averagePowerConsumption0}" />
							<p>&nbsp;Вт -&nbsp;</p>
							<form:input path="averagePowerConsumption1" class="amount-averagePowerConsumption1" value="${search.averagePowerConsumption1}" />
							<p>&nbsp;Вт</p>
						</div>
							<div class="slider-range-averagePowerConsumption"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Максимальная потребляемая мощность</p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="maxPowerConsumption0" class="amount-max_power_consumption0" value="${search.maxPowerConsumption0}" />
							<p>&nbsp;Вт -&nbsp;</p>
							<form:input path="maxPowerConsumption1" class="amount-max_power_consumption1" value="${search.maxPowerConsumption1}" />
							<p>&nbsp;Вт</p>
						</div>
							<div class="slider-range-max_power_consumption"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Вес</p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="weight0" class="amount-weight0" value="${search.weight0}" />
							<p>&nbsp;кг -&nbsp;</p>
							<form:input path="weight1" class="amount-weight1" value="${search.weight1}" />
							<p>&nbsp;кг</p>
						</div>
							<div class="slider-range-weight"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Ширина</p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="width0" class="amount-width0" value="${search.width0}" />
							<p>&nbsp;мм -&nbsp;</p>
							<form:input path="width1" class="amount-width1" value="${search.width1}" />
							<p>&nbsp;мм</p>
						</div>
						<div class="slider-range-width"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Высота</p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="heigth0" class="amount-heigth0" value="${search.heigth0}" />
							<p>&nbsp;мм -&nbsp;</p>
							<form:input path="heigth1" class="amount-heigth1" value="${search.heigth1}" />
							<p>&nbsp;мм</p>
						</div>
							<div class="slider-range-heigth"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Глубина</p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="depth0" class="amount-depth0" value="${search.depth0}" />
							<p>&nbsp;мм -&nbsp;</p>
							<form:input path="depth1" class="amount-depth1" value="${search.depth1}" />
							<p>&nbsp;мм</p>
						</div>
							<div class="slider-range-depth"></div>
					</div>
				</div>
			</div>
		</div>