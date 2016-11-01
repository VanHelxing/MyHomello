(
	function($)
	{
		$.fn.menu = function(options)
		{
		return this.each(function() {
			var settings = $.extend(
			{
            multiExpand: false,
            slideSpeed: 500,
            dropDownIcon: '&#9660'
         }, options );
        
			$(this).children("h1").each(
				function()
				{
					$(this).next('div').andSelf().wrapAll("<div class='menu-item'></div>");
				}
			);
			$(this).children().children('div').addClass("menu-content");
			$(this).find("h1").wrap("<div class='menu-header'></div>");
			$(this).find("h1").after("<div class='menu-header-icon'>"+settings.dropDownIcon+"</div>");
			$(this).children('.menu-item').wrap('<div class="drawer"></div>');
			$(this).find(".menu-header").click(
				function()
				{
					if(settings.multiExpand==false){
						if(!$(this).hasClass('menu-header-active'))
						{
							$(this).parent().parent().parent().find(".menu-header-active").removeClass('menu-header-active');
							$(this).parent().parent().parent().find(".menu-item-active").children(".menu-content").slideUp(settings.slideSpeed);
							$(this).parent().parent().parent().find(".menu-header-icon-active").removeClass("menu-header-icon-active");
							$(this).parent().parent().parent().find(".menu-item-active").removeClass("menu-item-active");
						}
					}
					$(this).toggleClass("menu-header-active");
					$(this).parent().toggleClass("menu-item-active");
					$(this).next().slideToggle(settings.slideSpeed);
					$(this).children(".menu-header-icon").toggleClass("menu-header-icon-active");
				}
			);	
		});
		}
	}
(jQuery));