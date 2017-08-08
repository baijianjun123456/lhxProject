var buttonAllMap = {};

var add = {'text': '添加',iconCls: 'icon-add','handler': function() { addData();}};
buttonAllMap["add"] = add;

var userAddRole = {'text': '配置角色',iconCls: 'icon-add','handler': function() { userAddRole();}};
buttonAllMap["userAddRole"] = userAddRole;

var remove = {'text': '删除',iconCls: 'icon-cut','handler': function() {removeData();}};
buttonAllMap["remove"] = remove;

var modify = {'text': '修改',iconCls: 'icon-edit','handler': function() {modifyData();}};
buttonAllMap["modify"] = modify;

var roleAddMenu = {'text': '配置菜单',iconCls: 'icon-add','handler': function() { roleAddMenu();}};
buttonAllMap["roleAddMenu"] = roleAddMenu;

var init = {'text': '初始化',iconCls: 'icon-reload','handler': function() {initData();}};
buttonAllMap["init"] = init;
