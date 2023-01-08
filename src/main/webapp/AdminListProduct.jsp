<%@ page import="Entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <meta name="description" content="Ekka - Admin Dashboard HTML Template.">

  <title>Danh sách sản phấm</title>

  <!-- GOOGLE FONTS -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@200;300;400;500;600;700;800&family=Poppins:wght@300;400;500;600;700;800;900&family=Roboto:wght@400;500;700;900&display=swap" rel="stylesheet">

  <link href="https://cdn.materialdesignicons.com/4.4.95/css/materialdesignicons.min.css" rel="stylesheet" />

  <!-- PLUGINS CSS STYLE -->
  <link href="assets/plugins/simplebar/simplebar.css" rel="stylesheet" />

  <!-- No Extra plugin used -->

  <link href='assets/plugins/data-tables/datatables.bootstrap5.min.css' rel='stylesheet'>
  <link href='assets/plugins/data-tables/responsive.datatables.min.css' rel='stylesheet'>

  <!-- ekka CSS -->
  <link id="ekka-css" rel="stylesheet" href="assets/css/ekka.css" />

  <!-- FAVICON -->
  <link href="assets/img/logoshop.png" rel="shortcut icon" />
</head>

<body class="ec-header-fixed ec-sidebar-fixed ec-sidebar-dark ec-header-light" id="body">

