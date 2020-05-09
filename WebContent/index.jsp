<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
		if(request.getSession().getAttribute("loginstate")!="logined")
			response.sendRedirect("login.jsp");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
 <link rel="stylesheet" href="./css/index.css">
    <link rel="stylesheet" href="./css/form1.css">
    <link rel="stylesheet" href="./css/form2.css">
    <link rel="stylesheet" href="./css/form3.css">
    <link rel="stylesheet" href="./css/form4.css">
    <link rel="stylesheet" href="./css/form5.css">
</head>
<body>
 <div class="nav-left">
        <div class="wacai">
            <img src="./images/renminbi.png" alt="">
            <span>理财记账</span>
        </div>
        <div class="menu" id="menu">
            <ul>
                <li class="opt"> <img src="./images/iconsd.png" alt=""><span>理财服务</span> </li>
                <li> <img src="./images/money.png" alt=""> <span>余额记录</span></li>
                <li> <img src="./images/changyonglogo30.png" alt=""><span> 分期支付</span></li>
                <li> <img src="./images/jizhangben.png" alt=""> <span>记账</span></li>
                <li> <img src="./images/finance.png" alt=""> <span>筛选账单</span></li>
            </ul>
        </div>
    </div>
    <div class="nav-right">
        <div class="include">
            <div id="use">
                <div class="title" id="look">理财服务</div>
                <div class="title"> 余额记录</div>
                <div class="title"> 分期支付</div>
                <div class="title"> 记账</div>
                <div class="title"> 筛选账单</div>
            </div>
            <ul id='include'>
                <li id="show">
                    <form id='form1' action="AddManageFin" method="post">
                        <input class="input1" type="number" step="0.01" placeholder="理财金额" name="money">
                        <br>
                        <select class="select" name="licai" id="">
                            <option value="value1">余额宝</option>
                            <option value="value2">余利宝</option>
                        </select>
                        <br>
                        <input class="input2" type="number" placeholder="理财天数" name="days">
                        <br>
                        <input class="button" type="submit" value="理财">
                    </form>
                </li>
                <li>
                    <form id="form2" action="addBalCalCont" method="post">
                        <ul>
                            <li><input class="input1" id="111" type="number" step="0.01" placeholder="基础现金" name="baseMoney"></li>
                            <li><input type="number" placeholder="收入" step="0.01" name="income"></li>
                            <li><input type="number" placeholder="房租" step="0.01" name="rent"></li>
                            <li><input type="number" placeholder="水电" step="0.01" name="hydropower"></li>
                            <li><input type="number" placeholder="吃饭" step="0.01" name="eating"></li>
                            <li><input type="number" placeholder="请吃饭" step="0.01" name="dinner"></li>
                            <li><input type="number" placeholder="Ktv" step="0.01" name="ktv"></li>
                        </ul>
                        <input class="button" type="submit" value="">
                    </form>
                </li>
                <li>
                    <form id="form3" action="AddPayInstall" method="post">
                        <input class="input1" type="number" step="0.01" placeholder="支付金额" name="money">
                        <br>
                        <select class="select" name="pay_way" id="">
                            <option value="valeu1">蚂蚁花呗</option>
                            <option value="value2">余额</option>
                            <option value="value3">信用卡</option>
                        </select>
                        <br>
                        <input class="input1" type="number" placeholder="分期次数" name="installment">
                        <br>
                        <input class="button" type="submit" value="支付">
                    </form>
                </li>
                <li>
                    <form id="form4" action="AddBookkeep" method="post">
                        <span>发生时间</span>
                        <br>
                        <input class="input1" type="date" placeholder="2020-01-01" name="date">
                        <br>
                        <span>记账金额</span>
                        <br>
                        <input class="input1" type="number" step="0.01" placeholder="记账金额" name="money">
                        <br>                        
                        <span> 收入</span><input class="input2" type="number" step="0.01" name="income">
                                                   房租<input class="input2" step="0.01" type="number" name="rent">                        
                        <br>
                        <input class="button" type="submit" value="记一笔">
                    </form>
                </li>
                <li>
                    <form id="form5" action="LookUpCont" method="post">
                        <input class="input" type="date" name="date"><span>之前</span>
                        <br>
                        <input class="button" type="submit" value="查找">
                    </form>    
                </li>
            </ul>
        </div>
    </div>
</body>
<script src="./js/index.js"></script>
<script type="text/javascript">
var opt='<%= request.getSession().getAttribute("opt") %>';
if(opt==="ok"){
	alert("操作成功");
}
<%request.getSession().removeAttribute("opt");%>
</script>
</html>