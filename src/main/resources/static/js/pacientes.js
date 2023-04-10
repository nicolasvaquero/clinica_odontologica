window.addEventListener("load", function () {
    const formulario = this.document.querySelector("#add_new_paciente");
  
    fetch("http://localhost:8080/pacientes/")
      .then((response) => response.json())
      .then((data) => {
        const pacientesDiv = document.getElementById("pacientes");
        const listaPacientes = document.createElement("ul");
        listaPacientes.setAttribute("class", "paciente-list");
  
        data.forEach((paciente) => {
          listaPacientes.innerHTML +=
            '<li class="paciente-item" id="paciente-'+paciente.id +'"><div class="paciente-info"><h3 class="paciente-nombre">' +
            paciente.nombre +
            " " +
            paciente.apellido +
            '</h3><p class="paciente-dni">DNI: ' +
            paciente.dni +
            '</p></div><div class="paciente-actions"><button class="editar-button">Editar</button><button class="borrar-button" onclick="deleteBy('+paciente.id+')">Borrar</button></div></li>';
        });
  
        pacientesDiv.appendChild(listaPacientes);
      });
  
    formulario.addEventListener("submit", function (event) {
      const formDataPaciente = {
        nombre: document.querySelector("#nombre").value,
        apellido: document.querySelector("#apellido").value,
        email: document.querySelector("#email").value,
        dni: document.querySelector("#dni").value,
        fechaIngreso: document.querySelector("#fecha").value,
        domicilio: {
          calle: document.querySelector("#calle").value,
          numero: document.querySelector("#numeroCalle").value,
          localidad: document.querySelector("#localidad").value,
          provincia: document.querySelector("#provincia").value,
        },
      };
  
      console.log(formDataPaciente);
  
      fetch("http://localhost:8080/pacientes/", {
        method: "POST", // or 'PUT'
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(formDataPaciente),
      })
        .then((response) => response.json())
        .then((data) => {
          console.log("Success:", data);
        })
  
        .catch((error) => {
          console.error("Error:", error);
        });
    });
  });
  
  function deleteBy(id) {
    if (confirm("Eliminar paciente?")){
    const url = "http://localhost:8080/pacientes/" + id;
      const settings = {
        method: "DELETE",
      };
  
      fetch(url, settings).then(response => response.JSON);
  
      let idPaciente = "#paciente-" + id;
      document.querySelector(idPaciente).remove();}
  }
  
  const botonMostrar = document.getElementById("mostrar-formulario");
  const formulario = document.getElementById("add_new_paciente");
  
  botonMostrar.addEventListener("click", function () {
    if (formulario.style.display === "none") {
      formulario.style.display = "block";
    } else {
      formulario.style.display = "none";
    }
  });