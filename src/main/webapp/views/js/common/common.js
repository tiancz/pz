ajax.jsonPost(data,url){
	var JsonData = JSON.stringify(data);
	$.ajax({
		url:url,
		type:'POST',
		dataType:'json',
		contentType:'application/json',
		data:JsonData,
		async:false,
		success:function(data){
			var id = data.article.id;
			window.location.href ="http://localhost:8080/pz/views/jsp/note/noteDetail.html?id="+id;
		}
	});
}
