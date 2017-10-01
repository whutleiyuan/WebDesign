
/*当页面被加载时控制菜单的隐藏 
*/
   function loadPage() {
    var array=document.getElementById("caidanyangshi");
    var array1=document.getElementById("data");
    var array2=document.getElementById("outData");
    var array3=document.getElementById("userManager");
    var array4=document.getElementById("systemManager");
    array.style.display="none";
    array1.style.display="none";
    array2.style.display="none";
    array3.style.display="none";
    array4.style.display="none";
   }
   /**用来控制页面的显示方法
    * 动态的改变页面
    */
function showMenu(menuId){
	var arrays=document.getElementById(menuId);
	if(arrays.style.display=="block"){
		arrays.style.display="none";
	}else{
		arrays.style.display="block";
	}
}

$(".menu-item").on('click', 'li a', function(e) {
	var $this = $(this);
	e.preventDefault();
	addIframe($this);
});

/*添加iframe*/
function addIframe(current){
	var $this = current;
	var $href = $this.attr("href");
	var m = $this.data("index");
	var	content= $this.find("span").text();
	var status = false;
	/*if ($href== "" || $.trim($href).length == 0) {
		return false;
	}*/
	
	$(".content-tab").each(function() {
		if ($(this).data("id") == $href) {
			if (!$(this).hasClass("active")) {
				$(this).addClass("active").siblings(".content-tab").removeClass("active");
				addTab(this);
			}
			status = true;
		}
	});
	if(status){
		$(".body-iframe").each(function() {
			if ($(this).data("id") == $href) {
				$(this).show().siblings(".body-iframe").hide();
			}
		});
	}
	if (!status) {
		var tab = "<a href='javascript:void(0);' class='content-tab active' data-id='"+$href+"'>"+ content +" <i class='iconfont-left icon-wrongicon01'></i></a>";
		$(".content-tab").removeClass("active");
		$(".tab-nav-content").append(tab);
		var iframe = "<iframe class='body-iframe' name='iframe"+ m +"' width='100%' height='100%' src='"+ $href +"' frameborder='0' data-id='"+ $href +"' seamless></iframe>";
		$(".layout-main-body").find("iframe.body-iframe").hide().parents(".layout-main-body").append(iframe);
		addTab($(".content-tab.active"));
	}
	return false;
}

/*添加tab*/
function addTab(cur) {
	var prev_all = tabWidth($(cur).prevAll()),
		next_all = tabWidth($(cur).nextAll());
	var other_width =tabWidth($(".layout-main-tab").children().not(".tab-nav"));
	var navWidth = $(".layout-main-tab").outerWidth(true)-other_width;//可视宽度
	var hidewidth = 0;
	if ($(".tab-nav-content").width() < navWidth) {
		hidewidth = 0
	} else {
		if (next_all <= (navWidth - $(cur).outerWidth(true) - $(cur).next().outerWidth(true))) {
			if ((navWidth - $(cur).next().outerWidth(true)) > next_all) {
				hidewidth = prev_all;
				var m = cur;
				while ((hidewidth - $(m).outerWidth()) > ($(".tab-nav-content").outerWidth() - navWidth)) {
					hidewidth -= $(m).prev().outerWidth();
					m = $(m).prev()
				}
			}
		} else {
			if (prev_all > (navWidth - $(cur).outerWidth(true) - $(cur).prev().outerWidth(true))) {
				hidewidth = prev_all - $(cur).prev().outerWidth(true)
			}
		}
	}
	$(".tab-nav-content").animate({
		marginLeft: 0 - hidewidth + "px"
	},
	"fast")
}

/*获取宽度*/
function tabWidth(tabarr) {
	var allwidth = 0;
	$(tabarr).each(function() {
		allwidth += $(this).outerWidth(true)
	});
	return allwidth;
}
/*选项卡关闭事件*/
$(".tab-nav-content").on("click", ".content-tab i", closePage);
/*选项卡切换事件*/
$(".tab-nav-content").on("click", ".content-tab", navChange);

/*选项卡关闭方法*/
function closePage() {
	/*得到父级标签的id*/
	var url = $(this).parents(".content-tab").data("id");
	var cur_width = $(this).parents(".content-tab").width();
	if ($(this).parents(".content-tab").hasClass("active")) {
		if ($(this).parents(".content-tab").next(".content-tab").length) {
			var next_url = $(this).parents(".content-tab").next(".content-tab:eq(0)").data("id");
			$(this).parents(".content-tab").next(".content-tab:eq(0)").addClass("active");
			$(".body-iframe").each(function() {
				if ($(this).data("id") == next_url) {
					$(this).show().siblings(".body-iframe").hide();
					return false
				}
			});
			var n = parseInt($(".tab-nav-content").css("margin-left"));
			if (n < 0) {
				$(".tab-nav-content").animate({
					marginLeft: (n + cur_width) + "px"
				},
				"fast")
			}
			$(this).parents(".content-tab").remove();
			$(".body-iframe").each(function() {
				if ($(this).data("id") == url) {
					$(this).remove();
					return false
				}
			})
		}
		if ($(this).parents(".content-tab").prev(".content-tab").length) {
			var prev_url = $(this).parents(".content-tab").prev(".content-tab:last").data("id");
			$(this).parents(".content-tab").prev(".content-tab:last").addClass("active");
			$(".body-iframe").each(function() {
				if ($(this).data("id") == prev_url) {
					$(this).show().siblings(".body-iframe").hide();
					return false
				}
			});
			$(this).parents(".content-tab").remove();
			$(".body-iframe").each(function() {
				if ($(this).data("id") == url) {
					$(this).remove();
					return false
				}
			})
		}
	} else {
		$(this).parents(".content-tab").remove();
		$(".body-iframe").each(function() {
			if ($(this).data("id") == url) {
				$(this).remove();
				return false
			}
		});
		addTab($(".content-tab.active"))
	}
	return false
}

/*选项卡切换方法*/
function navChange() {
	if (!$(this).hasClass("active")) {
		var k = $(this).data("id");
		$(".body-iframe").each(function() {
			if ($(this).data("id") == k) {
				$(this).show().siblings(".body-iframe").hide();
				return false
			}
		});
		$(this).addClass("active").siblings(".content-tab").removeClass("active");
		addTab(this);
	}
}
