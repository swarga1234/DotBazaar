var sidebar = document.querySelector('.sidebar');
var blurBackgroundSidebar = document.getElementById("blur-background-sidebar");

      function toggleSidebar() {
            sidebar.classList.toggle('active');
            if(sidebar.classList.contains('active'))
            {
				blurBackgroundSidebar.style.display = "block";
			}
        }
        document.addEventListener('mousedown', (e) => {
            if (sidebar.classList.contains('active') && !sidebar.contains(e.target)) {
                toggleSidebar();
                blurBackgroundSidebar.style.display = "none";
            }
        });
 
        