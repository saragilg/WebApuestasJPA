$(document).ready(function() {
    console.log('ready');
    init();
});

function init(){
   onshowInfo();
   onshowApostar();
}

function onshowInfo(){
    $('#modalInfo').on('show.bs.modal', function (event) {
      var button = $(event.relatedTarget) // Button that triggered the modal
      
      var local = button.data('local')
      var visitante = button.data('visitante')
      var idpartido = button.data('idpartido');
      
      $.ajax({
        type: "GET",
        url: "Controller?op=info&idpartido="+idpartido+"&local="+local+"&visitante="+visitante,
        success : function(info) {
            $(".modal-body").html(info);     
        }
      });
    })
}

function onshowApostar(){
    $('#modalApostar').on('show.bs.modal', function (event) {
      var button = $(event.relatedTarget) // Button that triggered the modal
      
      var local = button.data('local')
      var visitante = button.data('visitante')
      var idpartido = button.data('idpartido');
      var dni = button.data('dni');
      
      var modal = $(this)
      modal.find('.modal-content h4').text(local+' - '+visitante)
      modal.find('form').attr("action", "Controller?op=apostar&idpartido="+idpartido+"&dni="+dni)
      
    })
}
