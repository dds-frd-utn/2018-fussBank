$(function() {
    $("#listar").click(function(){
        $.ajax({
            url: "http://localhost:8080/fussBank/rest/cliente",
            success: function(data){
                for(var i in data){
                    $("#lista-cuentas").append(
                        $("<li/>", {text:data[i].nombre+" ("+data[i].cuil+")"})
                    );
                }
                $("#lista-cuentas").show();
            }
        });
    });
$(function(){
    
    $("#extracciones").click(function(){
        $.ajax({
            url: "http://localhost:8080/fussBank/rest/Movimiento",
            succes: function(data){
                for(var i in data){
                    $("#extraccion-cuentas").append(
                        $("<li/>", {text:data[i].id+" ("+data[i].id_cuenta+")"})
                    );
                }
                $("#extraccion-cuentas").show();
            }
        });
        $("#lista-cuentas").hide();
    });

});

});
