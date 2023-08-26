function deleteFilter() {
    let item = document.getElementsByClassName("defaultSelect");
    for (var i = 0; i < item.length; i++) {
        item[i].selected = "selected";
    }
}

function addToCart() {
    let itemCartId = document.getElementById("itemCartId");
    let numOfItem = itemCartId.textContent;
    numOfItem++;
    itemCartId.innerHTML = numOfItem;
    let btnAddToCarts = document.querySelectorAll(".btnAddToCart");
    for (var i = 0; i < btnAddToCarts.length; i++) {
        btnAddToCarts[i].addEventListener("click", function() {
            if (!btnAddToCarts[i].classList.contains("clicked")) {
                btnAddToCarts[i].classList.add("clicked");
                btnAddToCarts[i].innerHTML = "Added";
            }
        })
    }
}