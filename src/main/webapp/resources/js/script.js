var wrapper= document.querySelector('.wrapper');
var loginLink= document.querySelector('.login-link');
var registerLink= document.querySelector('.register-link');
var loginPopUp= document.querySelector('.btnLogin-popup');
var close=document.querySelector('.icon-close');

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
var blurBackground = document.getElementById("blur-background");
var popupSuccess = document.getElementById("popup-success");
var popupError = document.getElementById("popup-error");
var popupMessageError=document.getElementById("popup-message-error");
var closePopupSuccess = document.getElementById("close-popup-success");
var closePopupError = document.getElementById("close-popup-error");
var signupForm = document.getElementById("signup-form");
var loginForm= document.getElementById("login-form");
var popupMessageSuccess = document.getElementById("popup-message-success");

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
		url:"/dotbazaar/registration",
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
		url:"/dotbazaar/login",
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

//  var showPasswordButton = document.querySelector('.show-password');
//    var passwordInput = document.getElementById("password");
//     var passwordIcon = document.getElementById("password-icon");

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

var showPasswordButtonLogin = document.getElementById("show-password-login");
var passwordLoginInput = document.getElementById("passsword-login");
var passwordIconLogin= document.getElementById("password-icon-login");

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
var showPasswordButtonRegister = document.getElementById("show-password-register");
var passwordRegisterInput = document.getElementById("password-register");
var passwordIconRegister= document.getElementById("password-icon-regsiter");

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
 
 var loginSidebar= document.getElementById("login-sidebar");
 var blurBackgroundSidebar = document.getElementById("blur-background-sidebar");

 loginSidebar.addEventListener('click', ()=>{
	if (sidebar.classList.contains('active')) {
                toggleSidebar();
                blurBackgroundSidebar.style.display = "none";
            }
	wrapper.classList.add('active-popup');
});

 