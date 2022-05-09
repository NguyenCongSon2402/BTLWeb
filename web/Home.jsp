<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            html,body{
                margin: 0;
            }
            
            .header {
                width: 100%;
                height: 100%;
                background-image:url(https://media.gettyimages.com/photos/seamless-rice-paper-background-picture-id184882351?s=612x612);
                background-size: 100% auto;
                background-repeat:repeat;
            }
        </style>
    </head>
    <body >
        <div class="header">
            <jsp:include page="Menu.jsp"></jsp:include>
           
                <div class="container">
                    <div class="row">
                        <div class="col-sm-3.5">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="HomeControl">Home</a></li>
                                    <li class="breadcrumb-item"><a href="#">Category</a></li>
                                    <li class="breadcrumb-item active" aria-current="#">Sub-category</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                         <jsp:include page="CategoryVsLast.jsp"></jsp:include>

                        <div class="col-sm-9">
                            <div class="row">
                                <c:forEach items="${listP}" var="o">
                                    <div class="col-13 col-md-8 col-lg-4">
                                        <div class="card-bg-info">
                                            <img class="card-img-top" src="${o.image}" alt="Card image cap">
                                            <div class="card-body">
                                                <h4 class="card-title show_txt"><a href="DetailControl?pid=${o.id}" title="View Product">${o.name}</a></h4>
                                                <p class="card-text show_txt">${o.title}</p>
                                                <div class="row">
                                                    <div class="col">
                                                        <span class="badge badge-warning">${o.price}$</span>

                                                    </div>
                                                    <div class="col">
                                                        <a href="" class="btn btn-outline-success">Add to cart</a>
                                                    </div>
                                                    <div class="col">
                                                        <span class="badge badge-pill badge-info">Amount ${o.amount}</span>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>

                    </div>
                </div>

                <jsp:include page="Footer.jsp"></jsp:include>
            </div>
            <script src="https://uhchat.net/code.php?f=56ac67"></script>
            <div class="zalo-chat-widget" data-oaid="589634003921980460" 
                 data-welcome-message="Rất vui khi được hỗ trợ bạn!" data-autopopup="0" data-width="300" data-height="350"></div>

<script src="https://sp.zalo.me/plugins/sdk.js"></script>
    </body>
</html>

