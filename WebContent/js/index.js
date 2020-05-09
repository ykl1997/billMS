let navlist = document.getElementById("menu").children[0].children;
let includelist = document.getElementById("include").children;
let looklist=document.getElementById("use").children;
for (let i = 0; i < navlist.length; i++) {
    navlist[i].onclick = function () {
        navlist[i].setAttribute('index',i);
        let index=navlist[i].getAttribute('index');
        for (let j = 0; j < navlist.length; j++) {
            navlist[j].removeAttribute("class");
        }
        this.className = 'opt';

        for (let k = 0; k < includelist.length; k++) {
            includelist[k].removeAttribute('id');
            looklist[k].removeAttribute('id');
        }
        includelist[index].id='show';
        looklist[index].id='look';
    }
}

