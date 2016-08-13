jQuery(document).ready(function($) {

	$(".headroom").headroom({
		"tolerance": 20,
		"offset": 50,
		"classes": {
			"initial": "animated"
		}
	});
	var $window = $(window)

	$window.on('scroll', revealOnScroll);

	function revealOnScroll() {
		var scrolled      = $window.scrollTop(),
		win_height_padded = $window.height() * 0.8;
	     $(".revealOnScroll:not(.animated)").each(function () {
	       var $this     = $(this),
	           offsetTop = $this.offset().top;

	       if (scrolled + win_height_padded > offsetTop) {
	         if ($this.data('timeout')) {
	           setTimeout(function(){
	             $this.addClass('animated');
	           }, parseInt($this.data('timeout'),10));
	         } else {
	         	setTimeout(function() {
	         		$this.addClass('animated');
	         	}, 500)
	         }
	       }
		});
	}
	$('.navbar-collapse').on('click', 'a[href!="#"]', function () {
		$('.navbar-collapse').removeClass('in').addClass('collapse');
	})
});