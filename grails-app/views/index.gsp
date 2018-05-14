<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
    <content tag="nav">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Application Status <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="#">Environment: ${grails.util.Environment.current.name}</a></li>
                <li><a href="#">App profile: ${grailsApplication.config.grails?.profile}</a></li>
                <li><a href="#">App version:
                    <g:meta name="info.app.version"/></a>
                </li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Grails version:
                    <g:meta name="info.app.grailsVersion"/></a>
                </li>
                <li><a href="#">Groovy version: ${GroovySystem.getVersion()}</a></li>
                <li><a href="#">JVM version: ${System.getProperty('java.version')}</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Artefacts <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="#">Controllers: ${grailsApplication.controllerClasses.size()}</a></li>
                <li><a href="#">Domains: ${grailsApplication.domainClasses.size()}</a></li>
                <li><a href="#">Services: ${grailsApplication.serviceClasses.size()}</a></li>
                <li><a href="#">Tag Libraries: ${grailsApplication.tagLibClasses.size()}</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Installed Plugins <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
                    <li><a href="#">${plugin.name} - ${plugin.version}</a></li>
                </g:each>
            </ul>
        </li>
    </content>

    <div id="content" role="main" style="background-color:#ffe43b" style="font-weight:bold" style="color:green">
        <section class="row colset-2-its">
            <h1>Welcome to the Schilling Store!
            <style>
                h1{
                    white-space: pre-line;
                }
            </style>
            </h1>
            <h2>Ketu-Sami: Styling and Create Project, Alex-Deryk: Categories, William-Emmett: Products, Sean-Parker: Manufacturers</h2>

            <div id="controllers" role="navigation">
            <div class="svg" role="presentation">
                <div class="grails-logo-container">
                <asset:image src="Crest.svg" class="grails-logo"/>
            </div>
            </div>
    </div>

<div id="content" role="main" style="background-color:#ffe43b" style="font-weight:bold" style="color:green">
                <h2>Store Assets:</h2>
                <div class="col-sm-6 col-right">
                    <g:link controller="product">Products</g:link>
                </div>
                <div class="col-sm-6 col-right">
                    <g:link controller="category">Categories</g:link>
                </div>
                <div class="col-sm-6 col-right">
                    <g:link controller="manufacturer">Manufacturers</g:link>
                </div>
                <div class="col-sm-6 col-right">
                    <g:link controller="productOrder">Orders</g:link>
                </div>
                <div class="col-sm-6 col-right">
                    <g:link controller="user">Users</g:link>
                </div>
                <div class="col-sm-6 col-right">
                    <g:link controller="productReview">Reviews</g:link>
                </div>
            </div>
        </section>
    </div>

</body>
</html>
