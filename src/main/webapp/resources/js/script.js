const wrapper= document.querySelector('.wrapper');
const loginLink= document.querySelector('.login-link');
const registerLink= document.querySelector('.register-link');
const loginPopUp= document.querySelector('.btnLogin-popup');
const close=document.querySelector('.icon-close');

registerLink.addEventListener('click', ()=>{
	wrapper.classList.add('active');
});

loginLink.addEventListener('click', ()=>{
	wrapper.classList.remove('active');
});

loginPopUp.addEventListener('click', ()=>{
	wrapper.classList.add('active-popup');
});

close.addEventListener('click', ()=>{
	wrapper.classList.remove('active-popup');
});

const popup = document.getElementById("popup");
const closePopup = document.getElementById("close-popup");
const signupForm = document.getElementById("signup-form");
const popupMessage = document.getElementById("popup-message");

 closePopup.addEventListener("click", function () {
        popup.style.display = "none";
    });