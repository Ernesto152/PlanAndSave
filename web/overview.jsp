<%--
  Created by IntelliJ IDEA.
  User: Abraham
  Date: 12/07/2017
  Time: 04:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="b" uri="http://bootstrapjsp.org/" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="bootstrap.jsp"/>

<html>
<head title="Plan&Save">
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript" src="js/overviewChart.js"/>
</head>
<body id="overview">

<s:if test="%{#session.user_id==null || #session.user_id==0}">
<s:set var="user_id" value="id" scope="session"/>
<s:set var="user_email" value="email" scope="session"/>
<s:set var="user_name" value="firstName" scope="session"/>
</s:if>

<s:if test="%{#session.user_id==null || #session.user_id==0}">
    <jsp:include page="errorLogin.jsp"/>
</s:if>

<jsp:include page="navbar.jsp"/>

<s:if test="%{#session.user_id>0}">

    <c:set var="sumIncome" value="0"/>
    <c:set var="sumExpense" value="0"/>
    <c:set var="sumDebt" value="0"/>

    <jsp:useBean id="service" class="pe.edu.utp.planandsave.services.PSService"/>
    <c:forEach var="income" items="${service.incomes}">
        <c:if test="${income.user.id eq user_id}">
            <c:set var="sumIncome" value="${sumIncome+income.amount}"/>
        </c:if>
    </c:forEach>

    <c:forEach var="expense" items="${service.expenses}">
        <c:if test="${expense.user.id eq user_id}">
            <c:set var="sumExpense" value="${sumExpense+expense.amount}"/>
        </c:if>
    </c:forEach>

    <c:forEach var="debt" items="${service.debts}">
        <c:if test="${debt.user.id eq user_id}">
            <c:set var="sumDebt" value="${sumDebt+(debt.quota*debt.periodAmount)}"/>
        </c:if>
    </c:forEach>

    <s:hidden id="sumIncome" value="%{#attr.sumIncome}"/>
    <s:hidden id="sumExpense" value="%{#attr.sumExpense}"/>
    <s:hidden id="sumDebt" value="%{#attr.sumDebt}"/>

<b:container>
    <b:jumbotron title="Sample">
        <h1>Revisa tu cartera</h1>
        <p>Descubre a donde se fue tu dinero y manten un monitoreo constante de tu dinero.</p>
    </b:jumbotron>
</b:container>


<b:container>
    <div class="row">

        <div class="col-xs-12 col-sm-12 col-md-8 col-md-offset-2 col-lg-8 col-lg-offset-2">
            <div class="chart">
                <div id="chart_div1"/>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-8 col-md-offset-2 col-lg-8 col-lg-offset-2">
            <div class="table-responsive">
                <table class="table table-bordered table-inverse table-striped">
                    <thead>
                    <tr class="bg-primary">
                        <th></th>
                        <th>Ingreso</th>
                        <th>Gasto</th>
                        <th>Deuda</th>
                        <th>Saldo</th>
                    </tr>
                    </thead>
                    <tbody>
                        <tr class="info">
                            <td>Total</td>
                            <td><c:out value="${sumIncome}"/> </td>
                            <td><c:out value="${sumExpense}"/></td>
                            <td><c:out value="${sumDebt}"/></td>
                            <td><c:out value="${sumIncome-sumExpense-sumDebt}"/></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</b:container>
</s:if>
<jsp:include page="footer.jsp"/>

</body>
</html>