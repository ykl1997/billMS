function createXMLHttpRequest() {
    var xmlHttp;
    try {
        xmlHttp = new XMLHttpRequest();
    } catch (e) {
        try {
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                alert("您当前浏览器不支持异步请求");
            }
        }
    }
    return xmlHttp;
}

function send() {
    var xmlHttp = createXMLHttpRequest();
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            if (xmlHttp.responseText == "true") {
                document.getElementById("error").innerHTML = "用户名已被注册！";
            } else {
                document.getElementById("error").innerHTML = "";
            }
        }
    };
    xmlHttp.open("POST", "/billMS/CheckUser", true);
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    var username = document.getElementById("username").value;
    xmlHttp.send("username=" + username);
}

let passwordinput = document.getElementById("idpassword");
passwordinput.addEventListener("blur", function () {
    let password=document.getElementById("password");
    if (passwordinput.value === password.value) {
        document.getElementById("error1").innerHTML = "";
    } else {
        document.getElementById("error1").innerHTML = "两次密码不一致";
    }
})
