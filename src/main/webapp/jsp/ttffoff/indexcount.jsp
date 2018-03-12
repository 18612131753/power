<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>

<!-- 搜索栏  -->
<div id="${tabCode}_searchbar" class="grid_search_bg">
	&nbsp;&nbsp;&nbsp;&nbsp;期数：<input type="text" id="${tabCode}_search_ffid" />
	<a id="${tabCode}_search_button">搜索</a>
</div>
<!-- 数据表格 -->
<div style="clear:both;">
<div style="float:left;" >
	<table id="${tabCode}_grid"></table>
</div>
<div style="float:left;">
	<table id="${tabCode}_grid1"></table>
</div>
<div style="float:left;">
	<table id="${tabCode}_grid2"></table>
</div>
<div style="float:left;">
	<table id="${tabCode}_grid3"></table>
</div>
<div style="float:left;">
	<table id="${tabCode}_grid4"></table>
</div>
</div>
<script type="text/javascript">

$(document).ready(function() {
	var tabCode = "${tabCode}";
	// 计算表格高度
	var grid_height = CENTER_TAB_HEIGHT - 50 ;
	
    $('#'+tabCode+'_search_button').omButton({
		icons:{left:'${buttonSearchIcons}'},
		onClick:function(){
			$('#'+tabCode+'_grid').omGrid({
				extraData : {
					ffid:$('#'+tabCode+'_search_ffid').val(),
				}
			});
			$('#'+tabCode+'_grid1').omGrid({
				extraData : {
					ffid:$('#'+tabCode+'_search_ffid').val(),
				}
			});
			$('#'+tabCode+'_grid2').omGrid({
				extraData : {
					ffid:$('#'+tabCode+'_search_ffid').val(),
				}
			});
			$('#'+tabCode+'_grid3').omGrid({
				extraData : {
					ffid:$('#'+tabCode+'_search_ffid').val(),
				}
			});
			$('#'+tabCode+'_grid4').omGrid({
				extraData : {
					ffid:$('#'+tabCode+'_search_ffid').val(),
				}
			});
		}
	})
	var grid_width = 220;
	//GRID数据区域
	$('#'+tabCode+'_grid').omGrid({
		 method:'POST',
		 limit:-1,
		 height:grid_height,
		 width:grid_width,
		 autoFit:false,
		 showIndex:false,
		 singleSelect:true,
		 loadingMsg:'数据查询中...',
		 editMode:'insert',
		 dataSource:'${contextPath}/ttffoff/queryforlistcount',
		 colModel:[
			 { header:'编号',name:'groupid',width:50,align:'center'},
			 { header:'组合',name:'result',width:50,align:'center'},
			 { header:'<b style="color:red">万位</b>',name:'d1',width:50,align:'center'}
		]
	});
	$('#'+tabCode+'_grid1').omGrid({
		 method:'POST',
		 limit:-1,
		 height:grid_height,
		 width:grid_width,
		 autoFit:false,
		 showIndex:false,
		 singleSelect:true,
		 loadingMsg:'数据查询中...',
		 editMode:'insert',
		 dataSource:'${contextPath}/ttffoff/queryforlistcount',
		 colModel:[
			 { header:'编号',name:'groupid',width:50,align:'center'},
			 { header:'组合',name:'result',width:50,align:'center'},
			 { header:'<b style="color:red">千位</b>',name:'d2',width:50,align:'center'}
		]
	});
	$('#'+tabCode+'_grid2').omGrid({
		 method:'POST',
		 limit:-1,
		 height:grid_height,
		 width:grid_width,
		 autoFit:false,
		 showIndex:false,
		 singleSelect:true,
		 loadingMsg:'数据查询中...',
		 editMode:'insert',
		 dataSource:'${contextPath}/ttffoff/queryforlistcount',
		 colModel:[
			 { header:'编号',name:'groupid',width:50,align:'center'},
			 { header:'组合',name:'result',width:50,align:'center'},
			 { header:'<b style="color:red">百位</b>',name:'d3',width:50,align:'center'}
		]
	});
	$('#'+tabCode+'_grid3').omGrid({
		 method:'POST',
		 limit:-1,
		 height:grid_height,
		 width:grid_width,
		 autoFit:false,
		 showIndex:false,
		 singleSelect:true,
		 loadingMsg:'数据查询中...',
		 editMode:'insert',
		 dataSource:'${contextPath}/ttffoff/queryforlistcount',
		 colModel:[
			 { header:'编号',name:'groupid',width:50,align:'center'},
			 { header:'组合',name:'result',width:50,align:'center'},
			 { header:'<b style="color:red">十位</b>',name:'d4',width:50,align:'center'}
		]
	});
	$('#'+tabCode+'_grid4').omGrid({
		 method:'POST',
		 limit:-1,
		 height:grid_height,
		 width:grid_width,
		 autoFit:false,
		 showIndex:false,
		 singleSelect:true,
		 loadingMsg:'数据查询中...',
		 editMode:'insert',
		 dataSource:'${contextPath}/ttffoff/queryforlistcount',
		 colModel:[
			 { header:'编号',name:'groupid',width:50,align:'center'},
			 { header:'组合',name:'result',width:50,align:'center'},
			 { header:'<b style="color:red">个位</b>',name:'d5',width:50,align:'center'}
		]
	});
});

</script>