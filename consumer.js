document.addEventListener("DOMContentLoaded", () => {
    const productList = document.getElementById("product-list");
    const orderList = document.getElementById("order-list");
  
    // Example products
    const products = [
      { name: "Apples", price: 3, quantity: 50 },
      { name: "Carrots", price: 2, quantity: 30 },
      { name: "Tomatoes", price: 4, quantity: 20 },
    ];
  
    // Display products
    products.forEach((product, index) => {
      const productCard = document.createElement("div");
      productCard.textContent = `${product.name} - $${product.price}/unit - ${product.quantity} units available`;
      productCard.style.border = "1px solid #ddd";
      productCard.style.margin = "5px 0";
      productCard.style.padding = "10px";
  
      const buyButton = document.createElement("button");
      buyButton.textContent = "Buy";
      buyButton.style.marginLeft = "10px";
  
      // Handle Buy button click
      buyButton.addEventListener("click", () => {
        if (product.quantity > 0) {
          product.quantity--;
          productCard.textContent = `${product.name} - $${product.price}/unit - ${product.quantity} units available`;
  
          const orderItem = document.createElement("div");
          orderItem.textContent = `You bought 1 ${product.name} for $${product.price}`;
          orderList.appendChild(orderItem);
        } else {
          alert("Out of stock!");
        }
      });
  
      productCard.appendChild(buyButton);
      productList.appendChild(productCard);
    });
  });
  