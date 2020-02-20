<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>
<%@taglib prefix="w" tagdir="/WEB-INF/tags" %>

<w:wrapper>

    ${requestScope.question.getDescription()} ${requestScope.question.getTitle()}

    <form class="col-lg-12 regform" method="post" action="${pageContext.request.contextPath}/app/answer">
        <label class="row">
            <span class="col-lg-3"><fmt:message key="question.answer"/></span>
            <div class="col-lg-9">
                <input type="text" name="answer" value="${param.answer}" required>
                <input type="number" hidden="true" name="id" value="${requestScope.id}" required>
                <input type="number" hidden="true" name="questionId" value="${requestScope.question.id}" required>
            </div>
        </label>
        <label class="col-lg-8"><input type="submit" value="<fmt:message key="question.answer"/>"></label>
    </form>


</w:wrapper>

