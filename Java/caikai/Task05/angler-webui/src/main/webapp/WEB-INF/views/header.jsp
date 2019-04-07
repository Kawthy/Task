
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>首页</title>
    <link rel="stylesheet" href="../css/1.css">
    <link rel="stylesheet" href="../css/@media.css">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<header>
    <div class="container head-top">
        <div class="row-head">
            <div class="col-md-12 col-xs-12 row-left">
                <p>客服热线：010-594-78634</p>
                <div class="rest">
                    <a class="rest-left" href="https://www.qq.com/"></a>
                    <a class="rest-center" href="https://weixin.qq.com/ "></a>
                    <a class="rest-right" href="https://weibo.com/"></a>
                </div>
            </div>
        </div>
    </div>
    <div class="top">
        <div class="container color">
            <div class="row">
                <div class="col-md-12 col-xs-12 print-top">
                    <nav class="navbar navbar-default text-mg" role="navigation">
                        <div class="container-fluid text-top">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse"
                                        data-target="#example-navbar-collapse">
                                    <span class="sr-only">切换导航</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                                <a class="navbar-brand logo" href="#">
                                    <img src="../images/logo.png" alt="">
                                </a>
                            </div>
                            <div  class="collapse navbar-collapse center" id="example-navbar-collapse">
                                <ul class="nav navbar-nav text">
                                    <li><a class="gps-left" href="/tileHome">首页</a></li>
                                    <li><a class="gps-left" href="/profession">职业</a></li>
                                    <li><a class="gps-left" href="#">推荐</a></li>
                                    <li><a class="gps-left" href="/WEB-INF/2.html">关于</a></li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <div id="myCarousel" class="carousel slide">
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="item active print-one">
                <img src="../images/Image.png" alt="First slide">
            </div>
            <div class="item print-one">
                <img src="../images/Image.png" alt="Second slide">
            </div>
            <div class="item print-one">
                <img src="../images/Image.png" alt="Third slide">
            </div>
        </div>
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</header>
</div>
