<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="w" tagdir="/WEB-INF/tags" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<w:wrapper>
    <h1 class="col-lg-12"><fmt:message key="main"/></h1>
    <a href="${pageContext.request.contextPath}/app/question" class="col-lg-2 logo">Add Question</a>
    <a href="${pageContext.request.contextPath}/app/game" class="col-lg-2 logo">Play game</a>

</w:wrapper>