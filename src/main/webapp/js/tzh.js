var $T=new TZH();

function TZH(){

	this.post=function(obj){
		$.ajax({
			url:obj.dz,
			dataType:'json',
			method:'POST',
			contentType:'application/x-www-form-urlencoded',
			success:function(data){
				obj.su(data);
			}
		})
	}
	
	
	this.upfile=function(obj){
		var file=document.querySelector("#"+obj.id);
		if(file.files[0])
		{
				var xhr=new XMLHttpRequest();
				var fd=new FormData();
				fd.append("image",file.files[0]);
				xhr.open("post",obj.dz,true);
				xhr.addEventListener('load',function(){
					var json=eval(xhr.responseText);
					obj.su(json);
				})
				xhr.send(fd);
			
	    }else
	   {
	    	alert("error");
	    }
	}
	
	
	this.preview=function(obj){
			var fileinput=document.querySelector("#"+obj.file);
			var show=document.querySelector("#"+obj.show);
			
			fileinput.addEventListener('change',function(){
				var filereader=new FileReader();
				filereader.addEventListener("load",function(e){
					$(show).css("background-image",("url('"+e.target.result+"')"));
					$(show).css("background-repeat",("no-repeat"));
					$(show).css("background-size",("100% 100%"));
				});
				filereader.readAsDataURL(fileinput.files[0]);
			})
			
        }
        	
	this.previewI=function(obj){
			var fileinput=document.querySelector("#"+obj.file);
			var show=document.querySelector("#"+obj.show);
			
			fileinput.addEventListener('change',function(){
				var filereader=new FileReader();
				filereader.addEventListener("load",function(e){
					$(show).attr("src",e.target.result);
				});
				filereader.readAsDataURL(fileinput.files[0]);
			})
			
        }
}