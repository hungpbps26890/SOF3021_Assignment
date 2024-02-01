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
    
    
    <div class="tm-main-section light-gray-bg">
      <div class="container" id="main">
      
      	<section class="tm-section row">
          <div class="col-lg-12 tm-section-header-container margin-bottom-30">
            <h2 class="tm-section-header gold-text tm-handwriting-font"><img src="/assets/user/img/logo.png" alt="Logo" class="tm-site-logo"> Your Cart</h2>
            <div class="tm-hr-container"><hr class="tm-hr"></div>
          </div>
          <div> 
            <div class="tm-menu-product-content col-lg-12 col-md-12"> <!-- menu content -->
              <c:forEach var="item" items="${cart}">
              	<form action="/cart/update" method="post">
              		<input type="hidden" name="id" value="${item.id}">
              		<div class="tm-product row" style="margin-left: 0; max-width: 100%">
	              		<div class="col-md-4">
	              			<img src="/images/${item.image}" class="img-thumbnail">
	              		</div>
		                
		                <div class="tm-product-text col-md-6">
		                  <a href="/drink/${item.id}" style="text-decoration: none;">
		                  	<h3 class="tm-product-title">${item.name}</h3>
		                  </a>
		                  <h4 class="tm-product-description">${item.price * item.quantity} đ</h4>
		                  <input
			                type="number"
			                class="form-control"
			                min="1"
			                name="quantity"
			                value="${item.quantity}"
			                onclick="this.form.submit()"
			                style="width: 70px; margin-top: 10px"
			              />
		                </div>
		                <div class="tm-product-price col-md-2">
		                  <a href="cart/delete/${item.id}" class="tm-product-price-link tm-handwriting-font" style="padding: 24px 14px;">Delete</a>
		                </div>
		              </div>
              	</form>
              </c:forEach>
            </div>

		    <div class="col-lg-12 tm-section-header-container margin-bottom-30">
	            <h2 class="tm-section-header gold-text tm-handwriting-font" style="width: 100%"><img src="/assets/user/img/logo.png" alt="Logo" class="tm-site-logo"> Total (${count} product): ${amount} <span class="tm-handwriting-font gold-text" style="font-size: 20px">đ</span></h2>
	          </div>
            
            <div class="col-lg-12 row">
              	<div class="col-md-3">
              		<button class="tm-more-button">CHECK OUT</button> 
              	</div>
              		
              	<div class="col-md-3">
              		<a class="tm-more-button" href="/cart/clear">CLEAR CART</a> 
              	</div>
                
              </div>               
            </div>
          </div>          
        </section>
        
      </div>
    </div> 
    
    <%@ include file="/layout/user/_footer.jsp" %>

 </body>
 </html>