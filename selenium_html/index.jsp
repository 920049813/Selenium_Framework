<html>
<head>
	<title>界面自动化测试用例</title>
</head>
<style type="text/css">
	table{font-size:20;text-align:center;width:80%;border-collapse:collapse;margin:auto}	
	table th{background: #ccc}
	.display{color:red}
	.widgetStyle{text-align:left;padding-left:100px}	
</style>
<script>

function display_alert(){
  alert("请点击确定")
}
function display_confirm(){
   result = confirm("我是提示信息"); 
   if(result){alert("你点击的结果是-确定");}
   else{alert("你点击的结果是--取消");
	   }   
        
}
function display_prompt(){
    result = prompt("我是提示信息")
if(result){alert("你点击的结果是-确定");}
   else{alert("你点击的结果是--取消");
	   }   



}



function show_div(){   
	setTimeout("create_div()", 3000);   
}      
function create_div(){   
	d = document.createElement('div'); 	
	d.className = "red";  
	d.style.color='red';
	d.innerHTML="wait for display";
	document.getElementById("display").appendChild(d);   
}   
function mouseOver(){
	document.getElementById("over").innerHTML="<div class='display'>Hello World!</div>";
}
function mouseOut(){
	document.getElementById("over").innerHTML="";
}
</script>
<body>
<div>
	<div class="text" style="font-size:36;text-align:center"><b>UI 自动化测试</b>主页</div>
	<br/>
	<table cellpadding="10" cellspacing="0" border="1">
		<thead>
			<tr>
				<th width=20% class="widgetleft">控件名称</th>
				<th width=80% class="widgetStyle">控件操作</th>				
			</tr>
		</thead>
				<tbody>
					<tr>
						<td>Input按钮</td>
						<td class="widgetStyle"><div id='input'><input type="text" id="user"/></div></td>											
					</tr>
					<tr>
						<td>Link链接</td>
						<td class="widgetStyle"><div id='link'><a href="http://10.67.89.7/webcomm/" class='baidu'>登陆界面</a></div></td>						
					</tr>
					<tr>
						<td>Select下拉列表框</td>
						<td class="widgetStyle"><div id='select'>
								<select name='select' id="moreSelect">
								  <option value ="iphone">iphone</option>
								  <option value ="oppe">oppe</option>
								  <option value="vivo">vivo</option>
								  <option value="meizu">meizu</option>
								  <option value="huawei">huawei</option>
								  <option value="xiaomi">xiaomi</option>
								</select>
							</div>
						</td>						
					</tr>
					<tr>
						<td>RadioBox单选框</td>
						<td class="widgetStyle">
							<div id='radio'>
								<input type='radio' name="identity" class='Volvo'/><label>Volvo</label></br>
								<input type='radio' name="identity" class='Saab'/><label>Saab</label></br>
								<input type='radio' name="identity" class='Opel'/><label>Opel</label></br>
								<input type='radio' name="identity" class='Audi'/><label>Audi</label>
							</div>
						
						</td>						
					</tr>
					<tr>
						<td><p>CheckBox复选框</p></td>
						<td class="widgetStyle">
							<div id='checkbox'>
								<input type="checkbox" name="checkbox1"/><label>Volvo</label></br>
								<input type="checkbox" name="checkbox2"/><label>Saab</label></br>
								<input type="checkbox" name="checkbox3"/><label>Opel</label></br>
								<input type="checkbox" name="checkbox4"/><label>Audi</label> 
							</div>
						</td>						
					</tr>
					<tr>
						<td>Button按钮</td>
						<td class="widgetStyle"><div id='button'>
						<input name="buttonhtml" type='button' class='button' value='Submit' disabled="disabled"/>
						<input  type="button" class="btnSousuo" id="id01" value="打开百度" onclick="window.location.href='http://www.baidu.com'"/> 
						</div></td>						
					</tr>
                    <tr>
						<td>Alert警告框</td>
						<td class="widgetStyle"><div id='alert'><input type='button' class='alert' value='Alert' onclick='display_alert()'/></div></td>						
					</tr>
					<tr>
						<td>Confirm确认框</td>
						<td class="widgetStyle"><div id='confirm'><input type='button' class='confirm' value='confirm' onclick='display_confirm()'/></div></td>						
					</tr>
                    <tr>
						<td>Prompt提示框</td>
						<td class="widgetStyle"><div id='prompt'><input type='button' class='prompt' value='prompt' onclick='display_prompt()'/></div></td>						
					</tr>
                    
					<tr>
						<td>Upload上传</td>
						<td class="widgetStyle"><div id='upload'><input type='file' id='load'/></div></td>						
					</tr>
					<tr>
						<td>Open New Window打开新窗口</td>
						<td class="widgetStyle"><div id='open'><a href="demo1.html" class='open' target='_bank'>Open new window</a></div></td>						
					</tr>
					<tr>
						<td>Action获取焦点触发</td>
						<td class="widgetStyle"><div id='action'>
								<input type='button' class='over' value='Action'onmouseover="mouseOver()" onMouseOut="mouseOut()"/><div id='over'></div>
							</div>
						</td>						
					</tr>
					<tr>
						<td>Wait等待时间触发</td>
						<td class="widgetStyle">
							<div id='wait'><input type='button' class='wait' value='Wait' onclick = "show_div()"/></div>
							<div id='display'></div>
						</td>						
					</tr>
					<tr>
					<td>多选下拉框</td>
					<td class="widgetStyle">
					  <select id="selectWithMultipleEqualsMultiple" multiple="multiple">
					  <option selected="selected" label="emmental">Emmental</option>
					  <option label="roquefort">Roquefort</option>
					  <option label="parmigiano">Parmigiano</option>
					  <option label="cheddar">Cheddar</option>
                      </select>
					  </td>
					</tr>
					<tr>
						<td>Iframe子框架</td>
						<td class="widgetStyle">
							<iframe width=800 height=330 name=aa frameborder=0 src="./demo1.html"></iframe>
						</td>						
					</tr>
				</tbody>
			
		
	</table>
	<br/>
</div>
</body>
</html>
