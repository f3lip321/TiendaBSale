const buscar = document.getElementsByName('buscar')[0];    

function getProducCategory(id){
    fetch('http://localhost:8080/api/product/showProductCategory/'+id)
    .then(response => response.json())    
    .then(data => CreateCardProductsFromJSON(data));    
}

function CreateCardProductsFromJSON(data){
    let htmlCode = ``;
        
    data.forEach(function(singleProductObjects) {            

    htmlCode =
      htmlCode +
      `
  <div class="col">
    <div class="card">
      <img src="${singleProductObjects.url_image}"  alt="...">
      <div class="card-body">
        <h5 class="card-title">${singleProductObjects.name}</h5>
        <p class="card-text">$${singleProductObjects.price}</p>
      </div>
    </div>
  </div>    
    `;    
  });
  
  const productCards = document.querySelector(".all-product-cards");
  
  productCards.innerHTML = htmlCode;
}

function getProducName(){    
    fetch('http://localhost:8080/api/product/findByTitleContaining/'+buscar.value.trim())
    .then(response => response.json())
    .then(data => CreateCardProductsFromJSON(data));
}
