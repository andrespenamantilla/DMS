function mostrarVentana()
{
    var ventana = document.getElementById("miVentana");
    ventana.style.marginTop ='100px';
    ventana.style.left = ((document.body.clientWidth-350) / 2) +  "px";
    ventana.style.display = 'block';
}
