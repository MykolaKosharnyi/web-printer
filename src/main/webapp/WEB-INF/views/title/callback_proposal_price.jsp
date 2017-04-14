<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="callback_proposal_price" class="modal fade">
	<div class="modal-dialog" style="width:300px;">
		<div class="modal-content">
			<div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                
                <c:if test="${pageContext.request.userPrincipal.name != null}">
					<h5 class="modal-title">Пожалуйста оставьте цену за товар, через некоторое время мы с вами свяжемся</h5>
				</c:if>
                
                <c:if test="${pageContext.request.userPrincipal.name == null}">
					<h5 class="modal-title">Пожалуйста оставьте Ваши координаты и цену за товар, через некоторое время мы с вами свяжемся</h5>
				</c:if>
                
            </div>
            <div class="modal-body" style="padding: 5px 5px 0px 5px;">

					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<input type="hidden" name="logined" value="true"></input>
					</c:if>
					
					<c:if test="${pageContext.request.userPrincipal.name == null}">
						<input type="hidden" name="logined" value="false"></input>

						<div class="form-group">
							<label style="font-size: 13px; margin: 5px;">Введите имя:</label>
							<input type="text" class="form-control" name="name"></input>
						</div>

						<div class="form-group">
							<label style="font-size: 13px; margin: 5px;">Введите e-mail:</label>
							<input type="email" class="form-control" name="email"></input>
						</div>

						<div class="form-group">
							<label style="font-size: 13px; margin: 5px;">Введите номер телефона:</label>
							<input type="text" class="form-control" name="phonenumber"></input>
						</div>
						
						<div class="form-group">
							<hr style="border: 0.5px solid rgb(0, 96, 128);">
						</div>
					</c:if>
					
					<div id="proposal_product_link" class="form-group">
						<input type="hidden" name="typeProduct" value=""></input>
						<input type="hidden" name="idProduct" value=""></input>
						<img src="" class="col-sm-6 img-rounded" />
						<div class="col-sm-6" style="font-size: 14px;">
							<a href=""></a>
						</div>
					</div>
					
					<div class="form-group">
						<label style="font-size: 13px; margin: 5px;">Ваша цена за товар:</label> 
						<input type="text" class="form-control" name="price"></input>
					</div>			
					
					<div class="form-group">
						<label style="font-size: 13px; margin: 5px;">Сопроводительный текст:</label> 
						<textarea rows="3" cols="1" name="description" class="form-control"></textarea>
					</div>		
			</div>
            <div class="modal-footer">
            	<button class="btn btn-success">Уточнить</button>
				<button class="btn btn-danger button-close" data-dismiss="modal">Закрыть</button>
            </div>
		</div>
	</div>	
</div>	