<!-- WRAPPER -->
<div class="wrapper">

  <!-- LEFT MAIN SIDEBAR -->
  <div class="ec-left-sidebar ec-bg-sidebar">
    <div id="sidebar" class="sidebar ec-sidebar-footer">

      <div class="ec-brand">
        <a href="index.html" title="CVT">
          <img class="ec-brand-icon" src="assets/img/logoshop.png" alt="" />
          <span class="ec-brand-name text-truncate">CVT Shop</span>
        </a>
      </div>

      <!-- begin sidebar scrollbar -->
      <div class="ec-navigation" data-simplebar>
        <!-- sidebar menu -->
        <ul class="nav sidebar-inner" id="sidebar-menu">
          <!-- Dashboard -->
          <li>
            <a class="sidenav-item-link" href="index.html">
              <i class="mdi mdi-view-dashboard-outline"></i>
              <span class="nav-text">Bảng điều khiển</span>
            </a>
            <hr>
          </li>
          <!-- Users -->
          <li class="has-sub">
            <a class="sidenav-item-link" href="javascript:void(0)">
              <i class="mdi mdi-account-group"></i>
              <span class="nav-text">Khách hàng</span> <b class="caret"></b>
            </a>
            <div class="collapse">
              <ul class="sub-menu" id="users" data-parent="#sidebar-menu">
                <li class="">
                  <a class="sidenav-item-link" href="user-list.html">
                    <span class="nav-text">Danh sách khách hàng</span>
                  </a>
                </li>
                <!-- <li class="">
                    <a class="sidenav-item-link" href="user-profile.html">
                        <span class="nav-text">Users Profile</span>
                    </a>
                </li> -->
              </ul>
            </div>
            <hr>
          </li>

          <!-- Products -->
          <li class="has-sub active expand">
            <a class="sidenav-item-link" href="javascript:void(0)">
              <i class="mdi mdi-palette-advanced"></i>
              <span class="nav-text">Các sản phẩm</span> <b class="caret"></b>
            </a>
            <div class="collapse show">
              <ul class="sub-menu" id="products" data-parent="#sidebar-menu">
                <li class="">
                  <a class="sidenav-item-link" href="product-add.html">
                    <span class="nav-text">Thêm sản phẩm</span>
                  </a>
                </li>
                <li class="active">
                  <a class="sidenav-item-link" href="product-list.html">
                    <span class="nav-text">Danh sách sản phẩm</span>
                  </a>
                </li>
                <!-- <li class="">
                    <a class="sidenav-item-link" href="product-detail.html">
                        <span class="nav-text">Product Detail</span>
                    </a>
                </li> -->
              </ul>
            </div>
          </li>

          <!-- Orders -->
          <li class="has-sub">
            <a class="sidenav-item-link" href="javascript:void(0)">
              <i class="mdi mdi-cart"></i>
              <span class="nav-text">Đơn hàng</span> <b class="caret"></b>
            </a>
            <div class="collapse">
              <ul class="sub-menu" id="orders" data-parent="#sidebar-menu">
                <li class="">
                  <a class="sidenav-item-link" href="new-order.html">
                    <span class="nav-text">Đơn hàng mới</span>
                  </a>
                </li>
                <!-- <li class="">
                    <a class="sidenav-item-link" href="order-history.html">
                        <span class="nav-text">Lịch sử đơn hàng</span>
                    </a>
                </li> -->
                <!-- <li class="">
                    <a class="sidenav-item-link" href="order-detail.html">
                        <span class="nav-text">Order Detail</span>
                    </a>
                </li> -->
                <!-- <li class="">
                    <a class="sidenav-item-link" href="invoice.html">
                        <span class="nav-text">Invoice</span>
                    </a>
                </li> -->
              </ul>
            </div>
          </li>
          <!-- Bài viết -->
          <!-- <li class="has-sub">
              <a class="sidenav-item-link" href="javascript:void(0)">
                  <i class="mdi mdi-palette-advanced"></i>
                  <span class="nav-text">Bài viết</span> <b class="caret"></b>
              </a>
          </li> -->
          <!-- Reviews -->
          <li>
            <a class="sidenav-item-link" href="review-list.html">
              <i class="mdi mdi-star-half"></i>
              <span class="nav-text">Nhận xét</span>
            </a>
          </li>

          <!-- Other Pages -->
          <!-- <li class="has-sub">
              <a class="sidenav-item-link" href="javascript:void(0)">
                  <i class="mdi mdi-image-filter-none"></i>
                  <span class="nav-text">Other Pages</span> <b class="caret"></b>
              </a>
              <div class="collapse">
                  <ul class="sub-menu" id="otherpages" data-parent="#sidebar-menu">
                      <li class="has-sub">
                          <a href="404.html">404 Page</a>
                      </li>
                  </ul>
              </div>
          </li> -->
        </ul>
      </div>
    </div>
  </div>

  <!-- PAGE WRAPPER -->
  <div class="ec-page-wrapper">

    <!-- Header -->
    <header class="ec-main-header" id="header">
      <nav class="navbar navbar-static-top navbar-expand-lg">
        <!-- Sidebar toggle button -->
        <button id="sidebar-toggler" class="sidebar-toggle"></button>
        <!-- search form. don't use -->
        <div class="search-form d-lg-inline-block">
        </div>

        <!-- navbar right -->
        <div class="navbar-right">
          <ul class="nav navbar-nav">
            <!-- User Account -->
            <li class="dropdown user-menu">
              <button class="dropdown-toggle nav-link ec-drop" data-bs-toggle="dropdown"
                      aria-expanded="false">
                <img src="assets/img/user/user.png" class="user-image" alt="User Image" />
              </button>
              <ul class="dropdown-menu dropdown-menu-right ec-dropdown-menu">
                <!-- User image -->
                <li class="dropdown-header">
                  <img src="assets/img/user/user.png" class="img-circle" alt="User Image" />
                  <div class="d-inline-block">
                    Admin CVT <small class="pt-1">
                    <p>adminCVT@gmail.com</p>
                  </small>
                  </div>
                </li>
                <li class="right-sidebar-in">
                  <a href="javascript:0"> <i class="mdi mdi-settings-outline"></i> Cài đặt </a>
                </li>
                <li class="dropdown-footer">
                  <a href="index.html"> <i class="mdi mdi-logout"></i> Đăng xuất </a>
                </li>
              </ul>
            </li>
            <li class="dropdown notifications-menu custom-dropdown">
              <button class="dropdown-toggle notify-toggler custom-dropdown-toggler">
                <i class="mdi mdi-bell-outline"></i>
              </button>

              <div class="card card-default dropdown-notify dropdown-menu-right mb-0">
                <div class="card-header card-header-border-bottom px-3">
                  <h2>Thông báo</h2>
                </div>
                <!-- noi dung thong bao -->
                <div class="card-body px-0 py-0">
                  <div class="tab-content" id="myNotifications">
                    <div class="tab-pane fade show active" id="home2" role="tabpanel">
                      <ul class="list-unstyled" data-simplebar style="height: 360px">
                        <li>
                          <a href="javscript:void(0)"
                             class="media media-message media-notification">
                            <div class="position-relative mr-3">
                              <img class="rounded-circle" src="assets/img/user/u2.jpg"
                                   alt="Image">
                              <span class="status away"></span>
                            </div>
                            <div class="media-body d-flex justify-content-between">
                              <div class="message-contents">
                                <h4 class="title">Nitin</h4>
                                <p class="last-msg">Lorem ipsum dolor sit, amet
                                  consectetur adipisicing elit. Nam itaque
                                  doloremque odio, eligendi delectus vitae.</p>

                                <span
                                        class="font-size-12 font-weight-medium text-secondary">
																		<i class="mdi mdi-clock-outline"></i> 30 min
																		ago...
																	</span>
                              </div>
                            </div>
                          </a>
                        </li>

                        <li>
                          <a href="javscript:void(0)"
                             class="media media-message media-notification media-active">
                            <div class="position-relative mr-3">
                              <img class="rounded-circle" src="assets/img/user/u1.jpg"
                                   alt="Image">
                              <span class="status active"></span>
                            </div>
                            <div class="media-body d-flex justify-content-between">
                              <div class="message-contents">
                                <h4 class="title">Lovina</h4>
                                <p class="last-msg">Donec mattis augue a nisl
                                  consequat, nec imperdiet ex rutrum. Fusce et
                                  vehicula enim. Sed in enim eu odio vehic.</p>

                                <span
                                        class="font-size-12 font-weight-medium text-white">
																		<i class="mdi mdi-clock-outline"></i> Just
																		now...
																	</span>
                              </div>
                            </div>
                          </a>
                        </li>

                        <li>
                          <a href="javscript:void(0)"
                             class="media media-message media-notification">
                            <div class="position-relative mr-3">
                              <img class="rounded-circle" src="assets/img/user/u5.jpg"
                                   alt="Image">
                              <span class="status away"></span>
                            </div>
                            <div class="media-body d-flex justify-content-between">
                              <div class="message-contents">
                                <h4 class="title">Crinali</h4>
                                <p class="last-msg">Lorem ipsum dolor sit, amet
                                  consectetur adipisicing elit. Nam itaque
                                  doloremque odio, eligendi delectus vitae.</p>

                                <span
                                        class="font-size-12 font-weight-medium text-secondary">
																		<i class="mdi mdi-clock-outline"></i> 1 hrs
																		ago...
																	</span>
                              </div>
                            </div>
                          </a>
                        </li>

                        <li>
                          <a href="javscript:void(0)"
                             class="media media-message media-notification event-active">

                            <div
                                    class="d-flex rounded-circle align-items-center justify-content-center mr-3 media-icon iconbox-45 bg-info text-white">
                              <i class="mdi mdi-calendar-check font-size-20"></i>
                            </div>

                            <div class="media-body d-flex justify-content-between">
                              <div class="message-contents">
                                <h4 class="title">Upcomming event added</h4>
                                <p class="last-msg font-size-14">03/Jan/2020 (1pm -
                                  2pm)</p>

                                <span
                                        class="font-size-12 font-weight-medium text-secondary">
																		<i class="mdi mdi-clock-outline"></i> 10 min
																		ago...
																	</span>
                              </div>
                            </div>
                          </a>
                        </li>

                        <li>
                          <a href="javscript:void(0)"
                             class="media media-message media-notification">

                            <div
                                    class="d-flex rounded-circle align-items-center justify-content-center mr-3 media-icon iconbox-45 bg-warning text-white">
                              <i class="mdi mdi-chart-areaspline font-size-20"></i>
                            </div>

                            <div class="media-body d-flex justify-content-between">
                              <div class="message-contents">
                                <h4 class="title">Yearly Sales report</h4>
                                <p class="last-msg font-size-14">Lorem ipsum dolor
                                  sit, amet consectetur adipisicing elit. Nam
                                  itaque doloremque odio, eligendi delectus vitae.
                                </p>

                                <span
                                        class="font-size-12 font-weight-medium text-secondary">
																		<i class="mdi mdi-clock-outline"></i> 1 hrs
																		ago...
																	</span>
                              </div>
                            </div>
                          </a>
                        </li>

                        <li>
                          <a href="javscript:void(0)"
                             class="media media-message media-notification">

                            <div
                                    class="d-flex rounded-circle align-items-center justify-content-center mr-3 media-icon iconbox-45 bg-primary text-white">
                              <i
                                      class="mdi mdi-account-multiple-check font-size-20"></i>
                            </div>

                            <div class="media-body d-flex justify-content-between">
                              <div class="message-contents">
                                <h4 class="title">New request</h4>
                                <p class="last-msg font-size-14">Add Dany Jones as
                                  your contact consequat nec imperdiet ex rutrum.
                                  Fusce et vehicula enim. Sed in enim.</p>

                                <span
                                        class="my-1 btn btn-sm btn-success">Accept</span>
                                <span
                                        class="my-1 btn btn-sm btn-secondary">Delete</span>

                                <span
                                        class="font-size-12 font-weight-medium text-secondary d-block">
																		<i class="mdi mdi-clock-outline"></i> 5 min
																		ago...
																	</span>
                              </div>
                            </div>
                          </a>
                        </li>

                        <li>
                          <a href="javscript:void(0)"
                             class="media media-message media-notification">

                            <div
                                    class="d-flex rounded-circle align-items-center justify-content-center mr-3 media-icon iconbox-45 bg-danger text-white">
                              <i class="mdi mdi-server-network-off font-size-20"></i>
                            </div>

                            <div class="media-body d-flex justify-content-between">
                              <div class="message-contents">
                                <h4 class="title">Server overloaded</h4>
                                <p class="last-msg font-size-14">Donec mattis augue
                                  a nisl consequat, nec imperdiet ex rutrum. Fusce
                                  et vehicula enim. Sed in enim eu odio vehic.</p>

                                <span
                                        class="font-size-12 font-weight-medium text-secondary">
																		<i class="mdi mdi-clock-outline"></i> 30 min
																		ago...
																	</span>
                              </div>
                            </div>
                          </a>
                        </li>

                        <li>
                          <a href="javscript:void(0)"
                             class="media media-message media-notification">

                            <div
                                    class="d-flex rounded-circle align-items-center justify-content-center mr-3 media-icon iconbox-45 bg-purple text-white">
                              <i class="mdi mdi-playlist-check font-size-20"></i>
                            </div>

                            <div class="media-body d-flex justify-content-between">
                              <div class="message-contents">
                                <h4 class="title">Task complete</h4>
                                <p class="last-msg font-size-14">Nam ut nisi erat.
                                  Ut quis tortor varius, hendrerit arcu quis,
                                  congue nisl. In scelerisque, sem ut ve.</p>

                                <span
                                        class="font-size-12 font-weight-medium text-secondary">
																		<i class="mdi mdi-clock-outline"></i> 2 hrs
																		ago...
																	</span>
                              </div>
                            </div>
                          </a>
                        </li>

                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </li>
            <li class="right-sidebar-in right-sidebar-2-menu">
              <i class="mdi mdi-settings-outline mdi-spin"></i>
            </li>
          </ul>
        </div>
      </nav>
    </header>
    <% List<Product> list = (List<Product>) request.getAttribute("listproduct"); %>
    <!-- CONTENT WRAPPER -->
    <div class="ec-content-wrapper">
      <div class="content">
        <div class="breadcrumb-wrapper d-flex align-items-center justify-content-between">
          <div>
            <h1>Danh sách sản phẩm</h1>
          </div>
          <div>
            <a href="AdminAddProduct" class="btn btn-primary"> Thêm sản phẩm</a>
          </div>
        </div>
        <div class="row">
          <div class="col-12">
            <div class="card card-default">
              <div class="card-body">
                <div class="table-responsive">
                  <table id="responsive-data-table" class="table"
                         style="width:100%">
                    <thead>
                    <tr>
                      <th>Sản phẩm</th>
                      <th>Tên sản phẩm</th>
                      <th>Giá</th>
                      <th>Giá bán</th>
                      <th>Số lượng sản phẩm</th>
                      <th>Số lượng đã bán</th>
                      <th>Trạng thái</th>
                      <th>Hoạt động</th>
                    </tr>
                    </thead>

                    <tbody>
                    <% for(Product p : list){%>
                    <tr>
                      <td><img class="tbl-thumb" src="<%=p.getImages().get(0)%>" alt="Product Image" /></td>
                      <td><%=p.getName()%></td>
                      <td><%=p.getPrice()%>VNĐ</td>
                      <td><%=p.getPrice_buy()%>VNĐ</td>
                      <td><%=p.getQuantity()%></td>
                      <td><%=p.getProduct_sold()%></td>
                      <td><%=p.getStock()%></td>
                      <td>
                        <div class="btn-group mb-1">
                          <a class="btn btn-outline-success" href="AdminProduct?id=<%=p.getId()%>">Chỉnh sửa</a>
                        </div>
                      </td>
                    </tr>
                    <% } %>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div> <!-- End Content -->
    </div> <!-- End Content Wrapper -->


    <!-- Footer -->
    <footer class="footer mt-auto">
      <div class="copyright bg-white">
        <p>
          Copyright &copy; <span id="ec-year"></span><a class="text-primary"
                                                        href="https://themeforest.net/user/ashishmaraviya" target="_blank"> Ekka Admin Dashboard</a>. All Rights Reserved.
        </p>
      </div>
    </footer>

  </div> <!-- End Page Wrapper -->
</div> <!-- End Wrapper -->

<!-- Common Javascript -->
<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script src="assets/plugins/jquery/jquery-3.5.1.min.js"></script>
<script src="assets/js/bootstrap.bundle.min.js"></script>
<script src="assets/plugins/simplebar/simplebar.min.js"></script>
<script src="assets/plugins/jquery-zoom/jquery.zoom.min.js"></script>
<script src="assets/plugins/slick/slick.min.js"></script>

<!-- Datatables -->
<script src='assets/plugins/data-tables/jquery.datatables.min.js'></script>
<script src='assets/plugins/data-tables/datatables.bootstrap5.min.js'></script>
<script src='assets/plugins/data-tables/datatables.responsive.min.js'></script>

<!-- Option Switcher -->
<script src="assets/plugins/options-sidebar/optionswitcher.js"></script>

<!-- Ekka Custom -->
<script src="assets/js/ekka.js"></script>
</body>
</html>
