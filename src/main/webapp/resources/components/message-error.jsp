<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/messageStyle.css">
	<div id="popup" class="popup">
		<div class="icon-message">
			<i class="far fa-times-circle regular-icon icon-message-image" style="color: #D22B2B; font-size: 100px"></i>
		</div>
		<div class="popup-content">
			<span id="popup-message"> ${error} </span>
		</div>
		<div class="close">
			<button id="close-popup" class="close-popup">Close</button>
		</div>
	</div>
