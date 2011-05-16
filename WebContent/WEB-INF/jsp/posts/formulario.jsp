<div id="postar">
	<script type="text/javascript" src="<c:url value="/javascript/tiny_mce/tiny_mce.js" /> "></script>
	<script type="text/javascript" src="<c:url value="/javascript/tiny_mce/tiny_mce_popup.js" /> "></script>
	<script type="text/javascript" src="<c:url value="/javascript/tiny_mce/tiny_mce_src.js" /> "></script>
		
	<script type="text/javascript">
	tinyMCE.init({
	        // General options
	        mode : "textareas",
	        theme : "advanced",
	        //extended_valid_elements : "pre[name]",
	        plugins : "autolink,lists,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template",
			apply_source_formatting : true,
			
	        // Theme options
	        theme_advanced_buttons1 : "save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,|,styleselect,formatselect,fontselect,fontsizeselect",
	        theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
	        theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",
	        theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,spellchecker,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,blockquote,pagebreak,|,insertfile,insertimage",
	        theme_advanced_toolbar_location : "top",
	        theme_advanced_toolbar_align : "left",
	        theme_advanced_statusbar_location : "bottom",
	        theme_advanced_resizing : true,
	        theme_advanced_styles : "Code=brush: java;Quote=quoteStyle",
	        
	
	        // Skin options
	        skin : "o2k7",
	        skin_variant : "silver",
	
	        // Example content CSS (should be your site CSS)
	        content_css : "css/example.css",
	
	        // Drop lists for link/image/media/template dialogs
	        template_external_list_url : "js/template_list.js",
	        external_link_list_url : "js/link_list.js",
	        external_image_list_url : "js/image_list.js",
	        media_external_list_url : "js/media_list.js",
	
	        // Replace values for the template plugin
	        template_replace_values : {
	                username : "Some User",
	                staffid : "991234"
	        }
	});
	</script>
	
	<form action="<c:url value="/posts" />" method="post" >
		<div class="field">
			<label for="post.titulo">Titulo</label>
			<input type="text" name="post.titulo" value="${post.titulo }" id="post.titulo">
		</div>
		<div class="content">	
	    	<textarea name="post.corpo" style="width:100%; height:600px;">${post.corpo }</textarea>
	    </div>
	    <div class="field">
			<label for="tags">Tags</label>
			<input type="text" name="tags" value="" id="tags">
		</div>
	    <div class="button">
	    	<input type="submit" name="submit" value="Enviar" id="submit" />
	    	<input type="reset" name="reset" value="Limpar" class="limpar"/>
	    </div>
	</form>
</div>