<%-- 
    Document   : menu
    Created on : Oct 09, 2017, 1:15:33 AM
    Author     : phong
--%>

<%@page import="dao.CategoryDAO"%>
<%@page import="model.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Phượt Store|Shop đồ phượt</title>
    </head>
    <body>
        <%
            CategoryDAO categoryDAO = new CategoryDAO();
        %>
        <div class="logo-nav-left1">
            <nav class="navbar navbar-default">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header nav_2">
                    <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div> 
                <div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="index.jsp" class="act">Trang chủ</a></li>	
                        <!-- Menu chính -->
                        <li><a href="product.jsp?categoryID=1522440132472&pages=1">Sản phẩm</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Nón bảo hiểm<b class="caret"></b></a>
                            <ul class="dropdown-menu multi-column columns-3">
                                <div class="row">
                                    <div class="col-sm-3  multi-gd-img">
                                        <ul class="multi-column-dropdown">
                                            <%
                                                for (Category c : categoryDAO.getListCategoryNonbaohiem()) {
                                            %>
                                                <li><a href="product.jsp?categoryID=<%=c.getCategoryID()%>&pages=1"><%=c.getCategoryName()%></a></li>
                                            <%
                                                }
                                            %>
                                        </ul>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Phụ kiện<b class="caret"></b></a>
                            <ul class="dropdown-menu multi-column columns-3">
                                <div class="row">
                                    <div class="col-sm-3  multi-gd-img">
                                        <ul class="multi-column-dropdown">
                                            <%
                                                for (Category c : categoryDAO.getListCategoryPhukien()) {
                                            %>
                                                <li><a href="product.jsp?categoryID=<%=c.getCategoryID()%>&pages=1"><%=c.getCategoryName()%></a></li>
                                            <%
                                                }
                                            %>
                                        </ul>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </ul>
                        </li>
                        <li><a href="contact.jsp">Liên hệ</a></li>
                    </ul>
                </div>
            </nav>
        </div>
    </body>
</html>
