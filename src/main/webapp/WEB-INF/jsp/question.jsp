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
    <form class="col-lg-12 regform" method="post" action="${pageContext.request.contextPath}/app/addquestion">

        <label class="row">
            <span class="col-lg-3">title</span>
            <div class="col-lg-9">
                <input type="text" name="title" value="${param.title}" required>
            </div>
        </label>
        <label class="row">
            <span class="col-lg-3">description</span>
            <div class="col-lg-9">
                <input type="text" name="description" value="${param.description}" required>
            </div>
        </label>
        <label class="row">
            <span class="col-lg-3">help</span>
            <div class="col-lg-9">
                <input type="text" name="help" value="${param.help}" required>
            </div>
        </label>
        <label class="row">
            <span class="col-lg-3">answer</span>
            <div class="col-lg-9">
                <input type="text" name="answer" value="${param.answer}" required>
            </div>
        </label>


        <label class="col-lg-8"><input type="submit" value="<fmt:message key="register"/>"></label>
    </form>
</w:wrapper>
