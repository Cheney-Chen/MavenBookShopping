$(document).ready(function() {
alert("123");

		dataString = "countryCode="	+ countryCode;
		$.ajax({
			type : "GET",
                        data : dataString,
			url : "ShowBookDetail.view",
			dataType : "json",
			// if received a response from the server
			success : function(data) {
				// our country code was correct so we have
				// some information to display
                               $("#ajaxResponse").append("<table>");
                               //table必須在一串才會有作用
		   			$("#ajaxResponse").append("<tr>");
                                        $("#ajaxResponse").append(data);
					$("#ajaxResponse").append("</tr>");
                                        $("#ajaxResponse").append("</table>");
                        }
						});
		});
	
