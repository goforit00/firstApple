window.onload=function()
{
	//控制"换地址"栏的显隐
	$(".change_addr").mouseenter(function()
	{
		$(".other_addr").slideDown("slow");
	});
	$(".other_addr").mouseleave(function()
	{
		$(".other_addr").slideUp("slow");
	});

	//控制每家商店"去逛逛"阴影条的显隐
	$(".shops li").mouseenter(function()
	{
		$(this).attr("class","focused");
	});
	$(".shops li").mouseleave(function()
	{
		$(this).attr("class","");
	});
}