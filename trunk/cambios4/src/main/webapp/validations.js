
var whatField = "formDate";

function check_date(Cadena){
    var Fecha= new String(Cadena)	// Crea un string
    var RealFecha= new Date()	// Para sacar la fecha de hoy
    //Validar si tiene por lo menos tres /
        
    if (Fecha.lastIndexOf("/")==-1 ){
        alert('Fecha incorrecta')
        return false
    }

    // Cadena Año
    var Ano= new String(Fecha.substring(Fecha.lastIndexOf("/")+1,Fecha.length))
    // Cadena Mes
    var Mes= new String(Fecha.substring(Fecha.indexOf("/")+1,Fecha.lastIndexOf("/")))
    // Cadena Día
    var Dia= new String(Fecha.substring(0,Fecha.indexOf("/")))

    // Valido el año
    if (isNaN(Ano) || Ano.length<4 || parseFloat(Ano)<1900){
        alert('Fecha incorrecta')
        return false
    }
    // Valido el Mes
    if (isNaN(Mes) || parseFloat(Mes)<1 || parseFloat(Mes)>12){
        alert('Fecha incorrecta')
        return false
    }
    // Valido el Dia
    if (isNaN(Dia) || parseInt(Dia, 10)<1 || parseInt(Dia, 10)>31){
        alert('Fecha incorrecta')
        return false
    }
    if (Mes==4 || Mes==6 || Mes==9 || Mes==11 || Mes==2) {
        if (Mes==2 && Dia > 28 || Dia>30) {
            alert('Fecha incorrecta')
            return false
        }
    }
    //para que envie los datos, quitar las  2 lineas siguientes
    //alert("Fecha correcta.")
    return true
}

function dp(txtCampo,imgBoton){
    
    whatField=String(txtCampo);

    numDaysInMonth = numDays(new Date());
    firstDayOfMonth = firstDay(new Date());

    document.getElementById("formYear").innerHTML = returnMDY("year");
    document.getElementById("formMonth").selectedIndex = returnMDY("month");
    writeDays(numDaysInMonth, firstDayOfMonth);

    positionLayer("picker", String(imgBoton), 0, 42);

    document.getElementById("picker").style.visibility = "visible";

}

function updateCalendar(my, plusminus){

    if (my == "year"){
        current = parseInt(document.getElementById("formYear").innerHTML);
        result = eval(current + plusminus + 1);
        document.getElementById("formYear").innerHTML = result;
    }

    updateYear = parseInt(document.getElementById("formYear").innerHTML);
    updateMonth = parseInt(document.getElementById("formMonth").value) - 1;

    numDaysInMonth = numDays(new Date(updateYear,updateMonth,1));
    firstDayOfMonth = firstDay(new Date(updateYear,updateMonth,1));

    writeDays(numDaysInMonth, firstDayOfMonth);

}

function insertDate(formDay) {
    var sdia=formDay;
    var smes=document.getElementById("formMonth").value;
    var sannio=document.getElementById("formYear").innerHTML;
    var sfechafinal="";

    sdia="0"+sdia;
    sdia= sdia.substr(sdia.length-2, 2);
    smes="0"+smes;
    smes= smes.substr(smes.length-2, 2);

    sfechafinal=sdia+"/"+smes+"/"+sannio;

    document.getElementById(whatField).value =sfechafinal;

    document.getElementById("picker").style.visibility = "hidden";
}

function returnMDY(mdy) {
    var dateToday = new Date();
    var year = dateToday.getFullYear();
    var month = dateToday.getMonth();
    var day = dateToday.getDate();


    switch(mdy){
        case "month":
            return month;
            break;

        case "day":
            return day;
            break;

        case "year":
            return year;
            break;
    }
    var dateToday = new Date();
}

function writeDays(numDaysInMonth, firstDayOfMonth) {
    var dayCounter = 1;

    for (i=1; i <43; i++){
        document.getElementById("bx"+i).innerHTML = "&nbsp;";
    }

    startNum = firstDayOfMonth;
    for (j=1; j<=numDaysInMonth; j++){
        document.getElementById("bx"+startNum).innerHTML = "<div align='center' onClick='insertDate(" + j + ")'>" + j + "</div>";
        startNum++;
    }
}

