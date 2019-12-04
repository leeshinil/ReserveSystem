<%@ page import="com.example.demo.dto.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>


<%
    User user = (User) session.getAttribute("user");
%>

<div class="nav-left-sidebar sidebar-red">
    <div class="menu-list">
        <nav class="navbar navbar-expand-lg navbar-light">
            <a class="d-xl-none d-lg-none" href="#">Dashboard</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarNav" aria-controls="navbarNav"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav flex-column">
                    <li class="nav-divider">Menu</li>
                    <!--  ###############################  Common board start  ##############################  -->
                    <div id = "commonlist">
                        <li class='nav-item'><a class='nav-link' href='../reservetable'><i class="fas fa-wrench"></i> 회의실 예약</a></li>
                    </div>


                    <!--   ##############################  수업별 게시판 start  #################################  -->
                    <br/>


                    <!--   ##############################  수업별 게시판 end  #######################################  -->


                    <!--  ###############################  other board start  ####################################  -->
                    <br/>
                    <br/>
                    <div id = "otherlist"></div>
<%--                    <c:if test="${!empty user}">--%>
<%--                        <c:if test="${!user.ps || user.operator}">--%>
<%--                            <li class='nav-item'><a class='nav-link' href='../enrollment'><i class="fas fa-calendar-check"></i> 수강신청</a></li>--%>
<%--                        </c:if>--%>

<%--                        &lt;%&ndash;               <li class='nav-item'><a class='nav-link' href=''><i class="fas fa-calendar-check"></i> LAB/동아리 가입신청</a></li>&ndash;%&gt;--%>
<%--                        <!-- 교수님 및 관리자 -->--%>
<%--                        <c:if test="${user.ps || user.operator}">--%>
<%--                            <li class='nav-item'><a class='nav-link' href='../classlist'><i class="fas fa-wrench"></i> 수업게시판 관리</a></li>--%>
<%--                        </c:if>--%>
<%--                        <c:if test="${user.operator}">--%>
<%--                            <br/>--%>
<%--                            <li class='nav-item'><a class='nav-link' href='../edit'><i class="fas fa-wrench"></i> 게시판 개설</a></li>--%>
<%--                            <li class='nav-item'><a class='nav-link' href='../useredit'><i class="fas fa-wrench"></i> 유저 관리</a></li>--%>
<%--                        </c:if>--%>
<%--                    </c:if>--%>
                    <!--  -->
                    <!--  ##############################  other board  end  ###################################### -->

                </ul>
            </div>
        </nav>
    </div>
</div>
<script type = "text/javascript" src ="../assets/vendor/jquery/jquery-3.3.1.min.js"></script>
<script src="../assets/libs/js/menu.js"></script>
