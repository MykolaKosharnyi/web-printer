<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	 <div id="out_result_of_search">
            <c:forEach items="${listPrinters}" var="product">
            	<a href="<c:url value='/printer/${product.id}' />" class="product">
				    <div class="product_image"><img src="<%=request.getContextPath()%>/resources/images/printers/${product.id}/${product.pathPictures.get(0)}" alt=""></div>
				    <p class="product_title">${product.name}</p>
                    <p class="product_price">${product.prise} $</p>
                    <div class="product_buy"><img src="<%=request.getContextPath()%>/resources/images/button_buy.jpg" alt="" /></div>
				</a>
			</c:forEach>
    </div>
