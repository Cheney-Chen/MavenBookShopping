$(document).ready(function() {
alert("123");
		$.ajax({
			type : "GET",
			url : "ShowBookList.view",
			dataType : "json",
			// if received a response from the server
			success : function(data) {
				// our country code was correct so we have
				// some information to display
                               $("#ajaxResponse").append("<table>");
                               //table必須在一串才會有作用
				 for(var i = 0; i < data.length; i++)  
		          {  
				 
					$("#ajaxResponse").append("<tr>");
                                        $("#ajaxResponse").append("<th>"+data[i].ID+"</th>");
                                         $("#ajaxResponse").append("<th>"+data[i].name+"</th>");
                                          $("#ajaxResponse").append("<th>"+data[i].author+"</th>");
                                           $("#ajaxResponse").append("<th>"+data[i].publisher+"</th>");
                                           $("#ajaxResponse").append("<th>"+data[i].price+"</th>");
                                           $("#ajaxResponse").append("<th><a href='BookDetail.jsp?bookID="+data[i].ID+"'</a>show detail</th>");
					$("#ajaxResponse").append("</tr>");
					}
                                        $("#ajaxResponse").append("</table>");
                        }
						});
		});
	
