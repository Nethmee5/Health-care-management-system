<%-- 
    Document   : patientsLogin
    Created on : April 20, 2021, 7:34:05 AM
    Author     : vinu
--%>

<%@page contentType="text/html" session="true" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en">
    <head>

        <title>Login | Health Shield</title>
        <!--nav-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,500,500i,600,600i,700,700i&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="css/animate.css">

        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">

        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/jquery.timepicker.css">

        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/style.css">



        <style>



            button {
                background-color:rgb(6, 6, 7);
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 30%;
            }

            button:hover {
                opacity: 0.8;
            }

            .cancelbtn {
                width:30%;

                background-color: #c20635;
            }

            .imgcontainer {
                text-align: center;
                margin: 20px 0 12px 0;
            }



            span.psw {
                float: right;
                padding-top: 16px;
            }

            /* Change styles for span and cancel button on extra small screens */
            @media screen and (max-width: 300px) {
                span.psw {
                    display: block;
                    float: none;
                }
                .cancelbtn {
                    width: 30%;
                }
            }



            .input-container {
                display: -ms-flexbox; /* IE10 */
                display: flex;
                width: 30%;
                margin-bottom: 15px;

            }
            .icon {

                padding: 15px;
                background: rgb(3, 4, 5) ;
                margin: 5px 0 22px 0;
                height:50px;
                min-width: 40px;
                text-align: center;
            }

            .input-field {
                width: 100%;
                padding: 10px;
                outline: none;
            }
            /* Full-width input fields */
            input[type=email], input[type=password] {
                width: 100%;
                padding: 10px;
                margin: 5px 0 22px 0;
                display: inline-block;
                border: none;
                background: #f1f1f1;
            }


            img {
                border-radius: 50%;
            }


            .navbar-nav ml-auto{
                width: 20%;
                height: 20%;
            }
        </style>
    </head>




    <body>
        <!-- nav start-->
        <div class="wrap">
            <div class="container">
               <!-- <div class="row justify-content-between">
                    <div class="col d-flex align-items-center">
                        <p class="mb-0 phone"><span class="mailus">Idea Seekes</span><span class="mailus">  email developers:</span> <a href="#">Ideaseekers@gmail.com</a></p>
                    </div>

                </div>-->
            </div>

        </div>
        <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar" id="ftco-navbar" style="background-color: #1A237E;">
            <div class="container">
                <a class="navbar-brand" href="index.html">Health Shield</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="fa fa-bars"></span> Menu
                </button>
                <div class="collapse navbar-collapse" id="ftco-nav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active"><a href="index.html" class="nav-link">Home</a></li>
                       <!-- <li class="nav-item"><a href="services.html" class="nav-link">About</a></li>
                        <li class="nav-item"><a href="rooms.html" class="nav-link">Contact</a></li>
                        <li class="nav-item"><a href="blog.html" class="nav-link">News</a></li>-->

                    </ul>

                </div>
            </div>
        </nav>
        <!-- END nav -->




        <!--Login Form-->
        <div class="container p-4 text-center">
            <p class="alert-danger text-danger">${msg}</p>
            <div class="imgcontainer">
                <img src="Images/us_av.png" alt="Avatar" style="width:100px">
            </div>
            <h2 class="text-center">Patients Login</h2>
            <center>
                
                <form action="/app/auth" method="post">
                    <div class="form-group">
                        <div class="input-container">
                            <i class="fa fa-user icon" style="color:white" ></i>
                            <input type="email" placeholder="Email" name="email" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-container">
                            <i class="fa fa-key icon" style="color:white"></i>
                            <input type="password" placeholder="Password" name="pass" required>
                        </div> 
                    </div>
                    
                    <!--routing config-->
                    <input type="hidden" name="role" value="cus">
                    <input type="hidden" name="q" value="login">
                    
                    <div class="form-group" >
                        <input type="submit" value="Login" class="btn btn-primary" style="background-color:#1A237E; border: none" >
                    </div>
                    <div class="form-group">
                        <input type="checkbox" checked="checked" name="remember" style="color:lightslategray"> Remember me
                    </div>
                    <hr>
                    <div class="form-group">
                        <p class="f" style="color:lightslategray">Don't you have a account?Click Here <a href="customerRegister.jsp" target="customerRegister.jsp" style="color:black">Register</a></p>
                    </div>
                    <!-- <div class="container" style="background-color:white">
                      <span class="psw">Forgot <a href="#">password?</a></span>
                    </div> -->
                </form>
            </center>
        </div>

    </section>

    <div class="footer" style="background-color:#1A237E;">
            <div class="continer">
                <div class="col-12 py-5" >
                    <p class="text-center my-auto">Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved developed by <a href="" target="_blank" style="color:white">Land Marks</a></p>
                </div>
            </div>
        </div>



    <script src="js/jquery.min.js"></script>
    <script src="js/jquery-migrate-3.0.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.easing.1.3.js"></script>
    <script src="js/jquery.waypoints.min.js"></script>
    <script src="js/jquery.stellar.min.js"></script>
    <script src="js/jquery.animateNumber.min.js"></script>
    <script src="js/bootstrap-datepicker.js"></script>
    <script src="js/jquery.timepicker.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/scrollax.min.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
    <script src="js/google-map.js"></script>
    <script src="js/main.js"></script>




</body>
</html>













