
$( document ).ready(function() {
	
	// SUBMIT FORM
    $("#formm").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		ajaxPost();
	});

//    $(".use-address").click(function() {
//	    var $row = $(this).closest("tr");    // Find the row
//	    var $tds = $row.find("td");
//	    $.each($tds, function() {
//	        console.log($(this).text());
//	    });
//	}); 
    $(".use-address").click(function() {
	    var $row = $(this).closest("tr");    // Find the row
	    var $tds = $row.find("td:nth-child(2)").text();
	    console.log($tds);
	    $("#print").html($tds);
	})
    function ajaxPost(){
    	
    	// PREPARE FORM DATA
    	var formData = {
    		name : $("#name").val(),
    		address :  $("#address").val()
    	}
    	
    	// DO POST
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : window.location + $("#formm").attr( "action"),
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				if(result.status == "Done"){
					$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
												"Post Successfully! <br>" +
												"---> Customer's Info: FirstName = " + 
												result.data.name + " ,LastName = " + result.data.address + "</p>");
					var customerRow = '<tr>' +
					'<td>' + result.data.id + '</td>' +
					'<td>' + result.data.name + '</td>' +
					'<td>' + result.data.address + '</td>' +
					'<td ><a th:href="@{findone/(id=${custo.id})}" class="btn btn-primary eBtn">Edit</a></td>'+
					'<td><a th:href="@{delete/(id=${custo.id})}" onclick="delete()" class="btn btn-danger">Delete</a></td>'+
				  '</tr>';
                   $('#tablein tbody').append(customerRow);
                   $("#exampleModal").modal("hide");
                   
				}else{
					$("#postResultDiv").html("<strong>Error</strong>");
				}
				console.log(result);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    	
    	// Reset FormData after Posting
    	resetData();
    	
 
    }
   
    
    function resetData(){
    	$("#name").val("");
    	$("#address").val("");
    }
    
})