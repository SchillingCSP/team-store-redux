<%@ page import="team.store.redux.Product" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-product" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content…"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="list-product">
    <h1>Our Products</h1>
    <table>
        <tr><th>Products</th></tr>
        <g:each var="product" in="${productList}">
            <tr>
                <td>
                    <g:link class="show" action="show" resource="${product}">${team.store.redux.Product.name}</g:link>
                </td>
            </tr>
        </g:each>
    </table>
</div>
</body>
</html>