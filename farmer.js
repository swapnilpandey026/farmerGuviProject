document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("product-form");
    const productList = document.getElementById("product-list");
  
    form.addEventListener("submit", (e) => {
      e.preventDefault();
  
      // Get product details
      const name = form.elements[0].value;
      const price = form.elements[1].value;
      const quantity = form.elements[2].value;
  
      // Create a product card
      const productCard = document.createElement("div");
      productCard.textContent = `${name} - $${price}/unit - ${quantity} units available`;
      productCard.style.border = "1px solid #ddd";
      productCard.style.margin = "5px 0";
      productCard.style.padding = "10px";
  
      // Append to the product list
      productList.appendChild(productCard);
  
      // Reset the form
      form.reset();
    });
  });
  