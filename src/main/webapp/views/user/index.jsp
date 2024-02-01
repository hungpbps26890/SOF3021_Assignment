<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/common/_tablib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Cafe House</title>
  <%@ include file="/layout/user/_head.jsp" %>
	
  </head>
  <body>
  
    <%@ include file="/layout/user/_header.jsp" %>
    
    <%@ include file="/layout/user/_welcome.jsp" %>
    
    <div class="tm-main-section light-gray-bg">
      <div class="container" id="main">
                
        <section class="tm-section tm-section-margin-bottom-0 row">
          <div class="col-lg-12 tm-section-header-container">
            <h2 class="tm-section-header gold-text tm-handwriting-font"><img src="/assets/user/img/logo.png" alt="Logo" class="tm-site-logo"> Popular Items</h2>
            <div class="tm-hr-container"><hr class="tm-hr"></div>
          </div>
          <div class="col-lg-12 tm-popular-items-container">
            <c:forEach var="drink" items="${drinks}">
            	<div class="tm-popular-item">
	              <img src="/images/${drink.drinkImage}" class="img-thumbnail">
	              
	              <div class="tm-popular-item-description">
	                <h3 class="tm-handwriting-font tm-popular-item-title" style="margin-bottom: 7px">${drink.price} <span class="tm-handwriting-font tm-popular-item-title" style="font-size: 20px">đ</span> </h3><hr class="tm-popular-item-hr">
	                <h4>${drink.name }</h4>
	                <div class="order-now-container">
	                  <a href="/drink/${drink.id}" class="order-now-link tm-handwriting-font">Order Now</a>
	                </div>
	              </div>              
	            </div>
            </c:forEach>
            
          </div>          
        </section>
        
        <%@ include file="/layout/user/_daily_menu.jsp" %>
        
      </div>
    </div> 
    
    <%@ include file="/layout/user/_footer.jsp" %>

 </body>
 </html>