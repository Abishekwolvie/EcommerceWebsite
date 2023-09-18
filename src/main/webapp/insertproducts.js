function pregval()
{
			sp=document.getElementsByClassName("erbox");
			
			// product id
			pid=document.getElementById("prid");
			if(pid.value=="")
			{
				sp[0].innerHTML="Enter the product name";
				return false;
			}
			else{
				sp[0].innerHTML="";
			}
			
			//Graphics card
			gr=document.getElementById("prgraphics");
			if(gr.selectedIndex==0)
			{
				sp[1].innerHTML="Select the graphics card";
				return false;
			}
			else
			{
				sp[1].innerHTML="";
			}
			//processor
			procs=document.getElementById("prprc");
			if(procs.selectedIndex==0)
			{
				sp[2].innerHTML="Select the processor";
				return false;
			}
			else
			{
				sp[2].innerHTML="";
			}
			//ram
			rm=document.getElementById("prram");
			if(rm.selectedIndex==0)
			{
				sp[3].innerHTML="Select the ram";
				return false;
				
			}
			else
			{
				sp[3].innerHTML="";
			}
			
			//product price
			pric=document.getElementById("prprice");
			if(pric.value=="")
			{
				sp[4].innerHTML="Enter the product price";
				return false;
			}
			else if(isNaN(pric.value)) // to check if the entered value is a number
			{
				sp[4].innerHTML="Enter only numbers";
				return false;
			}
			else
			{
				sp[4].innerHTML="";
			}
			


}