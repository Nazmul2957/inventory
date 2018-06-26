
	$(document).ready(function() {
        
	       
	    $(deleteLink).click(function(event) {
	           
	    	var formData = {
	        		id : $(deletLink).val(),
	        	}
	    	
	        $.ajax({
	        	type : "POST",
				contentType : "application/json",
				url : "/customer/delete",
				data : JSON.stringify(formData),
				dataType : 'json',
	              success: function() {
	                var respContent = "";
	                var rowToDelete = $(event.target).closest("tr");
	                     
	                rowToDelete.remove();
	                     
	                respContent += "<span class='success'>Smartphone was deleted: [";
	               
	                
	                     
	                $("#sproduct").html(respContent);         
	              }
	        });
	   
	        event.preventDefault();
	    });
	        
	});   