function firstDay(theDate) {
    var dateToday = theDate;
    var year = dateToday.getFullYear();
    var month = dateToday.getMonth();

    dateToday.setDate(1);

    return dateToday.getDay() + 1;

}

function numDays(theDate) {
    var dateToday = theDate;
    var month = dateToday.getMonth() + 1;
    var numDaysInMonth = 0;
    var year = dateToday.getFullYear();

    if ((month==4 || month==6 || month==9 || month==11) ) {
        return numDaysInMonth = 30;
    }
    else if (month==2){
        var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
        if (isleap) {
            return numDaysInMonth = 29;
        }
        else {
            return numDaysInMonth = 28;
        }
    }
    else {
        return numDaysInMonth = 31;
    }

}

/*
positionLayer() moves a layer to any specified point on the screen based on the location of any image.
The layer position can be adjusted up adn down or side to side with top and left.
currentMenu, and startingPoint are the id attributes of a the laeyr being moved and the image used a reference point.
*/
function positionLayer(currentMenu, startingPoint, top, left)
{
    menuLocator = document.images[startingPoint];
    menuStartleft = getRealLeft(menuLocator);
    menuStartTop = getRealTop(menuLocator);

    document.getElementById(currentMenu).style.top = (menuStartTop + top) + "px";
    document.getElementById(currentMenu).style.left = (menuStartleft + left) + "px";
}

//This Function gets a starting left point from which we set the hidden menus
function getRealLeft(el)
{
    xPos = el.offsetLeft;
    tempEl = el.offsetParent;
    while (tempEl != null)
    {
        xPos += tempEl.offsetLeft;
        tempEl = tempEl.offsetParent;
    }
    return xPos;
}

//This Function gets a starting top point from which we set the hidden menus
function getRealTop(el)
{
    yPos = el.offsetTop;
    tempEl = el.offsetParent;
    while (tempEl != null)
    {
        yPos += tempEl.offsetTop;
        tempEl = tempEl.offsetParent;
    }
    return yPos;
}

