/**
 * VALIDA CAMPI LOGIN
 */

function validate() {
	var uname = document.forms["loginForm"]["username"];
	var password = document.forms["loginForm"]["password"];

	var letters = /^[A-Za-z]+$/;
	var strongRegex = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");

	if (uname.value.match(letters)) {
		if (password.value.match(strongRegex)) {
			return true;
		} else {
			alert("Password non va bene");
			password.focus();
			return false;
		}
	} else {
		alert("Username must have alphabet characters only");
		uname.focus();
		return false;
	}

}