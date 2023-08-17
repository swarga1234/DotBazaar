// Make sure to include the Axios library in your HTML file
// <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

document.addEventListener("DOMContentLoaded", function () {
    const popup = document.getElementById("popup");
    const popupMessage = document.getElementById("popup-message");
    const closePopup = document.getElementById("close-popup");
    const signupForm = document.getElementById("signup-form");
   
    closePopup.addEventListener("click", function () {
        popup.style.display = "none";
    });
});
