/**
 * 
 */

$( document ).ready(function() {
	alert("");
	$("#btnSave").click(function(){
		$("#addrSeq").val("1");
		$("#telNo").val("0319743439");
		saveForm();
	});
});

function saveForm(){
	 $.ajax({
         type : "post",
         url : "/createResturant",
         data : $("#rsturtInfoFrm").serialize(),
         dataType : "json",
         error : function(){
             alert('통신실패!!');
         },
         success : function(data){
             alert("통신데이터 값 : " + data) ;
             $("#dataArea").html(data) ;
         }
     });
}