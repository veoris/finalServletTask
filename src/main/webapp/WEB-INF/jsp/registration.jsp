<%@ page import="com.serhii.model.entity.Team" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="w" tagdir="/WEB-INF/tags" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<w:wrapper>
    <h1 class="col-lg-12 text-center"><fmt:message key="registration"/></h1>
    <c:if test="${param.unacceptableData == true}">
        <p><fmt:message key="unacceptableData"/></p>
    </c:if>
    <form class="col-lg-12 regform" method="post" action="${pageContext.request.contextPath}/app/register">
        <c:if test="${param.notUniqueLogin == true}">
            <p><fmt:message key="login.occupied"/></p>
        </c:if>
        <label class="row">
            <span class="col-lg-3"><fmt:message key="login"/></span>
            <div class="col-lg-9">
                <c:if test="${param.checkLogin == false}">
                    <p><fmt:message key="login.regex.err"/></p>
                </c:if>
                <input type="text" name="login" value="${param.login}" required>
            </div>
        </label>

        <label class="row">
            <span class="col-lg-3"><fmt:message key="password"/></span>
            <div class="col-lg-9">
                <c:if test="${param.checkPassword == false}">
                    <p><fmt:message key="password.regex.err"/></p>
                </c:if>
                <input type="password" name="password" required>
            </div>
        </label>

        <span class="col-lg-3"><fmt:message key="team"/></span>
        <select  id ="teamId" name ="teamId">
            <c:forEach items="${teams}" var="team">
                <option value = "${team.id}">${team.name}</option>
            </c:forEach>
        </select>

        <label class="col-lg-8"><input type="submit" value="<fmt:message key="register"/>"></label>
    </form>
</w:wrapper>
