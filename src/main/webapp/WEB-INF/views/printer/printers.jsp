<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	 <div id="out_result_of_search">
            <c:forEach items="${listProducts}" var="product">
            	<a href="<c:url value='/printer/${product.id}' />" class="products">
				    <div class="products_image"><img src="<%=request.getContextPath()%>/resources/images/printers/${product.id}/${product.pathPictures.get(0)}" alt=""></div>
				    <p class="products_title">${product.name}</p>
                    <p class="products_price">${product.prise} $</p>
                    <div class="products_buy"><img src="<%=request.getContextPath()%>/resources/images/button_buy.jpg" alt="" /></div>
				</a>
			</c:forEach>
    </div>
