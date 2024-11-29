document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("user-form");
    const userList = document.getElementById("user-list");
  
    form.addEventListener("submit", (e) => {
      e.preventDefault();
      const name = form.elements[0].value;
      const role = form.elements[1].value;
  
      const userDiv = document.createElement("div");
      userDiv.textContent = `${name} - ${role}`;
      userList.appendChild(userDiv);
  
      form.reset();
    });
  });
  