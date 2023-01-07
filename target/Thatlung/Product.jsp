<%@ page import="Entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Product product = (Product)request.getAttribute("product"); %>
<% String category = (String) request.getAttribute("category"); %>
<% String categoryName = (String) request.getAttribute("namecategory"); %>
<% List<Product> list = (List<Product>) request.getAttribute("listproduct"); %>
<html>
<head>
    <title><%=product.getName()%>></title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
    <link rel="stylesheet" href="../CSS/stylesheet.css">
    <script src="../JQuery/jquery-2.1.1.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="../Bootstrap/bootstrap.min.css" media="screen">
    <script src="../Bootstrap/bootstrap.min.js" type="text/javascript"></script>
    <script src="JQuery/jquery.elevateZoom.min.js" type="text/javascript"></script>
    <script src="JS/owl.carousel.min.js" type="text/javascript"></script>
    <script src="../JS/Custom.js" type="text/javascript"></script>
    <link rel="stylesheet" href="CSS/owl.carousel.min.css">
</head>
<body>
    <jsp:include page="Layout/Header.jsp" />
    <div id="product-product" class="container">
        <ul class="breadcrumb">
            <li><a href="index.jsp"><i class="fa fa-home"></i></a></li>
            <li><a href="ListProduct?category=<%=category%>"><%=categoryName%></a></li>
            <li><a href=""><%=product.getName()%></a></li>
        </ul>
        <div class="row">
            <div id="content" class="col-sm-12">

                <div class="row">

                    <div class="col-sm-6 product-left">
                        <div class="thumbnails">
                            <div class="pro-image" width="360" height="540">
                                <a href="<%=product.getImages().get(0)%>"
                                   title="thatlungdabo" class="thumbnail">
                                    <img src="<%=product.getImages().get(0)%>"
                                         title="thatlung" id="zoom" alt="thatlung"
                                         data-zoom-image="<%=product.getImages().get(0)%>"  />
                                </a>
                            </div>
                            <div id="additional-carousel" class="owl-carousel owl-theme thumbnails-gellery clearfix">
                                <% for(String link: product.getImages()) { %>
                                    <div class="image-additional">
                                    <a href="<%=link%>"
                                       title="party wear" class="elevatezoom-gallery"
                                       data-image="<%=link%>"
                                       data-zoom-image="<%=link%>">
                                        <img src="<%=link%>"
                                             title="party wear" alt="party wear" width="90" height="100" />
                                    </a>
                                </div>
                                <% } %>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 right-info">
                        <h1 class="product_title"><%=product.getName()%></h1>
                        <ul class="list-unstyled product-manufacturer">
                            <li><span class="disc">Thương hiệu: </span><%=product.getBrand()%>
                            </li>

                            <li><span class="disc">Mã sản phẩm: </span> <span class="disc1"><%=product.getId()%></span></li>
                            <li><span class="disc">Tình trạng: </span><span class="disc1"><%=product.getStock()%></span></li>
                        </ul>

                        <ul class="list-unstyled product_price">
                            <% if(product.getPrice_buy()!=product.getPrice()){ %>
                            <li>
                                <span class="pro_oldprice" style="text-decoration: line-through;"><%=product.getPrice()%>&nbsp;VNĐ</span>
                                <span class="pro_price"><%=product.getPrice_buy()%>&nbsp;VNĐ</span>
                            </li>
                            <% } else { %>
                            <span class="pro_price"><%=product.getPrice_buy()%>&nbsp;VNĐ</span>
                            <% } %>
                            <li><span class="disc"><%=product.getQuantity()%> sản phẩm có sẵn</span></li>
                        </ul>
                        <div id="product" class="product-options">
                            <div class="form-group clearfix">
                                <form action="/Cart?id=<%=product.getId()%>" method="post">
                                <div class="product-btn-quantity">
                                    <button class="minus"><i class="fa fa-minus" aria-hidden="true"></i></button>
                                    <input type="number" name="quantity" value="1" min="1" size="2" id="input-quantity"
                                           class="form-control" />
                                    <button class="plus"><i class="fa fa-plus" aria-hidden="true"></i></button>
                                    <% if(!product.getStock().equals("Hết hàng")) { %>
                                    <button type="submit" class="btn btn-primary btn-lg btn-block">
                                        &nbsp;<span class="">Thêm vào giỏ hàng</span></button>
                                    <% } else { %>
                                    <label class="btn btn-primary btn-lg btn-block" style="background-color: #5e5e5e"> &nbsp;<span class="">Hết hàng</span>s</label>
                                    <% } %>
                                </div>
                                </form>
                            </div>
                        </div>
                        <hr>
                        <!-- AddThis Button BEGIN -->
                        <div class="addthis_toolbox addthis_default_style" data-url="Product">

                            <a class="addthis_counter addthis_pill_style"></a>
                        </div>
                        <script type="text/javascript"
                                src="//s7.addthis.com/js/300/addthis_widget.js#pubid=ra-515eeaf54693130e"></script>
                        <!-- AddThis Button END -->
                    </div>
                </div>

                <div class="tab-block">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#tab-description" data-toggle="tab">Mô tả</a></li>
                    </ul>
                    <div class="tab-content clearfix">
                        <div class="tab-pane active" id="tab-description">
                            <div>
                                <%=product.getDetail()%>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="related-products-block">
                    <div class="page-title">
                        <h2>SẢN PHẨM LIÊN QUAN</h2>
                    </div>
                    <div class="row">
                        <div id="related-carousel" class="related-carousel clearfix" data-items="4">
                            <% for(Product p : list){ %>
                                <div class="product-layout col-xs-12">
                                <div class="product-thumb transition">
                                    <div class="image">
                                        <a href="Product?id=<%=p.getId()%>">
                                            <img src="<%=p.getImages().get(0)%>"
                                                 alt="thatlung" title="thatlung" class="img-responsive" />
                                            <% if(p.getImages().size()==1){ %>
                                                <img class="img-responsive hover-img"
                                                 src="<%=p.getImages().get(0)%>"
                                                 title="thatlung" alt="thatlung" />
                                            <% } else { %>
                                                <img class="img-responsive hover-img"
                                                 src="<%=p.getImages().get(0)%>"
                                                 title="thatlung" alt="thatlung" />
                                            <% } %>
                                        </a>
                                        <div class="product-item-addcart">
                                            <button type="button" class="addcart" onclick="cart.add();"><span>Thêm
													vào giỏ hàng</span></button>
                                        </div>
                                    </div>
                                    <div class="thumb-description clearfix">
                                        <div class="caption">
                                            <h4><a href="Product?id=<%=p.getId()%>"><%=p.getName()%></a></h4>
                                            <% if(p.getPrice_buy()!=p.getPrice()){ %>
                                            <span class="pro_oldprice"
                                                  style="text-decoration: line-through;"><%=p.getPrice()%>>&nbsp;VNĐ</span>
                                            <p class="price">
                                                <%=p.getPrice_buy()%>&nbsp;VNĐ
                                            </p>
                                            <% } else { %>
                                            <p class="price">
                                                <%=p.getPrice_buy()%>&nbsp;VNĐ
                                            </p>
                                            <% } %>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <% } %>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        $('select[name=\'recurring_id\'], input[name="quantity"]').change(function () {
            $.ajax({
                url: 'index.php?route=product/product/getRecurringDescription',
                type: 'post',
                data: $('input[name=\'product_id\'], input[name=\'quantity\'], select[name=\'recurring_id\']'),
                dataType: 'json',
                beforeSend: function () {
                    $('#recurring-description').html('');
                },
                success: function (json) {
                    $('.alert-dismissible, .text-danger').remove();

                    if (json['success']) {
                        $('#recurring-description').html(json['success']);
                    }
                }
            });
        });
    </script>
    <script type="text/javascript">
        $('#button-cart').on('click', function () {
            var timer;
            $.ajax({
                url: 'index.php?route=checkout/cart/add',
                type: 'post',
                data: $('#product input[type=\'text\'], #product input[type=\'hidden\'], #product input[type=\'radio\']:checked, #product input[type=\'checkbox\']:checked, #product select, #product textarea'),
                dataType: 'json',
                beforeSend: function () {
                    $('#button-cart').button('loading');
                },
                complete: function () {
                    $('#button-cart').button('reset');
                },
                success: function (json) {
                    $('.alert-dismissible, .text-danger').remove();
                    clearTimeout(timer);
                    $('.form-group').removeClass('has-error');

                    if (json['error']) {
                        if (json['error']['option']) {
                            for (i in json['error']['option']) {
                                var element = $('#input-option' + i.replace('_', '-'));

                                if (element.parent().hasClass('input-group')) {
                                    element.parent().after('<div class="text-danger">' + json['error']['option'][i] + '</div>');
                                } else {
                                    element.after('<div class="text-danger">' + json['error']['option'][i] + '</div>');
                                }
                            }
                        }

                        if (json['error']['recurring']) {
                            $('select[name=\'recurring_id\']').after('<div class="text-danger">' + json['error']['recurring'] + '</div>');
                        }

                        // Highlight any found errors
                        $('.text-danger').parent().addClass('has-error');
                    }

                    if (json['success']) {
                        $('#content').before('<div class="alert  alert-success alert-dismissible">' + json['success'] + '<button type="button" class="close" data-dismiss="alert">&times;</button></div>');

                        $('#cart > button').html('<span id="cart-total"> ' + json['total'] + '</span><span class="ti-bag"></span>');

                        timer = setTimeout(function () {
                            $('.alert').addClass('fadeUp');
                        }, 4000);
                        $('html, body').animate({ scrollTop: 0 }, 'slow');

                        $('#cart > ul').load('index.php?route=common/cart/info ul li');
                    }
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    alert(thrownError + "\r\n" + xhr.statusText + "\r\n" + xhr.responseText);
                }
            });
        });
    </script>
    <script type="text/javascript">
        $('.date').datetimepicker({
            language: 'en-gb',
            pickTime: false
        });

        $('.datetime').datetimepicker({
            language: 'en-gb',
            pickDate: true,
            pickTime: true
        });

        $('.time').datetimepicker({
            language: 'en-gb',
            pickDate: false
        });

        $('button[id^=\'button-upload\']').on('click', function () {
            var node = this;

            $('#form-upload').remove();

            $('body').prepend('<form enctype="multipart/form-data" id="form-upload" style="display: none;"><input type="file" name="file" /></form>');

            $('#form-upload input[name=\'file\']').trigger('click');

            if (typeof timer != 'undefined') {
                clearInterval(timer);
            }

            timer = setInterval(function () {
                if ($('#form-upload input[name=\'file\']').val() != '') {
                    clearInterval(timer);

                    $.ajax({
                        url: 'index.php?route=tool/upload',
                        type: 'post',
                        dataType: 'json',
                        data: new FormData($('#form-upload')[0]),
                        cache: false,
                        contentType: false,
                        processData: false,
                        beforeSend: function () {
                            $(node).button('loading');
                        },
                        complete: function () {
                            $(node).button('reset');
                        },
                        success: function (json) {
                            $('.text-danger').remove();

                            if (json['error']) {
                                $(node).parent().find('input').after('<div class="text-danger">' + json['error'] + '</div>');
                            }

                            if (json['success']) {
                                alert(json['success']);

                                $(node).parent().find('input').val(json['code']);
                            }
                        },
                        error: function (xhr, ajaxOptions, thrownError) {
                            alert(thrownError + "\r\n" + xhr.statusText + "\r\n" + xhr.responseText);
                        }
                    });
                }
            }, 500);
        });
    </script>
    <script type="text/javascript">
        $('#review').delegate('.pagination a', 'click', function (e) {
            e.preventDefault();

            $('#review').fadeOut('slow');

            $('#review').load(this.href);

            $('#review').fadeIn('slow');
        });

        $('#review').load('index.php?route=product/product/review&product_id=43');

        $('#button-review').on('click', function () {
            var timer;
            $.ajax({
                url: 'index.php?route=product/product/write&product_id=43',
                type: 'post',
                dataType: 'json',
                data: $("#form-review").serialize(),
                beforeSend: function () {
                    $('#button-review').button('loading');
                },
                complete: function () {
                    $('#button-review').button('reset');
                },
                success: function (json) {
                    $('.alert-dismissible').remove();

                    if (json['error']) {
                        $('#form-review').before('<div class="alert alert-danger alert-dismissible"><i class="fa fa-exclamation-circle"></i> ' + json['error'] + '<button type="button" class="close" data-dismiss="alert">&times;</button></div>');
                    }

                    if (json['success']) {
                        $('#form-review').before('<div class="alert alert-success alert-dismissible"><i class="fa fa-check-circle"></i> ' + json['success'] + '<button type="button" class="close" data-dismiss="alert">&times;</button></div>');

                        $('input[name=\'name\']').val('');
                        $('textarea[name=\'text\']').val('');
                        $('input[name=\'rating\']:checked').prop('checked', false);
                    }
                }
            });
        });
    </script>

    <!-- M-Custom script -->
    <script type="text/javascript">
        // Additional images
        const direction = $('html').attr('dir');
        $('#additional-carousel').each(function () {
            const items = $(this).data('items') || 4;
            const sliderOptions = {
                loop: false,
                nav: true,
                navText: ['<i class="fa fa-angle-left fa-5x"></i>', '<i class="fa fa-angle-right fa-5x"></i>'],
                dots: false,
                items: 4,
                responsiveRefreshRate: 200,
                responsive: {
                    0: { items: 1 },
                    320: { items: 2 },
                    425: { items: 3 },
                    480: { items: 3 },
                    767: { items: 4 },
                    768: { items: 3 },
                    991: { items: 3 },
                    992: { items: 3 },
                    1201: { items: 4 }
                }
            };
            if (direction == 'rtl') sliderOptions['rtl'] = true;
            $(this).owlCarousel(sliderOptions);
        });

        $('.related-carousel').each(function () {
            if ($(this).closest('#column-left').length == 0 && $(this).closest('#column-right').length == 0) {
                $(this).addClass('owl-carousel owl-theme');
                const items = $(this).data('items') || 4;
                const sliderOptions = {
                    loop: false,
                    nav: true,
                    navText: ['<i class="fa fa-angle-left" aria-hidden="true">', '<i class="fa fa-angle-right" aria-hidden="true">'],
                    dots: false,
                    items: items,
                    responsiveRefreshRate: 200,
                    responsive: {
                        0: { items: 1 },
                        481: { items: ((items - 2) > 1) ? (items - 2) : 1 },
                        767: { items: ((items - 2) > 1) ? (items - 2) : 1 },
                        768: { items: ((items - 2) > 1) ? (items - 2) : 1 },
                        991: { items: ((items - 1) > 1) ? (items - 1) : 1 },
                        1024: { items: ((items - 1) > 1) ? (items - 1) : 1 },
                        1201: { items: items }
                    }
                };
                if (direction == 'rtl') sliderOptions['rtl'] = true;
                $(this).owlCarousel(sliderOptions);
            }
        });

        $(document).ready(function () {
            if ($(window).width() > 767) {
                $("#zoom").elevateZoom({
                    zoomType: "inner",
                    cursor: "crosshair",
                    gallery: 'additional-carousel',
                    galleryActiveClass: 'active'
                });

                var image_index = 0;
                $(document).on('click', '.thumbnail', function () {
                    $('.thumbnails').magnificPopup('open', image_index);
                    return false;
                });

                $('#additional-carousel a').click(function () {
                    var smallImage = $(this).attr('data-image');
                    var largeImage = $(this).attr('data-zoom-image');
                    var ez = $('#zoom').data('elevateZoom');
                    $('.thumbnail').attr('href', largeImage);
                    ez.swaptheimage(smallImage, largeImage);
                    image_index = $(this).index('#additional-carousel a');
                    return false;
                });
            } else {
                $(document).on('click', '.thumbnail', function () {
                    $('.thumbnails').magnificPopup('open', 0);
                    return false;
                });
            }
        });

        $(document).ready(function () {
            $('.thumbnails').magnificPopup({
                type: 'image',
                delegate: 'a.elevatezoom-gallery',
                gallery: {
                    enabled: true
                }
            });
        });

       </script>
<jsp:include page="Layout/Footer.jsp"></jsp:include>
</body>
</html>
