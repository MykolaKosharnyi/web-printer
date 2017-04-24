<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="callback_proposal_price" class="modal fade">
	<div class="modal-dialog" style="width:400px;">
		<div class="modal-content">
			<div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>              
				<h5 class="modal-title">Форма обратной связи</h5>
            </div>
            <div class="modal-body" style="padding: 5px 5px 0px 5px;">

					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<input type="hidden" name="logined" value="true"></input>
					</c:if>
					
					<c:if test="${pageContext.request.userPrincipal.name == null}">
						<input type="hidden" name="logined" value="false"></input>

						<div class="form-group">
							<span style="color: red; top: -2px; position: relative;">*</span><label style="font-size: 13px; margin: 5px;"> Имя:</label>
							<input type="text" class="form-control" name="name"></input>
							<p class="bg-danger info_of_empty_field">Поле должно быть заполнено.</p>
						</div>

						<div class="form-group">
							<span style="color: red; top: -2px; position: relative;">*</span>
							<label style="font-size: 13px; margin: 5px;">E-mail:</label>
							<input type="text" class="form-control" name="email" id="email_in_proposal"></input>
							<p class="bg-danger info_of_empty_field">Поле должно быть заполнено.</p>
							<p class="bg-success info_of_checking_email">Введенный e-mail корректен!</p>
			  				<p class="bg-danger info_of_checking_email">E-mail не корректен!</p>
						</div>

						<div class="form-group">
							<span style="color: red; top: -2px; position: relative;">*</span>						
							<label style="font-size: 13px; margin: 5px;">Телефон:</label>
							<input type="text" id="proposal_price_phone_number" placeholder="+38(099) 99-99-999"
							 class="form-control" name="phonenumber"></input>
							<p class="bg-danger info_of_empty_field">Поле должно быть заполнено.</p>
						</div>
						
						<div class="form-group">
							<hr style="border: 0.5px solid rgb(0, 96, 128);">
						</div>
					</c:if>
					
					<div id="proposal_product_link" class="form-group" style="height: 77px;">
						<input type="hidden" name="typeProduct" value=""></input>
						<input type="hidden" name="idProduct" value=""></input>
						<img src="" class="col-sm-6 img-rounded" />
						<div class="col-sm-6" style="font-size: 14px;">
							<a href=""></a>
						</div>
					</div>
					
					<div class="form-group">
						<label style="font-size: 13px; margin: 5px; width: 95%;">Если Вам  интересно данное оборудование отправьте  запрос для просчета  актуальной стоимости.
</label> 
					</div>			
					
					<div class="form-group">
						<span style="color: red; top: -2px; position: relative;">*</span>
						<label style="font-size: 13px; margin: 5px;">Примечание:</label> 
						<textarea rows="3" cols="1" name="description" class="form-control"></textarea>
						<p class="bg-danger info_of_empty_field">Поле должно быть заполнено.</p>
					</div>		
					
					<div class="form-group">
						<div class="especial_notes"><p>*</p>Обязательные поля для заполнения:</div>
					</div>	
			</div>
            <div class="modal-footer">
            	<button class="btn btn-success" id="proposal_price_button">Уточнить</button>
				<button class="btn btn-danger button-close" data-dismiss="modal">Закрыть</button>
            </div>
		</div>
	</div>	
</div>	

<div class="alert alert-success" id="sended_proposal_alert" role="alert">
  <label>Спасибо за ответ, скоро мы с Вами звяжемся.</label>
</div>