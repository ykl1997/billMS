let finput=document.getElementById('111');
finput.onblur=function(){
    let finputv=finput.value;
    if(!finputv){
        alert('内容不能为空');
    }
}