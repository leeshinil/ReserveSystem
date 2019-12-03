<!doctype html>
<html lang="ko">

<head>
    <!-- Required meta tags -->
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="../assets/vendor/jquery/jquery-3.3.1.min.js"></script>
    <script src="../assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
    <script src="../assets/vendor/slimscroll/jquery.slimscroll.js"></script>
    <script src="../assets/libs/js/main-js.js"></script>
    <%--    // jQuery UI CSS파일--%>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
    <%--    // jQuery 기본 js파일--%>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <%--     jQuery UI 라이브러리 js파일--%>
    <script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){$("#header").load("/header");});
    </script>
    <script type="text/javascript">
        $(document).ready(function(){$("#menu").load("/menu");});
    </script>
</head>

<body>
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
        <div class="container-fluid dashboard-content">
            <div class="row">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">

                    <div class="card">
                        <h5 class="card-header">
                            <b>예약하기</b>
                        </h5>
                        <div class="card-body">
                            <form id = "myform" method="post" onsubmit="return false;" action="/reservedo" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label class="col-form-label" for="titleInput"  >제목</label>
                                    <input class="form-control" id="titleInput" name = "title" type="text">
                                    <div class="form-group">
                                        <%--@declare id="input-select"--%><label for="input-select">회의실 명</label>
                                        <select class="form-control" id="room">
                                            <option  value="A회의실">A회의실</option>
                                            <option value="B회의실">B회의실</option>
                                        </select>
                                    </div>
                                </div>
                                <label >조회 날짜</label>
                                <input type="text" id="Datepicker" name="date"><a class="btn btn-outline-dark"  onclick="MyCheck()" style="float:right">중복체크</a>
                                <div class="form-group">
                                    <%--@declare id="input-select"--%><label for="input-select">시작시간</label>
                                    <select class="form-control" id="start">
                                        <option  value="08:00">08:00</option>
                                        <option value="09:00">09:00</option>
                                        <option  value="10:00">10:00</option>
                                        <option value="11:00">11:00</option>
                                        <option  value="12:00">12:00</option>
                                        <option value="13:00">13:00</option>
                                        <option  value="14:00">14:00</option>
                                        <option value="15:00">15:00</option>
                                        <option  value="16:00">16:00</option>
                                        <option  value="17:00">17:00</option>
                                        <option value="18:00">18:00</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <%--@declare id="input-select"--%><label for="input-select">종료 시간</label>
                                    <select class="form-control" id="end">
                                        <option  value="08:00">08:00</option>
                                        <option value="09:00">09:00</option>
                                        <option  value="10:00">10:00</option>
                                        <option value="11:00">11:00</option>
                                        <option  value="12:00">12:00</option>
                                        <option value="13:00">13:00</option>
                                        <option  value="14:00">14:00</option>
                                        <option value="15:00">15:00</option>
                                        <option  value="16:00">16:00</option>
                                        <option  value="17:00">17:00</option>
                                        <option value="18:00">18:00</option>
                                    </select>
                                </div>
                                <script>
                                    $( "#Datepicker" ).datepicker({
                                        dateFormat:'yy-mm-dd'
                                    });
                                </script>
                                <div class="form-group">
                                    <label for="content">회의 내용</label>
                                    <textarea class="form-control" id="content" name ="content" rows="20"></textarea>
                                </div>
                                <div id="hiddenDiv">
                                </div>

                                <div align="right">
                                    <button type="button" class="btn btn-primary" onclick="wirte()">예약</button>
                                    <a class="btn btn-danger" href="#" onclick="history.back(-1);">취소</a>
                                </div>
                            </form>
                        </div>
                    </div>
                    <script>
                        var check = false;

                        function MyCheck() {
                            var start = $("#start").val();
                            var end = $("#end").val();
                            var date = $("#Datepicker").val();
                            var roomname = $("#room").val();
                            var obj = new Object();
                            obj.date = date;
                            obj.start= start;
                            obj.end = end;
                            obj.roomname = roomname;
                            var jsonData = JSON.stringify(obj);
                            console.log("json : " + jsonData);
                            return $.ajax({
                                type: 'POST',
                                data: jsonData,
                                url: "reserveRest/reserveCheck",
                                dataType: "json",
                                contentType: "application/json; charset=UTF-8",
                                success: function (data){
                                    console.log(data);
                                    if (data.result == "success") {
                                        alert("예약 가능합니다.");
                                        check = true;
                                    } else {
                                        alert("예약이 불가능합니다.");
                                        check=false;
                                    }
                                },
                                error: function (error) {
                                    console.log(error);
                                }
                            });

                        }


                        function wirte() {
                            if($("#titleInput").val()==""){
                                alert("제목을 작성해 주십시오.");
                                return ;
                            }
                            if(check == false){
                                alert("중복체크를 해야합니다.");
                                return ;
                            }
                            var str =$("#content").val();
                            if(str==""){
                                alert("내용을 작성해 주십시오.");
                                return ;
                            }

                            var endHtml = "<input name='end' value='"+end+"'>"
                            var startHtml = "<input name='start' value='"+start+"'>";
                            $("#hiddenDiv").append(startHtml);
                            $("#hiddenDiv").append(endHtml);

                            $("#content").val(str);
                            $("#myform").removeAttr('onsubmit');
                            $("#myform").submit();
                        }
                    </script>
                </div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- footer -->
        <!-- ============================================================== -->
        <div class="footer">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12">
                        Copyright Â© 2018 Concept. All rights reserved. Dashboard by <a
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