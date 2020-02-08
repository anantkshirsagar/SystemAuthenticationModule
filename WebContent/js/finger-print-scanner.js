function scanFinger() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var response = xhttp.responseText;
			if(response == "FAIL"){
				alert("Error occured while saving finger print data.");
			} else {
				alert("Finger print scanned successfully!");
			}
		}
	};
	
	xhttp.open("POST", "FingerPrintScannerServlet", true);
	xhttp.setRequestHeader("callType", "SCAN_FINGER_SERVICE");
	xhttp.send();	
}


function validate() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var score = xhttp.getResponseHeader("SCORE");
			var isValid = xhttp.getResponseHeader("IS_VALID");
			console.log("Score: " +score+ " --> isvalid: " +isValid);
			if(isValid == "true"){
				alert("Finger print matched with score: " +score);
			} else {
				alert("Finger print does not matched! SCORE: "+ score);
			}
		}
	};
	
	xhttp.open("POST", "FingerPrintScannerServlet", true);
	xhttp.setRequestHeader("callType", "VALIDATE_FINGER_SERVICE");
	xhttp.send();	
}
