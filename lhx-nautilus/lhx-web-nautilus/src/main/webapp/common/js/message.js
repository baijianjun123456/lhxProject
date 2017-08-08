var message = {};

message.error=function(title,context,backup){
	$.messager.alert(title,context,'error',backup);
};

message.info=function(title,context,backup){
	$.messager.alert(title,context,'info',backup);
};

message.question=function(title,context,backup){
	$.messager.alert(title,context,'question',backup);
};

message.warning=function(title,context,backup){
	$.messager.alert(title,context,'warning',backup);
};