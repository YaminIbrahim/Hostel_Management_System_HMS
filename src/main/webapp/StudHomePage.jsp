<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   

<%@page  import="java.sql.*"%>

<%@page import="com.hostel.util.DBConn" %>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        
        <title>Home Page</title>
        
        <link rel="stylesheet" href="stylehome.css">
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    </head>
    
    <body>
        
        <%
            request.getAttribute("email");
                
            Connection con = null;
            Statement statement = null;
                ResultSet resultSet = null;
                
                String username = "USER";
                String email = "USER";
                
                try{
                    con = DBConn.createConnection();
                    
                    statement= con.createStatement();
                    resultSet = statement.executeQuery("select * from student");
                    
                    String emailDB = "";
                    String usernameDB = "";
                    
                    while(resultSet.next()){
                        
                        usernameDB = resultSet.getString("studUserName");
                        emailDB  =resultSet.getString("studEmail");
                    
                        if(emailDB.equals(request.getAttribute("email"))){
                            username = resultSet.getString(2);
                            email = resultSet.getString(3);
                        }
                    }
                    
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            %>
        
        <!-- box description -->
        <div class="container">
            
            <!-- header -->
            <div class="welcometypo">
                <h2>Welcome<h2>
                <h1><% out.println(username); %><br/></h1>
            </div>
            
            <br/>
            
            <div class="photo-desc">
                <p>
                    A hostel is a place where student can stay for short or long periods of time. It provides basic facilities like bathrooms, 
                    showers and kitchens, as well as beds and lockers to store personal belongings. A successful hostel management involves making 
                    sure that the students are satisfied with their stay. Our hostel consist of one person room, two person room, four person room, 
                    and dorm that can fit eight to sixteen person per dorm. Each room category varies in different prices. Pictures below shows a few 
                    picture from our hostel facility and room.
                </p>
            </div>
            
            <!-- photo gallery -->
            <div class="gallery">
                <img src="image/dorm7.png" alt="image dorm">
                <div class="desc">2 person room</div>
            </div>
            
            <div class="gallery">
                <img src="image/dorm2.png" alt="image dorm">
                <div class="desc">4 person room</div>
            </div>
            
            <div class="gallery">
                <img src="image/dorm3.png" alt="image dorm">
                <div class="desc">4 person room</div>
            </div>
            
            <div class="gallery">
                <img src="image/dorm8.png" alt="image dorm">
                <div class="desc">8 person room</div>
            </div>
            
            <div class="gallery">
                <img src="image/dorm4.png" alt="image dorm">
                <div class="desc">Dorm</div>
            </div>
            
            <div class="gallery">
                <img src="image/dorm6.png" alt="image dorm">
                <div class="desc">Dorm</div>
            </div>
            
            <br/><br/><hr>
            
            <div class="info">
                <h2 class="info" id="info">Hostel Information</h2>
            </div>
            
            <hr>
            
            <div class="P-Desc">
                <p>
                    Hostek X, under the management of the Office of International Affairs (OIA), 
                    offers accomodation to UiTM international students and local students (based on availability). Single and married students may 
                    apply for accomodation through X Residential College Office Management.<br><br>

                    Hostel X begin its operation on 1 February 2008 and the first batch of international students was registered 
                    residents on July Semester 2008. The 11-storey condominium consists of 83 units. Each unit consists of 3 bedrooms, a living area, 
                    a dining area, a kitchen and 2 bathrooms (one bathroom is attached to the master bedroom). The units are fully furnished (a sofa set, 
                    a dining table and chairs, a refrigerator, a shoe rack, a kitchen cabinet) and some rooms are air-conditioned. Each bedrooms are 
                    basically equipped with a bed (single or double), study table with bookshelf, a chair, a cupboard and a clothes hanger.<br><br>

                    Among the other facilities provided are covered car park, 24 hours security service, TV/recreation room, social activity and meeting 
                    rooms, a discussion room, a computer room. Within the vacinity there are convenience store, childrens playground, laundrette and a 
                    surau.<br><br>

                    Hostel X is strategically located with 15 minutes walk to UiTM Main Campus. It is closely located to i-City, Wet World Waterpark, 
                    Supermarkets (Giant, AEON, Tesco), Shopping Complexes (PKNS, SACC Mall, Plaza Alam Sentral), Shah Alam Hospital, restaurants, 
                    petrol pump stations, KTM Commuter Station (Padang Jawa) and Section 7 Business Centres amongst others. Kristal residents have an 
                    easy acess to Bukit Raja, Klang and the Federal Highway.<br><br>

                    Kristal Residential College is managed by a manager and assisted by administrative staff and a residence staff cum counselor. 
                    The staff manages the administrative matters and maintenance of the College, while the residence staff focus on students matters and 
                    activities.<br><br>

                    Kristal Residential College places great emphasize on conducive living environment, creating a sense of community and an atmosphere 
                    of cooperation, safety and responsibility.<br><br>
                </p>
            </div>
            
            <br/><br/><hr>
            
            <div class="info">
                <h2 class="info" id="rule">Hostel Rule</h2>
            </div>
            
            <hr>
            
            <div class="P-Desc">
                <p>
                    <h2>1.0 DRESS CODE FOR STUDENTS</h2><br>
                        <h3>1.1 MALE STUDENTS</h3><br>
                            <b style="font-size: 18px">i) During Office Hours (8.00am -5.00pm) –Weekdays (Monday-Friday), Study Break and Examination</b><br>
                                <i class="fa fa-angle-right"></i>  Formal- long/short sleeve shirt (tucked in ) with tie and slacks<br>
                                <i class="fa fa-angle-right"></i>  Jeans are allowed but must not be faded or tattered<br>
                                <i class="fa fa-angle-right"></i>  No sagging or cargo pants allowed<br>
                                <i class="fa fa-angle-right"></i>  Traditional attire is allowed on Fridays only<br>
                                <i class="fa fa-angle-right"></i>  Sandals/slippers are not allowed<br>
                                <i class="fa fa-angle-right"></i>  Collarless T-shirts are not allowed
                                
                            <br><br>
                                
                            <b style="font-size: 18px">ii) After Office Hours (5pm onwards-Monday to Friday: Saturday, Sunday and Public Holiday)</b><br>
                                <i class="fa fa-angle-right"></i>  If there are classes, official functions, seminars or meetings, students must be formally dressed as in 1(a)<br>
                                <i class="fa fa-angle-right"></i>  Collarless T-shirts, shorts, sandals or slippers (only dinner at cafeteria and field)
                                
                            <br><br>
                                
                             <b style="font-size: 18px">iii) Hairstyle</b><br>
                                <i class="fa fa-angle-right"></i>  Short, collar length is allowed<br>
                                <i class="fa fa-angle-right"></i>  Hair not to bleached/dyed in extreme colours<br>
                                <i class="fa fa-angle-right"></i>  No punk styles
                                
                            <br><br>
                                
                            <b style="font-size: 18px">iv) Earrings</b><br>
                                <i class="fa fa-angle-right"></i>  Earrings or ear studs of any form or type, bangles (except for students of Sikh faith), wrist
                                chains and long chains are not allowed in the Hostel or campus grounds. <br>
                                <i class="fa fa-angle-right"></i>  Tattoos of any form or type are not allowed.<br>
                </p>
            </div>
            
            <br><br>
            
            <!--footer-->
            <footer class="footer">
                <div class="container bottom_border">
                    <div class="row">
                        <h5 class="find call" id="contact">Contact us</h5>
                        <p class="find-desc">  Find us using information below</p>
                        <p><i class="fa fa-location-arrow"></i>  40, Jalan Pualam 7/32, Seksyen 7, 40000 Shah Alam, Selangor</p>
                        <p><i class="fa fa-user"></i>  Muhammad Yamin bin Ibrahim</p>
                        <p><i class="fa fa-phone"></i>  +6011-2106 0402</p>
                        <p><i class="fa fa fa-envelope"></i>  2020459282@student.uitm.edu.my</p>
                    </div>
                </div>
            </footer>
            
        </div><!-- close div container -->
        
        <!-- side menu -->
        <nav>
            <ul>
                <li>
                    <a href="#" class="logo">
                        <img src="image/HMSLogo.png" alt="logo">
                        <span class="nav-item"> Hostel MS </span>
                    </a>
                </li>
                
                <hr>
                <p class="title"> Hostel </p>
                
                <!-- link for contact -->
                <li>
                    <a href="#info" class="menu-list">
                        <i class="fas fa-address-card"></i>
                        <span class="nav-item"> Information </span>
                    </a>
                </li>
                
                <li>
                    <a href="#rule" class="menu-list">
                        <i class="fas fa-balance-scale"></i>
                        <span class="nav-item"> Rule </span>
                    </a>
                </li>
                
                <li>
                    <a href="#contact" class="menu-list">
                        <i class="fas fa-phone"></i>
                        <span class="nav-item"> Contact </span>
                    </a>
                </li>
                
                <hr>
                <p class="title"> Features </p>
                
                <!-- Hostel Billing button -->
                <div class="box">
                
                <li>
                    <a href="StudViewRecord.jsp" class="menu-list">
                        <i class="fas fa-university"></i>
                        <span class="nav-item">Student Record</span>
                    </a>
                </li>
                    
                <li>
                    <a href="StudProfile.jsp?email=<c:out value='${email}'/> " class="menu-list">
                        <i class="fas fa-user"></i>
                        <span class="nav-item"> Profile </span>
                    </a>
                </li>
                
                </div>
                
                <!-- logout button -->
                <li>
                    <a href="StudLogoutServlet" class="menu-list logout">
                        <i class="fas fa-sign-out-alt"></i>
                        <span class="nav-item"> Logout </span>
                    </a>
                </li>
                
            </ul>
        </nav>
        

        
    </body>
</html>
