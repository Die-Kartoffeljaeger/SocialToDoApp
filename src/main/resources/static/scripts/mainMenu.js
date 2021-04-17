window.addEventListener('DOMContentLoaded', (event) => {
	document.getElementById("logoutButton").addEventListener('click', handleSignOut);
});

function handleSignOut()
{
	let httpRequest = new XMLHttpRequest();

	httpRequest.onreadystatechange = () =>
	{
		if (httpRequest.readyState === XMLHttpRequest.DONE)
		{
			
		}
	}
}