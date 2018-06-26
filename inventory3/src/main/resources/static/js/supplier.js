$( document ).ready(function() {
		ajaxGet();
		// SUBMIT FORM
	    $("#formm").submit(function(event) {
	    	 
			// Prevent the form from submitting via the browser.
			event.preventDefault();
			ajaxPost();
		});
	 
	   
		
// 		ajaxpost
	    function ajaxPost(){
	    	
	    	// PREPARE FORM DATA
	    	var formData = {
	    			id:$("#id").val(),
	    		name : $("#name").val(),
	    		address :  $("#address").val(),
	    		email :  $("#email").val(),
	    		mobileNo :  $("#mobileNo").val()
	    	}
	    	
	    	// DO POST
	    	$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "/supplier/saveSupplier",
				data : JSON.stringify(formData),
				dataType : 'json',
				success : function(result) {
					if(result.status == "Done"){
						//$("#postResultDiv").html("Post Successfully! <br>" +
													//"Customer's Info: FirstName = " + 
													//result.data.name + " ,LastName = " + result.data.address);
// 						var customerRow = "<tr class='row_" + result.data.id+ "'>"  +
// 			        	"<td>" + result.data.id + "</td>" +
// 						"<td>" + result.data.name + "</td>" +
// 						"<td>" + result.data.address + "</td>" +
// 						 "<td>" + "<button type='button' class='btn btn-primary' onclick='EditStudentRecord(" + result.data.id + ")'>Edit</button>" + "</td>" +
// 			             "<td>" + "<button type='button' data-toggle='confirmation' data-placement='right' class='btn btn-danger' onclick='Deletecustomer("+result.data.id+")'>Delete</button>" + "</td>"+
// 					  '</tr>';
                      
	                  // $('#tablein tbody').append(customerRow);
	                   
	                   ajaxGet();
	                   $("#exampleModal").modal("hide");
	                   $("#formm")[0].reset();
	       	    	  $("#id").val(0);
	                   
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
	    
	    
	   
		
		// DO GET
		function ajaxGet(){
			$.ajax({
				type : "GET",
				url : window.location + "/allsupp",
				success: function(result){
					if(result.status == "Done"){
						 $('#tablein tbody').empty();
						var SetData = $("#customerlist");
				        for (var i = 0; i < result.data.length; i++) {
				        	var customerRow = "<tr class='row_" + result.data[i].id+ "'>"  +
				        	"<td>" + result.data[i].id + "</td>" +
							"<td>" + result.data[i].name + "</td>" +
							"<td>" + result.data[i].address + "</td>" +
							"<td>" + result.data[i].email + "</td>" +
							"<td>" + result.data[i].mobileNo + "</td>" +
							 "<td>" + "<button type='button' class='btn btn-primary' onclick='EditStudentRecord(" + result.data[i].id + ")'>Edit</button>" + "</td>" +
				             "<td>" + "<button type='button' data-toggle='confirmation' data-placement='right' class='btn btn-danger' onclick='Deletecustomer("+result.data[i].id+")'>Delete</button>" + "</td>"+
						  '</tr>';
		                   $('#tablein tbody').append(customerRow);
		                   $("#LoadingStatus").html(" ");
				        }
					}else{
						$("#print").html("<strong>Error</strong>");
						console.log("Fail: ", result);
					}
				},
				error : function(e) {
					$("#print").html("<strong>Error</strong>");
					console.log("ERROR: ", e);
				}
			});	
		}
		function resetData(){
	    	$("#name").val("");
	    	$("#address").val("");
	    	$("#email").val("");
	    	$("#mobileNo").val("");
	    }
		
		function editfunc(){
      	  console.log("hello");
// 			var $row = $("#edit1").closest("tr");    // Find the row
// 		    $("#name") = $row.find("td:nth-child(2)").text();
// 		    $("#address") = $row.find("td:nth-child(3)").text();
// 		    $("#exampleModal").modal();
		    console.log($tds);
	         	}
	    
	})
	function EditStudentRecord(id){
		
       // $("#ModalTitle").html("Update Student Record");
        
        $.ajax({
            type: "GET",
            //url: window.location + "get/"+id,
            url:"/supplier/edit?id="+id,
            success: function (result) {
            	
            	$("#exampleModal").modal("show");
            	$("#id").val(result.data.id);
                $("#name").val(result.data.name);
                $("#address").val(result.data.address);
                $("#email").val(result.data.email);
    	    	$("#mobileNo").val(result.data.mobileNo);
           
            }
        })
		
		
		
	}
	function Deletecustomer(id){
		$("#custid").val(id);
       $("#ModalTitle").html("Are you sure ?");
       $("#delete").modal("show");
       
       
	}
	function confirmDelete(){
		var id=$("#custid").val();
        $.ajax({
			type : "GET",
			url : "/supplier/deletesupplier?id="+id,
			success: function(resultMsg){
				//$("#postResultDiv").show();
				//$("#postResultDiv").html("<p>Customer with Id=" + id + " is deleted successfully!</p>");
										
				
				$(".row_"+id).remove();
 
				$("#delete").modal("hide");
				//$("#postResultDiv > p").hide(5000);
				
			},
			error : function(e) {
				$("#print").html("<strong>Error</strong>");
				console.log("ERROR: ", e);
			}
        })
		
		
		
	}