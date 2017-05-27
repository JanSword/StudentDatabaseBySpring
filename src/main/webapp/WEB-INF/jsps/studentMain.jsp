<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017/5/17
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>博智学生信息管理系统</title>

    <meta name="description" content="Static &amp; Dynamic Tables"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-awesome.css"/>

    <!-- page specific plugin styles -->

    <!-- text fonts -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-fonts.css"/>

    <!-- ace styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace.css" class="ace-main-stylesheet"
          id="main-ace-style"/>

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-part2.css"
          class="ace-main-stylesheet"/>
    <![endif]-->

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-ie.css"/>
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->
    <script src="${pageContext.request.contextPath}/assets/js/ace-extra.js"></script>

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]>
    <script src="${pageContext.request.contextPath}/assets/js/html5shiv.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/respond.js"></script>
    <![endif]-->
    <script>
        function fn(){
            if(confirm("确定要删除该学生信息吗？")){
            }else{
                return false;
            }
        }
    </script>
</head>

<body class="no-skin">
<!-- #section:basics/navbar.layout -->
<div id="navbar" class="navbar navbar-default">
    <script type="text/javascript">
        try {
            ace.settings.check('navbar', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="navbar-container" id="navbar-container">
        <!-- #section:basics/sidebar.mobile.toggle -->
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
            <span class="sr-only">Toggle sidebar</span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>
        </button>

        <!-- /section:basics/sidebar.mobile.toggle -->
        <div class="navbar-header pull-left">
            <!-- #section:basics/navbar.layout.brand -->
            <a href="#" class="navbar-brand">
                <small>
                    <i class="fa fa-beer"></i>
                    学生信息管理系统
                </small>
            </a>

            <!-- /section:basics/navbar.layout.brand -->

            <!-- #section:basics/navbar.toggle -->

            <!-- /section:basics/navbar.toggle -->
        </div>


        <!-- /section:basics/navbar.dropdown -->
    </div><!-- /.navbar-container -->
</div>

<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>

    <!-- #section:basics/sidebar -->
    <div id="sidebar" class="sidebar                  responsive">
        <script type="text/javascript">
            try {
                ace.settings.check('sidebar', 'fixed')
            } catch (e) {
            }
        </script>

        <ul class="nav nav-list">
            <li class="">
                <a href="../student/studentMain">
                    <i class="menu-icon fa fa-list-alt"></i>
                    <span class="menu-text"> 学生信息管理 </span>
                </a>

                <b class="arrow"></b>
            </li>

            <li class="">
                <a href="../grade/gradeMain">
                    <i class="menu-icon fa fa-list-alt"></i>
                    <span class="menu-text"> 班级信息管理 </span>
                </a>

                <b class="arrow"></b>
            </li>

            <li class="">
                <a href="../subject/subjectMain">
                    <i class="menu-icon fa fa-list-alt"></i>
                    <span class="menu-text"> 课程信息管理 </span>
                </a>

                <b class="arrow"></b>
            </li>

        </ul><!-- /.nav-list -->


        <!-- /section:basics/sidebar.layout.minimize -->
        <script type="text/javascript">
            try {
                ace.settings.check('sidebar', 'collapsed')
            } catch (e) {
            }
        </script>
    </div>

    <!-- /section:basics/sidebar -->
    <div class="main-content">
        <div class="main-content-inner">

            <!-- /section:basics/content.breadcrumbs -->
            <div class="page-content">
                <!-- #section:settings.box -->
                <!-- /section:settings.box -->

                <div class="page-header">
                    <h1>
                        博智维讯
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            学生信息管理
                        </small>
                    </h1>
                </div><!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-6">
                        <a class="btn btn-sm btn-info" href="addStudentPrompt">
                            <i class="ace-icon fa fa-pencil align-top bigger-125"></i>
                            新增
                        </a>
                    </div>
                </div>


                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="row">
                            <div class="col-xs-12">
                                <table id="simple-table" class="table table-striped table-bordered table-hover row text-center">
                                    <thead>
                                    <tr>
                                        <th style="width: 10%" class="text-center">学号</th>
                                        <th style="width: 15%" class="text-center">姓名</th>
                                        <th style="width: 5%" class="text-center">性别</th>
                                        <th style="width: 10%" class="text-center">出生日期</th>
                                        <th style="width: 10%" class="text-center">所在班级</th>
                                        <th style="width: 10%" class="text-center">选修课程数</th>
                                        <th style="width: 10%" class="text-center">平均分</th>
                                        <th style="width: 30%" class="text-center">操作</th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <c:forEach var="Object" items="${students}">
                                        <tr>
                                            <td>${Object.studentid}</td>
                                            <td>${Object.name}</td>
                                            <td>${Object.sex}</td>
                                            <td>${Object.birthday}</td>
                                            <td>${Object.grade}</td>
                                            <td>${Object.subjectnum}</td>
                                            <td>${Object.avg}</td>
                                            <td>
                                                <div class="hidden-sm hidden-xs btn-group">
                                                    <a class="btn btn-sm btn-success" href="${pageContext.request.contextPath}/stddb/score/updateScoreMain?studentid=${Object.studentid}">分数录入</a>
                                                    <a class="btn btn-sm btn-info" href="${pageContext.request.contextPath}/stddb/score/addScoreMain?studentid=${Object.studentid}">选课</a>
                                                    <a class="btn btn-sm btn-warning" href="updateStudentPrompt?studentid=${Object.studentid}">修改</a>
                                                    <a class="btn btn-sm btn-danger" href="deleteStudent?studentid=${Object.studentid}&grade=${Object.grade}" onclick="return fn()">删除</a>
                                                    <a class="btn btn-sm btn-grey" href="refreshStudent?page=${studentPage.number+1}&studentid=${Object.studentid}">刷新</a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>

                                <div class="row">
                                    <div class="col-xs-12">
                                        <div class="dataTables_paginate paging_simple_numbers"
                                             id="dynamic-table_paginate">
                                            <ol class="pagination">
                                                <li class="paginate_button " aria-controls="dynamic-table" tabindex="0">
                                                    <input type="button" value="首页" class="btn  btn-purple" onclick="javascript:top.location.href='studentMain?page=1'"/>
                                                </li>
                                                <li class="paginate_button" aria-controls="dynamic-table" tabindex="0" id="dynamic-table_previous">
                                                    <input type="button" value="上一页" class="btn  btn-purple" onclick="javascript:top.location.href='studentMain?page=${studentPage.number}'"/>
                                                </li>
                                                <li class="paginate_button next" aria-controls="dynamic-table" tabindex="0" id="dynamic-table_next">
                                                    <input type="button" value="下一页" class="btn  btn-purple" onclick="javascript:top.location.href='studentMain?page=${studentPage.number+2}'"/>
                                                </li>
                                                <li class="paginate_button " aria-controls="dynamic-table" tabindex="0">
                                                    <input type="button" value="末页" class="btn  btn-purple" onclick="javascript:top.location.href='studentMain?page=${studentPage.totalPages}'"/>
                                                </li>
                                                ${studentPage.number+1}/${studentPage.totalPages}
                                                <input type="number" max="${studentPage.totalPages}" min="1" style="width:50px" id="jump" value="1"/>
                                                <input type="button" value="跳转" class="btn  btn-purple" onclick="jump()"/>
                                            </ol>
                                        </div>
                                    </div>
                                </div>
                            </div><!-- /.span -->
                        </div><!-- /.row -->

                        <div class="hr hr-18 dotted hr-double"></div>

                        <!-- PAGE CONTENT ENDS -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->

    <div class="footer">
        <div class="footer-inner">
            <!-- #section:basics/footer -->
            <div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">成都</span>
							博智维讯 &copy; 2017
						</span>

            </div>

            <!-- /section:basics/footer -->
        </div>
    </div>

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->
<script type="text/javascript">
    window.jQuery || document.write("<script src='{pageContext.request.contextPath}/assets/js/jquery.js'>" + "<" + "/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='{pageContext.request.contextPath}/assets/js/jquery1x.js'>" + "<" + "/script>");
</script>
<![endif]-->
<script type="text/javascript">
    if ('ontouchstart' in document.documentElement) document.write("<script src='{pageContext.request.contextPath}/assets/js/jquery.mobile.custom.js'>" + "<" + "/script>");
</script>
<script src="{pageContext.request.contextPath}/assets/js/bootstrap.js"></script>

<!-- page specific plugin scripts -->
<script src="{pageContext.request.contextPath}/assets/js/dataTables/jquery.dataTables.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/dataTables/jquery.dataTables.bootstrap.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/dataTables/extensions/buttons/dataTables.buttons.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/dataTables/extensions/buttons/buttons.flash.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/dataTables/extensions/buttons/buttons.html5.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/dataTables/extensions/buttons/buttons.print.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/dataTables/extensions/buttons/buttons.colVis.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/dataTables/extensions/select/dataTables.select.js"></script>

<!-- ace scripts -->
<script src="{pageContext.request.contextPath}/assets/js/ace/elements.scroller.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/ace/elements.colorpicker.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/ace/elements.fileinput.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/ace/elements.typeahead.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/ace/elements.wysiwyg.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/ace/elements.spinner.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/ace/elements.treeview.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/ace/elements.wizard.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/ace/elements.aside.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/ace/ace.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/ace/ace.ajax-content.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/ace/ace.touch-drag.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/ace/ace.sidebar.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/ace/ace.sidebar-scroll-1.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/ace/ace.submenu-hover.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/ace/ace.widget-box.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/ace/ace.settings.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/ace/ace.settings-rtl.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/ace/ace.settings-skin.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/ace/ace.widget-on-reload.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/ace/ace.searchbox-autocomplete.js"></script>

<!-- inline scripts related to this page -->
<script type="text/javascript">
    jQuery(function ($) {
        //initiate dataTables plugin
        var myTable =
                $('#dynamic-table')
                //.wrap("<div class='dataTables_borderWrap' />")   //if you are applying horizontal scrolling (sScrollX)
                        .DataTable({
                            bAutoWidth: false,
                            "aoColumns": [
                                {"bSortable": false},
                                null, null, null, null, null,
                                {"bSortable": false}
                            ],
                            "aaSorting": [],


                            //"bProcessing": true,
                            //"bServerSide": true,
                            //"sAjaxSource": "http://127.0.0.1/table.php"	,

                            //,
                            //"sScrollY": "200px",
                            //"bPaginate": false,

                            //"sScrollX": "100%",
                            //"sScrollXInner": "120%",
                            //"bScrollCollapse": true,
                            //Note: if you are applying horizontal scrolling (sScrollX) on a ".table-bordered"
                            //you may want to wrap the table inside a "div.dataTables_borderWrap" element

                            //"iDisplayLength": 50


                            select: {
                                style: 'multi'
                            }
                        });


        $.fn.dataTable.Buttons.swfPath = "${pageContext.request.contextPath}/assets/js/dataTables/extensions/buttons/swf/flashExport.swf"; //in Ace demo ../assets will be replaced by correct assets path
        $.fn.dataTable.Buttons.defaults.dom.container.className = 'dt-buttons btn-overlap btn-group btn-overlap';

        new $.fn.dataTable.Buttons(myTable, {
            buttons: [
                {
                    "extend": "colvis",
                    "text": "<i class='fa fa-search bigger-110 blue'></i> <span class='hidden'>Show/hide columns</span>",
                    "className": "btn btn-white btn-primary btn-bold",
                    columns: ':not(:first):not(:last)'
                },
                {
                    "extend": "copy",
                    "text": "<i class='fa fa-copy bigger-110 pink'></i> <span class='hidden'>Copy to clipboard</span>",
                    "className": "btn btn-white btn-primary btn-bold"
                },
                {
                    "extend": "csv",
                    "text": "<i class='fa fa-database bigger-110 orange'></i> <span class='hidden'>Export to CSV</span>",
                    "className": "btn btn-white btn-primary btn-bold"
                },
                {
                    "extend": "excel",
                    "text": "<i class='fa fa-file-excel-o bigger-110 green'></i> <span class='hidden'>Export to Excel</span>",
                    "className": "btn btn-white btn-primary btn-bold"
                },
                {
                    "extend": "pdf",
                    "text": "<i class='fa fa-file-pdf-o bigger-110 red'></i> <span class='hidden'>Export to PDF</span>",
                    "className": "btn btn-white btn-primary btn-bold"
                },
                {
                    "extend": "print",
                    "text": "<i class='fa fa-print bigger-110 grey'></i> <span class='hidden'>Print</span>",
                    "className": "btn btn-white btn-primary btn-bold",
                    autoPrint: false,
                    message: 'This print was produced using the Print button for DataTables'
                }
            ]
        });
        myTable.buttons().container().appendTo($('.tableTools-container'));

        //style the message box
        var defaultCopyAction = myTable.button(1).action();
        myTable.button(1).action(function (e, dt, button, config) {
            defaultCopyAction(e, dt, button, config);
            $('.dt-button-info').addClass('gritter-item-wrapper gritter-info gritter-center white');
        });


        var defaultColvisAction = myTable.button(0).action();
        myTable.button(0).action(function (e, dt, button, config) {

            defaultColvisAction(e, dt, button, config);


            if ($('.dt-button-collection > .dropdown-menu').length == 0) {
                $('.dt-button-collection')
                        .wrapInner('<ul class="dropdown-menu dropdown-light dropdown-caret dropdown-caret" />')
                        .find('a').attr('href', '#').wrap("<li />")
            }
            $('.dt-button-collection').appendTo('.tableTools-container .dt-buttons')
        });

        ////

        setTimeout(function () {
            $($('.tableTools-container')).find('a.dt-button').each(function () {
                var div = $(this).find(' > div').first();
                if (div.length == 1) div.tooltip({container: 'body', title: div.parent().text()});
                else $(this).tooltip({container: 'body', title: $(this).text()});
            });
        }, 500);


        myTable.on('select', function (e, dt, type, index) {
            if (type === 'row') {
                $(myTable.row(index).node()).find('input:checkbox').prop('checked', true);
            }
        });
        myTable.on('deselect', function (e, dt, type, index) {
            if (type === 'row') {
                $(myTable.row(index).node()).find('input:checkbox').prop('checked', false);
            }
        });


        /////////////////////////////////
        //table checkboxes
        $('th input[type=checkbox], td input[type=checkbox]').prop('checked', false);

        //select/deselect all rows according to table header checkbox
        $('#dynamic-table > thead > tr > th input[type=checkbox], #dynamic-table_wrapper input[type=checkbox]').eq(0).on('click', function () {
            var th_checked = this.checked;//checkbox inside "TH" table header

            $('#dynamic-table').find('tbody > tr').each(function () {
                var row = this;
                if (th_checked) myTable.row(row).select();
                else  myTable.row(row).deselect();
            });
        });

        //select/deselect a row when the checkbox is checked/unchecked
        $('#dynamic-table').on('click', 'td input[type=checkbox]', function () {
            var row = $(this).closest('tr').get(0);
            if (!this.checked) myTable.row(row).deselect();
            else myTable.row(row).select();
        });


        $(document).on('click', '#dynamic-table .dropdown-toggle', function (e) {
            e.stopImmediatePropagation();
            e.stopPropagation();
            e.preventDefault();
        });


        //And for the first simple table, which doesn't have TableTools or dataTables
        //select/deselect all rows according to table header checkbox
        var active_class = 'active';
        $('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on('click', function () {
            var th_checked = this.checked;//checkbox inside "TH" table header

            $(this).closest('table').find('tbody > tr').each(function () {
                var row = this;
                if (th_checked) $(row).addClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', true);
                else $(row).removeClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', false);
            });
        });

        //select/deselect a row when the checkbox is checked/unchecked
        $('#simple-table').on('click', 'td input[type=checkbox]', function () {
            var $row = $(this).closest('tr');
            if (this.checked) $row.addClass(active_class);
            else $row.removeClass(active_class);
        });


        /********************************/
        //add tooltip for small view action buttons in dropdown menu
        $('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});

        //tooltip placement on right or left
        function tooltip_placement(context, source) {
            var $source = $(source);
            var $parent = $source.closest('table')
            var off1 = $parent.offset();
            var w1 = $parent.width();

            var off2 = $source.offset();
            //var w2 = $source.width();

            if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2)) return 'right';
            return 'left';
        }


    })
