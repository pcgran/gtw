<div class="footer navbar-fixed-bottom dark">
  <div class="container">
    <p class="text-muted">Foot placeholder</p>
  </div>
</div>

<!-- Scripts -->
<script>

	$("#option1").click(function(){
	    
    var el = $("#keywords-text");

    if(this.checked) {
    	el.removeAttr("disabled");
    } else {
    	el.attr("disabled", "disabled");	    	
    }
});

$("#option2").click(function(){
	    
    var el = $("#lang");

    if(this.checked) {
    	el.removeAttr("disabled");
    } else {
    	el.attr("disabled", "disabled");	    	
    }
});

$("#option3").click(function(){
	    
    var el = $("#region");

    if(this.checked) {
    	el.removeAttr("disabled");
    } else {
    	el.attr("disabled", "disabled");	    	
    }
});

$("#option4").click(function(){
	    
    var el = $("#mood");

    if(this.checked) {
    	el.removeAttr("disabled");
    } else {
    	el.attr("disabled", "disabled");	    	
    }
});

$("#option5").click(function(){
	    
    var el = $("#number-results");

    if(this.checked) {
    	el.removeAttr("disabled");
    } else {
    	el.attr("disabled", "disabled");	    	
    }
});

</script>