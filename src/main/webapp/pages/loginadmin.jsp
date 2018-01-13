    <%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <center>
      
      <div class="section"></div>

      
      <div class="section"></div>

      <div class="container">
     
        <div class="z-depth-1 grey lighten-4 row" style="display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;">

          <form class="col s12" method="post">
            <div class='row'>
              <div class='col s12'>
               
              </div>
            </div>

            <div class='row'>
     			<h5 style="color:#00695c;"><b>ADMIN</b></h5>
              <div class='input-field col s12'>
              
                <input class='validate' type='email' name='email' id='email' />
                <label for='email'>Enter your email</label>
              </div>
            </div>

            <div class='row'>
              <div class='input-field col s12'>
                <input class='validate' type='password' name='password' id='password' />
                <label for='password'>Enter your password</label>
              </div>
              <label style='float: right;'>
                                <a class='' style="color: #009688" href='#!'><b>Forgot Password?</b></a>
                            </label>
            </div>

            <br />
            <center>
              <div class='row'>
                <button type='submit' name='btn_login' class='col s12 btn btn-large waves-effect teal darken-1 '>Login</button>
              </div>
            </center>
          </form>
        </div>
      </div>
     
    </center>
    