<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>

<!-- 搜索栏  -->
<div id="${tabCode}_searchbar" class="grid_search_bg">
	&nbsp;&nbsp;&nbsp;&nbsp;开始期数：<input type="text" id="${tabCode}_search_startffid" value="${startffid}"/> 
	&nbsp;&nbsp;&nbsp;&nbsp;结束期数：<input type="text" id="${tabCode}_search_endffid" value="${endffid}"/> 
	<a id="${tabCode}_search_button">搜索</a>
</div>
<!-- 数据表格 -->
<div">
	<table id="${tabCode}_grid"></table>
</div>
<script type="text/javascript">

	$(document).ready(function() {
		var tabCode = "${tabCode}";
		// 计算表格高度
		var grid_height = CENTER_TAB_HEIGHT - 50;

		$('#' + tabCode + '_search_button').omButton({
			icons : {
				left : '${buttonSearchIcons}'
			},
			onClick : function() {
				$('#' + tabCode + '_grid').omGrid({
					extraData : {
						ffid : $('#' + tabCode + '_search_ffid').val(),
					}
				});
			}
		})
		//GRID数据区域
		$('#' + tabCode + '_grid').omGrid({
			method : 'POST',
			limit : -1,
			height : grid_height,
			autoFit : false,
			showIndex : false,
			singleSelect : true,
			loadingMsg : '数据查询中...',
			editMode : 'insert',
			dataSource : '${contextPath}/ttffoff/queryforzhishu',
			extraData : {
				startffid : $('#' + tabCode + '_search_startffid').val(),
				endffid : $('#' + tabCode + '_search_endffid').val()
			},
			colModel : [
				{
					header : '编号',
					name : 'groupid',
					width : 80,
					align : 'center'
				} ,
				{
					header : '组合',
					name : 'result',
					width : 80,
					align : 'center'
				} ,
				{
					header : '<b style="color:red">万-指数差</b>',
					name : 'd1_x',
					width : 80,
					align : 'center',
					renderer : function(colValue, rowData, rowIndex) {
						return '<b style="color:red">' + ( rowData.d1_x - rowData.d1_y ) + '</b>';
					}
				} ,
				{
					header : '<b style="color:red">万-期数差</b>',
					name : 'd1_x_ffid',
					width : 80,
					align : 'center',
					renderer : function(colValue, rowData, rowIndex) {
						return '<b style="color:red">' + ( rowData.d1_x_ffid - rowData.d1_y_ffid ) + '</b>';
					}
				} ,
				{
					header : '<b style="color:green">千-指数差</b>',
					name : 'd2_x',
					width : 80,
					align : 'center',
					renderer : function(colValue, rowData, rowIndex) {
						return '<b style="color:green">' + ( rowData.d2_x - rowData.d2_y ) + '</b>';
					}
				} ,
				{
					header : '<b style="color:green">千-期数差</b>',
					name : 'd2_x_ffid',
					width : 80,
					align : 'center',
					renderer : function(colValue, rowData, rowIndex) {
						return '<b style="color:green">' + ( rowData.d2_x_ffid - rowData.d2_y_ffid ) + '</b>';
					}
				} ,
				{
					header : '<b style="color:blue">百-指数差</b>',
					name : 'd3_x',
					width : 80,
					align : 'center',
					renderer : function(colValue, rowData, rowIndex) {
						return '<b style="color:blue">' + ( rowData.d3_x - rowData.d3_y ) + '</b>';
					}
				} ,
				{
					header : '<b style="color:blue">百-期数差</b>',
					name : 'd3_x_ffid',
					width : 80,
					align : 'center',
					renderer : function(colValue, rowData, rowIndex) {
						return '<b style="color:blue">' + ( rowData.d3_x_ffid - rowData.d3_y_ffid ) + '</b>';
					}
				} ,
				{
					header : '<b style="color:#8F4586">十-指数差</b>',
					name : 'd4_x',
					width : 80,
					align : 'center',
					renderer : function(colValue, rowData, rowIndex) {
						return '<b style="color:#8F4586">' + ( rowData.d4_x - rowData.d4_y ) + '</b>';
					}
				} ,
				{
					header : '<b style="color:#8F4586">十-期数差</b>',
					name : 'd4_x_ffid',
					width : 80,
					align : 'center',
					renderer : function(colValue, rowData, rowIndex) {
						return '<b style="color:#8F4586">' + ( rowData.d4_x_ffid - rowData.d4_y_ffid ) + '</b>';
					}
				} ,
				{
					header : '<b style="color:#EA7500">个-指数差</b>',
					name : 'd5_x',
					width : 80,
					align : 'center',
					renderer : function(colValue, rowData, rowIndex) {
						return '<b style="color:#EA7500">' + ( rowData.d5_x - rowData.d5_y ) + '</b>';
					}
				} ,
				{
					header : '<b style="color:#EA7500">个-指数差</b>',
					name : 'd5_x_ffid',
					width : 80,
					align : 'center',
					renderer : function(colValue, rowData, rowIndex) {
						return '<b style="color:#EA7500">' + ( rowData.d5_x_ffid - rowData.d5_y_ffid ) + '</b>';
					}
				}
			]
		});

		$('#' + tabCode + '_search_button').omButton({
			icons : {
				left : '${buttonSearchIcons}'
			},
			onClick : function() {
				$('#' + tabCode + '_grid').omGrid({
					extraData : {
						startffid : $('#' + tabCode + '_search_startffid').val(),
						endffid : $('#' + tabCode + '_search_endffid').val()
					}
				});
			}
		});
	});
</script>