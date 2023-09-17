        function loginval()
        {
            
            errormsg=document.getElementsByClassName("erbox");

            //username

            username=document.getElementById("usrname");
            if(username.value=="")
            {
                errormsg[0].innerHTML="Enter the username";
                return false;
            }
            else{
                errormsg[0].innerHTML="";
            }

            //passwor

            password=document.getElementById("usrpass");
            if(password.value=="")
            {
                errormsg[1].innerHTML="Enter the password";
                return false;
            }
            else
            {
                errormsg[1].innerHTML="";
            }
        }