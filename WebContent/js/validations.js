function myFunction(){
	var pid=document.getElementById("pid").value;
	var name=document.getElementById("name").value;
	var price=document.getElementById("price").value;
	if(pid==null||pid.trim()==""){
		document.getElementById("pidErr").style.display="inline";
	}
	else if(name.trim()==""){
		document.getElementById("nameErr").style.display="inline";
	}
	else if(price==null||price.trim()==""){
		document.getElementById("priceErr").style.display="inline";
	}
	else{
		document.getElementById("productManagementForm").submit();
	}
}