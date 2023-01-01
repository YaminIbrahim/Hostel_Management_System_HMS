<%@page contentType="text/html" pageEncoding="windows-1252"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        
        <title>Student Login</title>
        
        <link rel="stylesheet" href="styleLogin.css">
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    </head>
    
    <body>
        <div class="welcometypo">
            <div class="typo-1">
                Welcome to
            </div>
            <div class="typo-2">
                Hostel Management System <br/>
            </div>
        </div>
        
        <!-- Container -->
        <div class="container">
            
            <!-- flip for to close -->
            <input type="checkbox" id="flip">
            
            <!-- image to cover -->
            <div class="cover">
                <div class="front">
                    <img src="image/loginBG2.png" alt="login image">
                </div>
                
                <div class="back">
                    <img class="backImg" src="image/loginBG1.png" alt="register image">
                </div>
            </div>
            
            <!-- Form -->
            <form action="StudLoginRegisterServlet" method="post">
                <div class="form-content">
                    
                    <!-- login div -->
                    <div class="login-form">
                    
                        <!-- login title -->
                        <div class="title">
                            Login
                        </div>
                    
                        <!-- input box for login -->
                        <div class="input-boxes">
                            
                            <!-- input login email -->
                            <div class="input-box">
                                <i class="fas fa-envelope"></i>
                                <input type="text" 
                                       name="loginEmail"
                                       placeholder="Enter your educational email">
                            </div>
                            
                            <!-- input login password -->
                            <div class="input-box">
                                <i class="fas fa-lock"></i>
                                <input type="password" 
                                       name="loginPassword"
                                       placeholder="Enter your password">
                            </div>
                        
                            <!-- forgot password link -->
                            <div class="text">
                                <a href="#">forgot password?</a>
                            </div>
                        
                            <!-- login button -->
                            <div class="button input-box">
                                <input type="submit" 
                                       name="login"
                                       value="login">
                            </div>
                        
                            <!-- Register link -->
                            <div class="text register-text">
                                Don't have any account?
                                <label for="flip"> Register here </label>
                            </div>
                        
                        </div>
                    </div>
                    
                    <!-- register div -->
                    <div class="register-form">
                    
                        <!-- register title -->
                        <div class="title">
                            Register
                        </div>
                    
                        <!-- input box -->
                        <div class="input-boxes">
                            
                            <!-- input for username -->
                            <div class="input-box">
                                <i class="fas fa-user"></i>
                                <input type="text" 
                                       name="username"
                                       placeholder="Enter your username">
                            </div>
                        
                            <!-- input for email -->
                            <div class="input-box">
                                <i class="fas fa-envelope"></i>
                                <input type="text" 
                                       name="email"
                                       placeholder="Enter your educational email">
                            </div>
                        
                            <!-- input for password -->
                            <div class="input-box">
                                <i class="fas fa-lock"></i>
                                <input type="password" 
                                       name="password"
                                       placeholder="Enter your password">
                            </div>
                            
                            <!-- input for password -->
                            <div class="input-box">
                                <i class="fas fa-lock"></i>
                                <input type="password" 
                                       name="confirmPassword"
                                       placeholder="Enter your confirm password">
                            </div>
                        
                            <!-- register button -->
                            <div class="button input-box">
                                <input type="submit" 
                                       name="register"
                                       value="register">
                            </div>
                        
                            <!-- Login link -->
                            <div class="text register-text">
                                Already have an account?
                                <label for="flip"> Login here </label>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div> 
    </body>
</html>
