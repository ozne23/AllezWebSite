function validateRegistrazione() {
	var nome = document.forms["regForm"]["nome"];
	var cognome = document.forms["regForm"]["cognome"];
	var email = document.forms["regForm"]["email"];
	var username = document.forms["regForm"]["username"];
	var password = document.forms["regForm"]["password"];
	var conpassword = document.forms["regForm"]["conpassword"];
	var telefono = document.forms["regForm"]["telefono"];
	var provincia = document.forms["regForm"]["provincia"];
	var citta = document.forms["regForm"]["citta"];
	var cap = document.forms["regForm"]["cap"];
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	var letters = /^[A-Za-z ]+$/;
	var phoneno = /^\d{10}$/;
	var capno = /^\d{5}$/;

	if (nome.value == null || nome.value == "") {
		alert("Campo 'nome' vuoto!");
		nome.focus();
		return false;
	} else if (cognome.value == null || cognome.value == "") {
		alert("Campo 'cognome' vuoto!");
		cognome.focus();
		return false;
	} else if (!nome.value.match(letters)) {
		alert("Il nome può contenere solo caratteri alfabetici!");
		nome.focus();
		return false;
	} else if (!cognome.value.match(letters)) {
		alert("Il cognome può contenere solo caratteri alfabetici!");
		cognome.focus();
		return false;
	} else if (!telefono.value.match(phoneno)) {
		alert("Formato numero di telefono non valido!");
		telefono.focus();
		return false;
	} else if (!cap.value.match(capno)) {
		alert("Formato del cap non valido!");
		cap.focus();
		return false;
	} else if (!provincia.value.match(letters)) {
		alert("La provincia può contenere solo caratteri alfabetici!");
		provincia.focus();
		return false;
	} else if (!citta.value.match(letters)) {
		alert("La città può contenere solo caratteri alfabetici!");
		citta.focus();
		return false;
	} else if (email.value == null || email.value == "") {
		alert("Campo email non può essere vuoto");
		email.focus();
		return false;
	} else if (!email.value.match(mailformat)) {
		alert("Formato email non valido!");
		email.focus();
		return false;
	} else if (username.value == null || username.value == "") {
		alert("Campo username vuoto!");
		username.focus();
		return false;
	} else if (password.value == null || password.value == "") {
		alert("Campo password vuoto!");
		password.focus();
		return false;
	} else if (password.value.length < 8) {
		alert("La password deve contenre almeno 8 caratteri");
		password.focus();
		return false;
	} else if (password.value != conpassword.value) {
		alert("Le password non combaciano!");
		password.focus();
		conpassword.focus();
		return false;
	} else
		return true;
}