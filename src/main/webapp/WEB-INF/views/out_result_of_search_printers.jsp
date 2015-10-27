<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <div id="out_result_of_search">
            <c:forEach items="${listPrinters}" var="printer">
            	<a href="<c:url value='/printer/${printer.id}' />" class="printer">
				    <div class="printer_image"><img src="<%=request.getContextPath()%>/resources/images/printers/${printer.id}/${printer.pathPictures.get(0)}" alt=""></div>
				    <p class="printer_title">${printer.name}</p>
                    <p class="printer_price">${printer.prise} $</p>
                    <div class="printer_buy"><img src="<%=request.getContextPath()%>/resources/images/button_buy.jpg" alt="" /></div>
				</a>
			</c:forEach>
        </div>