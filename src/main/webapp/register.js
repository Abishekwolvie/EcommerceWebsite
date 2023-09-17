        function regval()
        {
            var email=document.getElementById("usremail");
            var cnfuserpassword=document.getElementById("cnfusrpass");
            
            var username=document.getElementById("usrname");
            var userpassword=document.getElementById("usrpass");

            var sp=document.getElementsByClassName("erbox");
        
        //email
            if(email.value=="")
            {
                sp[0].innerHTML="Enter the email";
                return false;
            }
            else
            {
                sp[0].innerHTML="";
                
            }
        
        //password

            if(userpassword.value==""){
                sp[1].innerHTML="Enter the password";
                return false;
            }
            else
            {
                sp[1].innerHTML="";
            }

        //confirm password

            if(cnfuserpassword.value==""){
                sp[2].innerHTML="Enter the password";
                return false;
            }
            else
            {
                sp[2].innerHTML="";
            }

        //confim password and password check

            if(userpassword.value!=cnfuserpassword.value){
                sp[2].innerHTML="Password and confirm password should match";
                return false;

            }
            else
            {
                sp[2].innerHTML="";
            }
         //mobile number
         var exp=/^[6-9]{1}[0-9]{9}$/;
         var mob=document.getElementById("mobno");
         
         if(mob.value=="")
         {
			 sp[3].innerHTML="Enter the mobile number";
			 return false;
		 }
		 else if(exp.test(mob.value)==false)
		 {
			sp[3].innerHTML="Invalid format";
			 return false;
		 }
		 else
		 {
			 sp[3].innerHTML="";
		 }


        }