$(document).ready(function() {
    $('#agregar-odontologo-form').on('submit', function(event) {
      event.preventDefault(); // evitar que el formulario se envíe automáticamente
  
      // Recuperar los valores de los campos del formulario
      var nombre = $('#nombre').val();
      var apellido = $('#apellido').val();
      var dni = $('#dni').val();
      var calle = $('#calle').val();
      var numero = $('#numero').val();
      var localidad = $('#localidad').val();
      var provincia = $('#provincia').val();
      var fecha_alta = $('#fecha_alta').val();


      var especialidad = $('#especialidad').val();
  
      // Crear el objeto de datos que se enviará en la solicitud POST
      var datos = {
        nombre: nombre,
        apellido: apellido,
        dni: dni,
        calle: calle,
        numero: numero,
        localidad: localidad,
        provincia: provincia,
        fecha_alta: fecha_alta,

      };
  
      // Realizar la solicitud POST al servidor
      $.ajax({
        url: '/pacientes/',
        method: 'POST',
        data: datos,
        success: function(response) {
          // Manejar la respuesta del servidor en caso de éxito
          console.log('Odontólogo agregado correctamente');
        },
        error: function(error) {
          // Manejar el error en caso de falla
          console.error('Error al agregar el odontólogo:', error);
        }
      });
    });
  });
/*



  nombre: document.querySelector('#nombre').value,
  apellido: document.querySelector('#apellido').value,
  dni: document.querySelector('#dni').value,
  calle: document.querySelector('#calle').value,
  numero: document.querySelector('#numero').value,
  localidad: document.querySelector('#localidad').value,
  provincia: document.querySelector('#provincia').value,
  fecha_alta: document.querySelector('"fecha_alta').value,






window.addEventListener('load', function(){

    const formulario = document.querySelector('#addPaciente');

    formulario.addEventListener('submit', function (event)) {

        const formData = {
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
            calle: document.querySelector('#calle').value,
            numero: document.querySelector('#numero').value,
            localidad: document.querySelector('#localidad').value,
            provincia: document.querySelector('#provincia').value,
            fecha_alta: document.querySelector('"fecha_alta').value,

    };

    const url =  '/pacientes';

    const settings = {
        method: 'POST',
        headers: {
            'Content-Type' : 'application/json',
        },
        body: JSON.stringify(formData)
        }

    fetch(url, settings)
    .then(response => response.json())
    .then (data => {

        let successAlert = '<div class="alert alert-sucesss alert-dismissible">'+
        '<butoon type="button" class="close" data-dismiss="alert">&times; </button>'+
        '<strong></strong> Paciente agregado </div>'

        document.querySelector('#response').innerHTML = successAlert;
        document.querySelector('#response').getElementsByClassName.display = 'block';

        resetUploadForm();
    })

    .catch(error => {
        let error= '<div class="alert alert-sucesss alert-dismissible">'+
        '<butoon type="button" class="close" data-dismiss="alert">&times; </button>'+
        '<strong></strong> Error intente nuevamente </div>'

        document.querySelector('#response').innerHTML = error;
        document.querySelector('#response').getElementsByClassName.display = 'block';

        resetUploadForm();

    });

    function resetUploadForm();
        document.querySelector('#nombre').value= "";
        document.querySelector('#apellido').value= "";
        document.querySelector('#dni').value= "";
        document.querySelector('#calle').value= "";
        document.querySelector('#numero').value= "";
        document.querySelector('#localidad').value= "";
        document.querySelector('#provincia').value= "";
        document.querySelector('"fecha_alta').value= "";
        }
    }
)

*/