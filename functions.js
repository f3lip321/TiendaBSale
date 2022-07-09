function CreateTableFromJSON(data){
    
    
    let col = [];
    for (let i = 0; i < data.length; i++) {
        for (let key in data[i]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
        
    }

    let table = document.createElement("table");

    let tr = table.insertRow(-1);

    for (let i = 0; i < col.length; i++) {
        let th = document.createElement("th");
        th.innerHTML = col[i];
        tr.appendChild(th);        
    }

    for (let i = 0; i < data.length; i++) {
        tr = table.insertRow(-1);

        for (let j = 0; j < col.length; j++) {
            let tabCell = tr.insertCell(-1);
            tabCell.innerHTML = data[i][col[j]];
        }        
    }

    let divContainer = document.getElementById("showData");
    divContainer.innerHTML = "";
    divContainer.appendChild(table);
}

function getProductList(){
    fetch('http://localhost:8080/api/product/list')
    .then(response => response.json())
    .then(data => CreateTableFromJSON(data));
}

function getProducCategory(id){
    fetch('http://localhost:8080/api/product/showProductCategory/'+id)
    .then(response => response.json())
    .then(data => CreateTableFromJSON(data));
}

function getProducName(name){
    fetch('http://localhost:8080/api/product/findByTitleContaining/'+name)
    .then(response => response.json())
    .then(data => CreateTableFromJSON(data));
}