// Función que valida un formato de fecha concreto.
// Devolverá true o false en función de la evaluación
function validaFormFechas() {
    var vcfecd = document.forms[0].fechadesde.value;
    var vcfech = document.forms[0].fechahasta.value;
    if(vcfecd=='' || vcfech==''){
        alert('Por favor, ingrese el rango de fechas para realizar la b\xfasqueda');
        return false;
    }
    if (check_date(vcfecd)){
        if (check_date(vcfech)){
            if(Date.parse(vcfecd) > Date.parse(vcfech)){
                alert("La fecha hasta no puede ser mayor a la fecha desde.");
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }else{
        return false;
    }
    return true;
}

function validaFormLogin(login, pw)
{
 var error=''; 
 error+=login==''?'\nlogin':'';
 error+=pw==''?'\npassword':'';
 if (error!='')
 {
  alert('Por favor, ingrese los valores necesarios para iniciar sesi\xf3n');
 }
 return error=='';
}

function validaFormPlaca(vnplaca){
    if (vnplaca.length != 7){
        alert('Por favor, ingrese un n\xfamero de placa v\xe1lido');
        return false;
    }
    if ((/[A-Za-z\s]/.test(vnplaca.substr(0, 2))) && (vnplaca.substr(2, 1) == '-') && (/^([0-9])*$/.test(vnplaca.substr(3, 4)))){
       return true;
    }
    if ((/[A-Za-z\s]/.test(vnplaca.substr(0, 3))) && (vnplaca.substr(3, 1) == '-') && (/^([0-9])*$/.test(vnplaca.substr(4, 3)))){
       return true;
    }
    alert('Por favor, ingrese un n\xfamero de placa v\xe1lido');
    return false;
}

function validaForm() {
	// Buscamos el elemento con id "campoFecha"
	var vcform = document.forms[0].name;
        var resultado;
        switch (vcform)
        {
            case "card_mov":
                return validaFormFechas();
            break;
            case "query":
                var vcplaca = document.forms[0].placa.value;                
                resultado=validaFormPlaca(vcplaca)
                if (resultado){
                    if (!validaFormFechas()){
                        return false;
                    }
                    return true;
                }else{
                    return false;
                }
            break;
            case "login_dni":
                var vclogin = document.forms[0].user.value;
                var vcpw = document.forms[0].clave.value;                
                if ((vclogin.length != 8) || !(/^([0-9])*$/.test(vclogin))){
                    alert('Por favor, ingrese un n\xfamero de DNI v\xe1lido');
                    return false;
                }
                return validaFormLogin(vclogin, vcpw);
            break;
            case "login_usu":
                var vclogin = document.forms[0].txtUsuario.value;
                var vcpw = document.forms[0].txtPassword.value;
                return validaFormLogin(vclogin, vcpw);
            break;
            case "checkin_park":
                var vcplaca = document.forms[0].txtPlaca.value;
                if (vcplaca==''){
                    alert('Por favor, ingrese el n\xfamero de placa');
                    return false;
                }
                return validaFormPlaca(vcplaca);
            break;
            case "checkout_park":
                var vcplaca = document.forms[0].txtPlaca.value;
                var vctarjeta = document.forms[0].txtTarjeta.value;
                if (vcplaca=='' && vctarjeta==''){
                    alert('Por favor, ingrese los valores necesarios para realizar la b\xfasqueda');
                    return false;
                }
                return validaFormPlaca(vcplaca);
            break;
            case "cust_reg":
                var vcnombre = document.forms[0].txtNombre.value;
                var vcdireccion = document.forms[0].txtDireccion.value;
                var vctelefono = document.forms[0].txtTelefono.value;
                var vcmail = document.forms[0].txtMail.value;
                if (vcnombre==''){
                    alert('Por favor, ingrese el nombre del cliente');
                    return false;
                }
                if (vcdireccion==''){
                    alert('Por favor, ingrese la direcci\xf3n del cliente');
                    return false;
                }
                if (vctelefono==''){
                    alert('Por favor, ingrese el tel\xe9fono del cliente');
                    return false;
                }
                if (vcmail==''){
                    alert('Por favor, ingrese el e-mail del cliente');
                    return false;
                }
            break;
            case "cust_sel":
                var vccliente = document.forms[0].cliente.value;
                if (vccliente==''){
                    alert('Por favor, ingrese el DNI del cliente');
                    return false;
                }
                if ((vccliente.length != 8) || !(/^([0-9])*$/.test(vccliente))){
                    alert('Por favor, ingrese un n\xfamero de DNI v\xe1lido');
                    return false;
                }
            break;
            case "card_load":
                var vcmonto = document.forms[0].monto.value;
                if (vcmonto == ''){
                    alert('Por favor, ingrese el monto a recargar');
                    if ((!/^([0-9])*[.]?[0-9]*$/.test(vcmonto))) {
                        alert('Por favor, ingrese un valor num\xe9rico');
                        return false;
                    }
                    var vimonto = ParseInt(vcmonto);
                    if (vimonto < 0 ) {
                        alert('Por favor, ingrese un valor mayor a cero');
                        return false;
                    }
                }
            break;
            case "card_load":
                var vcmonto = document.forms[0].monto.value;
                if (vcmonto == ''){
                    alert('Por favor, ingrese el monto a recargar');
                    if ((!/^([0-9])*[.]?[0-9]*$/.test(vcmonto))) {
                        alert('Por favor, ingrese un valor num\xe9rico');
                        return false;
                    }
                    var vimonto = ParseInt(vcmonto);
                    if (vimonto < 0 ) {
                        alert('Por favor, ingrese un valor mayor a cero');
                        return false;
                    }
                }
            break;
        }
        return true;

}




