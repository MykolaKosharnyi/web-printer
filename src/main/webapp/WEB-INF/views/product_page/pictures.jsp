<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="pictures">
	<div class="col-md-10 col-sm-10 col-xs-10">
		<div class="row bigImage">
			<a class="fancybox" data-fancybox-group="group" href="/images/${type}s/${product.id}/${product.pathPictures.get(0)}">
				<img src="/images/${type}s/${product.id}/${product.pathPictures.get(0)}" alt="alt" />
			</a>				
		</div>
	</div>

	<div class="col-md-2 col-sm-2 col-xs-2">
		<div class="row">
			<div class="small_pictures">
				<c:forEach items="${product.pathPictures}" var="pathPicture">
					<a class="fancybox" data-fancybox-group="group" href="/images/${type}s/${product.id}/${pathPicture}">
						<img src="/images/${type}s/${product.id}/${pathPicture}" alt="alt" />
					</a>
				</c:forEach>
			</div>
		</div>
	</div>
</div>