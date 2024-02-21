<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giao dịch được thực hiện hoàn tất</title>
 <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"
    />
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
      crossorigin="anonymous"
    ></script>
</head>
<body style="font-size: 0.9rem;">

    <div class="container">
         
        

<p style="text-align: center">Giao dịch được thực hiện thành công. Cảm ơn quý khách đã sử dụng dịch vụ</p>
<div class="row">
    <table class="table table-striped table-hover table-hover">
        <thead>
            <tr>
                <th>Name</th>
                <th>Value</th>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Merchant ID</td>
                <td>CTTVNP01</td>
                <td>Được cấp bởi VNPAY</td>
            </tr>
			<tr>
                <td>Merchant Name</td>
                <td>VNPAY Demo</td>
                <td>Tên Website Merchant</td>
            </tr>
            <tr>
                <td>Merchant Transaction Reference</td>
                <td>174938</td>
                <td>Mã GD của website merchant</td>
            </tr>
            <tr>
                <td>Transaction Info</td>
                <td>Thanh toan don hang thoi gian: 2024-02-21 19:21:03</td>
                <td>Thông tin mô tả từ website merchant</td>
            </tr>
            <tr>
                <td>Amount</td>
                <td>10000</td>
                <td>Số tiền được thanh toán</td>
            </tr>
            <tr>
                <td>Current Code</td>
                <td>VND</td>
                <td>Đơn vị tiền tệ được thanh toán</td>
            </tr>
            <tr>
                <td>Transaction Response Code</td>
                <td>00</td>
                <td>Trạng thái GD</td>
            </tr>
            <tr>
                <td>Message</td>
                <td>Giao dịch được thực hiện thành công. Cảm ơn quý khách đã sử dụng dịch vụ</td>
                <td>Thông báo từ cổng thanh toán</td>
            </tr>
            <tr>
                <td>Transaction Number</td>
                <td>14302748</td>
                <td>Mã GD trên cổng thanh toán</td>
            </tr>
            <tr>
                <td>Bank</td>
                <td>NCB</td>
                <td>Ngân hàng GD</td>
            </tr>
        </tbody>
    </table>
</div>
<P style="text-align: center">
    <a  id="btnClose" class="btn btn-primary" href="http://localhost:8080/home">Về Trang Chủ</a>
</P>

       
    </div> <!-- /container -->
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/tryitnow/Styles/js/ie10-viewport-bug-workaround.js"></script>
    
    <script>

    </script>
</body>
</html>