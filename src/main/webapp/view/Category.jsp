<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>

<script>

var xmlhttp;
var buttonclicked;
var message;
function sendData(button)
{
	var cid = document.categoryForm.cid.value;
	var cname = document.categoryForm.cname.value;
	
	var javascriptobject ={"cid":cid,"cname":cname}
	
	xmlhttp = new XMLHttpRequest();
	
	 buttonclicked = button.value;
	if(buttonclicked=="post")
	{
		message = "data is inserted successfully";
	xmlhttp.open("post","CategoryInfo/saveCategory");
	}
	else
		{
		message = "data in updated successfully";
		xmlhttp.open("put","CategoryInfo/updateCategory");
		}
	
	xmlhttp.onload=displayResponse;
	
	var jsonstring = JSON.stringify(javascriptobject);
	
	xmlhttp.setRequestHeader('Content-type','application/json');
	
	xmlhttp.send(jsonstring);
	
	alert("Data send to api");
	
	}
	
	function displayResponse()
	{
		alert(xmlhttp.responseText);
		document.getElementById("message").innerHTML=message;
	}
	
	
	
	function getData(button)
	{
		var cid = document.categoryForm.cid.value;
		
		xmlhttp = new XMLHttpRequest();
		
		 buttonclicked = button.value;
		
		if(buttonclicked=="get")
			{
			message = "data is retrieved successfully";
		xmlhttp.open("get","CategoryInfo/getCategory/" + cid);
			}
		
		else
			{
			message = "data is deleted successfully";
			xmlhttp.open("Delete","CategoryInfo/deleteCategory/" + cid);
			}
		
		xmlhttp.onload=displayResponse2;
		
		xmlhttp.send();
	}
	
	
	function displayResponse2()
	{
	
		var jsonstring = xmlhttp.responseText;
		var obj = JSON.parse(jsonstring); //parse () method convert json string to javascript object
		
		var cname = obj.cname;
		
			if(obj.message!=undefined)
			{
				document.categoryForm.cname.value=" ";
				document.getElementById("message").innerHTML=obj.message;
			}
			else
				{
		document.categoryForm.cname.value=cname;
		document.getElementById("message").innerHTML=message;
				}
	}
	
	
	function getAllData()
	{
		
		xmlhttp = new XMLHttpRequest(); // xmlhttp is predefined class
		
		xmlhttp.onload=displayResponse3;
		
		xmlhttp.open("get","CategoryInfo/getAllCategory");
		
		xmlhttp.send();
		
	}

	function displayResponse3()
	{
		alert(xmlhttp.responseText);
		
		
		var AllJSONStrings = xmlhttp.responseText;
		
		
		var p1 = document.getElementById("p1");
		/*
		var data = " ";
		for(var i =0;AllJSONStrings.length;i++)
			{
			var obj = JSON.parse(AllJSONStrings[i]);
			data = data + obj + "<br>";
			}
		
		*/
		
		p1.innerHTML= AllJSONStrings;
	
	}
	
	
	

</script>
<style>

@import url('https://fonts.googleapis.com/css?family=Raleway:400,700');

body {
  background: #c0c0c0; 
  font-family: Raleway, sans-serif;
  color: #666;
}

.login {
  margin: 20px auto;
  padding: 40px 50px;
  max-width: 300px;
  border-radius: 5px;
  background: #fff;
  box-shadow: 1px 1px 1px #666;
}
  .login input {
    width: 80%;
    display: block;
    box-sizing: border-box;
    margin: 10px 0;
    padding: 14px 12px;
    font-size: 16px;
    border-radius: 2px; 
    font-family: Raleway, sans-serif;
  }

.login input[type=text],
.login input[type=password] {
  border: 1px solid #c0c0c0;
  transition: .2s;
}

.login input[type=text]:hover {
  border-color: #F44336;
  outline: none;
  transition: all .2s ease-in-out;
} 

.login input[type=button] {
  border: none;
  background: #EF5350;
  color: white;
  font-weight: bold;  
  transition: 0.2s;
  margin: 20px 0px;
}

.login input[type=button]:hover {
  background: #F44336;  
}

  .login h2 {
    margin: 20px 0 0; 
    color: #EF5350;
    font-size: 28px;
  }

.login p {
  margin-bottom: 40px;
}

.links {
  display: table;
  width: 100%;  
  box-sizing: border-box;
  border-top: 1px solid #c0c0c0;
  margin-bottom: 10px;
}

.links a {
  display: table-cell;
  padding-top: 10px;
}

.links a:first-child {
  text-align: left;
}

.links a:last-child {
  text-align: right;
}

  .login h2,
  .login p,
  .login a {
    text-align: center;    
  }

.login a {
  text-decoration: none;  
  font-size: .8em;
}

.login a:visited {
  color: inherit;
}

.login a:hover {
  text-decoration: underline;
}


span 
{
font-size: 30px;
color: red;
margin:400px;
}



</style>
</head>
<body>
<span id = "message">Waiting</span>
<form class="login" name=categoryForm>
  <h2>Category</h2>
  <p>Please Enter Category Id and Password</p>
  <input name=cid placeholder="Enter cid" />
  <input name=cname placeholder="Enter Category name" />
  <input type="button" value="post" onclick="sendData(this)" />
   <input type="button" value="get" onclick="getData(this)" />
    <input type="button" value="put" onclick="sendData(this)" />
     <input type="button" value="Delete" onclick="getData(this)" />
      <input type="button" value="getall" onclick="getAllData()" />
      
      
      <p id ="p1">All Category Data</p>

</form>

</body>
</html>