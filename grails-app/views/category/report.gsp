<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'category.label', default: 'Category')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-category" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content…"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
        <li><g:link class="report" action="report">Report</g:link></li>
    </ul>
</div>
<div id="list-category">
    <h1>Categories</h1>
    <table>
        <tr><th>team.store.Category</th><th>Products</th></tr>
        <g:each var="category" in="${categoryList}">
            <tr>
                <td>
                    <g:link class="show" action="show" resource="${category}">${category.name}</g:link>
                </td>
                <td>
                    <ul>
                        <g:each var="product" in="${schilling.store.kens.Product.findAllByCategory(category)}">
                            <li><g:link class="show" action="show" resource="${product}">${product.name}</g:link></li>
                        </g:each>
                    </ul>
                </td>
            </tr>
        </g:each>
    </table>
</div>
</body>
</html>