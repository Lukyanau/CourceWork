<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:choose>
    <c:when test="${not empty language}"> <fmt:setLocale value="${language}"/></c:when>
    <c:when test="${empty language}"> <fmt:setLocale value="en"/></c:when>
</c:choose>

<fmt:setBundle basename="pagecontent.language"/>


<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Courgette&family=Lato:wght@300;400;500;700&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/resetTable.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styleTable.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mediaTable.css">
    <title>USER CATALOG</title>
</head>

<body>
<div class="layout">
    <c:import url="${pageContext.request.contextPath}/jsp/header.jsp"/>
    <div class="layout-body"
         style="background-image: url(${pageContext.request.contextPath}/images/catalog.jpg); background-size: cover;">
        <div class="account-section">
            <div class="container">
                <div class="account-section__head">
                    <h2 class="account-section__title">Catalog of Cars</h2>
                </div>
                <div class="default-table-wrapper">
                    <table class="default-table">
                        <c:choose>
                            <c:when test="${empty cars || cars.size() == 0}">
                                <tr>
                                    <td>Catalog is empty. Try to visit us later....</td>
                                </tr>
                            </c:when>
                            <c:when test="${not empty cars}">
                                <tr>
                                    <th>MARK</th>
                                    <th>TITLE</th>
                                    <th>COLOR</th>
                                    <th>DESCRIPTION</th>
                                    <th>PRICE</th>
                                </tr>
                                <c:forEach var="car" items="${cars}">
                                    <tr>
                                        <td>${car.getMark()}</td>
                                        <td>${car.getTitle()}</td>
                                        <td>${car.getColor()}</td>
                                        <td>${car.getDescription()}</td>
                                        <td>${car.getPrice()}$</td>
                                        <c:choose>
                                            <c:when test="${car.isStatus() == true}">
                                                <td class="default-table__action">
                                                    <a href="controller?command=ban_car&carId=${car.getCarId()}"
                                                       class="default-table__button default-table__button--red">INACTIVATE</a>
                                                </td>
                                            </c:when>
                                            <c:otherwise>
                                                <td class="default-table__action">
                                                    <a href="controller?command=unBan_car&carId=${car.getCarId()}"
                                                       class="default-table__button default-table__button--green">ACTIVATE</a>
                                                </td>
                                            </c:otherwise>
                                        </c:choose>
                                    </tr>
                                </c:forEach>
                            </c:when>
                        </c:choose>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <c:import url="${pageContext.request.contextPath}/jsp/footer.jsp"/>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/current-day.js"></script>
</html>
