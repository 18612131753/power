<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>

<!-- 按钮栏  -->
<!-- 搜索栏  -->
<div id="${tabCode}_searchbar" class="grid_search_bg">
	&nbsp;&nbsp;&nbsp;&nbsp;期数：<input type="text" id="${tabCode}_search_ffid" />
	&nbsp;&nbsp;&nbsp;&nbsp;年份：<input type="text" id="${tabCode}_search_year" />
	<a id="${tabCode}_search_button">搜索</a>
</div>
<!-- 数据表格 -->
<table id="${tabCode}_grid"></table>

<script type="text/javascript">

$(document).ready(function() {
	var tabCode = "${tabCode}";
	// 计算表格高度
	var grid_height = CENTER_TAB_HEIGHT - 50 ;
	
	//按钮区
	$('#'+tabCode+'_buttonbar').omButtonbar({
          	btns:[{separtor:true},{separtor:true},{separtor:true}]
	});
	// 搜索区域
	$('#'+tabCode+'_search_pmenu').omCombo({
        dataSource:'${contextPath}/menu/findMenu1?type=0',
        optionField:function(data,index){
            return data.text;
        },
        emptyText:'全部',
        editable:false,
        lazyLoad:true,
        listMaxHeight:80
    });
    $('#'+tabCode+'_search_state').omCombo({
        dataSource:[{text:'全部',value:''},{text:'正常',value:'1'},{text:'停用',value:'0'}],
        optionField:function(data,index){
            return data.text;
        },
        emptyText:'全部',
        editable:false,
        lazyLoad:false,
        listMaxHeight:80
    });
    $('#'+tabCode+'_search_button').omButton({
		icons:{left:'${buttonSearchIcons}'},
		onClick:function(){
			$('#'+tabCode+'_grid').omGrid({
				extraData : {
					ffid:$('#'+tabCode+'_search_ffid').val(),
					year:$('#'+tabCode+'_search_year').val()
				}
			});
		}
	})
	//GRID数据区域
	$('#'+tabCode+'_grid').omGrid({
		 method:'POST',
		 limit:ALL_LIMIT,
		 height:grid_height,
		 autoFit:false,
		 showIndex:false,
		 singleSelect:true,
		 loadingMsg:'数据查询中...',
		 editMode:'insert',
		 dataSource:'${contextPath}/ttffoff/queryforlist',
		 colModel:[
		 	 { header:'',width:20,name:'ffid',align:'center',
			    renderer:function(colValue,rowData,rowIndex) {
					return '<input type="checkbox" class="'+tabCode+'_checkbox" id="'+tabCode+'_checkbox_'+colValue+'" value="'+colValue+'"/>';
                }
			 },
			 { header:'期号',name:'ffid',width:130,align:'center'},
			 { header:'中奖号码',name:'result',width:160,align:'center' },
			 { header:'年份',name:'year',width:60,align:'center' },
			 { header:'月份',name:'month',width:60,align:'center' },
			 { header:'单日期号',name:'dayid',width:60,align:'center' },
			 { header:'万',name:'d1',width:60,align:'center'},
			 { header:'千',name:'d2',width:60,align:'center'},
			 { header:'百',name:'d3',width:60,align:'center'},
			 { header:'十',name:'d4',width:60,align:'center'},
			 { header:'个',name:'d5',width:60,align:'center'},
			 { header:'开奖时间',name:'udate',width:160,align:'center' }
		],
		onRowClick:function(rowIndex,rowData,event){
			//保存用户的选中状态
			$('.'+tabCode+'_checkbox').attr('checked',false);
			$('#'+tabCode+'_checkbox_'+rowData.ffid).attr('checked','checked');
		},
		onRowDblClick:function(rowIndex,rowData,event){
	    }
	});
});
</script>