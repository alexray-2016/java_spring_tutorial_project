
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    
    <link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery.js"></script>
    <script type="text/javascript">

        function onLoad() {
            $("#password").keyup(checkPasswordsMatch);
            $("#confirmpass").keyup(checkPasswordsMatch);
            $("#details").submit(canSubmit);
        }

        function canSubmit() {
            var password = $("#password").val();
            var confirmpass = $("#confirmpass").val();
            if (password != confirmpass) {
                alert("Passwords do not match.")
                return false;
            }
            else {
                return true;
            }
        }

        function checkPasswordsMatch() {
            var password = $("#password").val();
            var confirmpass = $("#confirmpass").val();

            if (password.length > 3 || confirmpass.length > 3) {
                if (password == confirmpass) {
                    $("#matchpass").text("<fmt:message key="MatchedPasswords.user.password"/>");
                    $("#matchpass").removeClass("error")
                    $("#matchpass").addClass("valid");
                }
                else {
                    $("#matchpass").text("<fmt:message key="UnmatchedPasswords.user.password"/>");
                    $("#matchpass").removeClass("valid")
                    $("#matchpass").addClass("error");
                }
            }
        }

        $(document).ready(onLoad);

    </script>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Create new account</title>
</head>
<body>
<h2>Create new account</h2>


<sf:form id="details" method="post" action="${pageContext.request.contextPath}/createaccount" commandName="user">

<table class="formtable">
<tr><td class="label">Name: </td><td><sf:input class="control" path="username" type="text" /><div class="error"><sf:errors path="username"/></div></td></tr>
<tr><td class="label">Email: </td><td><sf:input class="control"  path="email" type="text" /><div class="error"><sf:errors path="email"/></div></td></tr>
<tr><td class="label">Password: </td><td><sf:input id="password" class="control"  path="password" type="password" /><div class="error"><sf:errors path="password"/></div></td></tr>
<tr><td class="label">Repeat password: </td><td><input id="confirmpass" class="control"  name="confirmpass" type="text" /><div id="matchpass"></div></td></tr>
<tr><td class="label"> </td><td><input class="control"  value="Create account" type="submit" /></td></tr>
</table>

</sf:form>

</body>
</html>