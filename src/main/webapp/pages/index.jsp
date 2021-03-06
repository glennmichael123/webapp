<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
        <%@ page contentType="text/html; charset=UTF-8" %>

            <!DOCTYPE html>

            <html>

            <head>
                <!--Import Google Icon Font-->
                <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
                <!--Import materialize.css-->
                <link rel="stylesheet" href="css/materialize.min.css">
                <link rel="stylesheet" href="css/materialize.css">
                <link rel="stylesheet" href="css/indexstyle.css">
                <!--Let browser know website is optimized for mobile-->
                <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            </head>

            <body>
            
            
            
                <div id="header">
                
                    <!-- Dropdown Structure -->
                    <ul id="dropdown1" class="dropdown-content">
                        <li><a href="#" class="to-user">User</a></li>
                        <li><a href="#" class="to-admin">Admin</a></li>
                    </ul>
                    <nav>
                        <div class="nav-wrapper teal darken-1">
                            <a href="#!" class="brand-logo">Alliance</a>
                            <ul class="right hide-on-med-and-down">
                                <li><a class="dropdown-button" href="#!" data-activates="dropdown1">Login as<i class="material-icons right">arrow_drop_down</i></a></li>
                            </ul>
                        </div>
                    </nav>
                </div>
                <div class="progress">
                    <div class="indeterminate"></div>
                </div>
                <div id="main-container"></div>

                <!--Import jQuery before materialize.js-->
                <script src="js/jquery.min.js"></script>
                <script src="js/materialize.min.js"></script>
                 <script src="js/main.js"></script>	
                
            </body>

            </html>
	
        