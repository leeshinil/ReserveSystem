<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <%@ page language="java" contentType="text/html; charset=UTF-8" %>
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
          href="/assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
    <style>
        html, body {
            height: 100%;
        }

        body {
            display: -ms-flexbox;
            display: flex;
            -ms-flex-align: center;
            align-items: center;
            padding-top: 40px;
            padding-bottom: 40px;
        }
    </style>
</head>
<!-- ============================================================== -->
<!-- signup form  -->
<!-- ============================================================== -->

<body>
<!-- ============================================================== -->
<!-- signup form  -->
<!-- ============================================================== -->
<form class="splash-container" method="post" id="signup_form" action="/signuppost">
    <div class="card">
        <div class="card-header">
            <h3 class="mb-1">Registrations Form</h3>
            <p>Please enter your user information.</p>
        </div>

        <div class="card-body">
            <div class="input-group mb-3">
                <input class="form-control form-control-lg" id="id" type="text"
                       name="id" required="true" placeholder="ID" autocomplete="off">
                <div class="input-group-append">
                    <button class="btn btn-primary" id="id_btn" type="button">중복확인</button>
                </div>
            </div>

            <div class="form-group">
                <input class="form-control form-control-lg" id="pw"
                       type="password" required="" placeholder="Password" name="pw">
            </div>

            <div class="form-group">
                <input class="form-control form-control-lg" id="confirm"
                       type="password" required="" placeholder="Confirm">
            </div>

            <div class="form-group">
                <input class="form-control form-control-lg" type="text" name="name"
                       id="name" required="" placeholder="Name" autocomplete="off">
            </div>

            <div class="form-group">
                <input class="form-control form-control-lg" type="tel" name="phone"
                       id="phone" required="" placeholder="핸드폰('-'제외)" autocomplete="off">
            </div>

            <div class="form-group">
                <input class="form-control form-control-lg" type="email"
                       name="email" id="email" required="" placeholder="E-mail"
                       autocomplete="off">
            </div>

            <!--직급-->
            <!--본부장 : first, 부장 : second, 사원 : third-->
            <div class="form-group">
                <%--@declare id="input-select"--%><label for="input-select">직급</label>
                <select class="form-control" id="auth">
                    <option  value="bon">본부장</option>
                    <option value="bu">부장</option>
                    <option selected="" value="sa">사원</option>
                </select>
            </div>
            <!--부서 선택-->
            <div class="form-group">
                <%--@declare id="input-select"--%><label for="input-select">그룹</label>
                <select class="form-control" id="group">
                    <option  value="a">A그룹</option>
                    <option value="b">B그룹</option>
                    <option selected="" value="none">없음</option>
                </select>
            </div>
            <!--동의 checkbox-->
            <div class="form-group">
                <label class="custom-control custom-checkbox"> <input
                        class="custom-control-input" type="checkbox" required id="signup_agree">
                    <span class="custom-control-label">회원가입을 동의합니다</span>
                </label>
            </div>

            <div id="hidden">
            </div>

            <!--회원가입 버튼-->
            <div>
                <a class="btn btn-block btn-primary" id="signup_btn"  onClick="goPost()">회원가입</a>
            </div>
        </div>
        <div class="card-footer bg-white">
            <p>
                Already member? <a href="signin" class="text-secondary">Login Here.</a>
            </p>
        </div>

    </div>
</form>
<script src="../assets/vendor/jquery/jquery-3.3.1.min.js"></script>
<script src="../assets/libs/js/signup.js"></script>
</body>


</html>