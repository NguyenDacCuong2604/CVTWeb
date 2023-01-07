<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Đổi mật khẩu</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
  <link rel="stylesheet" href="CSS/stylesheet.css">
  <script src="JQuery/jquery-2.1.1.min.js" type="text/javascript"></script>
  <link rel="stylesheet" href="Bootstrap/bootstrap.min.css" media="screen">
  <script src="Bootstrap/bootstrap.min.js" type="text/javascript"></script>
  <script src="JS/Custom.js" type="text/javascript"></script>
</head>
<body>
  <jsp:include page="Layout/Header.jsp" />
  <div id="myaccount" class="container">
    <ul class="breadcrumb">
      <li><a href="index.jsp"><i class="fa fa-home"></i></a></li>
     <li><a href="MyAccount.jsp">Tài khoản của tôi</a></li>
      <li><a href="Changepassword.jsp">Đổi mật khẩu</a></li>
    </ul>
    <div class="row">
      <jsp:include page="/Layout/MenuBarAccount.jsp" />
      <div id="content" class="col-sm-9">
        <h1 class="page_title">Thay đổi mật khẩu</h1>
        <form action="ChangePassword" method="post"class="form-horizontal">
          <fieldset>
            <legend>Mật khẩu của bạn</legend>
            <div class="form-group required">
              <label class="col-sm-2 control-label" for="input-password">Mật khẩu cũ</label>
              <div class="col-sm-10">
                <input type="password" name="password" value="" placeholder="Mật khẩu cũ" id="input-password" class="form-control">
              </div>
            </div>
            <div class="form-group required">
              <label class="col-sm-2 control-label" for="input-password">Mật khẩu mới</label>
              <div class="col-sm-10">
                <input type="password" name="newpassword" value="" placeholder="Mật khẩu mới" id="input-newpassword" class="form-control">
              </div>
            </div>
            <div class="form-group required">
              <label class="col-sm-2 control-label" for="input-confirm">Xác nhận mật khẩu</label>
              <div class="col-sm-10">
                <input type="password" name="confirm" value="" placeholder="Xác nhận mật khẩu" id="input-confirm" class="form-control">
              </div>
            </div>
          </fieldset>
          <div class="buttons clearfix">
            <div class="pull-left"><a href="MyAccount.jsp" class="btn btn-default">Trở về</a></div>
            <div class="pull-right">
              <input type="submit" value="Tiếp tục" class="btn btn-primary">
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
    <jsp:include page="/Layout/Footer.jsp" />
</body>
</html>
