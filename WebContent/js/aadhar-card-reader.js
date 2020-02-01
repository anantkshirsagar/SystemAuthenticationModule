function getAadharCardDetails(value) {
	var aadharCardStr = document.getElementById("aadharCardStr").value;
	console.log(aadharCardStr);

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var response = xhttp.responseText;
			if(response == "FAIL"){
				alert("Please scan aadhar card barcode only.");
			} else {
				setValuesToTextField(JSON.parse(response));
			}
		}
	};
	
	xhttp.open("POST", "AadharCardServlet", true);
	xhttp.setRequestHeader("callType", "AADHAR_CARD_SERVICE");
	xhttp.send(aadharCardStr);	
}

function setValuesToTextField(aadharCardData) {
	document.getElementById("aadharCardNo").value = aadharCardData.aadharCardNo;
	document.getElementById("name").value = aadharCardData.name;
	document.getElementById("gender").value = aadharCardData.gender;
	document.getElementById("yearOfBirth").value = aadharCardData.yearOfBirth;
	document.getElementById("address").value = aadharCardData.address;
	document.getElementById("district").value = aadharCardData.district;
	document.getElementById("subDistrict").value = aadharCardData.subDistrict;
	document.getElementById("state").value = aadharCardData.state;
	document.getElementById("pincode").value = aadharCardData.pincode;
	document.getElementById("dateOfBirth").value = aadharCardData.dateOfBirth;
}

function printScreen() {
	window.print();
}
