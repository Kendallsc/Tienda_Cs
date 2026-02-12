// Esta funcion carga una imagen local en la pgina

function readURL(input){
    if(input.files && input.files[0]){  // Se revisa si lo que se carga es un archivo
        
        var lector = new FileReader();
        
        lector.onload = function(e) {
            $('#blah').attr('src', e.target.result).height(200);
        };
        lector.readAsDataURL(input.files[0]);
    }
}