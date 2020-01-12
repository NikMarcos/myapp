<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<%@ page isELIgnored="false" %>
<h2>Hello World!</h2>
<form action = "../servlet" method = "GET">
   Path <input type = "text" name = "path" checked = "checked" />
    <input type = "submit" value = "Send path" />
</form>
<ul>
    <c:forEach items="${list}" var="file">
       <c:choose>
          <c:when test="${file.value.get(0) == 'folder'}">
            <li>
              <a href="../servlet?path=${file.value.get(1)}">${file.key}</a>
            </li>
              </c:when>
            <c:otherwise>
                <li>
                     ${file.key}
                </li>
            </c:otherwise>
            </c:choose>
    </c:forEach>
</ul>
<a href="../servlet?path=${parent}">Back</a>

</body>
</html>
