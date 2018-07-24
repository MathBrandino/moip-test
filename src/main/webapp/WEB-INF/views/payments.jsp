<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"
          integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
    <title>Payments</title>
    <link rel="shortcut icon"
          href="https://png.icons8.com/metro/1600/card-in-use.png">
</head>
<body>
<div class="container my-3">
    <div class="col-md-12 col-md-offset-3 mx-auto">
        <h1 class="text-center my-3">Payments</h1>
        <table class="table table-hover ">
            <thead>
            <tr class="alert alert-light">
                <th class="text-center">Client</th>
                <th class="text-center">Buyer</th>
                <th class="text-center">Amout</th>
                <th class="text-center">Method</th>
                <th class="text-center">Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${payments}" var="payment">
                <tr>
                    <td class="text-center">${payment.client.name}</td>
                    <td class="text-center">${payment.buyer.name}</td>
                    <td class="text-center">R$ ${payment.paymentMethod.amount}</td>
                    <td class="text-center">${payment.paymentMethod.class.simpleName}</td>
                    <c:choose>
                        <c:when test="${payment.paymentMethod.class.simpleName =='Boleto'}">
                            <td class="text-center alert alert-primary"><strong>Waiting</strong></td>
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${payment.paymentMethod.card.valid}">
                                    <td class="text-center alert alert-success"><strong>Authorized</strong>
                                    </td>
                                </c:when>
                                <c:otherwise>
                                    <td class="text-center alert alert-danger"><strong>Unauthorized</strong>
                                    </td>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"
        integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em"
        crossorigin="anonymous"></script>
</body>
</html>