<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Content-top</title>
        <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
        <link href="css/content-top.css" rel="stylesheet" />
            <link rel="stylesheet" href="slide/css/demo.css" type="text/css" media="screen" />
            <link rel="stylesheet" href="slide/css/flexslider.css" type="text/css" media="screen" />
            <script src="slide/js/jquery.flexslider.js"></script>
			<script src="./js/jquery.min.js"></script>
          
            <script type="text/javascript">
                $(function(){
                  SyntaxHighlighter.all();
                });
                $(window).load(function(){
                  $('.flexslider').flexslider({
                    animation: "slide",
                    start: function(slider){
                      $('div').removeClass('loading');
                    }
                  });
                });
            </script>
</head>
    <body>
        <div id="content-top">
            <!-- Begin: Hien thi slide-images -->
            <div class="top-mid" style="width: 980px !important">
        		<jsp:include page="slide/slide-images.html"></jsp:include>
            </div>
            <!-- End: Hien thi slide-images -->
            <div class="top-right">
            </div>
        </div>
    </body> 
</html>
