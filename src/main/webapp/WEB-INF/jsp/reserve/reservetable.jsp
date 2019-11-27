<!doctype html>
<html lang="ko">

<head>
    <!-- Required meta tags -->
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <script src="../assets/vendor/jquery/jquery-3.3.1.min.js"></script>
    <script src="../assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
    <script src="../assets/vendor/slimscroll/jquery.slimscroll.js"></script>
    <script src="../assets/vendor/custom-js/jquery.multi-select.html"></script>
    <script src="../assets/libs/js/main-js.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){$("#header").load("/header");});
    </script>
    <script type="text/javascript">
        $(document).ready(function(){$("#menu").load("/menu");});
    </script>

<%--    // jQuery UI CSS파일--%>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<%--    // jQuery 기본 js파일--%>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<%--     jQuery UI 라이브러리 js파일--%>
    <script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Concept - Bootstrap 4 Admin Dashboard Template</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="../assets/vendor/bootstrap/css/bootstrap.min.css">
    <link href="../assets/vendor/fonts/circular-std/style.css"
          rel="stylesheet">
    <link rel="stylesheet" href="../assets/libs/css/style.css">
    <link rel="stylesheet"
          href="../assets/vendor/fonts/fontawesome/css/fontawesome-all.css">

</head>

<body oncontextmenu="return false" onselectstart="return false" ondragstart="return false">
<!-- ============================================================== -->
<!-- main wrapper -->
<!-- ============================================================== -->
<div class="dashboard-main-wrapper">
    <!-- ============================================================== -->
    <!-- navbar -->
    <!-- ============================================================== -->
    <div id="header"></div>
    <!-- ============================================================== -->
    <!-- end navbar -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- left sidebar -->
    <!-- ============================================================== -->
    <div id="menu"></div>
    <!-- ============================================================== -->
    <!-- end left sidebar -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- wrapper  -->
    <!-- ============================================================== -->
    <div class="dashboard-wrapper">
        <div class="container-fluid  dashboard-content">
            <!-- ============================================================== -->
            <!-- pageheader -->
            <!-- ============================================================== -->
            <div class="row">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="page-header">
                        <div class="alert alert-light" role="alert">
                            <h2 class="pageheader-title">회의실예약관리 목록</h2>
                            <label >조회 날짜</label>
                            <input type="text" id="Datepicker"> <a class="btn btn-outline-dark"  onclick="show()" style="float:right">조회</a>
                            <script>
                                $( "#Datepicker" ).datepicker({
                                    dateFormat:'yy-mm-dd'
                                });

                                function show (){
                                    var date = $("#Datepicker").val();
                                    document.getElementById("showArea").innerText=date;
                                    var obj = new Object();
                                    obj.date = date;
                                    var jsonData = JSON.stringify(obj);
                                    console.log("json : " + jsonData);
                                    return $.ajax({
                                        type: 'POST',
                                        data: jsonData,
                                        url: "rest/readReserveTable",
                                        dataType: "json",
                                        contentType: "application/json; charset=UTF-8",
                                        success: function (data){

                                        },
                                        error: function (error) {
                                            console.log(error);
                                        }
                                    });
                                }
                            </script>
                        </div>
                    </div>

                </div>
            </div>
            <!-- ============================================================== -->
            <!-- end pageheader -->
            <!-- ============================================================== -->

            <div class="row">
                <!-- ============================================================== -->
                <!-- end bordered table -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- hoverable table -->
                <!-- ============================================================== -->
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="card">
                        <h5 class="card-header"><b id="showArea"></b>
                                <a class="btn btn-outline-dark" style="float:right">예약하기</a></h5>
                        <div class="card-body">
                            <table class="table table-hover">
                                <colgroup>
<%--                                    <col width="10%"/>--%>
<%--                                    <col width="*"/>--%>
<%--                                    <col width="10%"/>--%>
<%--                                    <col width="10%"/>--%>
<%--                                    <col width="10%"/>--%>
                                </colgroup>
                                <thead>
                                <tr>
                                    <th scope="col">회의실 명</th>
                                    <th scope="col">08:00-09:00</th>
                                    <th scope="col">09:00-10:00</th>
                                    <th scope="col">10:00-11:00</th>
                                    <th scope="col">11:00-12:00</th>
                                    <th scope="col">12:00-13:00</th>
                                    <th scope="col">13:00-14:00</th>
                                    <th scope="col">14:00-15:00</th>
                                    <th scope="col">15:00-16:00</th>
                                    <th scope="col">16:00-17:00</th>
                                    <th scope="col">17:00-18:00</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--                                <c:if test="#{element.img == true}"> <i class="fas fa-image"></i> </c:if>--%>
                                <c:set var="l" value="${fn:length(list)}" />
                                <c:forEach var="element" items="${list}" varStatus="var" >
                                    <tr onclick="location.href='/detail/${element.postNo}'" style="cursor:pointer;">
                                        <th scope="col"><font size="1"> ${l - var.index}</font></th>
                                        <th scope="col">${element.postTitle}  &nbsp; &nbsp; &nbsp;<c:if test="${element.img == true}"><span class="badge badge-pill badge-success "><i class="fas fa-image"></i></span>  </c:if>
                                            <c:if test="${element.file == true}"><span class="badge badge-pill badge-primary ">첨부파일</span> </c:if><c:if test="${element.commentCount >0}"><span class="badge badge-success">${element.commentCount}</span></c:if></th>
                                        <th scope="col" >${element.fk_postNick}</th>
                                        <th scope="col"><font size="1" > ${element.postDate} </font></th>
                                        <th scope="col"><font size="1">${element.hits}</font></th>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- end hoverable table -->
                <!-- ============================================================== -->
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- footer -->
        <!-- ============================================================== -->
        <div class="footer">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12">
                        Copyright © 2018 Concept. All rights reserved. Dashboard by <a
                            href="https://colorlib.com/wp/">Colorlib</a>.
                    </div>
                    <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12">
                        <div class="text-md-right footer-links d-none d-sm-block">
                            <a href="javascript: void(0);">About</a> <a
                                href="javascript: void(0);">Support</a> <a
                                href="javascript: void(0);">Contact Us</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- end footer -->
        <!-- ============================================================== -->
    </div>
</div>
<!-- ============================================================== -->
<!-- end main wrapper -->
<!-- ============================================================== -->
<!-- Optional JavaScript -->

</body>

</html>