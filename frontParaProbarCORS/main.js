const span = document.querySelector("#id1");

const getData = async () => {
  const url = "http://localhost:8080/api/usuarios/all";
  try {
    const response = await fetch(url);
    const data = await response.json();
    const stringDOM = data.map(
      (item) =>
        `<p>${item.id}</p>
      <p>${item.nombreUsuario}</p>
      <p>${item.run}</p>`
    );
    span.innerHTML = stringDOM;
  } catch (error) {
    console.log(error);
  }
};

getData();
