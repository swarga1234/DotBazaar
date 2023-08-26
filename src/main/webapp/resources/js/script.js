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
const blurBackground = document.getElementById("blur-background");
const popupSuccess = document.getElementById("popup-success");
const popupError = document.getElementById("popup-error");
const popupMessageError=document.getElementById("popup-message-error");
const closePopupSuccess = document.getElementById("close-popup-success");
const closePopupError = document.getElementById("close-popup-error");
const signupForm = document.getElementById("signup-form");
const loginForm= document.getElementById("login-form");
const popupMessageSuccess = document.getElementById("popup-message-success");

var message = document.getElementById("session-message").getAttribute("data-message");

if(message!="null" && message.trim() !== "")
{
	popupMessageError.textContent=message;
	popupError.style.display="flex";
	blurBackground.style.display = "block";
}

signupForm.addEventListener('submit', function(event){
	
	event.preventDefault();
	
	var f=$(this).serialize();
	//console.log(f);
	$.ajax({
		url:"registration",
		data:f,
		type:'POST',
		success: function(response){

			if(response.status==="success")
			{
				popupMessageSuccess.textContent=response.message;
				popupSuccess.style.display="flex";
				blurBackground.style.display = "block";
				signupForm.reset();
			}
			else{
				popupMessageError.textContent=response.message;
				popupError.style.display="flex";
				blurBackground.style.display = "block";
			}
		},
		error: function(response)
		{
			popupMessageError.textContent=response.message;
			popupError.style.display="flex";
			blurBackground.style.display = "block";
		}
                       
                     

	})

})
loginForm.addEventListener('submit',function(event){
	event.preventDefault();
	var f=$(this).serialize();
	$.ajax({
		url:"login",
		data:f,
		type:'POST',
		success: function(response){

			
			if(response.status==="success")
			{
				window.location.href = "welcome";
			}
			else{
				popupMessageError.textContent=response.message;
				popupError.style.display="flex";
				blurBackground.style.display = "block";
			}
			
		},
		error: function(response)
		{
			popupMessageError.textContent=response;
			popupError.style.display="flex";
			blurBackground.style.display = "block";
		}

	})
})

 closePopupSuccess.addEventListener("click", function () {
    popupSuccess.style.display = "none";
    blurBackground.style.display = "none";
    wrapper.classList.remove('active');
    
});
closePopupError.addEventListener("click", function () {
    popupError.style.display = "none";
    blurBackground.style.display = "none";
});

//  const showPasswordButton = document.querySelector('.show-password');
//    const passwordInput = document.getElementById("password");
//     const passwordIcon = document.getElementById("password-icon");

//     showPasswordButton.addEventListener("click", function () {
//         if (passwordInput.type === "password") {
//             passwordInput.type = "text";
//             passwordIcon.classList.remove("fa-lock");
//             passwordIcon.classList.add("fa-unlock");
//         } else {
//             passwordInput.type = "password";
//             passwordIcon.classList.remove("fa-unlock");
//             passwordIcon.classList.add("fa-lock");
//         }
//     });

const showPasswordButtonLogin = document.getElementById("show-password-login");
const passwordLoginInput = document.getElementById("passsword-login");
const passwordIconLogin= document.getElementById("password-icon-login");

    showPasswordButtonLogin.addEventListener("click", function () {
        if (passwordLoginInput.type === "password") {
            passwordLoginInput.type = "text";
            passwordIconLogin.setAttribute("name", "eye");
            //passwordIconLogin.nameList.add("eye");
        } else {
			passwordLoginInput.type = "password";
            passwordIconLogin.setAttribute("name", "eye-off");
        }
    });
const showPasswordButtonRegister = document.getElementById("show-password-register");
const passwordRegisterInput = document.getElementById("password-register");
const passwordIconRegister= document.getElementById("password-icon-regsiter");

showPasswordButtonRegister.addEventListener("click", function () {
        if (passwordRegisterInput.type === "password") {
            passwordRegisterInput.type = "text";
            passwordIconRegister.setAttribute("name", "eye");
            //passwordIconLogin.nameList.add("eye");
        } else {
			passwordRegisterInput.type = "password";
            passwordIconRegister.setAttribute("name", "eye-off");
        }
    });