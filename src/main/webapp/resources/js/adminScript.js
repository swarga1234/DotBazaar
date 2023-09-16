const blurBackground = document.getElementById("blur-background");
const popupSuccess = document.getElementById("popup-success");
const popupError = document.getElementById("popup-error");
const popupMessageError=document.getElementById("popup-message-error");
const closePopupSuccess = document.getElementById("close-popup-success");
const closePopupError = document.getElementById("close-popup-error");
const addCategory = document.getElementById("add-category-admin-form");
const addProduct= document.getElementById("add-product-admin-form");
const popupMessageSuccess = document.getElementById("popup-message-success");
const addCategoryModal= document.getElementById("add-category-admin");

var message = document.getElementById("session-message").getAttribute("data-message");

if(message!="null" && message.trim() !== "")
{
	popupMessageSuccess.textContent=message;
	popupSuccess.style.display="flex";
	blurBackground.style.display = "block";
}

addCategory.addEventListener('submit',function(event){
	event.preventDefault();
	var f=$(this).serialize();
	$.ajax({
		url:"add-category",
		data:f,
		type:'POST',
		success: function(response){

			if(response.status==="success")
			{
				window.location.href = "admin-page";
				
				
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
addProduct.addEventListener('submit',function(event){
	event.preventDefault();
	var formData = new FormData(this);
	$.ajax({
		url:"add-product",
		data:formData,
		type:'POST',
		processData: false,
        contentType: false,
		success: function(response){

			if(response.status==="success")
			{
				window.location.href = "admin-page";
				
				
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
closePopupSuccess.addEventListener("click", function () {
    popupSuccess.style.display = "none";
    blurBackground.style.display = "none";
    
});
closePopupError.addEventListener("click", function () {
    popupError.style.display = "none";
    blurBackground.style.display = "none";
});
