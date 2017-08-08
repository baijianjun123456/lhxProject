var Tree = {};

/**
 * 刷新目标节点
 */
Tree.refresh=function(tree,nodeId){
	debugger;
	var currentNode = Tree.findNodeById(tree,nodeId);
	$.get(tree.url+"?id="+node.id,function(result){
		Tree.appendNode(tree,currentNode,result);
	});
};

/**
 * 根据ID查询节点
 */
Tree.findNodeById=function(tree,nodeId){
	return tree.tree('find',nodeId);
};

/**
 * 移除目标节点下的所有子节点；
 */
Tree.removeAllChildNodes=function(tree,node){
	var allChildren = tree.tree('getChildren',node.target);
	for(var i = 0; i < allChildren.length; i++){
		Tree.removeNode(tree,allChildren[i]);
	}
};

/**
 * 移除目标节点
 */
Tree.removeNode=function(tree,node){
	tree.tree('remove', node.target);
};

/**
 * 给目标节点追加子节点；
 */
Tree.appendNode=function(tree,node,appendData){
	tree.tree('append', {parent:node.target,data:result});
};

/**
 * 获取选节点列表；
 * param：获取选中节点属性字段名称；
 */
Tree.selectedNodes=function(tree,attrFileNames,indeterminate){
	
	var restut = [];
	
	var nodes = tree.tree('getChecked');
	var nodesindet = tree.tree('getChecked','indeterminate');
	
	for(var yindex = 0; yindex < nodes.length; yindex++){
		
		restut[yindex] = {};
		
		for(var xindex = 0; xindex < attrFileNames.length; xindex++){
			var attrName = attrFileNames[xindex];
			restut[yindex][attrName] = nodes[yindex][attrName];
		}
	};
	
	if(indeterminate){	
		for(var yindex = 0; yindex < nodesindet.length; yindex++){
			
			restut[yindex] = {};
			
			for(var xindex = 0; xindex < attrFileNames.length; xindex++){
				var attrName = attrFileNames[xindex];
				restut[yindex][attrName] = nodesindet[yindex][attrName];
			}
		};
	};

	return restut;
};