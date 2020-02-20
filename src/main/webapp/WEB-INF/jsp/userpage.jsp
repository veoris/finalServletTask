<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>
<%@taglib prefix="w" tagdir="/WEB-INF/tags" %>

<w:wrapper>
    <div class="col-lg-12 text-left">
        <h1 class="uname">
            <c:out value="${sessionScope.user.login}"/>
        </h1>

    </div>



</w:wrapper>