</script>

<!-- the following scripts are used in demo only for onpage help and you don't need them -->
<link rel="stylesheet" href="{pageContext.request.contextPath}/assets/css/ace.onpage-help.css"/>
<link rel="stylesheet" href="{pageContext.request.contextPath}/docs/assets/js/themes/sunburst.css"/>

<script type="text/javascript"> ace.vars['base'] = '..'; </script>
<script src="{pageContext.request.contextPath}/assets/js/ace/elements.onpage-help.js"></script>
<script src="{pageContext.request.contextPath}/assets/js/ace/ace.onpage-help.js"></script>
<script src="{pageContext.request.contextPath}/docs/assets/js/rainbow.js"></script>
<script src="{pageContext.request.contextPath}/docs/assets/js/language/generic.js"></script>
<script src="{pageContext.request.contextPath}/docs/assets/js/language/html.js"></script>
<script src="{pageContext.request.contextPath}/docs/assets/js/language/css.js"></script>
<script src="{pageContext.request.contextPath}/docs/assets/js/language/javascript.js"></script>

</body>
</html>
<script type="text/javascript">

    function changePage(p) {
        window.location.href="studentMain?page="+p;
    }
    function jump() {
        var jump = document.getElementById("jump");
        var p = jump.value;
        changePage(p)
    }
</script>