// phan dang ky
function kiemtra(bt1){
	if(ktname(bt1)&&ktpass(bt1)) infor(bt1);
	else {
		alert("!Error register");
		bt1.txtf1.value = "";
		bt1.txtf2.value = "";
		bt1.txtf3.value = "";
	}

function ktname(bt1){
	if((bt1.txtf1.value == "" )) return false;
	else return true;
}

function ktpass(bt1){
	if(bt1.txtf2.value == bt1.txtf3.value) return true;
	else return false;
}

function ktmail(frmRegister){
regMail = /\w{1,10}@\w{2,5}\.\w{3,5}/;
	
	if(regMail.test(frmRegister.txtMail.value))
	return true;
	else return false;
}

function infor(bt1){
	var strInfor="";
	var dem = 0;
	//Lay thong tin tu textBox, textAre, Password
	strInfor += "Ten: " + bt1.txtf1.value;
	strInfor += "\nMat khau: " + bt1.txtf2.value;
	strInfor +="\nEmail: " + bt1.txtf4.value;
	if(bt1.txta.value != "") strInfor += "\nDia chi: " + bt1.txta.value;	
	//Lay thong tin tu radio button don
	//strInfor += "\nGioi tinh: ";
	for(var i=0; i<bt1.radioG.length; i++){		
		if(bt1.radioG[i].checked){
			strInfor += "\nGioi tinh: " + bt1.radioG[i].value + "\t";
			break;
		}
	}	
	//lay gia tri tu 1 checkboxList
	if(bt1.marriage.checked){
		strInfor += "\nTinh trang hon nhan: " + bt1.marriage.value;
	}
	else{
		strInfor += "\nTinh trang hon nhan: Chua ket hon";	
	}
	
	//get tu radio button list
	//strInfor += "\nKy nang: ";
	for(var i=0; i<bt1.radioS.length; i++){
		if(bt1.radioS[i].checked){
			strInfor += "\nKy nang: " + bt1.radioS[i].value + "\t";
			break;
		}
	}
	
	//Lay gia tri tu checkbox list:
	//strInfor += "\nSo thich: ";
	for(var i=0; i<bt1.hoppies.length; i++){
		if(bt1.hoppies[i].checked){
			if(dem == 0) strInfor += "\nSo thich: " + bt1.hoppies[i].value + "\t";	
			else strInfor += bt1.hoppies[i].value + "\t";
			dem ++;		
		}
	}
	dem = 0;
	//Lay gia tri tu the select
	//strInfor += "\nNghe nghiep: ";
	for(var i=0; i<bt1.jobs.length; i++){
		if(bt1.jobs[i].selected){
			if(dem == 0) strInfor += "\nNghe nghiep: " + bt1.jobs[i].value + "\t";	
			else strInfor += bt1.jobs[i].value + "\t";	
			dem ++;
		}
	}
	/**/
	alert("register successful");
	//document.write("<pre>" + strInfor+ "</pre>");
	alert(strInfor);
	}
}
// phan tao hieu ung
// tao quan cao chay theo

    function FloatTopDiv() 
    { 
        startLX = ((document.body.clientWidth -MainContentW)/2)-LeftBannerW-LeftAdjust , startLY = TopAdjust+80; 
        startRX = ((document.body.clientWidth -MainContentW)/2)+MainContentW+RightAdjust , startRY = TopAdjust+80; 
        var d = document; 
        function ml(id) 
        { 
            var el=d.getElementById?d.getElementById(id):d.all?d.all[id]:d.layers[id]; 
            el.sP=function(x,y){this.style.left=x + 'px';this.style.top=y + 'px';}; 
            el.x = startRX; 
            el.y = startRY; 
            return el; 
        } 
        function m2(id) 
        { 
            var e2=d.getElementById?d.getElementById(id):d.all?d.all[id]:d.layers[id]; 
            e2.sP=function(x,y){this.style.left=x + 'px';this.style.top=y + 'px';}; 
            e2.x = startLX; 
            e2.y = startLY; 
            return e2; 
        } 
        window.stayTopLeft=function() 
        { 
            if (document.documentElement && document.documentElement.scrollTop) 
                var pY =  document.documentElement.scrollTop; 
            else if (document.body) 
                var pY =  document.body.scrollTop; 
            if (document.body.scrollTop > 30){startLY = 3;startRY = 3;} else {startLY = TopAdjust;startRY = TopAdjust;}; 
            ftlObj.y += (pY+startRY-ftlObj.y)/16; 
            ftlObj.sP(ftlObj.x, ftlObj.y); 
            ftlObj2.y += (pY+startLY-ftlObj2.y)/16; 
            ftlObj2.sP(ftlObj2.x, ftlObj2.y); 
            setTimeout("stayTopLeft()", 1); 
        } 
        ftlObj = ml("divAdRight"); 
        //stayTopLeft(); 
        ftlObj2 = m2("divAdLeft"); 
        stayTopLeft(); 
    } 
    function ShowAdDiv() 
    { 
        var objAdDivRight = document.getElementById("divAdRight"); 
        var objAdDivLeft = document.getElementById("divAdLeft");        
        if (document.body.clientWidth < 1000) 
        { 
            objAdDivRight.style.display = "none"; 
            objAdDivLeft.style.display = "none"; 
        } 
        else 
        { 
            objAdDivRight.style.display = "block"; 
            objAdDivLeft.style.display = "block"; 
            FloatTopDiv(); 
        } 
    }  